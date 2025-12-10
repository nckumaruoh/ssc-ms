package com.klh.sscms.services;

import com.klh.sscms.core.Student;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyticsService {

    private List<Student> students;

    public AnalyticsService(List<Student> students) {
        this.students = students;
    }

    // 1. Students above a threshold
    public List<Student> getTopPerformers(int threshold) {
        return students.stream()
                .filter(s -> s.getTotalMarks() >= threshold)
                .collect(Collectors.toList());
    }

    // 2. Students below a threshold
    public List<Student> getLowPerformers(int threshold) {
        return students.stream()
                .filter(s -> s.getTotalMarks() < threshold)
                .collect(Collectors.toList());
    }

    // 3. Get student with highest marks
    public Student getTopper() {
        return students.stream()
                .max((s1, s2) -> Integer.compare(s1.getTotalMarks(), s2.getTotalMarks()))
                .orElse(null);
    }

    // 4. Get student with lowest marks
    public Student getBottom() {
        return students.stream()
                .min((s1, s2) -> Integer.compare(s1.getTotalMarks(), s2.getTotalMarks()))
                .orElse(null);
    }

    // 5. Get average marks of all students
    public double getAverageMarks() {
        return students.stream()
                .mapToInt(Student::getTotalMarks)
                .average()
                .orElse(0);
    }
}

