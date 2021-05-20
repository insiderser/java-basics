package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.io.IOException;

public class GetAllStudentGradebooksUseCase {

    public StudentGradebook[] invoke() throws IOException {
        return StudentGradebooksRepository.getInstance().getAll();
    }
}
