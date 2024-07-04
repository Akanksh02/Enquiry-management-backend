package com.enquirymgmt.enquiry.entity;


import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column( name = "Payers_name")
    private String name;
    @Column(name = "course")
    private String courseName;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "cardnumber")
    private String cardNumber;
    @Column(name = "amount")
    private int amount;
    @Column (name = "date")
    private Date date;

    public Payment() {
    }

    public Payment(int id , String name,String courseName,String paymentType,String cardNumber , int amount , Date date) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.amount=amount;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCourseName() {
        return courseName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
