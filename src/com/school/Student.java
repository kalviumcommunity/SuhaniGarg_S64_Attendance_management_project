// package com.school;

// public class Student {
//     private int studentId;
//     private String name;

    
//     public void setDetails(int studentId, String name) {
//         this.studentId = studentId;
//         this.name = name;
//     }

    
//     public void displayDetails() {
//         System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
//     }
// }
package com.school;

public class Student {
    private static int nextStudentIdCounter = 1; // auto-increment counter
    private int studentId;
    private String name;

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++; // assign & increment
        this.name = name;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
    }
}
