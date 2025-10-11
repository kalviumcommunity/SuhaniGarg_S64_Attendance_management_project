package com.school;

public class Course implements Storable {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}
