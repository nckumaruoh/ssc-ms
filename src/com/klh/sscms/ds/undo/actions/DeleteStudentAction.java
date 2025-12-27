package com.klh.sscms.ds.undo.actions;

import com.klh.sscms.ds.undo.Action;
import com.klh.sscms.ds.undo.StudentOperations;
import com.klh.sscms.core.Student;

public class DeleteStudentAction implements Action {

    private final StudentOperations ops;
    private final Student student;

    public DeleteStudentAction(StudentOperations ops, Student student) {
        this.ops = ops;
        this.student = student;
    }

    @Override
    public String description() {
        return "Undo Delete Student (Roll No: " + student.getRollNo() + ")";
    }

    @Override
    public void undo() {
        ops.addStudent(student);
    }
}

