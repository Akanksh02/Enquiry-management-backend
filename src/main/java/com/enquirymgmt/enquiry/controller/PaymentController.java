package com.enquirymgmt.enquiry.controller;


import com.enquirymgmt.enquiry.entity.Payment;
import com.enquirymgmt.enquiry.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    @Autowired
    PaymentRepository repo;

    @GetMapping("/payment")
    public List<Payment> showPaymentForm(){
        return repo.findAll();
    }

    @PostMapping("/payment/add")
    public void  addPayment(@RequestBody Payment payment){
        repo.save(payment);
    }
}
