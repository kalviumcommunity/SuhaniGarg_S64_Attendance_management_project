package com.school;

import java.util.List;

public class main {
    public static void main(String[] args) {
        // Part 9: SOLID Service Layer - Create services
        FileStorageService fileStorageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(fileStorageService);
        AttendanceService attendanceService = new AttendanceService(fileStorageService, registrationService);

        // Create and register students
        Student student1 = new Student("Alice", "Grade 10");
        Student student2 = new Student("Bob", "Grade 11");
        registrationService.registerStudent(student1);
        registrationService.registerStudent(student2);

        // Create and register teachers
        Teacher teacher1 = new Teacher("Ms. Johnson", "Mathematics");
        Teacher teacher2 = new Teacher("Mr. Smith", "Science");
        registrationService.registerTeacher(teacher1);
        registrationService.registerTeacher(teacher2);

        // Create and register staff members
        Staff staff1 = new Staff("Mrs. Davis", "Administrator");
        Staff staff2 = new Staff("Mr. Wilson", "Janitor");
        registrationService.registerStaff(staff1);
        registrationService.registerStaff(staff2);

        // Create and register courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        registrationService.registerCourse(course1);
        registrationService.registerCourse(course2);

        // Part 7: Polymorphic Behaviour - School Directory
        System.out.println("=== School Directory ===");
        displaySchoolDirectory(registrationService.getAllPeople());

        // Display courses
        System.out.println("\n=== Courses ===");
        for (Course course : registrationService.getAllCourses()) {
            course.displayDetails();
        }

        // Part 8: Overloaded Commands - AttendanceService
        System.out.println("\n=== Part 8: Attendance Service with Overloaded Methods ===");
        
        // Mark attendance using overloaded methods
        System.out.println("\n--- Marking Attendance (Method 1: With Objects) ---");
        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course2, "Absent");
        
        System.out.println("\n--- Marking Attendance (Method 2: With IDs) ---");
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present");
        attendanceService.markAttendance(student2.getId(), course1.getCourseId(), "Late"); // invalid status
        
        // Display attendance using overloaded methods
        System.out.println("\n--- Displaying All Attendance Records ---");
        attendanceService.displayAttendanceLog();
        
        System.out.println("\n--- Displaying Attendance for Specific Student ---");
        attendanceService.displayAttendanceLog(student1);
        
        System.out.println("\n--- Displaying Attendance for Specific Course ---");
        attendanceService.displayAttendanceLog(course1);
        
        // Part 9: Save all data using services
        System.out.println("\n=== Saving Data to Files ===");
        registrationService.saveAllData();
        attendanceService.saveAttendanceData();
        
        System.out.println("\n=== Data Saved Successfully ===");
        System.out.println("Check the following files:");
        System.out.println("- students.txt");
        System.out.println("- teachers.txt");
        System.out.println("- staff.txt");
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