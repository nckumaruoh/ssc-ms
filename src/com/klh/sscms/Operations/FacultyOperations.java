package com.klh.sscms.Operations;

import java.util.Scanner;
import com.klh.sscms.services.FacultyService;
import com.klh.sscms.core.Faculty;

public class FacultyOperations {

    private FacultyService fs;

    public FacultyOperations(FacultyService fs) {
        this.fs = fs;
    }

    public void facultyMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- FACULTY MANAGEMENT ---");
            System.out.println("1. Add Faculty");
            System.out.println("2. List Faculty");
            System.out.println("3. Search By Faculty ID");
            System.out.println("0. Back to Main Menu");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Faculty ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    Faculty f = new Faculty(id, name, email, dept, new String[]{});
                    fs.addFaculty(f);
                    break;

                case 2:
                    fs.listFaculty();
                    break;

                case 3:
                    System.out.print("Enter Faculty ID: ");
                    String fid = sc.nextLine();
                    Faculty found = fs.searchById(fid);
                    System.out.println(found != null ? found : "Not Found.");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
