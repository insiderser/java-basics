package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.ArrayList;
import java.util.List;

public class FindExcellentStudents {

    private static final float EXCELLENT_GRADE_THRESHOLD = 4.5f;

    public static StudentGradebook[] invoke(StudentGradebook[] gradebooks) {
        List<StudentGradebook> foundGradebooks = new ArrayList<>();

        for (StudentGradebook gradebook : gradebooks) {
            if (gradebook.getMedianGrade() >= EXCELLENT_GRADE_THRESHOLD) {
                foundGradebooks.add(gradebook);
            }
        }

        return foundGradebooks.toArray(new StudentGradebook[0]);
    }
}
