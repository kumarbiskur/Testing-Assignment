package com.vagrant.basics;


import com.vagrant.helpers.PropertyReader;

import java.io.PrintStream;

public class BaseSetup {
    public static PropertyReader properties;

    public static String startTimeForReport;
    public static String endTimeForReport;
    private static BaseSetup baseObject = null;
    public static PrintStream printStream;


    public static void killInstance() throws Throwable {
        baseObject = null;
        properties = null;
        printStream = null;
        killDriverInstance();
    }

    public static void killDriverInstance() throws Throwable {
        try {
            Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
        } catch (Throwable t) {

        }
    }
}
