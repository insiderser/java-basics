package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudent;
import com.insiderser.kpi.java.domain.FindExcellentStudents;
import com.insiderser.kpi.java.domain.GetAllStudentGradebooks;
import com.insiderser.kpi.java.domain.SaveExams;
import com.insiderser.kpi.java.domain.SaveGradebooks;
import com.insiderser.kpi.java.exceptions.InvalidInputException;
import com.insiderser.kpi.java.exceptions.StudentNotFoundException;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.InputUtils;
import java.io.IOException;

public class GradebooksController {

    private static final int OPTION_LIST_ALL_STUDENTS = 1;
    private static final int OPTION_EXCELLENT_STUDENTS = 2;
    private static final int OPTION_EXAMS_FOR_STUDENT = 3;
    private static final int OPTION_EXIT = 4;
    private static final int OPTION_INVALID = -1;

    private final GradebooksView view = new GradebooksView();

    public void run() {
        try {
            loopOptions();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void loopOptions() throws Exception {
        boolean exiting = false;
        while (!exiting) {
            int chosenOption = chooseOption();

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

    private int chooseOption() {
        view.showOptionsMenu();

        try {
            return InputUtils.readInt();
        } catch (InvalidInputException e) {
            view.showInvalidOptionChosen();
            return OPTION_INVALID;
        }
    }

    private void onListAllStudents() throws Exception {
        StudentGradebook[] gradebooks = GetAllStudentGradebooks.invoke();
        view.showStudentGradebooks(gradebooks);
        maybeWriteToFile(gradebooks);
    }

    private void onListExcellentStudents() throws Exception {
        StudentGradebook[] excellent = FindExcellentStudents.invoke();
        view.showStudentGradebooks(excellent);
        maybeWriteToFile(excellent);
    }

    private void onListExamsForStudent() throws Exception {
        String studentName = getStudentNameFromInput();

        try {
            Exam[] exams = FindExamsForStudent.invoke(studentName);
            view.showStudentExams(exams);
            maybeWriteToFile(exams);
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

    private void maybeWriteToFile(StudentGradebook[] gradebooks) throws IOException {
        String filePath = getOutputFilePath();
        if (!filePath.isEmpty()) {
            SaveGradebooks.invoke(gradebooks, filePath);
        }
    }

    private void maybeWriteToFile(Exam[] exams) throws IOException {
        String filePath = getOutputFilePath();
        if (!filePath.isEmpty()) {
            SaveExams.invoke(exams, filePath);
        }
    }

    private String getOutputFilePath() {
        view.showEnterOperationsOutputFile();
        return InputUtils.readFilePath();
    }
}
