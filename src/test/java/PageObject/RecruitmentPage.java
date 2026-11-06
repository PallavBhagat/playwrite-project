package PageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class RecruitmentPage extends BasePage {

    // Locators
    private Locator clickonRecruitment;
    private Locator vacancyDropDown;
    private Locator candidateEmail;
    private Locator candidateContactNumber;
    private Locator candidateKeywords;
    private Locator candidateNote;
    private Locator candidateCheckBox;
    private Locator searchusingvacancyDropDown;
    private Locator uplodeFile;
    private String selectoption;
    //private Locator searchBtn;
    private Locator tableRow;
    private String selectVacancy;

    // Constructor
    public RecruitmentPage(Page page) {

        // First assign page
        this.page = page;

        initializeCommonLocators();

        // Initialize locators after page is assigned
        clickonRecruitment = page.locator("a:has-text('Recruitment')");


        vacancyDropDown = page.locator(
                "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"
        );

        candidateEmail = page.locator(
                "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"
        );

        candidateContactNumber = page.locator(
                "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"
        );

        candidateKeywords = page.locator(
                "input[placeholder='Enter comma seperated words...']"
        );

        candidateNote = page.locator(
                "textarea[placeholder='Type here']"
        );

        candidateCheckBox = page.locator(
                ".oxd-checkbox-input.oxd-checkbox-input--active"
        );

        uplodeFile = page.locator(
                "input[type='file']"
        );

        searchusingvacancyDropDown = page.locator(
                "div[class='oxd-table-filter-area'] div:nth-child(2) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) i:nth-child(1)"
        );

//        searchBtn = page.locator(
//                "button[type='submit']"
//        );

        tableRow = page.locator(
                "//div[contains(@class,'oxd-table-card')]//div[@role='row']"
        );

    }


    // Actions

    public void clickOnRecuitmentBth() {
        clickonRecruitment.click();
    }

    public void selectvacancy() {

        vacancyDropDown.click();

        page.waitForTimeout(5000);
        System.out.println("====================================");

        Locator options = page.locator(".oxd-select-option");

        int count = options.count();
        System.out.println("total count in add candidate page " + count);

        for (int i = 0; i < count; i++) {
             selectoption = "Option " + (i + 1) + ": " + options.nth(i).innerText();
            System.out.println(selectoption);
        }

        selectVacancy  = options.nth(1).innerText().trim();

        System.out.println("Selected vacancy: " + selectVacancy);

        // Select 2nd option
        options.nth(1).click();
    }

    public void enterCandidateEmail(String email) {
        candidateEmail.fill(email);
    }

    public void enterCandidateContactNumber(String contactNumber) {
        candidateContactNumber.fill(contactNumber);
    }

    public void enterCandidateKeywords(String keywords) {
        candidateKeywords.fill(keywords);
    }

    public void enterCandidateNote(String note) {
        candidateNote.fill(note);
    }

    public void uplodefile() {

        // this is file path
        uplodeFile.setInputFiles(Paths.get("C:\\Users\\PALLAV BHAGAT\\OneDrive\\Desktop\\JAVA.txt"));

//        Locator button = page.locator("//button[normalize-space()='Upload Multiple Files']");
//        button.click();
    }

    public void clickCandidateCheckBox() {
        candidateCheckBox.click();
    }

    public void checkingofusingVacancy() throws InterruptedException {
        searchusingvacancyDropDown.click();

        page.waitForTimeout(4000);

        Locator options = page.locator(".oxd-select-option");

        int count = options.count();
        System.out.println("Total count in search candidate page " + count);

        for (int i = 0; i < count; i++) {
            selectoption = "Option " + (i + 1) + ": " + options.nth(i).innerText();
            System.out.println(
                    "Option " + (i + 1) + ": " + selectoption
            );
        }

        // Find the vacancy that was selected earlier
        Locator selectedOption = options.filter(
                new Locator.FilterOptions()
                        .setHasText(selectVacancy)
        );

        selectedOption.first().click();

        // Select 3rd option
        //options.nth(1).click();

        // Verify the vacancy was found before clicking
//        if (selectedOption.count() == 0) {
//            throw new RuntimeException(
//                    "Vacancy not found in search dropdown: " + selectVacancy
//            );
//        }

        // Click the matching vacancy
        //selectedOption.click();

        Thread.sleep(5000);

    }

//    public void clickonSearchBtn(){
//        searchBtn.click();
//    }

    public boolean isCandidateVisible(String candidateName) {

        // Filter the table rows and find the row that contains the candidate name
        //Locator candidateRow = tableRow.filter(new Locator.FilterOptions().setHasText(candidateName));


        System.out.println("====================================");
        System.out.println("Searching candidate: " + candidateName);

        // Get all candidate rows displayed in the table
        int rowCount = tableRow.count();

        System.out.println("Total candidate rows: " + rowCount);

        // Print the text of every row
//        for (int i = 0; i < rowCount; i++) {
//
//            String rowText = tableRow.nth(i).innerText().trim();
//
//            System.out.println("Row " + (i + 1) + ": " + rowText);
//        }


        // Wait until at least one candidate row appears
        tableRow.first().waitFor();

        // Find the table row containing the candidate name
        Locator candidateRow = tableRow.filter(
                new Locator.FilterOptions()
                        .setHasText(candidateName)
        );


        // Wait until the candidate row appears in the table
        try {
            candidateRow.first().waitFor(
                    new Locator.WaitForOptions()
                            .setTimeout(10000)
            );
        } catch (Exception e) {
            System.out.println("Candidate was not found: " + candidateName);
            return false;
        }

        int matchingRows = candidateRow.count();

        System.out.println(
                "Matching candidate rows: " + matchingRows
        );

        System.out.println("====================================");

        // Check that at least one matching row exists
        // AND check that the first matching row is visible on the page
        return candidateRow.count() > 0
                && candidateRow.first().isVisible();
    }

    public String getActualCandidateName(String candidateName) {
        Locator candidateRow = tableRow.filter(
                new Locator.FilterOptions()
                        .setHasText(candidateName)
        );

        return candidateRow.first()
                .locator(".oxd-table-cell")
                .nth(2)
                .innerText()
                .trim();
    }

    public String getActualCandidateVacancy(String candidateName) {
        Locator candidateRow = tableRow.filter(
                new Locator.FilterOptions()
                        .setHasText(candidateName)
        );

        return candidateRow.first()
                .locator(".oxd-table-cell")
                .nth(1)
                .innerText()
                .trim();
    }

}