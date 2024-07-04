package com.enquirymgmt.enquiry.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "enquiry")
public class Enquiry {



    public Enquiry() {
    }

    public Enquiry(int id ,String courseName ,String enquiryTitle,String description,String email , Date date) {
        super();
        this.courseName = courseName;
        this.enquiryTitle=enquiryTitle;
        this.description=description;
        this.email = email;
        this.date=date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "enquiry_title")
    private String enquiryTitle;

    @Column(name = "description")
    private  String description;
    @Column(name = "email")
    private  String email;
    @Column(name = "date")
    private Date date;


    public int getId() {
        return id;
    }

    public String getEnquiryTitle() {
        return enquiryTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnquiryTitle(String enquiryTitle) {
        this.enquiryTitle = enquiryTitle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Enquiry{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", enquiryTitle='" + enquiryTitle + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }

}
