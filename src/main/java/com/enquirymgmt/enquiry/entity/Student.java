package com.enquirymgmt.enquiry.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    public Student() {
    }

    public Student(String name , String email , String password,String role) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role =role;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "username")
    private  String name;
    @Column(name = "email")
    private String email;
    @Column (name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
