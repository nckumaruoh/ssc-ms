package com.klh.sscms.services;

import com.klh.sscms.core.Student;
import com.klh.sscms.core.Course;
import com.klh.sscms.core.Enrollment;
import com.klh.sscms.core.Faculty;

import java.io.*;
import java.util.*;

public class FileService {

    // -----------------------------
    // SAVE STUDENTS TO CSV
    // -----------------------------
    public void saveStudents(List<Student> students, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                pw.println(s.toCsv());
            }
            System.out.println("Students saved to file.");
        } catch (Exception e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // -----------------------------
    // LOAD STUDENTS FROM CSV
    // -----------------------------
    public List<Student> loadStudents(String filename) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                // CSV: id, name, email, sem, m1, m2, m3
                int[] marks = new int[t.length - 4];

                for (int i = 4; i < t.length; i++)
                    marks[i - 4] = Integer.parseInt(t[i]);

                Student s = new Student(
                    t[0], t[1], t[2],
                    Integer.parseInt(t[3]),
                    marks
                );

                list.add(s);
            }
            System.out.println("Students loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return list;
    }

    // -----------------------------
    // SAVE COURSES
    // -----------------------------
    public void saveCourses(List<Course> courses, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Course c : courses) {
                pw.println(c.getCourseCode() + "," +
                           c.getTitle() + "," +
                           c.getCredits() + "," +
                           c.getFacultyId());
            }
            System.out.println("Courses saved.");
        } catch (Exception e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    public void saveFaculty(List<Faculty> list, String filename) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
        for (Faculty f : list) {
            pw.println(f.toCsv());
        }
        System.out.println("Faculty saved successfully.");
    } catch (Exception ex) {
        System.out.println("Error saving faculty: " + ex.getMessage());
    }
}
  
public List<Faculty> loadFaculty(String filename) {
    List<Faculty> facultyList = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        while ((line = br.readLine()) != null) {
            String[] t = line.split(",");

            // t[0]=id, t[1]=name, t[2]=email, t[3]=department
            String[] courses = {};
            if (t.length > 4 && !t[4].isEmpty()) {
                courses = t[4].split(";");
            }

            Faculty f = new Faculty(
                t[0],     // id
                t[1],     // name
                t[2],     // email
                t[3],     // department
                courses   // coursesHandled
            );

            facultyList.add(f);
        }

        System.out.println("Faculty loaded successfully.");

    } catch (Exception e) {
        System.out.println("Error loading faculty: " + e.getMessage());
    }

    return facultyList;
}


    // -----------------------------
    // SAVE ENROLLMENTS
    // -----------------------------
    public void saveEnrollments(List<Enrollment> records, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Enrollment e : records) {
                pw.println(e.getStudentId() + "," + e.getCourseCode());
            }
            System.out.println("Enrollments saved.");
        } catch (Exception e) {
            System.out.println("Error saving enrollments: " + e.getMessage());
        }
    }

    public List<Course> loadCourses(String filename) {
    List<Course> list = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        while ((line = br.readLine()) != null) {

            String[] t = line.split(",");
            String code = t[0];
            String title = t[1];
            int credits = Integer.parseInt(t[2]);
            String facultyId = t.length > 3 ? t[3] : null;

            Course c = new Course(code, title, credits);
            if (facultyId != null && !facultyId.equals(""))
                c.assignFaculty(facultyId);

            list.add(c);
        }

    } catch (Exception e) {
        System.out.println("Error loading courses: " + e.getMessage());
    }

    return list;
}

public List<Enrollment> loadEnrollments(String filename) {
    List<Enrollment> list = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        while ((line = br.readLine()) != null) {
            String[] t = line.split(",");
            String sid = t[0];
            String cid = t[1];
            list.add(new Enrollment(sid, cid));
        }

    } catch (Exception e) {
        System.out.println("Error loading enrollments: " + e.getMessage());
    }

    return list;
}


}

