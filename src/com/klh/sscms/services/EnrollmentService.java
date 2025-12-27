package com.klh.sscms.services;

import com.klh.sscms.core.Student;
import com.klh.sscms.exceptions.StudentNotFoundException;
import com.klh.sscms.core.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class EnrollmentService {

    // ============================
    // STUDENT LIST MANAGEMENT
    // ============================

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully.");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled yet.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }
   


    public List<Student> getStudentsList() {
        return students;
    }

    // ============================
    // ENROLLMENT MANAGEMENT
    // ============================

    private ArrayList<Enrollment> records = new ArrayList<>();

    public void enroll(String studentId, String courseCode) {
        records.add(new Enrollment(studentId, courseCode));
        System.out.println("Enrollment successful.");
    }

    public void viewStudentEnrollments(String studentId) {
        boolean found = false;
        for (Enrollment e : records) {
            if (e.getStudentId().equals(studentId)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("No enrollments found.");
    }

    public void viewCourseEnrollments(String courseCode) {
        boolean found = false;
        for (Enrollment e : records) {
            if (e.getCourseCode().equals(courseCode)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("No students enrolled.");
    }

    public void drop(String studentId, String courseCode) {
        Enrollment remove = null;
        for (Enrollment e : records) {
            if (e.getStudentId().equals(studentId) &&
                e.getCourseCode().equals(courseCode)) {
                remove = e;
                break;
            }
        }
        if (remove != null) {
            records.remove(remove);
            System.out.println("Enrollment removed.");
        } else {
            System.out.println("Enrollment not found.");
        }
    }
public void addEnrollmentRecord(Enrollment e) {
    records.add(e);
}
public Student findByIdOrThrow(String id) throws StudentNotFoundException {
    for (Student s : students) {
        if (s.getId().equals(id)) {
            return s;
        }
    }
    throw new StudentNotFoundException("Student with ID " + id + " not found.");
}


    public List<Enrollment> getEnrollmentRecords() {
        return records;
  
  
    }

    public void removeStudent(String studentId) {
    java.util.Iterator<Student> it = students.iterator();
    while (it.hasNext()) {
        Student s = it.next();
        if (s.getId().equals(studentId)) {
            it.remove();
            return;
        }
    }
}

}
