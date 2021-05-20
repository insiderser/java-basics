package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.domain.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.domain.model.Exam;
import com.insiderser.kpi.java.domain.model.StudentGradebook;
import com.insiderser.kpi.java.utils.ValidationUtils;
import java.io.IOException;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindExamsForStudentUseCase {

    private static final Logger LOGGER = LogManager.getLogger();

    public Exam[] invoke(String studentName) throws IOException {
        if (!ValidationUtils.isValidStudentName(studentName)) {
            LOGGER.warn("Student name {} is invalid", studentName);
            return new Exam[0];
        }

        StudentGradebook[] gradebooks = StudentGradebooksRepository.getInstance().getAll();
        for (StudentGradebook gradebook : gradebooks) {
            if (Objects.equals(gradebook.getStudentName(), studentName)) {
                return gradebook.getExams();
            }
        }

        LOGGER.warn("Student {} not found", studentName);
        return new Exam[0];
    }
}
