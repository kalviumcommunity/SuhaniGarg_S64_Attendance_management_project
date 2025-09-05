package com.school;

public class Course {
    private int courseId;
    private String courseName;

    // Method to set details
    public void setDetails(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Course ID: " + this.courseId + ", Course Name: " + this.courseName);
    }
}