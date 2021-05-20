package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.ValidationUtils;
import java.io.IOException;
import java.util.Objects;

public class FindExamsForStudentUseCase {

    public Exam[] invoke(String studentName) throws IOException {
        if (!ValidationUtils.isValidStudentName(studentName)) {
            return new Exam[0];
        }

        StudentGradebook[] gradebooks = StudentGradebooksRepository.getInstance().getAll();
        for (StudentGradebook gradebook : gradebooks) {
            if (Objects.equals(gradebook.getStudentName(), studentName)) {
                return gradebook.getExams();
            }
        }
        return new Exam[0];
    }
}
