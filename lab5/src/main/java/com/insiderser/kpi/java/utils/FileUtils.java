package com.insiderser.kpi.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    public static String readEverythingFromFile(String fileName) throws FileNotFoundException {
        LOGGER.debug("Reading contents of {}", fileName);
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        scanner.useDelimiter("\\A");
        return scanner.next();
    }

    public static void writeToFile(String fileName, CharSequence content) throws IOException {
        LOGGER.trace("Writing {} to {}", content, fileName);

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName));
        writer.append(content);
        writer.close();

        LOGGER.info("Writing output to {} success", fileName);
    }
}
