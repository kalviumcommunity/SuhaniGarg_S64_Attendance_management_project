// package com.school;

// public class Main {
//     public static void main(String[] args) {
//         Student[] students = new Student[2];
//         Course[] courses = new Course[2];

//         // Initialize students
//         students[0] = new Student();
//         students[0].setDetails(1, "Alice");
//         students[1] = new Student();
//         students[1].setDetails(2, "Bob");

//         // Initialize courses
//         courses[0] = new Course();
//         courses[0].setDetails(101, "Mathematics");
//         courses[1] = new Course();
//         courses[1].setDetails(102, "Science");

//         // Display students
//         System.out.println("=== Students ===");
//         for (Student student : students) {
//             student.displayDetails();
//         }

//         // Display courses
//         System.out.println("=== Courses ===");
//         for (Course course : courses) {
//             course.displayDetails();
//         }
//     }
// }
package com.school;

public class main {
    public static void main(String[] args) {
        // Create students using constructor
        Student[] students = {
            new Student("Alice"),
            new Student("Bob"),
            new Student("Charlie") // extra student to test auto-ID
        };

        // Create courses using constructor
        Course[] courses = {
            new Course("Mathematics"),
            new Course("Science"),
            new Course("History") // extra course to test auto-ID
        };

        // Display students
        System.out.println("=== Students ===");
        for (Student student : students) {
            student.displayDetails();
        }

        // Display courses
        System.out.println("=== Courses ===");
        for (Course course : courses) {
            course.displayDetails();
        }
    }
}
