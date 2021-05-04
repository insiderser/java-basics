package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.exceptions.StudentNotFoundException;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.Objects;

public class FindExamsForStudent {

    public static Exam[] invoke(String studentName) throws StudentNotFoundException {
        StudentGradebook[] gradebooks = StudentGradebooksRepository.getAll();
        for (StudentGradebook gradebook : gradebooks) {
            if (Objects.equals(gradebook.getStudentName(), studentName)) {
                return gradebook.getExams();
            }
        }
        throw new StudentNotFoundException();
    }
}
