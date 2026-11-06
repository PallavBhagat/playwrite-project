//package TestCase;
//
//import PageObject.BasePage;
//import com.aventstack.extentreports.ExtentTest;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import util.ScreenShotUtil;
//
//public class BaseTest extends BasePage {
//
//    // Before every Scenario
//    @Before
//    public void setUp(Scenario scenario) {
//
//        // Open browser
//        openBrowser();
//
//        // Create dynamic Extent Report test name
//        test = extent.createTest(scenario.getName());
//        test.info("Browser opened successfully");
//
//        // Open OrangeHRM
//        page.navigate( "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" );
//
//        test.info("OrangeHRM website opened");
//    }
//
//    // After every Scenario
//    @After
//    public void tearDown(Scenario scenario) {
//
//        // Check Scenario result
//        if (scenario.isFailed()) {
//
//            test.fail("Test Failed");
//
//            // Take screenshot
//            String screenShotPath = ScreenShotUtil.takeScreenShot( page, scenario.getName() );
//
//            // Add screenshot to Extent Report
//            test.addScreenCaptureFromPath(screenShotPath);
//
//        } else {
//            test.pass("Test Passed");
//        }
//        // Save Extent Report
//        extent.flush();
//
//        // Close browser
//        closeBrowser();
//    }
//}