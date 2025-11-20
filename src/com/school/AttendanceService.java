package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // Overloaded method 1: Mark attendance with Student and Course objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Overloaded method 2: Mark attendance with IDs and lookup lists
    public void markAttendance(int studentId, int courseId, String status, 
                              List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("⚠ Warning: Could not find student (ID: " + studentId + 
                             ") or course (ID: " + courseId + ") for attendance record.");
        }
    }

    // Helper method to find Student by ID
    private Student findStudentById(int studentId, List<Student> allStudents) {
        for (Student student : allStudents) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Helper method to find Course by ID
    private Course findCourseById(int courseId, List<Course> allCourses) {
        for (Course course : allCourses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    // Overloaded method 1: Display all attendance records
    public void displayAttendanceLog() {
        System.out.println("\n=== Attendance Log (All Records) ===");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            for (AttendanceRecord record : attendanceLog) {
                record.displayRecord();
            }
        }
    }

    // Overloaded method 2: Display attendance records for a specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n=== Attendance Log for Student: " + student.getName() + " ===");
        List<AttendanceRecord> filteredRecords = attendanceLog.stream()
            .filter(record -> record.getStudent().getId() == student.getId())
            .collect(Collectors.toList());
        
        if (filteredRecords.isEmpty()) {
            System.out.println("No attendance records found for this student.");
        } else {
            for (AttendanceRecord record : filteredRecords) {
                record.displayRecord();
            }
        }
    }

    // Overloaded method 3: Display attendance records for a specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n=== Attendance Log for Course: " + course.getCourseName() + " ===");
        List<AttendanceRecord> filteredRecords = attendanceLog.stream()
            .filter(record -> record.getCourse().getCourseId() == course.getCourseId())
            .collect(Collectors.toList());
        
        if (filteredRecords.isEmpty()) {
            System.out.println("No attendance records found for this course.");
        } else {
            for (AttendanceRecord record : filteredRecords) {
                record.displayRecord();
            }
        }
    }

    // Save attendance data using storage service
    public void saveAttendanceData() {
        FileStorageService.saveData(attendanceLog, "attendance_log.txt");
    }
}