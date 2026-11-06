package PageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import freemarker.core.LocalContext;

public class PIMReportsPage extends BasePage {

    private Locator reportMenu;
    private Locator reportName;
    private Locator searchReportName;
    private Locator selectionCriteriaDropDown;
    private Locator includeDropDown;
    private Locator selectDisplayFieldGroupDropDown;
    private Locator selectDisplayFieldDropDown;
    private String selectOption;
    private String selectVacency;
    private Locator tableRow;


    public PIMReportsPage(Page page) {
        this.page = page;

        initializeCommonLocators();

        reportMenu = page.locator(
                "li:has-text('Reports')"
        );

        // Report name field on the Add Report page
        reportName = page.locator(
                "//input[@placeholder='Type here ...']"
        );

        // Report name field on the Reports search page
        searchReportName = page.locator(
                "//div[contains(@class,'oxd-input-group')]//input"
        );

        selectionCriteriaDropDown = page.locator(
                "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"
        ).nth(0);

        includeDropDown = page.locator(
                "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"
        ).nth(1);

        selectDisplayFieldGroupDropDown = page.locator(
                "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"
        ).nth(2);

        selectDisplayFieldDropDown = page.locator(
                "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"
        ).nth(3);

        tableRow = page.locator(
                "//div[contains(@class,'oxd-table-card')]//div[@role='row']"
        );

    }

    public void clickonReportsMenu() {
    reportMenu.click();
    }

    public void enterReportName(String rpName) {
        reportName.fill(rpName);
    }

    public void enterReportNameInSearch(String rpName) {
        searchReportName.fill(rpName);
    }

    public void setSelectionCriteriaDropDown() {
        selectionCriteriaDropDown.click();

        page.waitForTimeout(5000);
        System.out.println("====================================");

        Locator options = page.locator(
                "//div[@class='oxd-select-option']");

        int count = options.count();
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            selectOption = "Option " + (i + 1) + " " + options.nth(i).innerText();
            System.out.println("Selected option: " + selectOption);
        }

        selectVacency = options.nth(1).innerText().trim();
        System.out.println("Selected vacency: " + selectVacency);

        options.nth(1).click();
    }

    public void setIncludeDropDown() {
        includeDropDown.click();

        page.waitForTimeout(5000);
        System.out.println("====================================");

        Locator options = page.locator(
                "//div[@class='oxd-select-option']");

        int count = options.count();
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            selectOption = "Option " + (i + 1) + " " + options.nth(i).innerText();
            System.out.println("Selected option: " + selectOption);
        }

        selectVacency = options.nth(1).innerText().trim();
        System.out.println("Selected vacency: " + selectVacency);

        options.nth(1).click();
    }

    public void selectDisplayFieldGroupDropDown() {
        selectDisplayFieldGroupDropDown.click();

        page.waitForTimeout(5000);
        System.out.println("====================================");

        Locator options = page.locator(
                "//div[@class='oxd-select-option']");

        int count = options.count();
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            selectOption = "Option " + (i + 1) + " " + options.nth(i).innerText();
            System.out.println("Selected option: " + selectOption);
        }

        selectVacency = options.nth(1).innerText().trim();
        System.out.println("Selected vacency: " + selectVacency);

        options.nth(1).click();
    }

    public void selectDisplayFieldDropDown() {
        selectDisplayFieldDropDown.click();

        page.waitForTimeout(5000);
        System.out.println("====================================");

        Locator options = page.locator(
                "//div[@class='oxd-select-option']");

        int count = options.count();
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            selectOption = "Option " + (i + 1) + " " + options.nth(i).innerText();
            System.out.println("Selected option: " + selectOption);
        }

        selectVacency = options.nth(1).innerText().trim();
        System.out.println("Selected vacency: " + selectVacency);

        options.nth(1).click();
    }

    public boolean isReportVisible(String reportName) {

        System.out.println("====================================");
        System.out.println("Searching report: " + reportName);


        // Wait until the candidate row appears in the table
        try {
            tableRow.first().waitFor(
                    new Locator.WaitForOptions()
                            .setTimeout(10000)
            );
        } catch (Exception e) {
            System.out.println("report was not found: " + reportName );
            return false;
        }

        int matchingRows = tableRow.count();

        System.out.println(
                "Matching candidate rows: " + matchingRows
        );

        System.out.println("====================================");

        // Check that at least one matching row exists
        // AND check that the first matching row is visible on the page
        return matchingRows > 0
                && tableRow.first().isVisible();
    }


    public String getActualReportName(String reportName) {
        Locator reportRow = tableRow.filter(
                new Locator.FilterOptions()
                        .setHasText(reportName)
        );
        return reportRow.first()
                .locator(".oxd-table-cell")
                .nth(1)
                .innerText().trim();
    }
}
