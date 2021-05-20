package com.insiderser.kpi.java.utils;

import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final Scanner INPUT = new Scanner(System.in);

    public static int readInt() {
        try {
            return INPUT.nextInt();
        } catch (NoSuchElementException e) {
            INPUT.next();
            throw e;
        }
    }

    public static String readStudentName() {
        return String.format("%s %s %s", INPUT.next(), INPUT.next(), INPUT.next());
    }

    public static String readFilePath() {
        INPUT.useDelimiter(System.lineSeparator());
        try {
            return INPUT.next();
        } finally {
            INPUT.reset();
        }
    }
}
