package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.ArrayList;
import java.util.List;

public class FindExcellentStudents {

    private static final float EXCELLENT_GRADE_THRESHOLD = 4.5f;

    public static StudentGradebook[] invoke() {
        StudentGradebook[] allGradebooks = StudentGradebooksRepository.getAll();
        List<StudentGradebook> foundGradebooks = new ArrayList<>();

        for (StudentGradebook gradebook : allGradebooks) {
            if (gradebook.getMedianGrade() >= EXCELLENT_GRADE_THRESHOLD) {
                foundGradebooks.add(gradebook);
            }
        }

        return foundGradebooks.toArray(new StudentGradebook[0]);
    }
}
