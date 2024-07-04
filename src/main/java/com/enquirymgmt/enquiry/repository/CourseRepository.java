package com.enquirymgmt.enquiry.repository;

import com.enquirymgmt.enquiry.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
