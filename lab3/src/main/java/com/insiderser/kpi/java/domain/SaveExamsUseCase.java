package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.domain.model.Exam;
import com.insiderser.kpi.java.utils.FileUtils;
import com.insiderser.kpi.java.utils.JsonUtils;
import java.io.IOException;

public class SaveExamsUseCase {

    public void invoke(Exam[] exams, String fileName) throws IOException {
        String json = JsonUtils.toJson(exams);
        FileUtils.writeToFile(fileName, json);
    }
}
