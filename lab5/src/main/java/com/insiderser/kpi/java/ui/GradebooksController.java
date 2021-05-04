package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudent;
import com.insiderser.kpi.java.domain.FindExcellentStudents;
import com.insiderser.kpi.java.domain.GetAllStudentGradebooks;
import com.insiderser.kpi.java.exceptions.InvalidInputException;
import com.insiderser.kpi.java.exceptions.StudentNotFoundException;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.FileUtils;
import com.insiderser.kpi.java.utils.InputUtils;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GradebooksController {

    private static final Logger LOGGER = LogManager.getLogger();

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
            LOGGER.error(e);
            System.err.println(e.getMessage());
        }
    }

    private void loopOptions() throws Exception {
        boolean exiting = false;
        while (!exiting) {
            int chosenOption = chooseOption();
            LOGGER.info("Chose option {}", chosenOption);

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
                    LOGGER.info("Exiting...");
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
            LOGGER.warn("Invalid option entered", e);
            view.showInvalidOptionChosen();
            return OPTION_INVALID;
        }
    }

    private void onListAllStudents() throws Exception {
        StudentGradebook[] gradebooks = GetAllStudentGradebooks.invoke();
        LOGGER.debug("Found {} students", gradebooks.length);

        view.showStudentGradebooks(gradebooks);
        maybeWriteToFile(gradebooks);
    }

    private void onListExcellentStudents() throws Exception {
        StudentGradebook[] excellent = FindExcellentStudents.invoke();
        LOGGER.debug("Found {} excellent students", excellent.length);

        view.showStudentGradebooks(excellent);
        maybeWriteToFile(excellent);
    }

    private void onListExamsForStudent() throws Exception {
        String studentName = getStudentNameFromInput();

        try {
            Exam[] exams = FindExamsForStudent.invoke(studentName);
            LOGGER.debug("Found {} exams for student {}", exams.length, studentName);

            view.showStudentExams(exams);
            maybeWriteToFile(exams);
        } catch (StudentNotFoundException e) {
            view.showStudentExamsNotFound();
            LOGGER.warn("Student {} not found", studentName);
        }
    }

    private String getStudentNameFromInput() {
        LOGGER.debug("Getting student name from input...");

        String studentName = null;
        while (studentName == null) {
            view.showEnterStudentNameMessage();

            try {
                studentName = InputUtils.readStudentName();
            } catch (InvalidInputException e) {
                LOGGER.warn("Invalid student name entered", e);
                view.showInvalidStudentNameEntered();
            }
        }
        return studentName;
    }

    private void maybeWriteToFile(StudentGradebook[] gradebooks) throws IOException {
        String filePath = getOutputFilePath();
        if (!filePath.isEmpty()) {
            FileUtils.writeToFile(filePath, gradebooks);
        }
    }

    private void maybeWriteToFile(Exam[] exams) throws IOException {
        String filePath = getOutputFilePath();
        if (!filePath.isEmpty()) {
            FileUtils.writeToFile(filePath, exams);
        }
    }

    private String getOutputFilePath() {
        view.showEnterOperationsOutputFile();
        String path = InputUtils.readFilePath();

        if (path.isEmpty()) {
            LOGGER.info("Not outputting to any file because entered file path is empty");
        } else {
            LOGGER.info("Outputting data into '{}' file", path);
        }

        return path;
    }
}
