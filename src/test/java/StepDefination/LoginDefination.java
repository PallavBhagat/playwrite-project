package StepDefination;

import PageObject.BasePage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginDefination extends BasePage {

    /*
    ============================================================
    OLD CODE - COMMENTED
    ============================================================

     */
    private LoginPage loginPage;

    @Given("User opens the OrangeHRM website")
    public void user_opens_the_orange_hrm_website() {
        // URL is open from hooks
        loginPage = new LoginPage(page);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        test.info("User enters valid username and password");
        loginPage.UserName("Admin");
        loginPage.Password("admin123");
    }

    @When("User clicks on the Login button")
    public void user_clicks_on_the_login_button() {
        test.info("User clicks on the Login button");
        loginPage.Loginbtn();
    }

    @Then("User should be redirected to the Dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        page.waitForURL("**/dashboard/**");
     test.info("User should be redirected to the Dashboard");
        Assert.assertTrue(
                page.url().contains("/dashboard"),
                "Dashboard URL is not displayed"
        );
     }

     @Then("User should see the Dashboard page")
     public void user_should_see_the_dashboard_page() {

     test.info("User should see the Dashboard page");

     Assert.assertEquals(
     page.title(),
     "OrangeHRM",
     "Dashboard Title is not displayed"
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

//    private LoginPage loginPage;
//
//    @Given("User opens the OrangeHRM website")
//    public void user_opens_the_orange_hrm_website() {
//
//        // URL is opened from Hooks
//        loginPage = new LoginPage(page.get());
//    }
//
//    @When("User enters valid username and password")
//    public void user_enters_valid_username_and_password() {
//
//        test.get().info(
//                "User enters valid username and password"
//        );
//
//        loginPage.UserName("Admin");
//        loginPage.Password("admin123");
//    }
//
//    @When("User clicks on the Login button")
//    public void user_clicks_on_the_login_button() {
//
//        test.get().info(
//                "User clicks on the Login button"
//        );
//
//        loginPage.Loginbtn();
//    }
//
//    @Then("User should be redirected to the Dashboard")
//    public void user_should_be_redirected_to_the_dashboard() {
//
//        page.get().waitForURL("**/dashboard/**");
//
//        test.get().info(
//                "User should be redirected to the Dashboard"
//        );
//
//        Assert.assertTrue(
//                page.get().url().contains("/dashboard"),
//                "Dashboard URL is not displayed"
//        );
//    }
//
//    @Then("User should see the Dashboard page")
//    public void user_should_see_the_dashboard_page() {
//
//        test.get().info(
//                "User should see the Dashboard page"
//        );
//
//        Assert.assertEquals(
//                page.get().title(),
//                "OrangeHRM",
//                "Dashboard Title is not displayed"
//        );
//    }
}