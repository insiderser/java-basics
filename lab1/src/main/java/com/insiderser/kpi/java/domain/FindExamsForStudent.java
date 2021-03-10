package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.Objects;

public class FindExamsForStudent {

    public static Exam[] invoke(String studentName, StudentGradebook[] gradebooks) {
        for (StudentGradebook gradebook : gradebooks) {
            if (Objects.equals(gradebook.getStudentName(), studentName)) {
                return gradebook.getExams();
            }
        }
        return new Exam[0];
    }
}
