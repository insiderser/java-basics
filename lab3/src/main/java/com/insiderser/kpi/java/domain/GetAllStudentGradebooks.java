package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.io.IOException;

public class GetAllStudentGradebooks {

    public static StudentGradebook[] invoke() throws IOException {
        return StudentGradebooksRepository.getInstance().getAll();
    }
}
