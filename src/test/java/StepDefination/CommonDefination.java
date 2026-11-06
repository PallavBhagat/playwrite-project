package StepDefination;

import PageObject.BasePage;
import PageObject.PIMPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CommonDefination extends BasePage {

    @When("User clicks on the Save button")
    public void user_clicks_on_the_save_button() {
        test.info("User clicks on the Save button");
        clickOnSaveBth();
    }

    @When("User clicks on the Add button")
    public void user_clicks_on_the_add_button() {
        test.info("User clicks on the Add button");
        clickOnAddBth();
    }

    @When("User clicks on the PIM menu")
    public void user_clicks_on_the_pim_menu() {
        test.info("User clicks on the PIM menu");
        clickonPIM();
    }

    @When("User clicks on the Search button")
    public void user_clicks_on_the_search_button() {
        test.info("User clicks on the PIM Search button");
        clickonSearchBtn();
    }

}