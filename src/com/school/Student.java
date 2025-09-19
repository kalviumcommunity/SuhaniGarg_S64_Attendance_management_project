package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;
    private int studentId;
    private String name;

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
    }

    // Getters (Encapsulation)
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
    }
}
