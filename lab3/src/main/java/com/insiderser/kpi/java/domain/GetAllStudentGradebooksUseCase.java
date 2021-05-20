package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.domain.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.domain.model.StudentGradebook;
import java.io.IOException;

public class GetAllStudentGradebooksUseCase {

    public StudentGradebook[] invoke() throws IOException {
        return StudentGradebooksRepository.getInstance().getAll();
    }
}
