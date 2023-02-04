package com.vagrant.basics;

import com.vagrant.common.CommonObject;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.util.ArrayList;
import java.util.Arrays;

public class CucumberHooks {
    private static int failed = 0;
    private static int passed = 0;
    private static int skipped = 0;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001b[42;1m";
    private static final String ANSI_RED_BACKGROUND = "\u001b[41;1m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001b[43;1m";


     CommonObject baseObject=new CommonObject();


    @Before
    public void beforeScenario(Scenario sc) throws Throwable {

        baseObject.scenario = sc;

        CommonObject.SourceTags = new ArrayList<>(Arrays.asList(sc.getSourceTagNames().toArray()));
        //Import feature file


    }

    @After
    public void afterHook(Scenario sc) throws Throwable {
        String msg;
        try {

            // Take screenshot for failed scenario
            if (baseObject.driver != null && sc.isFailed()) {
                try {
                    sc.embed(((TakesScreenshot) baseObject.driver).getScreenshotAs(OutputType.BYTES), "image/png", "");
                } catch (NoSuchSessionException e) {

                }
            }

            if (sc.getStatus().toString().equals("FAILED")) {
                failed++;
            } else if (sc.getStatus().toString().equals("PASSED")) {
                passed++;
            } else if (sc.getStatus().toString().equals("UNDEFINED")) {
                skipped++;
            }
            msg = "Current Status : >>> " + ANSI_GREEN_BACKGROUND + " PASSED : " + passed + " " + ANSI_RESET + "  " + ANSI_RED_BACKGROUND + " FAILED : " + failed + " " + ANSI_RESET + " " + ANSI_YELLOW_BACKGROUND + " SKIPPED : " + skipped + " " + ANSI_RESET;
            System.out.println("====== Status:" + sc.getStatus() + " =======");
            System.out.println(msg);

            if (baseObject.driver != null) {
                try {
                    baseObject.driver.quit();
                    baseObject.driver = null;
                } catch (NoSuchSessionException s) {
                }
            }
        } catch (Throwable t) {
            throw t;
        }
    }
}
