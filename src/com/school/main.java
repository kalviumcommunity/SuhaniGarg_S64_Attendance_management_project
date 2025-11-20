package com.school;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Create students with grade levels
        Student student1 = new Student("Alice", "Grade 10");
        Student student2 = new Student("Bob", "Grade 11");

        // Create teachers
        Teacher teacher1 = new Teacher("Ms. Johnson", "Mathematics");
        Teacher teacher2 = new Teacher("Mr. Smith", "Science");

        // Create staff members
        Staff staff1 = new Staff("Mrs. Davis", "Administrator");
        Staff staff2 = new Staff("Mr. Wilson", "Janitor");

        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        // Part 7: Polymorphic Behaviour - School Directory
        System.out.println("=== School Directory ===");
        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(student1);
        schoolPeople.add(student2);
        schoolPeople.add(teacher1);
        schoolPeople.add(teacher2);
        schoolPeople.add(staff1);
        schoolPeople.add(staff2);
        
        displaySchoolDirectory(schoolPeople);

        // Display courses
        System.out.println("\n=== Courses ===");
        course1.displayDetails();
        course2.displayDetails();

        // Attendance Log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Add attendance records using Student and Course objects
        attendanceLog.add(new AttendanceRecord(student1, course1, "Present"));
        attendanceLog.add(new AttendanceRecord(student2, course2, "Absent"));
        attendanceLog.add(new AttendanceRecord(student1, course2, "Late")); // invalid

        // Display attendance
        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Part 6: Interface-Driven Persistence with Storage
        System.out.println("\n=== Saving Data to Files ===");
        
        // Filter students from schoolPeople list using instanceof
        List<Student> students = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                students.add((Student) person);
            }
        }
        
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        
        // Save data to files using FileStorageService
        FileStorageService.saveData(students, "students.txt");
        FileStorageService.saveData(courses, "courses.txt");
        FileStorageService.saveData(attendanceLog, "attendance_log.txt");
        
        System.out.println("\n=== Data Saved Successfully ===");
        System.out.println("Check the following files:");
        System.out.println("- students.txt");
        System.out.println("- courses.txt");
        System.out.println("- attendance_log.txt");
    }

    // Part 7: Display School Directory using polymorphism
    public static void displaySchoolDirectory(List<Person> people) {
        for (Person person : people) {
            person.displayDetails(); // Each calls its own overridden version at runtime
        }
    }
}