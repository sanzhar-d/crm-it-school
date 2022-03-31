package com.example.models;

public class CourseFormat {

    private Long id;
    private String format;
    private int durationWeeks;
    private int lessonDuration;
    private int lessonsPerWeek;
    private boolean isOnline;

    public CourseFormat(Long id, String format, int durationWeeks, int lessonDuration, int lessonsPerWeek, boolean isOnline) {
        this.id = id;
        this.format = format;
        this.durationWeeks = durationWeeks;
        this.lessonDuration = lessonDuration;
        this.lessonsPerWeek = lessonsPerWeek;
        this.isOnline = isOnline;
    }

    public CourseFormat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
    }

    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public int getLessonsPerWeek() {
        return lessonsPerWeek;
    }

    public void setLessonsPerWeek(int lessonsPerWeek) {
        this.lessonsPerWeek = lessonsPerWeek;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
