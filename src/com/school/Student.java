package com.school;

public class Student extends Person {
    private String gradeLevel;

    // Constructor
    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    // Override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, Grade Level: " + gradeLevel);
    }
}
