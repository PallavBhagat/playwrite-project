package StepDefination;

import PageObject.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ScreenShotUtil;
import Runner.runner;

public class Hooks extends BasePage {

    /*
    ============================================================
    OLD CODE - COMMENTED
    ============================================================
     */
    @Before
    public void setUp(Scenario scenario) {

        // Open browser
        //openBrowser();

        // Get browser name from TestNG XML
        String browserName = runner.getBrowserName();


        System.out.println(
                "========================================"
        );

        System.out.println(
                "Starting Scenario: " + scenario.getName()
        );

        System.out.println(
                "Browser: " + browserName
        );

        System.out.println(
                "========================================"
        );


        // Open selected browser
        openBrowser(browserName);

        // Create dynamic Extent Report test name
        test = extent.createTest(
                scenario.getName() + browserName
        );

        test.info("Browser opened successfully");

        // Open OrangeHRM
        page.navigate(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );

        test.info("OrangeHRM website opened");
    }


    @After
    public void tearDown(Scenario scenario) {

        // Check Scenario result
        if (scenario.isFailed()) {

            test.fail("Test Failed");

            // Take screenshot
            String screenShotPath =
                    ScreenShotUtil.takeScreenShot(
                            page,
                            scenario.getName()
                    );

            // Add screenshot to Extent Report
            test.addScreenCaptureFromPath(
                    screenShotPath
            );

        } else {

            test.pass("Test Passed");
        }

        // Save Extent Report
        extent.flush();

        // wait for 10 sec
        page.waitForTimeout(10000);

        test.info("Browser closed successfully");

        // Close browser
        closeBrowser();
    }

 /*
    ============================================================
    END OF OLD CODE
    ============================================================
    */


    // ============================================================
    // NEW CODE - PARALLEL CROSS BROWSER
    // ============================================================


    // Before every Scenario
//    @Before
//    public void setUp(Scenario scenario) {
//
//        // Get browser name from TestNG XML
//        String browserName = runner.getBrowserName();
//
//        System.out.println(
//                "========================================"
//        );
//
//        System.out.println(
//                "Starting Scenario: " + scenario.getName()
//        );
//
//        System.out.println(
//                "Browser: " + browserName
//        );
//
//        System.out.println(
//                "========================================"
//        );
//
//
//        // Open selected browser
//        openBrowser(browserName);
//
//
//        // Create Extent Report test
//        test.set(
//                extent.createTest(
//                        scenario.getName()
//                                + " - "
//                                + browserName
//                )
//        );
//
//
//        test.get().info(
//                "Browser: " + browserName
//        );
//
//        test.get().info(
//                "Browser opened successfully"
//        );
//
//
//        // Open OrangeHRM
//        page.get().navigate(
//                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
//        );
//
//
//        test.get().info(
//                "OrangeHRM website opened"
//        );
//    }
//
//
//    // After every Scenario
//    @After
//    public void tearDown(Scenario scenario) {
//
//        // Check Scenario result
//        if (scenario.isFailed()) {
//
//            test.get().fail("Test Failed");
//
//
//            // Take screenshot
//            String screenShotPath =
//                    ScreenShotUtil.takeScreenShot(
//                            page.get(),
//                            scenario.getName()
//                    );
//
//
//            // Add screenshot to Extent Report
//            test.get().addScreenCaptureFromPath(
//                    screenShotPath
//            );
//
//        } else {
//
//            test.get().pass("Test Passed");
//        }
//
//
//        // Browser closing message
//        test.get().info(
//                "Browser closed successfully"
//        );
//
//
//        // Save Extent Report
//        extent.flush();
//
//
//        // Close browser
//        closeBrowser();
//    }
}



