package com.enquirymgmt.enquiry.repository;

import com.enquirymgmt.enquiry.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
