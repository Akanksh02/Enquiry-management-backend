package com.enquirymgmt.enquiry.controller;

import com.enquirymgmt.enquiry.entity.Enquiry;
import com.enquirymgmt.enquiry.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class EnquiryController {

    @Autowired
    EnquiryRepository repo;

    @GetMapping("/enquiry")
    public List<Enquiry> getAllEnquiry(){
        return  repo.findAll();
    }

    @GetMapping("/enquiry/{id}")
    public ResponseEntity<Enquiry> enquiryById(@PathVariable int id){
        Optional<Enquiry> enquiry = repo.findById(id);
        return enquiry.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping("/enquiry/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createEnquiry(@RequestBody Enquiry enquiry){
        repo.save(enquiry);
    }

    @DeleteMapping("/enquiry/delete/{id}")
    public ResponseEntity<Void> deleteEnquiry(@PathVariable int id){
        Optional<Enquiry> enquiry = repo.findById(id);
        if(enquiry.isPresent()){
           repo.delete(enquiry.get());

           return ResponseEntity.noContent().build();
        }else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/enquiry/update/{id}")
    public ResponseEntity<Enquiry> updateEnquiry(@PathVariable int id , @RequestBody Enquiry enquiry){
       Optional<Enquiry> enquiry1 = repo.findById(id);
       if(enquiry1.isPresent()){
           Enquiry enquiry2 = enquiry1.get();
           enquiry2.setCourseName(enquiry.getCourseName());
           enquiry2.setEnquiryTitle(enquiry.getEnquiryTitle());
           enquiry2.setDescription(enquiry.getDescription());
           enquiry2.setEmail(enquiry.getEmail());
           enquiry2.setDate(enquiry.getDate());

           repo.save(enquiry2);

           return ResponseEntity.ok(enquiry2);
       }else
           return  ResponseEntity.notFound().build();
    }


    

}
