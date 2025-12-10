package com.klh.sscms.core;

import java.util.*;

import com.klh.sscms.exceptions.StudentNotFoundException;
import com.klh.sscms.services.*;


public class AppMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ----------------------------------
        // INITIALIZE ALL SERVICES
        // ----------------------------------
        EnrollmentService enrollService = new EnrollmentService();
        CourseService courseService = new CourseService();
        FacultyService facultyService = new FacultyService();
        FileService fileService = new FileService();

        // ----------------------------------
        // LOAD DATA FROM FILES
        // ----------------------------------
        System.out.println("Loading data from CSV files...");

        try {
            // Load Students
            List<Student> loadedStudents = fileService.loadStudents("students.csv");
            for (Student s : loadedStudents) enrollService.addStudent(s);

            // Load Faculty
            List<Faculty> loadedFaculty = fileService.loadFaculty("faculty.csv");
            for (Faculty f : loadedFaculty) facultyService.addFaculty(f);

            // Load Courses
            List<Course> loadedCourses = fileService.loadCourses("courses.csv");
            for (Course c : loadedCourses) courseService.addCourse(c);

            // Load Enrollments
            List<Enrollment> loadedEnroll = fileService.loadEnrollments("enrollments.csv");
            for (Enrollment e : loadedEnroll) enrollService.addEnrollmentRecord(e);

        } catch (Exception ex) {
            System.out.println("Some files could not be loaded. Starting fresh.");
        }

        System.out.println("Data loaded successfully.\n");

        // ----------------------------------
        // MAIN MENU LOOP
        // ----------------------------------
        while (true) {

            System.out.println("\n========= SSC-MS MAIN MENU =========");
            System.out.println("1. Student Management");
            System.out.println("2. Faculty Management");
            System.out.println("3. Course Management");
            System.out.println("4. Enrollment Management");
            System.out.println("5. Reports & Analytics");
            System.out.println("6. Save All Data to Files");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (ch) {
                case 1: studentMenu(sc, enrollService); break;
                case 2: facultyMenu(sc, facultyService); break;
                case 3: courseMenu(sc, courseService); break;
                case 4: enrollmentMenu(sc, enrollService); break;
                case 5: analyticsMenu(sc, enrollService); break;

                case 6:
                    fileService.saveStudents(enrollService.getStudentsList(), "students.csv");
                    fileService.saveFaculty(facultyService.getFacultyList(), "faculty.csv");
                    fileService.saveCourses(courseService.getCoursesList(), "courses.csv");
                    fileService.saveEnrollments(enrollService.getEnrollmentRecords(), "enrollments.csv");
                    System.out.println("All data saved successfully.");
                    break;

                case 0:
                    System.out.println("Exiting SSC-MS. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ==================================
    // SUBMENU: STUDENT MANAGEMENT
    // ==================================
  public static void studentMenu(Scanner sc, EnrollmentService enroll) {
    while (true) {
        System.out.println("\n--- STUDENT MANAGEMENT ---");
        System.out.println("1. Add Student");
        System.out.println("2. List All Students");
        System.out.println("3. Search By Student ID");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {

            case 1: // Add Student
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
                for (int i = 0; i < 3; i++) marks[i] = sc.nextInt();
                sc.nextLine();

                Student s = new Student(id, name, email, sem, marks);
                enroll.addStudent(s);
                break;

            case 2:
                enroll.listStudents();
                break;

            case 3:
                System.out.print("Enter ID to search: ");
                String sid = sc.nextLine();
                 try {
        Student foundSafe = enroll.findByIdOrThrow(sid);
        System.out.println(foundSafe);
    } catch (StudentNotFoundException ex) {
        System.out.println(ex.getMessage());
    }
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid choice.");
        }
    }
}


    // ==================================
    // SUBMENU: FACULTY MANAGEMENT
    // ==================================
   public static void facultyMenu(Scanner sc, FacultyService fs) {
    while (true) {
        System.out.println("\n--- FACULTY MANAGEMENT ---");
        System.out.println("1. Add Faculty");
        System.out.println("2. List Faculty");
        System.out.println("3. Search By Faculty ID");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter choice: ");

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


    // ==================================
    // SUBMENU: COURSE MANAGEMENT
    // ==================================
 public static void courseMenu(Scanner sc, CourseService cs) {
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


    // ==================================
    // SUBMENU: ENROLLMENT MANAGEMENT
    // ==================================
  public static void enrollmentMenu(Scanner sc, EnrollmentService es) {
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


    // ==================================
    // SUBMENU: ANALYTICS
    // ==================================
   public static void analyticsMenu(Scanner sc, EnrollmentService es) {

    AnalyticsService analytics = new AnalyticsService(es.getStudentsList());

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
    System.out.print("Enter choice: ");
    ch = sc.nextInt();
    sc.nextLine(); // clear buffer
} catch (InputMismatchException ex) {
    System.out.println("Please enter a valid number.");
    sc.nextLine(); // clear invalid input
    continue;      // go back to menu
}

        switch (ch) {

            case 1:
                System.out.println("Enter threshold: ");
                int t1 = sc.nextInt();
                sc.nextLine();
                analytics.getTopPerformers(t1).forEach(System.out::println);
                break;

            case 2:
                System.out.println("Enter threshold: ");
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
