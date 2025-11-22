package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    // Constructor
    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // Overloaded method 1: Mark attendance with Student and Course objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Overloaded method 2: Mark attendance with IDs (delegates lookup to RegistrationService)
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("⚠ Warning: Could not find student (ID: " + studentId + 
                             ") or course (ID: " + courseId + ") for attendance record.");
        }
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