package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.model.StudentGradebook;
import com.insiderser.kpi.java.utils.FileUtils;
import com.insiderser.kpi.java.utils.JsonUtils;
import java.io.IOException;

public class SaveGradebooksUseCase {

    public void invoke(StudentGradebook[] gradebooks, String fileName) throws IOException {
        String json = JsonUtils.toJson(gradebooks);
        FileUtils.writeToFile(fileName, json);
    }
}
