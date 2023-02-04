package com.vagrant.basics;

import com.vagrant.utils.CucumberReport;
import com.vagrant.utils.FailureLogs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/cucumber-json-report.json",
                "rerun:target/cucumber-reports/failedTests.txt"},

        extraGlue = "com.vagrant.stepdefs",
        tags = "@Test"
)
public class TestRunner {

    @AfterClass
    public static void afterClass() {

        try {
            if(TestConfig.GenerateCucumberHtmlReport.equalsIgnoreCase("yes")) {
                try {
                    CucumberReport.generateHtmlReport();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (TestConfig.FailureLoggingToFile.equalsIgnoreCase("Yes")) {
                FailureLogs.closeLogsFile(BaseSetup.printStream);
            }



            BaseSetup.killInstance();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
