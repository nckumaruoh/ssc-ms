package com.klh.sscms.services;

import com.klh.sscms.core.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course c) {
        courses.add(c);
        System.out.println("Course added successfully.");
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : courses) {
            System.out.println(c);
        }
    }
public List<Course> getCoursesList() {
    return courses;
}

    public Course searchByCode(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    public void assignFaculty(String courseCode, String facultyId) {
        Course c = searchByCode(courseCode);
        if (c == null) {
            System.out.println("Course not found.");
        } else {
            c.assignFaculty(facultyId);
            System.out.println("Faculty assigned successfully.");
        }
    }
}

