package com.vagrant.utils;

import org.apache.commons.io.output.WriterOutputStream;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;

public class FailureLogs {

    public static PrintStream printStream;
    private static FileWriter fileWriter;
    static Generics generic;

    public static PrintStream logFailureLogsToFile(String logFolder) throws Throwable {

        try {

            generic = new Generics();
            File dir = new File(logFolder);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (logFolder.endsWith("/")) {
                logFolder = logFolder.substring(0, logFolder.length() - 1);
            }

            fileWriter = new FileWriter(logFolder + "/" + "Logs" + "_" + generic.getCurrentDate("dd-MMM-yyyy") + "_"
                    + generic.getCurrentTime("hhmmss") + ".txt");
            printStream = new PrintStream(new WriterOutputStream(fileWriter, "US-ASCII", 2048, true));
            printStream.print("============================Failure Logs Details Are Given Below ==================================================================");
            printStream.println();
            generic = null;
        } catch (Throwable t) {
            System.out.println("Error Occurred in method logFailureLogsToFile is : " + t.toString());
        }
        return printStream;
    }

    public static void closeLogsFile(PrintStream print) throws Throwable {
        try {
            print.flush();
            print.close();
            print = null;
        } catch (Throwable t) {
            System.out.println("Error Occurred in method closeLogsFile is : " + t.toString());
            throw t;
        }
    }
}
