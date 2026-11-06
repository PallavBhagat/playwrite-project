package StepDefination;

import PageObject.BasePage;
import PageObject.PIMReportsPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class PIMReportsDefination extends BasePage {

    PIMReportsPage pimReportsPage;

    @When("User clicks on the Reports menu")
    public void user_clicks_on_the_reports_menu() {
        pimReportsPage = new PIMReportsPage(page);
        test.info("User clicks on the Reports menu");
        pimReportsPage.clickonReportsMenu();
    }

    @When("User enters the report name")
    public void user_enters_the_report_name() {
        test.info("User enters the report name");
        pimReportsPage.enterReportName("Employee Contact info report");
    }

    @When("User fills the report details")
    public void user_fills_the_report_details() {
//        test.info("User fills the Display Field DropDown");
//        pimReportsPage.selectDisplayFieldDropDown();
//
//        test.info("User fills the Include DropDown");
//        pimReportsPage.setIncludeDropDown();
//
//        test.info("User fills the Display Field Group DropDown");
//        pimReportsPage.selectDisplayFieldGroupDropDown();
//
//        test.info("User fills the Display Field DropDown");
//        pimReportsPage.selectDisplayFieldDropDown();
    }

    @When("User enters the report name in the search field")
    public void user_enters_the_report_name_in_the_search_field() {
        pimReportsPage.enterReportNameInSearch("Employee Contact info report");
    }

//    @When("User clicks on the PIM Repoort Search button")
//    public void user_clicks_on_the_pim_repoort_search_button() {
//        clickonSearchBtn();
//    }

    @Then("User should see the report name in the search results")
    public void user_should_see_the_report_name_in_the_search_results() {
        test.info("Verifying the new report is visible in the search results");
        Assert.assertTrue(
                pimReportsPage.isReportVisible("Employee Contact info report"),
                "Report is not visible in the search results"
        );
    }

    @Then("User should verify the report name")
    public void user_should_verify_the_report_name() {
        test.info("Verifying report name in the Table");

        String expertedReportName = "Employee Contact info report";

        String actualReportName = pimReportsPage.getActualReportName(expertedReportName);
        Assert.assertEquals(
                actualReportName,
                "Employee Contact info report",
                "Candidate First and Last Name does not match");
    }
}
