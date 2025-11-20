package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    // Constructor with validation
    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("⚠ Warning: Invalid attendance status provided for Student ID: " + student.getId());
        }
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getStudentId() {
        return student.getId();
    }

    public int getCourseId() {
        return course.getCourseId();
    }

    public String getStatus() {
        return status;
    }

    // Display method
    public void displayRecord() {
        System.out.println("AttendanceRecord -> Student: " + student.getName() + 
                           " (ID: " + student.getId() + "), " +
                           "Course: " + course.getCourseName() + 
                           " (ID: C" + course.getCourseId() + "), " +
                           "Status: " + status);
    }

    // Implement Storable interface - CSV format
    @Override
    public String toDataString() {
        return this.student.getId() + "," + this.course.getCourseId() + "," + this.status;
    }
}