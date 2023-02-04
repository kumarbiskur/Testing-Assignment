package com.vagrant.basics;

public class TestConfig {

    //Author - Kumar
    //Date of creation - 02/02/2023
    //Usage - To configure the property , report and wait attributes

    public static String baseDir = System.getProperty("user.dir");
    public static String ProfileFilePath ="";
    public static String FailureLoggingToFile = "Yes";
    public static String FailureLogsFilePath = "target/Logs";
    public static String CucumberJsonReport = "target/cucumber-reports";
    public static String CucumberHtmlReport = "CucumberHtmlReport";
    public static String GenerateCucumberHtmlReport = "Yes";
    public static int IdleConnectionTimeOutForResponse = 200;
    public static String PathSeparator = "/";
    public static int MinWait = 10;
    public static int MedWait = 30;
    public static int MaxWait = 60;
    public static String XrayReportImport = "no";
}

