package com.insiderser.kpi.java.utils;

import com.insiderser.kpi.java.model.Exam;
import com.insiderser.kpi.java.model.StudentGradebook;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    private static final Moshi MOSHI = new Moshi.Builder().build();

    public static StudentGradebook[] toStudentGradebooks(String json) throws IOException {
        JsonAdapter<List<StudentGradebook>> adapter = MOSHI.adapter(Types.newParameterizedType(List.class, StudentGradebook.class));
        return adapter.fromJson(json).toArray(new StudentGradebook[0]);
    }

    public static String toJson(StudentGradebook[] gradebooks) {
        JsonAdapter<List<StudentGradebook>> adapter = MOSHI.adapter(Types.newParameterizedType(List.class, StudentGradebook.class));
        return adapter.toJson(Arrays.asList(gradebooks));
    }

    public static String toJson(Exam[] exams) {
        JsonAdapter<List<Exam>> adapter = MOSHI.adapter(Types.newParameterizedType(List.class, Exam.class));
        return adapter.toJson(Arrays.asList(exams));
    }
}
