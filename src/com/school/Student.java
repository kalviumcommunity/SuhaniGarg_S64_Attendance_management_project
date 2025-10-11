package com.school;

public class Student implements Storable {
    private String id;
    private String name;
    private int gradeLevel;

    public Student(String id, String name, int gradeLevel) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + gradeLevel;
    }
}
