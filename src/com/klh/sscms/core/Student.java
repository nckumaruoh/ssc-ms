package com.klh.sscms.core;

import com.klh.sscms.interfaces.Exportable;

/**
 * Represents a student in the SSC-MS system.
 * Inherits basic fields from User and adds academic details.
 */
public class Student extends User implements Exportable {

    private int semester;
    private int[] marks;   // array of subject marks

    /**
     * Creates a Student object.
     * @param id       Unique student ID
     * @param name     Student full name
     * @param email    Student email address
     * @param semester Current semester number
     * @param marks    Array of marks
     */
    public Student(String id, String name, String email,
                   int semester, int[] marks) {

        super(id, name, email);
        this.semester = semester;
        this.marks = marks;
    }
    
    // -------------------------
    // Overridden method from User
    // -------------------------
    @Override
    public String getRole() {
        return "STUDENT";
    }

    // -------------------------
    // Getters and Setters
    // -------------------------
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public int[] getMarks() { return marks; }
    public void setMarks(int[] marks) { this.marks = marks; }

    public String getId() { return id; }
public String getName() { return name; }


     @Override
    public String toCsv() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
          .append(name).append(",")
          .append(email).append(",")
          .append(semester);
        if (marks != null) {
            for (int m : marks) {
                sb.append(",").append(m);
            }
        }
        return sb.toString();
    }

    @Override
    public String toDisplayString() {
        return "Student: " + name + " (" + id + "), Sem " + semester;
    }

// -------------------------
    // Basic Analytics (CO2)
    // -------------------------
    public int calculateTotal() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    public double calculateAverage() {
        return marks.length == 0 ? 0 : (double) calculateTotal() / marks.length;
    }

    public int getHighestMark() {
        int max = marks[0];
        for (int m : marks) {
            if (m > max) { max = m; }
        }
        return max;
    }

    public int getLowestMark() {
        int min = marks[0];
        for (int m : marks) {
            if (m < min) { min = m; }
        }
        return min;
    }
    public int getTotalMarks() {
    int sum = 0;
    for (int m : marks) sum += m;
    return sum;
}


    @Override
    public String toString() {
        return "Student: " + name + " (" + id + "), Sem " + semester;
    }
}