package com.klh.sscms.core;

import java.util.*;

import com.klh.sscms.services.*;
import com.klh.sscms.Operations.*;

import com.klh.sscms.ds.undo.UndoManager;

public class AppMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------
        // INITIALIZE SERVICES
        // -------------------------------
        EnrollmentService enrollService = new EnrollmentService();
        CourseService courseService = new CourseService();
        FacultyService facultyService = new FacultyService();
        FileService fileService = new FileService();

        // -------------------------------
        // INITIALIZE UNDO MANAGER
        // -------------------------------
        UndoManager undoManager = new UndoManager();

        // -------------------------------
        // LOAD DATA
        // -------------------------------
        try {
            fileService.loadStudents("students.csv")
                       .forEach(enrollService::addStudent);

            fileService.loadFaculty("faculty.csv")
                       .forEach(facultyService::addFaculty);

            fileService.loadCourses("courses.csv")
                       .forEach(courseService::addCourse);

            fileService.loadEnrollments("enrollments.csv")
                       .forEach(enrollService::addEnrollmentRecord);

        } catch (Exception e) {
            System.out.println("Starting with empty data.");
        }

        // -------------------------------
        // INITIALIZE OPERATIONS
        // -------------------------------
        StudentOperations studentOps =
                new StudentOperations(enrollService, undoManager);

        FacultyOperations facultyOps =
                new FacultyOperations(facultyService);

        CourseOperations courseOps =
                new CourseOperations(courseService);

        EnrollmentOperations enrollOps =
                new EnrollmentOperations(enrollService);

        AnalyticsOperations analyticsOps =
                new AnalyticsOperations(enrollService);

        // -------------------------------
        // MAIN MENU
        // -------------------------------
        while (true) {

            System.out.println("\n========= SSC-MS MAIN MENU =========");
            System.out.println("1. Student Management");
            System.out.println("2. Faculty Management");
            System.out.println("3. Course Management");
            System.out.println("4. Enrollment Management");
            System.out.println("5. Reports & Analytics");
            System.out.println("6. Save All Data");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    studentOps.studentMenu(sc);
                    break;

                case 2:
                    facultyOps.facultyMenu(sc);
                    break;

                case 3:
                    courseOps.courseMenu(sc);
                    break;

                case 4:
                    enrollOps.enrollmentMenu(sc);
                    break;

                case 5:
                    analyticsOps.analyticsMenu(sc);
                    break;

                case 6:
                    fileService.saveStudents(enrollService.getStudentsList(), "students.csv");
                    fileService.saveFaculty(facultyService.getFacultyList(), "faculty.csv");
                    fileService.saveCourses(courseService.getCoursesList(), "courses.csv");
                    fileService.saveEnrollments(enrollService.getEnrollmentRecords(), "enrollments.csv");
                    System.out.println("All data saved successfully.");
                    break;

                case 0:
                    sc.close();
                    System.out.println("Exiting SSC-MS.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
