package util;

import com.microsoft.playwright.Page;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

    public static String takeScreenShot(Page page, String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        Path screenshotPath =
                Paths.get("target/screenshots/"
                        + testName + "_" + timestamp + ".png");

        try {

            Files.createDirectories(screenshotPath.getParent());

            System.out.println("Taking screenshot...");
            System.out.println("URL: " + page.url());
            System.out.println("Title: " + page.title());

            // Make sure the page is active
            page.bringToFront();

            // Give the browser time to render the current page
            page.waitForTimeout(1000);

            // Take screenshot of the current viewport
            page.screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(screenshotPath)
                            .setFullPage(false)
            );

            System.out.println(
                    "Screenshot saved: "
                            + screenshotPath.toAbsolutePath()
            );

        } catch (Exception e) {

            System.out.println("Screenshot capture failed!");
            e.printStackTrace();
        }

        return screenshotPath.toString();
    }
}
