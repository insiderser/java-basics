package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudent;
import com.insiderser.kpi.java.domain.FindExcellentStudents;
import com.insiderser.kpi.java.domain.GetAllStudentGradebooks;
import com.insiderser.kpi.java.exceptions.InvalidInputException;
import com.insiderser.kpi.java.exceptions.StudentNotFoundException;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.InputUtils;

public class GradebooksController {

    private static final int OPTION_LIST_ALL_STUDENTS = 1;
    private static final int OPTION_EXCELLENT_STUDENTS = 2;
    private static final int OPTION_EXAMS_FOR_STUDENT = 3;
    private static final int OPTION_EXIT = 4;

    private final GradebooksView view = new GradebooksView();

    public void run() {
        boolean exiting = false;
        while (!exiting) {
            view.showOptionsMenu();

            int chosenOption;
            try {
                chosenOption = InputUtils.readInt();
            } catch (InvalidInputException e) {
                view.showInvalidOptionChosen();
                continue;
            }

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
                    break;

                default:
                    view.showInvalidOptionChosen();
            }
        }
    }

    private void onListAllStudents() {
        StudentGradebook[] gradebooks = GetAllStudentGradebooks.invoke();
        view.showStudentGradebooks(gradebooks);
    }

    private void onListExcellentStudents() {
        StudentGradebook[] excellent = FindExcellentStudents.invoke();
        view.showStudentGradebooks(excellent);
    }

    private void onListExamsForStudent() {
        String studentName = getStudentNameFromInput();

        try {
            Exam[] exams = FindExamsForStudent.invoke(studentName);
            view.showStudentExams(exams);
        } catch (StudentNotFoundException e) {
            view.showStudentExamsNotFound();
        }
    }

    private String getStudentNameFromInput() {
        String studentName = null;
        while (studentName == null) {
            view.showEnterStudentNameMessage();

            try {
                studentName = InputUtils.readStudentName();
            } catch (InvalidInputException e) {
                view.showInvalidStudentNameEntered();
            }
        }
        return studentName;
    }
}
