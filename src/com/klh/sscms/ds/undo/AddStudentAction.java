package com.klh.sscms.ds.undo;

import com.klh.sscms.services.EnrollmentService;
import com.klh.sscms.core.Student;

public class AddStudentAction implements Action {

    private EnrollmentService enrollService;
    private Student student;

    public AddStudentAction(EnrollmentService enrollService, Student student) {
        this.enrollService = enrollService;
        this.student = student;
    }

    @Override
    public String description() {
        return "Add Student (" + student.getId() + ")";
    }

    @Override
    public void undo() {
        enrollService.removeStudent(student.getId());
    }
}
