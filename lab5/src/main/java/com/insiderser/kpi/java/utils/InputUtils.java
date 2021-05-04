package com.insiderser.kpi.java.utils;

import com.insiderser.kpi.java.exceptions.InvalidInputException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final Scanner INPUT = new Scanner(System.in);

    public static int readInt() throws InvalidInputException {
        if (INPUT.hasNextInt()) {
            return INPUT.nextInt();
        } else {
            INPUT.next();
            throw new InvalidInputException("Entered number was invalid");
        }
    }

    public static String readStudentName() throws InvalidInputException {
        String input = String.format("%s %s %s", INPUT.next(), INPUT.next(), INPUT.next());
        LOGGER.debug("Entered student name {}", input);

        if (!ValidationUtils.isValidStudentName(input)) {
            LOGGER.info("Student name {} is invalid", input);
            throw new InvalidInputException("Entered student name was invalid");
        }
        return input;
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
