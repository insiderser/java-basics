package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.List;

public interface GradebooksView {

    void listStudentGradebooks(List<StudentGradebook> gradebooks);

    void showStudentNotFound();

    void showStudentExams(List<Exam> exams);
}
