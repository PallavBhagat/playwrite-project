package PageObject;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class PIMPage extends BasePage{

    // Locator
    private Locator employeeID;
    private Locator slider;
    private Locator userName;
    private Locator password;
    private Locator confirmPassword;
    private Locator employeeList;
    private Locator searchemployeeId;
    private Locator tableRow;

    // Constructor
    public PIMPage(Page page) {
        this.page = page;

        initializeCommonLocators();

       // clickonPIMPage = page.locator("a:has-text('PIM')");

        employeeID = page.locator(
                "//label[normalize-space()='Employee Id']/parent::div/following-sibling::div//input"
        );

        slider = page.locator(
                "span.oxd-switch-input.oxd-switch-input--active.--label-right"
        );

        userName = page.locator(
                "//label[normalize-space()='Username']/parent::div/following-sibling::div//input"
        );

        password = page.locator(
                "//label[normalize-space()='Password']/parent::div/following-sibling::div//input"
        );

        confirmPassword = page.locator(
                "//label[normalize-space()='Confirm Password']/parent::div/following-sibling::div//input"
        );

        employeeList = page.locator(
                ":text-is('Employee List')"
        );


        searchemployeeId = page.locator(
                "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']"
        );

        tableRow = page.locator(
                "//div[contains(@class,'oxd-table-card')]//div[@role='row']"
        );
    }


    // Action Methods

    public void enterEmployeeID(String empID) {
        employeeID.clear();
        employeeID.fill(empID);
    }

    public void clickonsilderBth() {
        slider.click();
    }

    public void enterUserName(String usName) {
        userName.fill(usName);
    }

    public void enterPassword(String pwd) {
        password.fill(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        confirmPassword.fill(pwd);
    }

    public void clickonEmployeeList() {
        employeeList.click();
    }

    public void enterSearchemployeeId(String empID) {
        searchemployeeId.fill(empID);
    }

//    public void clickonSearchBtn() {
//        searchBtn.click();
//        page.waitForTimeout(3000);
//
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
//    }

    public boolean isCandidateVisible(String candidateName) {

        System.out.println("====================================");
        System.out.println("Searching candidate: " + candidateName);

        // Get all candidate rows displayed in the table
        //int rowCount = tableRow.count();

        //System.out.println("Total candidate rows: " + rowCount);

        // Wait until at least one candidate row appears
        //tableRow.first().waitFor();

        // Find the table row containing the candidate name
//        Locator candidateRow = tableRow.filter(
//                new Locator.FilterOptions()
//                        .setHasText(candidateName)
//        );


        // Wait until the candidate row appears in the table
        try {
            tableRow.first().waitFor(
                    new Locator.WaitForOptions()
                            .setTimeout(10000)
            );
        } catch (Exception e) {
            System.out.println("Candidate was not found: " + candidateName );
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

    public String getActualCandidateFirstandMiddleName(String candidateName) {
        Locator candidateRow = tableRow.filter(
                new Locator.FilterOptions()
                .setHasText(candidateName)
        );
        return candidateRow.first()
                .locator(".oxd-table-cell")
                .nth(2)
                .innerText().trim();
    }


    public String getActualCandidateLastName(String candidateName) {
        Locator candidateRow = tableRow.filter(
                new Locator.FilterOptions()
                        .setHasText(candidateName)
        );
        return candidateRow.first()
                .locator(".oxd-table-cell")
                .nth(3)
                .innerText().trim();
    }

    public String getActualID(String empID) {
        Locator empRow = tableRow.filter(
                new Locator.FilterOptions()
                        .setHasText(empID)
        );
        return empRow.first()
                .locator(".oxd-table-cell")
                .nth(1)
                .innerText().trim();
    }
}
