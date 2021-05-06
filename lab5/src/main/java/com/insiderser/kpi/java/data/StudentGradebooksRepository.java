package com.insiderser.kpi.java.data;

import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.FileUtils;
import com.insiderser.kpi.java.utils.JsonUtils;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentGradebooksRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String STUDENTS_FILE_NAME = "student-gradebooks.json";

    private static StudentGradebooksRepository INSTANCE = null;

    private StudentGradebook[] gradebooks;

    private StudentGradebooksRepository() throws IOException {
        LOGGER.trace("Initializing StudentGradebooksRepository...");

        String json = FileUtils.readEverythingFromFile(STUDENTS_FILE_NAME);
        gradebooks = JsonUtils.toStudentGradebooks(json);

        LOGGER.trace("Initializing StudentGradebooksRepository success");
    }

    /**
     * @noinspection NonThreadSafeLazyInitialization
     */
    public static StudentGradebooksRepository getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new StudentGradebooksRepository();
        }
        return INSTANCE;
    }

    public StudentGradebook[] getAll() {
        return gradebooks;
    }

    /**
     * @noinspection unused
     */
    public void saveAll(StudentGradebook[] gradebooks) throws IOException {
        LOGGER.info("Saving {} gradebooks", gradebooks.length);

        this.gradebooks = gradebooks;
        String json = JsonUtils.toJson(gradebooks);
        FileUtils.writeToFile(STUDENTS_FILE_NAME, json);
    }
}
