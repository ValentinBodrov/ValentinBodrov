package hw5.ex2.steps;

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

    @Step("I click the item on header menu with name '{0}'")
    public void clickHeaderMenuItem(final String itemName) {
        homePage.clickHeaderMenuItem(itemName);
    }

    @Step("I click the item on left side menu with name '{0}'")
    public void clickLeftSideMenuItem(final String itemName) {
        homePage.clickLeftSideMenuItem(itemName);
    }

    @Step("I click the item on header in the service submenu with name '{0}'")
    public void clickItemInServiceHeader(final String itemName) {
        homePage.clickItemInService(itemName);
    }

    @Step("I click the checkbox with name '{0}'")
    public void clickTheCheckboxWithLabel(final String itemName) {
        differentElementsPage.clickTheCheckboxWithLabel(itemName);
    }

    @Step("I click the radiobutton with name '{0}'")
    public void clickTheRadioWithLabel(final String itemName) {
        differentElementsPage.clickTheRadioWithLabel(itemName);
    }

    @Step("I select the color in the dropdown with name '{0}'")
    public void selectInTheDropDownThisColor(final String colorName) {
        differentElementsPage.selectColorInDropDown(colorName);
    }

}
