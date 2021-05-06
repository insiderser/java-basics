package com.insiderser.kpi.java.domain;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.utils.FileUtils;
import com.insiderser.kpi.java.utils.JsonUtils;
import java.io.IOException;

public class SaveExams {

    public static void invoke(Exam[] exams, String fileName) throws IOException {
        String json = JsonUtils.toJson(exams);
        FileUtils.writeToFile(fileName, json);
    }
}
