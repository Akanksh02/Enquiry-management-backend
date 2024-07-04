package com.enquirymgmt.enquiry.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    public Course()
    {
    }

    public Course(int course_id ,String course_name,String course_description,int cost , int duration)
    {
        super();
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.cost = cost;
        this.duration = duration;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    @Column(name = "course_name")
    private String course_name;
    @Column(name = "course_description")
    private String course_description;
    @Column(name = "cost")
    private int cost;
    @Column(name = "duration")
    private int duration;


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }


    public String getCourse_description() {
        return course_description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_description='" + course_description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                '}';
    }
}
