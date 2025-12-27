package com.klh.sscms.ds.undo;

import com.klh.sscms.core.Student;

public interface StudentOperations {

    void addStudent(Student student);

    void deleteStudentByRollNo(String rollNo);

    void replaceStudent(Student student);
}

