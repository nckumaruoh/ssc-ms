package com.klh.sscms.core;
/**
 * Represents a course in the SSC-MS system.
 */
public class Course {

    private String courseCode;
    private String title;
    private int credits;
    private String facultyId; // assigned faculty (optional for now)

    public Course(String courseCode, String title, int credits) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.facultyId = null;
    }

    // Assign a faculty
    public void assignFaculty(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getFacultyId() { return facultyId; }

    @Override
    public String toString() {
        return courseCode + " - " + title + " (" + credits + " credits)" +
               (facultyId != null ? " | Faculty: " + facultyId : "");
    }
}

