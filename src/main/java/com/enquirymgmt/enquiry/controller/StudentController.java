package com.enquirymgmt.enquiry.controller;

import com.enquirymgmt.enquiry.entity.Student;
import com.enquirymgmt.enquiry.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/student")
    public List<Student> getAllStudent(){

        return  repo.findAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Optional<Student> student = repo.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }

//    @PutMapping("/student/update/{id}")
//    public Student updateStudent(@PathVariable int id){
//        repo.findById(id);
//        return null;
//    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
     Optional<Student> student = repo.findById(id);
     if(student.isPresent()){
         repo.delete(student.get());
         reassignId();
         return ResponseEntity.noContent().build();
     } else
       return ResponseEntity.notFound().build();
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student){
        Optional<Student> students = repo.findById(id);
        if(students.isPresent()) {
            Student existingStudent = students.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            repo.save(existingStudent);

            return ResponseEntity.ok(existingStudent);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    public void reassignId() {
        List<Student> enquiries = repo.findAll();
        for (int i = 0; i < enquiries.size(); i++) {
            Student enquiry = enquiries.get(i);
            enquiry.setId(i + 1);
            repo.save(enquiry);
        }
    }
}
