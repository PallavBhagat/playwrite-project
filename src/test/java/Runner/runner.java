package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/Feature/PIMReports.feature",
        glue = "StepDefination",
        plugin = {
                "pretty",
                "html:teg/cucumber-report.html" // this is for report generation
        },
        monochrome = true,
        dryRun = false
)
public class runner extends AbstractTestNGCucumberTests {


        /*
    ============================================================
    OLD CODE - PARALLEL CROSS BROWSER
    ============================================================

    private static ThreadLocal<String> browserName =
            new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public void setBrowser(String browser) {

        browserName.set(browser);

        System.out.println(
                "========================================"
        );

        System.out.println(
                "Running Cucumber tests on: " + browser
        );

        System.out.println(
                "========================================"
        );
    }

    public static String getBrowserName() {
        return browserName.get();
    }

    ============================================================
    END OF OLD CODE
    ============================================================
    */


        // ============================================================
        // NEW CODE - SEQUENTIAL CROSS BROWSER
        // ============================================================

        private static String browserName;


        @BeforeTest
        @Parameters("browser")
        public void setBrowser(String browser) {

                browserName = browser;

                System.out.println(
                        "========================================"
                );

                System.out.println(
                        "Running Cucumber tests on: " + browser
                );

                System.out.println(
                        "========================================"
                );
        }



        public static String getBrowserName() {

                return browserName;
        }
}