package StepDefination;

import PageObject.BasePage;
import PageObject.RecruitmentPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RecruitmentDefination extends BasePage {

    /*
    ============================================================
    OLD CODE - COMMENTED
    ============================================================
*/

    private RecruitmentPage recruitmentPage;

    @When("User clicks on the Recruitment menu")
    public void user_clicks_on_the_recruitment_menu() {
        recruitmentPage = new RecruitmentPage(page);

        test.info("User clicks on the Recruitment menu");
        recruitmentPage.clickOnRecuitmentBth();
    }

    @When("User enters the candidate first name")
    public void user_enters_the_candidate_first_name() {

        test.info("Enters the candidate first name");
        recruitmentPage.enterCandidateFirstName("Nikita");
    }

    @When("User enters the candidate middle name")
    public void user_enters_the_candidate_middle_name() {

        test.info("Enters the candidate middle name");
        recruitmentPage.enterCandidateMiddleName("Pallav");
    }

    @When("User enters the candidate last name")
    public void user_enters_the_candidate_last_name() {

        test.info("Enters the candidate last name");
        recruitmentPage.enterCandidateLastName("Bhagat");
    }

    @When("User selects the vacancy")
    public void user_selects_the_vacancy() {

        test.info("Select the vacancy");
        recruitmentPage.selectvacancy();
    }

    @When("User enters the candidate email address")
    public void user_enters_the_candidate_email_address() {

        test.info("Enters the candidate email address");
        recruitmentPage.enterCandidateEmail(
                "nikitabhagat11@gmail.com"
        );
    }

    @When("User enters the candidate contact number")
    public void user_enters_the_candidate_contact_number() {

        test.info("Enters the candidate contact number");
        recruitmentPage.enterCandidateContactNumber(
                "1234567890"
        );
    }

    @When("User uploads the candidate resume")
    public void user_uploads_the_candidate_resume() {

        test.info("Uploads the candidate resume");
        recruitmentPage.uplodefile();
    }

    @When("User enters the candidate keywords")
    public void user_enters_the_candidate_keywords() {

        test.info("Enters the candidate keywords");
        recruitmentPage.enterCandidateKeywords("");
    }

    @When("User enters the candidate notes")
    public void user_enters_the_candidate_notes() {

        test.info("Enters the candidate notes");
        recruitmentPage.enterCandidateNote("");
    }

    @When("User selects the consent checkbox")
    public void user_selects_the_consent_checkbox() {

        test.info("Select the consent checkbox");
        recruitmentPage.clickCandidateCheckBox();
    }

    @Then("User should see a success message of recruitment page")
    public void user_should_see_a_success_message() {
        test.info("Verifing the success message");
        String actulResult = successMessage();

        // Using Assert Equal
        Assert.assertEquals(actulResult, "Success");

        // Using Assert True
        Assert.assertTrue(actulResult.contains("Success"));

        test.pass("Success message verified: ");
    }

    @When("User selects the Vacancy from the dropdown")
    public void user_selects_the_vacancy_from_the_dropdown() throws InterruptedException{
        test.info("Select the Vacancy from the dropdown");
        recruitmentPage.checkingofusingVacancy();
    }

//    @When("User clicks on the Search button")
//    public void user_clicks_on_the_search_button() {
//        test.info("Clicks on the Search button");
//        recruitmentPage.clickonSearchBtn();
//    }

    @Then("User should see the newly added candidate in the search results")
    public void user_should_see_the_newly_added_candidate_in_the_search_results() {

        test.info("Verifying the new candidate is visible in the search results");
        Assert.assertTrue(
                recruitmentPage.isCandidateVisible("Nikita Pallav Bhagat"),
                "Candidate not visible in search results"
        );
    }

    @Then("User should verify the candidate name and vacancy in Recruitment")
    public void user_should_verify_the_candidate_name_and_vacancy() {
        test.info("Verifying candidate name and vacancy");

        String expectedCandidateName = "Nikita Pallav Bhagat";
        String expectedVacancy = "Junior Account Assistant";

        String actualCandidateName =
                recruitmentPage.getActualCandidateName(expectedCandidateName);

        String actualCandidateVacancy =
                recruitmentPage.getActualCandidateVacancy(expectedCandidateName);

        Assert.assertEquals(
                actualCandidateName,
                expectedCandidateName,
                "Candidate name does not match"
        );

        Assert.assertEquals(
                actualCandidateVacancy,
                expectedVacancy,
                "Candidate Vacancy does not match"
        );


        test.pass(
                "Candidate name and vacancy verified successfully"
        );
    }

/*
    ============================================================
    END OF OLD CODE
    ============================================================
    */


    // ============================================================
    // NEW CODE - PARALLEL CROSS BROWSER
    // ============================================================

//    private RecruitmentPage recruitmentPage;
//
//    @When("User clicks on the Recruitment menu")
//    public void user_clicks_on_the_recruitment_menu() {
//
//        recruitmentPage = new RecruitmentPage(page.get());
//
//        test.get().info(
//                "User clicks on the Recruitment menu"
//        );
//
//        recruitmentPage.clickOnRecuitmentBth();
//    }
//
//    @When("User enters the candidate first name")
//    public void user_enters_the_candidate_first_name() {
//
//        test.get().info(
//                "Enters the candidate first name"
//        );
//
//        recruitmentPage.enterCandidateFirstName("Pallav");
//    }
//
//    @When("User enters the candidate middle name")
//    public void user_enters_the_candidate_middle_name() {
//
//        test.get().info(
//                "Enters the candidate middle name"
//        );
//
//        recruitmentPage.enterCandidateMiddleName("Dilip");
//    }
//
//    @When("User enters the candidate last name")
//    public void user_enters_the_candidate_last_name() {
//
//        test.get().info(
//                "Enters the candidate last name"
//        );
//
//        recruitmentPage.enterCandidateLastName("Bhagat");
//    }
//
//    @When("User selects the vacancy")
//    public void user_selects_the_vacancy() {
//
//        test.get().info(
//                "Select the vacancy"
//        );
//
//        recruitmentPage.selectvacancy();
//    }
//
//    @When("User enters the candidate email address")
//    public void user_enters_the_candidate_email_address() {
//
//        test.get().info(
//                "Enters the candidate email address"
//        );
//
//        recruitmentPage.enterCandidateEmail(
//                "pallavbhagat123@gmail.com"
//        );
//    }
//
//    @When("User enters the candidate contact number")
//    public void user_enters_the_candidate_contact_number() {
//
//        test.get().info(
//                "Enters the candidate contact number"
//        );
//
//        recruitmentPage.enterCandidateContactNumber(
//                "1234567890"
//        );
//    }
//
//    @When("User uploads the candidate resume")
//    public void user_uploads_the_candidate_resume() {
//
//        test.get().info(
//                "Uploads the candidate resume"
//        );
//
//        recruitmentPage.uplodefile();
//    }
//
//    @When("User enters the candidate keywords")
//    public void user_enters_the_candidate_keywords() {
//
//        test.get().info(
//                "Enters the candidate keywords"
//        );
//
//        recruitmentPage.enterCandidateKeywords("");
//    }
//
//    @When("User enters the candidate notes")
//    public void user_enters_the_candidate_notes() {
//
//        test.get().info(
//                "Enters the candidate notes"
//        );
//
//        recruitmentPage.enterCandidateNote("");
//    }
//
//    @When("User selects the consent checkbox")
//    public void user_selects_the_consent_checkbox() {
//
//        test.get().info(
//                "Select the consent checkbox"
//        );
//
//        recruitmentPage.clickCandidateCheckBox();
//    }
//
//    @Then("User should see a success message")
//    public void user_should_see_a_success_message() {
//
//    }
//
//    @When("User selects the Vacancy from the dropdown")
//    public void user_selects_the_vacancy_from_the_dropdown() {
//
//    }
//
//    @When("User clicks on the Search button")
//    public void user_clicks_on_the_search_button() {
//
//    }
//
//    @Then("User should see the newly added candidate in the search results")
//    public void user_should_see_the_newly_added_candidate_in_the_search_results() {
//
//    }
//
//    @Then("User should verify the candidate name and vacancy in Recruitment")
//    public void user_should_verify_the_candidate_name_and_vacancy() {
//
//    }
}