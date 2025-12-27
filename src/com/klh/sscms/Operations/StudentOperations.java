package com.klh.sscms.Operations;

import java.util.Scanner;

import com.klh.sscms.services.EnrollmentService;
import com.klh.sscms.core.Student;
import com.klh.sscms.exceptions.StudentNotFoundException;
import com.klh.sscms.ds.undo.*;

public class StudentOperations {

    private EnrollmentService enrollService;
    private UndoManager undoManager;

    // ✅ Constructor expected by AppMain
    public StudentOperations(EnrollmentService enrollService,
                             UndoManager undoManager) {
        this.enrollService = enrollService;
        this.undoManager = undoManager;
    }

    // -------------------------------
    // STUDENT MENU
    // -------------------------------
    public void studentMenu(Scanner sc) {

        while (true) {

            System.out.println("\n--- STUDENT MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. List All Students");
            System.out.println("3. Search By Student ID");
            System.out.println("4. Undo Last Operation");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    enrollService.listStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    performUndo();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // -------------------------------
    // ADD STUDENT + UNDO
    // -------------------------------
    private void addStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();

        int[] marks = new int[3];
        System.out.println("Enter 3 subject marks:");
        for (int i = 0; i < 3; i++)
            marks[i] = sc.nextInt();
        sc.nextLine();

        Student s = new Student(id, name, email, sem, marks);
        enrollService.addStudent(s);

        // ✅ Record undo action
        undoManager.push(new AddStudentAction(enrollService, s));

        System.out.println("Student added successfully.");
    }

    // -------------------------------
    // SEARCH STUDENT
    // -------------------------------
    private void searchStudent(Scanner sc) {

        System.out.print("Enter ID to search: ");
        String sid = sc.nextLine();

        try {
            Student found = enrollService.findByIdOrThrow(sid);
            System.out.println(found);
        } catch (StudentNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // -------------------------------
    // UNDO
    // -------------------------------
    private void performUndo() {

        Action undone = undoManager.undo();

        if (undone == null) {
            System.out.println("Nothing to undo.");
        } else {
            System.out.println("Undo successful: " + undone.description());
        }
    }
}
