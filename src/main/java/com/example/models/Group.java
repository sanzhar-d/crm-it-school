package com.example.models;

public class Group {

    private Long id;
    private String name;
    private String groupTime;
    private Branch branch;
    private Course course;
    private Mentor mentor;

    public Group(Long id, String name, String groupTime, Branch branch, Course course, Mentor mentor) {
        this.id = id;
        this.name = name;
        this.groupTime = groupTime;
        this.branch = branch;
        this.course = course;
        this.mentor = mentor;
    }

    public Group() {
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

    public String getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(String groupTime) {
        this.groupTime = groupTime;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
