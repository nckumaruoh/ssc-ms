package com.klh.sscms.ds.undo.actions;

import com.klh.sscms.ds.undo.Action;
import com.klh.sscms.ds.undo.StudentOperations;
import com.klh.sscms.core.Student;

public class UpdateStudentAction implements Action {

    private final StudentOperations ops;
    private final Student oldState;

    public UpdateStudentAction(StudentOperations ops, Student oldState) {
        this.ops = ops;
        this.oldState = oldState;
    }

    @Override
    public String description() {
        return "Undo Update Student (Roll No: " + oldState.getRollNo() + ")";
    }

    @Override
    public void undo() {
        ops.replaceStudent(oldState);
    }
}
