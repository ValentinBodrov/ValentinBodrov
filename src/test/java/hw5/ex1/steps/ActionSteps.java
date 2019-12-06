package hw5.ex1.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps extends AbstractSteps {

    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("I open EPAM JDI site")
    public void openEpamJdiSite() {
        homePage.open();
    }

    @Step("I login as '{0}' with password '{1}'")
    public void login(final String username, final String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @Step("I switch to iframe")
    public void switchToIframe() {
        homePage.switchToIframe();
    }

    @Step("I switch to original window back")
    public void switchBackToOriginalPage() {
        homePage.switchToOriginalWindow();
    }
}
