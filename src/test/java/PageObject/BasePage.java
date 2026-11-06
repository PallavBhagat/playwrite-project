package PageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import util.ExtendManagerReport;

public class BasePage {

    /*
    ============================================================
    OLD CODE - COMMENTED
    ============================================================
     */
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected static Page page;

    protected static ExtentReports extent;
    protected static ExtentTest test;

    // Common locators
    protected Locator addbtn;
    protected Locator savebtn;
    protected Locator candidateFirstName;
    protected Locator candidateMiddleName;
    protected Locator candidateLastName;
    protected Locator successMsg;
    private Locator PIMPage;
    private Locator searchBtn;


    public void openBrowser(String browserName) {

        // Initialize Extent Report
        extent = ExtendManagerReport.getInstance();

        // Create test
        test = extent.createTest("Cucumber Test");

        // Start Playwright
        playwright = Playwright.create();


        // Open Crome Browser
        //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Browser selection
        switch (browserName.toLowerCase()) {

            case "chrome":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("chrome")
                                .setHeadless(false)
                );
                break;

            case "edge":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("msedge")
                                .setHeadless(false)
                );
                break;

            case "firefox":
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions().setChannel("firefox")
                                .setHeadless(false)
                );
                break;

            case "webkit":
                browser = playwright.webkit().launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(false)
                );
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid browser: " + browserName
                );
        }

        // Create browser context
        context = browser.newContext();

        // Create page
        page = context.newPage();

        // Set viewport
        page.setViewportSize(1920, 1080);

        // Set navigation timeout
        page.setDefaultNavigationTimeout(60000);

        // Initialize common locators
        initializeCommonLocators();
    }


    protected void initializeCommonLocators() {

        addbtn = page.locator(
                "//button[normalize-space()='Add']"
        );

        savebtn = page.locator(
                "//button[normalize-space()='Save']"
        );

        candidateFirstName =
                page.getByPlaceholder("First Name");

        candidateMiddleName =
                page.getByPlaceholder("Middle Name");

        candidateLastName =
                page.getByPlaceholder("Last Name");

        successMsg = page.locator(
                "p.oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text"
        );

        PIMPage = page.locator(
                "a:has-text('PIM')"
        );

        searchBtn = page.locator(
                "button:has-text('Search')"
        );
    }


    public void clickonPIM() {
        if (PIMPage == null) {
            initializeCommonLocators();
        }

        PIMPage.click();
    }


    public void clickonSearchBtn() {
        searchBtn.click();
        page.waitForTimeout(3000);

//        System.out.println("Table rows: " + tableRow.count());
//
//        for (int i = 0; i < tableRow.count(); i++) {
//            System.out.println(
//                    "ROW " + i + ": " + tableRow.nth(i).innerText()
//            );
//        }page.waitForTimeout(3000);
//
//        System.out.println("Table rows: " + tableRow.count());
//
//        for (int i = 0; i < tableRow.count(); i++) {
//            System.out.println(
//                    "ROW " + i + ": " + tableRow.nth(i).innerText()
//            );
//        }
    }

    public void clickOnAddBth() {

        if (addbtn == null) {
            initializeCommonLocators();
        }

        addbtn.click();
    }


    public void clickOnSaveBth() {

        if (savebtn == null) {
            initializeCommonLocators();
        }

        savebtn.click();
    }


    public void enterCandidateFirstName(String firstName) {
        candidateFirstName.fill(firstName);
    }


    public void enterCandidateMiddleName(String middleName) {
        candidateMiddleName.fill(middleName);
    }


    public void enterCandidateLastName(String lastName) {
        candidateLastName.fill(lastName);
    }


    public String successMessage() {
        successMsg.waitFor();
        return successMsg.innerText().trim();
    }

    public void closeBrowser() {

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }

/*
    ============================================================
    END OF OLD CODE
    ============================================================
    */


    // ============================================================
    // NEW CODE - PARALLEL CROSS BROWSER
    // ============================================================

//    protected static ThreadLocal<Playwright> playwright =
//            new ThreadLocal<>();
//
//    protected static ThreadLocal<Browser> browser =
//            new ThreadLocal<>();
//
//    protected static ThreadLocal<BrowserContext> context =
//            new ThreadLocal<>();
//
//    protected static ThreadLocal<Page> page =
//            new ThreadLocal<>();
//
//    protected static ExtentReports extent;
//
//    protected static ThreadLocal<ExtentTest> test =
//            new ThreadLocal<>();
//
//
//    // Common locators
//    protected Locator addbtn;
//    protected Locator savebtn;
//
//    private Locator candidateFirstName;
//    private Locator candidateMiddleName;
//    private Locator candidateLastName;
//
//
//    // Open Browser
//    public void openBrowser(String browserName) {
//
//        // Initialize Extent Report
//        extent = ExtendManagerReport.getInstance();
//
//        // Start Playwright
//        Playwright pw = Playwright.create();
//        playwright.set(pw);
//
//        Browser br;
//
//        BrowserType.LaunchOptions options =
//                new BrowserType.LaunchOptions()
//                        .setHeadless(false);
//
//
//        // Browser selection
//        switch (browserName.toLowerCase()) {
//
//            case "chrome":
//
//                br = pw.chromium().launch(
//                        options.setChannel("chrome")
//                );
//
//                break;
//
//
//            case "edge":
//
//                br = pw.chromium().launch(
//                        options.setChannel("msedge")
//                );
//
//                break;
//
//
//            case "firefox":
//
//                br = pw.firefox().launch(options);
//
//                break;
//
//
//            default:
//
//                throw new IllegalArgumentException(
//                        "Invalid browser: " + browserName
//                );
//        }
//
//
//        // Store browser for current thread
//        browser.set(br);
//
//
//        // Create browser context
//        BrowserContext ctx = br.newContext(
//                new Browser.NewContextOptions()
//                        .setViewportSize(1920, 1080)
//        );
//
//        context.set(ctx);
//
//
//        // Create page
//        Page currentPage = ctx.newPage();
//
//        page.set(currentPage);
//
//
//        // Set navigation timeout
//        currentPage.setDefaultNavigationTimeout(60000);
//
//
//        // Initialize common locators
//        initializeCommonLocators();
//    }
//
//
//    protected void initializeCommonLocators() {
//
//        addbtn = page.get().locator(
//                "//button[normalize-space()='Add']"
//        );
//
//        savebtn = page.get().locator(
//                "//button[normalize-space()='Save']"
//        );
//
//        candidateFirstName =
//                page.get().getByPlaceholder("First Name");
//
//        candidateMiddleName =
//                page.get().getByPlaceholder("Middle Name");
//
//        candidateLastName =
//                page.get().getByPlaceholder("Last Name");
//    }
//
//
//    // Common Add button
//    public void clickOnAddBth() {
//
//        if (addbtn == null) {
//            initializeCommonLocators();
//        }
//
//        addbtn.click();
//    }
//
//
//    // Common Save button
//    public void clickOnSaveBth() {
//
//        if (savebtn == null) {
//            initializeCommonLocators();
//        }
//
//        savebtn.click();
//    }
//
//
//    public void enterCandidateFirstName(String firstName) {
//
//        candidateFirstName.fill(firstName);
//    }
//
//
//    public void enterCandidateMiddleName(String middleName) {
//
//        candidateMiddleName.fill(middleName);
//    }
//
//
//    public void enterCandidateLastName(String lastName) {
//
//        candidateLastName.fill(lastName);
//    }
//
//
//    // Close Browser
//    public void closeBrowser() {
//
//        if (context.get() != null) {
//
//            context.get().close();
//            context.remove();
//        }
//
//
//        if (browser.get() != null) {
//
//            browser.get().close();
//            browser.remove();
//        }
//
//
//        if (playwright.get() != null) {
//
//            playwright.get().close();
//            playwright.remove();
//        }
//
//
//        page.remove();
//        test.remove();
//    }



}