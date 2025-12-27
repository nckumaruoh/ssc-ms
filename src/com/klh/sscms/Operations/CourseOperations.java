package com.klh.sscms.Operations;

import java.util.Scanner;
import com.klh.sscms.services.CourseService;
import com.klh.sscms.core.Course;

public class CourseOperations {

    private CourseService cs;

    public CourseOperations(CourseService cs) {
        this.cs = cs;
    }

    public void courseMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- COURSE MANAGEMENT ---");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Assign Faculty to Course");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Enter Course Code: ");
                    String code = sc.nextLine();

                    System.out.print("Enter Course Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Credits: ");
                    int credits = sc.nextInt();
                    sc.nextLine();

                    Course c = new Course(code, title, credits);
                    cs.addCourse(c);
                    break;

                case 2:
                    cs.listCourses();
                    break;

                case 3:
                    System.out.print("Enter Course Code: ");
                    String cc = sc.nextLine();

                    System.out.print("Enter Faculty ID: ");
                    String fid = sc.nextLine();

                    cs.assignFaculty(cc, fid);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

