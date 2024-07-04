package com.enquirymgmt.enquiry.repository;

import com.enquirymgmt.enquiry.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryRepository extends JpaRepository<Enquiry,Integer> {
}
