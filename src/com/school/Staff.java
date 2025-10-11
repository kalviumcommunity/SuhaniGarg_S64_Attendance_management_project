package com.school;

public class Staff extends Person {
    private String role;

    // Constructor
    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff, Staff Role: " + role);
    }
}

