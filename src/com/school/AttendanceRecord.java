package com.school;

public class AttendanceRecord implements Storable {
    private String studentId;
    private String courseId;
    private String status;

    public AttendanceRecord(String studentId, String courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}
