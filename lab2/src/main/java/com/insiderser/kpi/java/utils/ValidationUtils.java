package com.insiderser.kpi.java.utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern PATTERN_STUDENT_NAME = Pattern.compile("^([a-zA-Z'\\-]+\\s){2}[a-zA-Z'\\-]+$");

    public static boolean isValidStudentName(String name) {
        return PATTERN_STUDENT_NAME.matcher(name).matches();
    }
}
