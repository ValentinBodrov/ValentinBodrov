package hw5.steps;

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

    public void switchToIframe() {
        homePage.switchToIframe();
    }

    public void switchBackToOriginalPage() {
        homePage.switchToOriginalWindow();
    }
}
