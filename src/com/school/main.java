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

        // Part 8: Overloaded Commands - AttendanceService
        System.out.println("\n=== Part 8: Attendance Service with Overloaded Methods ===");
        
        // Create FileStorageService and AttendanceService instances
        FileStorageService fileStorageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(fileStorageService);
        
        // Create lists of all Students and all Courses
        List<Student> allStudents = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                allStudents.add((Student) person);
            }
        }
        
        List<Course> allCourses = new ArrayList<>();
        allCourses.add(course1);
        allCourses.add(course2);
        
        // Mark attendance using overloaded methods
        System.out.println("\n--- Marking Attendance (Method 1: With Objects) ---");
        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course2, "Absent");
        
        System.out.println("\n--- Marking Attendance (Method 2: With IDs) ---");
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present", allStudents, allCourses);
        attendanceService.markAttendance(student2.getId(), course1.getCourseId(), "Late", allStudents, allCourses); // invalid status
        
        // Display attendance using overloaded methods
        System.out.println("\n--- Displaying All Attendance Records ---");
        attendanceService.displayAttendanceLog();
        
        System.out.println("\n--- Displaying Attendance for Specific Student ---");
        attendanceService.displayAttendanceLog(student1);
        
        System.out.println("\n--- Displaying Attendance for Specific Course ---");
        attendanceService.displayAttendanceLog(course1);
        
        // Part 6: Interface-Driven Persistence with Storage
        System.out.println("\n=== Saving Data to Files ===");
        
        // Save students and courses
        FileStorageService.saveData(allStudents, "students.txt");
        FileStorageService.saveData(allCourses, "courses.txt");
        
        // Save attendance data using AttendanceService
        attendanceService.saveAttendanceData();
        
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