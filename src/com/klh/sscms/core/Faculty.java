package com.klh.sscms.core;

/**
 * Represents a faculty member in the SSC-MS system.
 * Extends User and includes department and courses handled.
 */
public class Faculty extends User {

    private String department;
    private String[] coursesHandled;

    /**
     * Creates a Faculty object.
     * @param id       Unique faculty ID
     * @param name     Full name
     * @param email    Email address
     * @param department Department name
     * @param coursesHandled Array of courses taken by faculty
     */
    public Faculty(String id, String name, String email,
                   String department, String[] coursesHandled) {

        super(id, name, email);
        this.department = department;
        this.coursesHandled = coursesHandled;
    }
     // -------------------------
    // Overridden method
    // -------------------------
    @Override
    public String getRole() {
        return "FACULTY";
    }

    // -------------------------
    // Getters and setters
    // -------------------------
    public String getDepartment() { return department; }
    public void setDepartment(String dept) { this.department = dept; }

    public String[] getCoursesHandled() { return coursesHandled; }
    public void setCoursesHandled(String[] coursesHandled) {
        this.coursesHandled = coursesHandled;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
 

    // -------------------------
    // Utility Method
    // -------------------------
    public void displayCourses() {
        System.out.println("Courses handled by " + name + ":");
        for (String c : coursesHandled) {
            System.out.println(" - " + c);
        }
    }

    public String toCsv() {
    StringBuilder sb = new StringBuilder();
    sb.append(id).append(",")
      .append(name).append(",")
      .append(email).append(",")
      .append(department).append(",");

    // append courses handled
    if (coursesHandled != null) {
        for (String c : coursesHandled) {
            sb.append(c).append(";");
        }
    }
    return sb.toString();
}

  


    @Override
    public String toString() {
        return "Faculty: " + name + " (" + id + "), Dept: " + department;
    }
}
