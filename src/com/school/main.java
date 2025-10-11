package com.school;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // ✅ Updated: provide gradeLevel to Student constructor
        Student student1 = new Student("Alice", "10th Grade");
        Student student2 = new Student("Bob", "12th Grade");

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

        // ✅ Attendance Log using getId() (from Person)
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(student2.getId(), course2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(student1.getId(), course2.getCourseId(), "Late")); // invalid

        // Display attendance records
        System.out.println("=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
