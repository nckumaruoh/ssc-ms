package com.klh.sscms.Operations;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.klh.sscms.services.AnalyticsService;
import com.klh.sscms.services.EnrollmentService;

public class AnalyticsOperations {

    private AnalyticsService analytics;

    public AnalyticsOperations(EnrollmentService es) {
        this.analytics = new AnalyticsService(es.getStudentsList());
    }

    public void analyticsMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- ANALYTICS ---");
            System.out.println("1. Top Performers");
            System.out.println("2. Low Performers");
            System.out.println("3. Class Average");
            System.out.println("4. Topper & Lowest Scorer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            int ch;
            try {
                ch = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            switch (ch) {

                case 1:
                    System.out.print("Enter threshold: ");
                    int t1 = sc.nextInt();
                    sc.nextLine();
                    analytics.getTopPerformers(t1).forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter threshold: ");
                    int t2 = sc.nextInt();
                    sc.nextLine();
                    analytics.getLowPerformers(t2).forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Class Average: " + analytics.getAverageMarks());
                    break;

                case 4:
                    System.out.println("Topper: " + analytics.getTopper());
                    System.out.println("Lowest: " + analytics.getBottom());
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
