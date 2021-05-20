package com.insiderser.kpi.java.ui;

import com.insiderser.kpi.java.domain.FindExamsForStudentUseCase;
import com.insiderser.kpi.java.domain.FindExcellentStudentsUseCase;
import com.insiderser.kpi.java.domain.GetAllStudentGradebooksUseCase;
import com.insiderser.kpi.java.domain.SaveExamsUseCase;
import com.insiderser.kpi.java.domain.SaveGradebooksUseCase;
import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.InputUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
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

    private final GetAllStudentGradebooksUseCase getAllStudents = new GetAllStudentGradebooksUseCase();
    private final FindExcellentStudentsUseCase findExcellentStudents = new FindExcellentStudentsUseCase();
    private final FindExamsForStudentUseCase findExamsForStudent = new FindExamsForStudentUseCase();
    private final SaveGradebooksUseCase saveGradebooks = new SaveGradebooksUseCase();
    private final SaveExamsUseCase saveExams = new SaveExamsUseCase();

    public void run() {
        try {
            loopOptions();
        } catch (Exception e) {
            handleError(e);
        }
    }

    private void loopOptions() throws IOException {
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
        } catch (NoSuchElementException e) {
            LOGGER.warn("Invalid option entered", e);
            return OPTION_INVALID;
        }
    }

    private void onListAllStudents() throws IOException {
        StudentGradebook[] gradebooks = getAllStudents.invoke();
        LOGGER.debug("Found {} students", gradebooks.length);

        view.showStudentGradebooks(gradebooks);
        maybeWriteToFile(gradebooks);
    }

    private void onListExcellentStudents() throws IOException {
        StudentGradebook[] excellent = findExcellentStudents.invoke();
        LOGGER.debug("Found {} excellent students", excellent.length);

        view.showStudentGradebooks(excellent);
        maybeWriteToFile(excellent);
    }

    private void onListExamsForStudent() throws IOException {
        view.showEnterStudentNameMessage();
        String studentName = InputUtils.readStudentName();

        Exam[] exams = findExamsForStudent.invoke(studentName);
        LOGGER.debug("Found {} exams for student {}", exams.length, studentName);

        view.showStudentExams(exams);
        maybeWriteToFile(exams);
    }

    private void maybeWriteToFile(StudentGradebook[] gradebooks) throws IOException {
        if (gradebooks.length == 0) {
            return;
        }

        String filePath = getOutputFilePath();
        if (!filePath.isEmpty()) {
            saveGradebooks.invoke(gradebooks, filePath);
        }
    }

    private void maybeWriteToFile(Exam[] exams) throws IOException {
        if (exams.length == 0) {
            return;
        }

        String filePath = getOutputFilePath();
        if (!filePath.isEmpty()) {
            saveExams.invoke(exams, filePath);
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

    private void handleError(Exception e) {
        LOGGER.error(e);
        if (e instanceof FileNotFoundException) {
            view.showDataFileNotFound();
        } else {
            view.showUnknownError();
        }
    }
}
