package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudent;
import com.insiderser.kpi.java.domain.FindExcellentStudents;
import com.insiderser.kpi.java.model.DummyStudentGradebooksProvider;
import com.insiderser.kpi.java.model.GradebookOption;
import com.insiderser.kpi.java.model.Student;
import com.insiderser.kpi.java.model.StudentGradebook;
import java.util.List;

public class GradebooksPresenter {

    private final List<StudentGradebook> gradebooks = DummyStudentGradebooksProvider.get();

    private final GradebooksView view;

    public GradebooksPresenter(GradebooksView view) {
        this.view = view;
    }

    public void onOptionChosen(GradebookOption option) {
        switch (option) {
            case LIST_ALL_STUDENTS:
                onListAllStudents();
                break;

            case LIST_EXCELLENT:
                onListExcellentStudents();
                break;

            case LIST_EXAMS_FOR_STUDENT:
                var student = view.getStudentFromUser();
                if (student != null) {
                    onListExamsForStudent(student);
                }
                break;

            case EXIT:
                System.exit(0);
                break;

            case INVALID:
                // Ignored
                break;
        }
    }

    private void onListAllStudents() {
        view.listStudentGradebooks(gradebooks);
    }

    private void onListExcellentStudents() {
        var excellent = FindExcellentStudents.invoke(gradebooks);
        view.listStudentGradebooks(excellent);
    }

    private void onListExamsForStudent(Student student) {
        var exams = FindExamsForStudent.invoke(student, gradebooks);
        if (exams.isPresent()) {
            view.showStudentExams(exams.get());
        } else {
            view.showStudentNotFound();
        }
    }
}
