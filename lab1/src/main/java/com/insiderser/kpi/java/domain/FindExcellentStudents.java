package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.List;
import java.util.stream.Collectors;

public class FindExcellentStudents {

    private static final float EXCELLENT_GRADE_THRESHOLD = 4.5f;

    public static List<StudentGradebook> invoke(List<StudentGradebook> gradebooks) {
        return gradebooks.stream()
            .filter(gradebook -> gradebook.getMedianGrade() >= EXCELLENT_GRADE_THRESHOLD)
            .collect(Collectors.toUnmodifiableList());
    }
}
