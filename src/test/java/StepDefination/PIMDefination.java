package StepDefination;

import PageObject.BasePage;
import PageObject.PIMPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class PIMDefination extends BasePage {

    /*
    ============================================================
    OLD CODE - COMMENTED
    ============================================================
    */
    private PIMPage pimPage;

//    @When("User clicks on the PIM menu")
//    public void user_clicks_on_the_pim_menu() {
//        pimPage = new PIMPage(page);
//        test.info("User clicks on the PIM menu");
//        pimPage.clickonPIM();
//    }

    @When("User enters the employee first name")
    public void user_enters_the_employee_first_name() {
        pimPage = new PIMPage(page);
        test.info("User enters the employee first name");
        pimPage.enterCandidateFirstName("Pallav");
    }

    @When("User enters the employee middle name")
    public void user_enters_the_employee_middle_name() {
        test.info("User enters the employee middle name");
        pimPage.enterCandidateMiddleName("Dilip");
    }

    @When("User enters the employee last name")
    public void user_enters_the_employee_last_name() {
        test.info("User enters the employee last name");
        pimPage.enterCandidateLastName("Bhagat");
    }

    @When("User enters the employee ID")
    public void user_enters_the_employee_id() {
        test.info("User enters the employee ID");
        pimPage.enterEmployeeID("0003");
    }

    @When("User clicks on the Create Login Details slider")
    public void user_clicks_on_the_create_login_details_slider() {

        test.info("User clicks on the Create Login Details slider");
        pimPage.clickonsilderBth();
    }

    @When("User enters the employee username")
    public void user_enters_the_employee_username() {
        test.info("User enters the employee username");
        pimPage.enterUserName("Pallav1234");
    }

    @When("User enters the employee password")
    public void user_enters_the_employee_password() {
        test.info("User enters the employee password");
        pimPage.enterPassword("Pallav++12345");
    }

    @When("User enters the employee confirm password")
    public void user_enters_the_employee_confirm_password() {
        test.info("User enters the employee confirm password");
        pimPage.enterConfirmPassword("Pallav++12345");
    }

    @Then("User should see a success message of PIM page")
    public void user_should_see_the_employee_personal_details_page() {
        test.info("Verifing the success message");
        String actulResult = successMessage();
        // Using Assert Equal
        Assert.assertEquals(actulResult, "Success");

        // Using Assert True
        Assert.assertTrue(actulResult.contains("Success"));

        test.pass("Success message verified: ");
    }

    @When("User clicks on the Employee List")
    public void user_clicks_on_the_employee_list() {
        test.info("User clicks on the Employee List");
        pimPage.clickonEmployeeList();
    }

    @When("User enters the employee ID in the search field")
    public void user_enters_the_employee_id_in_the_search_field() {
        test.info("User enters the employee ID in the search field");
        pimPage.enterSearchemployeeId("0003");
    }

//    @When("User clicks on the Search button")
//    public void user_clicks_on_the_search_button() {
//        test.info("User clicks on the PIM Search button");
//        clickonSearchBtn();
//    }

    @Then("User should see the employee in the search results")
    public void user_should_see_the_employee_in_the_search_results() {
        test.info("Verifying the new candidate is visible in the search results");
        Assert.assertTrue(
                pimPage.isCandidateVisible("Pallav Dilip Bhagat"),
                "candidate is not visible in the search results"
        );
    }

    @Then("User should verify the employee name and employee ID")
    public void user_should_verify_the_employee_name_and_employee_id() {
        test.info("Verifying candidate name and ID");

        String expectedCandidateFirstandMiddleName = "Pallav Dilip";
        String expectedCandidateLastName = "Bhagat";
        String expectedEmpID = "0003";

        String actualCandidateFirstandMiddleName =
                pimPage.getActualCandidateFirstandMiddleName(expectedCandidateFirstandMiddleName);

        String actualCandidateLastName =
                pimPage.getActualCandidateLastName(expectedCandidateLastName);

        String actualEmpId =
                pimPage.getActualID(expectedEmpID);

        Assert.assertEquals(
                actualCandidateFirstandMiddleName,
                expectedCandidateFirstandMiddleName,
                "Candidate First and Last Name does not match"
        );

        Assert.assertEquals(
                actualCandidateLastName,
                expectedCandidateLastName,
                "Candidate Last name does not match"
        );

        Assert.assertEquals(
                actualEmpId,
                expectedEmpID,
                "Candidate Last name does not match"
        );

        test.pass("Candidate name and vacancy verified successfully");
    }

    /*
    ============================================================
    END OF OLD CODE
    ============================================================
    */


    // ============================================================
    // NEW CODE - PARALLEL CROSS BROWSER
    // ============================================================

//    private PIMPage pimPage;
//
//    @When("User clicks on the PIM menu")
//    public void user_clicks_on_the_pim_menu() {
//
//        pimPage = new PIMPage(page.get());
//
//        test.get().info(
//                "User clicks on the PIM menu"
//        );
//
//        pimPage.clickonPIM();
//    }
//
//    @When("User enters the employee first name")
//    public void user_enters_the_employee_first_name() {
//
//        test.get().info(
//                "User enters the employee first name"
//        );
//
//        pimPage.enterCandidateFirstName("Nikita");
//    }
//
//    @When("User enters the employee middle name")
//    public void user_enters_the_employee_middle_name() {
//
//        test.get().info(
//                "User enters the employee middle name"
//        );
//
//        pimPage.enterCandidateMiddleName("Pallav");
//    }
//
//    @When("User enters the employee last name")
//    public void user_enters_the_employee_last_name() {
//
//        test.get().info(
//                "User enters the employee last name"
//        );
//
//        pimPage.enterCandidateLastName("Bhagat");
//    }
//
//    @When("User enters the employee ID")
//    public void user_enters_the_employee_id() {
//
//        test.get().info(
//                "User enters the employee ID"
//        );
//
//        pimPage.enterEmployeeID("0001");
//    }
//
//    @When("User clicks on the Create Login Details slider")
//    public void user_clicks_on_the_create_login_details_slider() {
//
//        test.get().info(
//                "User clicks on the Create Login Details slider"
//        );
//
//        pimPage.clickonsilderBth();
//    }
//
//    @When("User enters the employee username")
//    public void user_enters_the_employee_username() {
//
//        test.get().info(
//                "User enters the employee username"
//        );
//
//        pimPage.enterUserName("Nikita1");
//    }
//
//    @When("User enters the employee password")
//    public void user_enters_the_employee_password() {
//
//        test.get().info(
//                "User enters the employee password"
//        );
//
//        pimPage.enterPassword("NIK++12345");
//    }
//
//    @When("User enters the employee confirm password")
//    public void user_enters_the_employee_confirm_password() {
//
//        test.get().info(
//                "User enters the employee confirm password"
//        );
//
//        pimPage.enterConfirmPassword("NIK++12345");
//    }
//
//    @Then("User should see the employee personal details page")
//    public void user_should_see_the_employee_personal_details_page() {
//
//    }
//
//    @When("User clicks on the Employee List")
//    public void user_clicks_on_the_employee_list() {
//
//    }
//
//    @When("User enters the employee ID in the search field")
//    public void user_enters_the_employee_id_in_the_search_field() {
//
//    }
//
//    @When("User clicks on the PIM Search button")
//    public void user_clicks_on_the_search_button() {
//
//    }
//
//    @Then("User should see the employee in the search results")
//    public void user_should_see_the_employee_in_the_search_results() {
//
//    }
//
//    @Then("User should verify the employee name and employee ID")
//    public void user_should_verify_the_employee_name_and_employee_id() {
//
//    }
}