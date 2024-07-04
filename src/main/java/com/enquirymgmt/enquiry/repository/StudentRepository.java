package com.enquirymgmt.enquiry.repository;

import com.enquirymgmt.enquiry.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
}
