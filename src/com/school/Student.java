package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    // Constructor
    public Student(String name, String gradeLevel) {
        super(name); // Call parent constructor
        this.gradeLevel = gradeLevel;
    }

    // Getter for grade level
    public String getGradeLevel() {
        return gradeLevel;
    }

    // Override display details to add student-specific info
    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + this.getId() + ", Name: " + this.getName() + 
                          ", Grade Level: " + this.gradeLevel);
    }

    // Keep getStudentId() for backward compatibility
    public int getStudentId() {
        return this.getId();
    }

    // Implement Storable interface - CSV format
    @Override
    public String toDataString() {
        return this.getId() + "," + this.getName() + "," + this.gradeLevel;
    }
}