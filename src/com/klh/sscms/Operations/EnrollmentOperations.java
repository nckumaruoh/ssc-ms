package com.klh.sscms.Operations;

import java.util.Scanner;
import com.klh.sscms.services.EnrollmentService;

public class EnrollmentOperations {

    private EnrollmentService es;

    public EnrollmentOperations(EnrollmentService es) {
        this.es = es;
    }

    public void enrollmentMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- ENROLLMENT MANAGEMENT ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Student's Enrollments");
            System.out.println("3. View Course Enrollment List");
            System.out.println("4. Drop Enrollment");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();

                    System.out.print("Enter Course Code: ");
                    String cid = sc.nextLine();

                    es.enroll(sid, cid);
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    String s = sc.nextLine();
                    es.viewStudentEnrollments(s);
                    break;

                case 3:
                    System.out.print("Enter Course Code: ");
                    String c = sc.nextLine();
                    es.viewCourseEnrollments(c);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    String ds = sc.nextLine();

                    System.out.print("Enter Course Code: ");
                    String dc = sc.nextLine();

                    es.drop(ds, dc);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
