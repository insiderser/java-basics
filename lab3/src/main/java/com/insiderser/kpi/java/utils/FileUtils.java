package com.insiderser.kpi.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileUtils {

    public static String readEverythingFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        scanner.useDelimiter("\\A");
        return scanner.next();
    }

    public static void writeToFile(String fileName, CharSequence content) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName));
        writer.append(content);
        writer.close();
    }
}
