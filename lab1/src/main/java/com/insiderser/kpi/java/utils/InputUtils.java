package com.insiderser.kpi.java.utils;

import java.util.Scanner;

public class InputUtils {

    public static int readInt() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            input.next();
        }
        return input.nextInt();
    }

    public static String readStudentName() {
        Scanner input = new Scanner(System.in);
        return String.format("%s %s %s", input.next(), input.next(), input.next());
    }
}
