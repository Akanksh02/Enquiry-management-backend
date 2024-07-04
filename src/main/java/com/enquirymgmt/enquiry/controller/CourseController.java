package com.enquirymgmt.enquiry.controller;

import com.enquirymgmt.enquiry.entity.Course;
import com.enquirymgmt.enquiry.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {


    @Autowired
    CourseRepository repo;



    @GetMapping("/courses")
    public List<Course> allCourse(){

        return  repo.findAll();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id){

        Optional<Course> course = repo.findById(id);
        return course.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping("/courses/add")
    public void insertCourse(@RequestBody Course course){
        repo.save(course);
    }

    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id){
        Optional<Course> course = repo.findById(id);
        if(course.isPresent()){
            repo.delete(course.get());

            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();

    }

    @PutMapping("/courses/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course , @PathVariable int id)
    {
       Optional<Course> courses = repo.findById(id);
       if(courses.isPresent())
       {
           Course existingCourse = courses.get();
           existingCourse.setCourse_name(course.getCourse_name());
           existingCourse.setCourse_description(course.getCourse_description());
           existingCourse.setCost(course.getCost());
           existingCourse.setDuration(course.getDuration());
           repo.save(existingCourse);

           return  ResponseEntity.ok(existingCourse);

       }
       else
           return ResponseEntity.notFound().build();

    }

   

}
