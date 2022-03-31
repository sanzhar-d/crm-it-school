package com.example.models;

public class Course {

    private Long id;
    private String name;
    private double price;
    private CourseFormat courseFormat;

    public Course(Long id, String name, double price, CourseFormat courseFormat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.courseFormat = courseFormat;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CourseFormat getCourseFormat() {
        return courseFormat;
    }

    public void setCourseFormat(CourseFormat courseFormat) {
        this.courseFormat = courseFormat;
    }
}
