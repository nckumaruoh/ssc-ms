## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# Smart Student Course Management System (SSC-MS)

A complete Java-based console application designed as a **Capstone + PBL (Project-Based Learning)** system for first-year engineering students.

This project integrates all core concepts of **Java Programming**, **Object-Oriented Design**, **File Handling**, **Interfaces**, **Exception Handling**, **Collections**, and **Streams API**.

---

## 🔰 1. Project Overview

SSC-MS (Smart Student Course Management System) is an end-to-end academic management platform that allows:

- Student Management  
- Faculty Management  
- Course Management  
- Student–Course Enrollment  
- Reports & Analytics  
- File Storage (CSV-based persistence)  
- Full menu-driven console interface  

This project is designed so that every module aligns directly with specific **Course Outcomes (COs)**.

---

## 🧩 2. Features (Module-Wise)

### ✔ Student Management
- Add student  
- View all students  
- Search by student ID  
- Store marks, semester, email  

### ✔ Faculty Management
- Add faculty  
- View all faculty  
- Search by faculty ID  
- Handle department and handled courses  

### ✔ Course Management
- Add course  
- List courses  
- Assign faculty to a course (Many-to-One mapping)  

### ✔ Enrollment Management
- Enroll student into a course  
- View student’s courses  
- View course-wise enrolled students  
- Drop a student from a course  

### ✔ Reports & Analytics (Streams API)
- Identify top and low performers  
- Compute class average  
- Find topper and lowest scorer  
- Filter student datasets efficiently  

### ✔ File Operations (CSV)
- Save Students, Faculty, Courses, Enrollments  
- Load all data on program start  
- Ensures persistence  

### ✔ Exception Handling
- Custom exception: `StudentNotFoundException`
- Input mismatch handling  
- Safe file load operations  

---

## 🗂️ 3. Project Structure
SSC-MS/
│
├── src/com/klh/sscms/core/
│ ├── AppMain.java
│ ├── User.java
│ ├── Student.java
│ ├── Faculty.java
│ ├── Course.java
│ └── Enrollment.java
│
├── src/com/klh/sscms/services/
│ ├── EnrollmentService.java
│ ├── FacultyService.java
│ ├── CourseService.java
│ ├── AnalyticsService.java
│ └── FileService.java
│
├── src/com/klh/sscms/exceptions/
│ └── StudentNotFoundException.java
│
├── students.csv
├── faculty.csv
├── courses.csv
└── enrollments.csv


---

## ⚙️ 4. How to Set Up the Project (VS Code)

### **Step 1 — Install Required Tools**
- Install **JDK Temurin 17 LTS** or Temurin 25 LTS  
- Install **Visual Studio Code**  
- Install the following VS Code extensions:
  - **Extension Pack for Java**
  - **Debugger for Java**
  - **Java Test Runner**
  - **Java Dependency Viewer**

### **Step 2 — Open Project**
File → Open Folder → SSC-MS


### **Step 3 — Build Project**
VS Code automatically builds Java projects using the Language Server.

### **Step 4 — Run the Program**
Run via:
Right-click AppMain.java → Run Java

Or terminal:
cd SSC-MS
java -cp bin com.klh.sscms.core.AppMain


---

## 🧪 5. Sample Data Files

The project works with CSV-based persistence.

### students.csv

S101,Rahul Sharma,rahul@klh.edu,3,85,90,78
S102,Anjali Verma,anjali@klh.edu,2,88,92,80
S103,Kiran Rao,kiran@klh.edu,1,55,60,52


### faculty.csv

F201,Dr. Kavitha,kavitha@klh.edu,CSE,Java;DS
F202,Dr. Ramesh,ramesh@klh.edu,EEE,Circuits;Machines


### courses.csv
CS101,Programming in C,4,F201
CS102,Data Structures,3,F201
EE101,Basic Electrical Engineering,4,F202


### enrollments.csv
S101,CS101
S101,CS102
S102,CS102
S103,EE101

---

## 🧠 6. COURSE OUTCOMES (CO-wise Mapping With Problem Statements)

### 🎯 **CO1 — Understand Object-Oriented Concepts**

**Topics Covered**
- Classes & Objects  
- Constructors  
- Encapsulation  
- Data Members & Methods  
- Real-world modeling  

**Problem Statements**
- Create Student, Faculty, Course classes  
- Model relationships using objects  
- Use constructors to initialize data  

---

### 🎯 **CO2 — Implement Relationships and Modularization**

**Topics Covered**
- Has-a relationships  
- Many-to-many (Enrollment: Student ↔ Course)  
- One-to-many (Faculty → Course)  
- Modular design (Service classes)  

**Problem Statements**
- Build EnrollmentService to manage students  
- Implement FacultyService for faculty records  
- Assign faculty to courses  

---

### 🎯 **CO3 — Work With Interfaces, Abstraction, and Exceptions**

**Topics Covered**
- Interfaces (`Exportable`)  
- Abstraction via service layer  
- Exception handling (`try-catch`)  
- Custom exceptions (`StudentNotFoundException`)  

**Problem Statements**
- Export students in CSV format  
- Handle invalid student ID search  
- Add custom exception for missing entities  

---

### 🎯 **CO4 — Manage Data Structures Using Collections**

**Topics Covered**
- ArrayList  
- Iteration  
- Searching  
- Aggregation  

**Problem Statements**
- Store student/faculty/course lists  
- Implement search operations  
- Build dynamic enrollment list  

---

### 🎯 **CO5 — Persistent Storage & File Handling**

**Topics Covered**
- File I/O  
- CSV read/write  
- BufferedReader, FileWriter, PrintWriter  

**Problem Statements**
- Save all students to file  
- Load from CSV into objects  
- Maintain program state between runs  

---

### 🎯 **CO6 — Data Analysis Using Streams API**

**Topics Covered**
- Streams  
- Filtering  
- Mapping  
- Aggregation (max, min, average)  

**Problem Statements**
- Find topper  
- List top performers  
- Compute class average  
- Filter students below threshold  

---

## 🧠 7. Master Menu (User Interface)

========= SSC-MS MAIN MENU =========

1. Student Management

2. Faculty Management

3. Course Management

4. Enrollment Management

5. Reports & Analytics

6. Save All Data to Files

7. Exit


Each submenu loops until user chooses "Back".

---

## 🛡️ 8. Exception Handling & Robustness

- Handles invalid numeric inputs  
- Handles missing CSV files  
- Prevents null pointer errors  
- Throws custom exceptions for missing students  

---

## 📝 9. Final Outcomes

By completing this project, students learn:

- End-to-end Java application development  
- How to design modular OOP systems  
- How to use collections and services  
- File handling and persistence  
- Menu-driven program structure  
- Using streams for data analytics  
- Writing clean, maintainable code  

This project can be proudly showcased during **lab evaluations, viva, internships, and interviews**.


                          +----------------------+
                          |       User           |
                          +----------------------+
                          | - id : String        |
                          | - name : String      |
                          | - email : String     |
                          +----------------------+
                                     ^
                                     |
                     +--------------------------------+
                     |                                |
      +---------------------------+     +---------------------------+
      |        Student            |     |         Faculty           |
      +---------------------------+     +---------------------------+
      | - semester : int          |     | - department : String     |
      | - marks[] : int           |     | - coursesHandled[] : Str  |
      +---------------------------+     +---------------------------+
      | + getTotalMarks() : int   |     | + assignCourse()          |
      +---------------------------+     +---------------------------+


      +---------------------------+
      |         Course            |
      +---------------------------+
      | - courseCode : String     |
      | - title : String          |
      | - credits : int           |
      | - facultyId : String      |
      +---------------------------+
      | + assignFaculty(id)       |
      +---------------------------+


      +---------------------------+
      |       Enrollment          |
      +---------------------------+
      | - studentId : String      |
      | - courseCode : String     |
      +---------------------------+


+------------------------------------------------+
|               EnrollmentService                |
+------------------------------------------------+
| - students : ArrayList<Student>                |
| - records  : ArrayList<Enrollment>             |
+------------------------------------------------+
| + addStudent()                                 |
| + listStudents()                                |
| + searchById()                                  |
| + enroll(sId,cId)                               |
| + viewStudentEnrollments()                      |
| + viewCourseEnrollments()                       |
| + drop()                                        |
| + getStudentsList()                             |
| + getEnrollmentRecords()                        |
+------------------------------------------------+
           ^                     ^
           |                     |
           | uses                | uses
           |                     |
       Student              Enrollment


+------------------------------+       +----------------------------+
|        CourseService         |       |       FacultyService       |
+------------------------------+       +----------------------------+
| - courses : ArrayList<Course>|       | - facultyList : ArrayList  |
+------------------------------+       +----------------------------+
| + addCourse()                |       | + addFaculty()             |
| + assignFaculty()            |       | + listFaculty()            |
| + listCourses()              |       | + searchById()             |
| + getCoursesList()           |       | + getFacultyList()         |
+------------------------------+       +----------------------------+
        ^                                   ^
        |                                   |
        | uses                              | uses
        |                                   |
     Course                               Faculty


           +-------------------------------+
           |       AnalyticsService        |
           +-------------------------------+
           | + getTopPerformers()          |
           | + getLowPerformers()          |
           | + getAverageMarks()           |
           | + getTopper()                 |
           | + getBottom()                 |
           +-------------------------------+
                        ^
                        |
                        | depends on
                        |
                     Student


           +-------------------------------+
           |         FileService           |
           +-------------------------------+
           | + saveStudents()              |
           | + loadStudents()              |
           | + saveFaculty()               |
           | + loadFaculty()               |
           | + saveCourses()               |
           | + loadCourses()               |
           | + saveEnrollments()           |
           | + loadEnrollments()           |
           +-------------------------------+
                        ^
                        |
                        | operates on
                        |
  Student, Faculty, Course, Enrollment (CSV persistence)











