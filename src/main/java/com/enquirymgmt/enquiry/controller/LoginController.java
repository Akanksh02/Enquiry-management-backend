package com.enquirymgmt.enquiry.controller;

import com.enquirymgmt.enquiry.entity.Student;
import com.enquirymgmt.enquiry.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private StudentRepository repo;

   


    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Student loginStudent){
        Student student = repo.findByEmail(loginStudent.getEmail());
        if(student != null && student.getPassword().equals(loginStudent.getPassword())){
            return ResponseEntity.ok(student);
        }else {
            throw new RuntimeException("Invalid email or password");
        }
    }

}
