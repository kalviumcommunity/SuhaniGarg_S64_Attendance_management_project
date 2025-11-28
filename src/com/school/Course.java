package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters (Encapsulation)
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents); // Return a copy to prevent external modification
    }

    public int getEnrollmentCount() {
        return enrolledStudents.size();
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            if (!enrolledStudents.contains(student)) {
                enrolledStudents.add(student);
                return true;
            }
        }
        return false;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + ", Course Name: " + this.courseName + 
                          ", Capacity: " + this.capacity + ", Enrolled: " + this.enrolledStudents.size());
    }

    // Implement Storable interface - CSV format
    @Override
    public String toDataString() {
        return this.courseId + "," + this.courseName + "," + this.capacity;
    }
}