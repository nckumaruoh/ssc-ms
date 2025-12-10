package com.klh.sscms.core;

/**
 * Represents enrollment of a student into a course.
 */
public class Enrollment {

    private String studentId;
    private String courseCode;

    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }

    @Override
    public String toString() {
        return "Enrollment: Student " + studentId +
               " -> Course " + courseCode;
    }
}

