package com.insiderser.kpi.java.utils;

import com.insiderser.kpi.java.exceptions.InvalidInputException;
import java.util.Scanner;

public class InputUtils {

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
        if (!ValidationUtils.isValidStudentName(input)) {
            throw new InvalidInputException("Entered student name was invalid");
        }
        return input;
    }
}
