package com.klh.sscms.services;

import com.klh.sscms.core.Faculty;
import java.util.ArrayList;
import java.util.List;

public class FacultyService {

    private ArrayList<Faculty> facultyList = new ArrayList<>();

    public void addFaculty(Faculty f) {
        facultyList.add(f);
        System.out.println("Faculty added successfully.");
    }

    public void listFaculty() {
        if (facultyList.isEmpty()) {
            System.out.println("No faculty added yet.");
            return;
        }
        facultyList.forEach(System.out::println);
    }

    public Faculty searchById(String id) {
        for (Faculty f : facultyList) {
            if (f.getId().equals(id)) return f;
        }
        return null;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }
}
