package com.klh.sscms.services;



import com.klh.sscms.core.Student;
import com.klh.sscms.interfaces.Searchable;

public class StudentSearchService implements Searchable<Student> {

    private Student[] students;

    public StudentSearchService(Student[] students) {
        this.students = students;
    }

    @Override
    public Student findById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student[] findByName(String name) {
        Student[] result = new Student[students.length];
        int index = 0;

        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                result[index++] = s;
            }
        }
        return result;
    }
}
