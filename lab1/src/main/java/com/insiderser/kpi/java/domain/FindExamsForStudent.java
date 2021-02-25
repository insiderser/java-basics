package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.Student;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FindExamsForStudent {

    public static Optional<List<Exam>> invoke(Student student, List<StudentGradebook> gradebooks) {
        return gradebooks.stream()
            .filter(gradebook -> Objects.equals(gradebook.getStudent(), student))
            .map(gradebook -> gradebook.getExams())
            .findAny();
    }
}
