package com.insiderser.kpi.java.utils;

import java.util.Scanner;

public class InputUtils {

    private static final Scanner INPUT = new Scanner(System.in);

    public static int readInt() {
        while (!INPUT.hasNextInt()) {
            INPUT.next();
        }
        return INPUT.nextInt();
    }

    public static String readStudentName() {
        return String.format("%s %s %s", INPUT.next(), INPUT.next(), INPUT.next());
    }
}
