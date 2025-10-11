package com.school;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        // Sample data
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Alice", 10));
        students.add(new Student("S002", "Bob", 11));
        students.add(new Student("S003", "Charlie", 12));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("C101", "Mathematics"));
        courses.add(new Course("C102", "Science"));

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord("S001", "C101", "Present"));
        records.add(new AttendanceRecord("S002", "C102", "Absent"));
        records.add(new AttendanceRecord("S003", "C101", "Present"));

        // Save to files
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");

        System.out.println("All data saved successfully!");
    }
}
