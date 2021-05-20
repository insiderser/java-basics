package com.insiderser.kpi.java.utils;

import com.insiderser.kpi.java.domain.model.Exam;

public class StringUtils {

    public static String joinToString(Exam[] exams, String separator) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < exams.length; i++) {
            builder.append(exams[i].getName());
            if (i < exams.length - 1) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }
}
