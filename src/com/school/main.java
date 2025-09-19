package com.school;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        // Display students
        System.out.println("=== Students ===");
        student1.displayDetails();
        student2.displayDetails();

        // Display courses
        System.out.println("=== Courses ===");
        course1.displayDetails();
        course2.displayDetails();

        // Attendance Log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Add attendance records (valid + invalid)
        attendanceLog.add(new AttendanceRecord(student1.getStudentId(), course1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(student2.getStudentId(), course2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(student1.getStudentId(), course2.getCourseId(), "Late")); // invalid

        // Display attendance
        System.out.println("=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
