package com.vagrant.utils;

import com.vagrant.basics.TestConfig;



import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import static com.vagrant.basics.BaseSetup.*;
import static com.vagrant.basics.BaseSetup.endTimeForReport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CucumberReport {


    public static void generateHtmlReport() throws Throwable {
        File reportOutputDirectory = new File(TestConfig.baseDir + TestConfig.PathSeparator + TestConfig.CucumberHtmlReport + TestConfig.PathSeparator);
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(TestConfig.baseDir + TestConfig.PathSeparator + TestConfig.CucumberJsonReport + TestConfig.PathSeparator + "cucumber-json-report.json");

        String buildNumber = "001";
        String projectName = "TestVagarant";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addClassifications("Squad", "QA");
        configuration.addClassifications("StartTime", startTimeForReport);
        endTimeForReport = new Generics().getCurrentTime("dd MMM yyyy HH:mm:ss");
        configuration.addClassifications("EndTime", endTimeForReport);
        configuration.addClassifications("TimeTaken", findDifference(startTimeForReport,endTimeForReport,"dd MMM yyyy HH:mm:ss"));
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
    public static String findDifference(String start_date, String end_date, String format) throws Throwable {
        String timeTaken = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            // Calucalte time difference in milliseconds
            long difference_In_Time = d2.getTime() - d1.getTime();
            long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
            long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
            long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
            timeTaken = difference_In_Hours
                    + " hour, "
                    + difference_In_Minutes
                    + " minutes, "
                    + difference_In_Seconds
                    + " seconds";

        } catch (Throwable e) {

        }
        return timeTaken;
    }
}
