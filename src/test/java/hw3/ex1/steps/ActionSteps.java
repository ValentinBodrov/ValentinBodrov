package hw3.ex1.steps;

import org.openqa.selenium.WebDriver;

public class ActionSteps extends AbstractSteps {

    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    public void openEpamJdiSite() {
        homePage.open();
    }

    public void login(final String username, final String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }

    public void switchToIframe() {
        homePage.switchToIframe();
    }

    public void switchBackToOriginalPage() {
        homePage.switchToOriginalWindow();
    }
}
