package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudent;
import com.insiderser.kpi.java.domain.FindExcellentStudents;
import com.insiderser.kpi.java.model.DummyStudentGradebooksProvider;
import com.insiderser.kpi.java.model.Student;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.List;

public class GradebooksPresenter {

    private final List<StudentGradebook> gradebooks = DummyStudentGradebooksProvider.get();

    private final GradebooksView view;

    public GradebooksPresenter(GradebooksView view) {
        this.view = view;
    }

    public void onListAllStudents() {
        view.listStudentGradebooks(gradebooks);
    }

    public void onListExcellentStudents() {
        var excellent = FindExcellentStudents.invoke(gradebooks);
        view.listStudentGradebooks(excellent);
    }

    public void onListExamsForStudent(Student student) {
        var exams = FindExamsForStudent.invoke(student, gradebooks);
        if (exams.isPresent()) {
            view.showStudentExams(exams.get());
        } else {
            view.showStudentNotFound();
        }
    }
}
