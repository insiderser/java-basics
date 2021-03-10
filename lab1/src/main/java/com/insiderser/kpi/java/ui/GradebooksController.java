package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudent;
import com.insiderser.kpi.java.domain.FindExcellentStudents;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.DummyStudentGradebooksProvider;
import com.insiderser.kpi.java.utils.InputUtils;

public class GradebooksController {

    private static final int OPTION_LIST_ALL_STUDENTS = 1;
    private static final int OPTION_EXCELLENT_STUDENTS = 2;
    private static final int OPTION_EXAMS_FOR_STUDENT = 3;
    private static final int OPTION_EXIT = 4;

    private final StudentGradebook[] gradebooks = DummyStudentGradebooksProvider.get();

    private final GradebooksView view = new GradebooksView();

    public void run() {
        boolean exiting = false;
        while (!exiting) {
            view.showOptionsMenu();

            int chosenOption = InputUtils.readInt();
            switch (chosenOption) {
                case OPTION_LIST_ALL_STUDENTS:
                    onListAllStudents();
                    break;

                case OPTION_EXCELLENT_STUDENTS:
                    onListExcellentStudents();
                    break;

                case OPTION_EXAMS_FOR_STUDENT:
                    onListExamsForStudent();
                    break;

                case OPTION_EXIT:
                    exiting = true;
            }
        }
    }

    private void onListAllStudents() {
        view.showStudentGradebooks(gradebooks);
    }

    private void onListExcellentStudents() {
        StudentGradebook[] excellent = FindExcellentStudents.invoke(gradebooks);
        if (excellent.length > 0) {
            view.showStudentGradebooks(excellent);
        } else {
            view.showStudentsNotFound();
        }
    }

    private void onListExamsForStudent() {
        view.showEnterStudentNameMessage();
        String studentName = InputUtils.readStudentName();
        Exam[] exams = FindExamsForStudent.invoke(studentName, gradebooks);
        if (exams.length > 0) {
            view.showStudentExams(exams);
        } else {
            view.showStudentExamsNotFound();
        }
    }
}
