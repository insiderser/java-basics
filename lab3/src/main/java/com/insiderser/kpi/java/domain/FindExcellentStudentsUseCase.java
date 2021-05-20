package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.domain.data.StudentGradebooksRepository;
import com.insiderser.kpi.java.domain.model.StudentGradebook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindExcellentStudentsUseCase {

    private static final float EXCELLENT_GRADE_THRESHOLD = 4.5f;

    public StudentGradebook[] invoke() throws IOException {
        StudentGradebook[] allGradebooks = StudentGradebooksRepository.getInstance().getAll();
        List<StudentGradebook> foundGradebooks = new ArrayList<>();

        for (StudentGradebook gradebook : allGradebooks) {
            if (gradebook.getMedianGrade() >= EXCELLENT_GRADE_THRESHOLD) {
                foundGradebooks.add(gradebook);
            }
        }

        return foundGradebooks.toArray(new StudentGradebook[0]);
    }
}
