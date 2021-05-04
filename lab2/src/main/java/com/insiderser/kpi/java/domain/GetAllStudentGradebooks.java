package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.model.StudentGradebook;

public class GetAllStudentGradebooks {

    public static StudentGradebook[] invoke() {
        return StudentGradebooksRepository.getAll();
    }
}
