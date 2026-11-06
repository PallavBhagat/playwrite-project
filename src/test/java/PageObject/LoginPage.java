package PageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private Page page;

    // Locators
    private Locator txtUserName;
    private Locator txtPassword;
    private Locator btnLogin;

    // Constructor
    public LoginPage(Page page) {

        // 1. First assign page
        this.page = page;

        // 2. Then create locators
        txtUserName = page.locator("input[name='username']");
        txtPassword = page.locator("input[name='password']");
        btnLogin = page.locator("button[type='submit']");

    }

    // Actions
    public void UserName(String usName) {
        txtUserName.fill(usName);
    }

    public void Password(String usPass) {
        txtPassword.fill(usPass);
    }

    public void Loginbtn() {
        btnLogin.click();
    }
}