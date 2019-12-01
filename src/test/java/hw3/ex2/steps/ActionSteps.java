package hw3.ex2.steps;

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

    public void clickHeaderMenuItem(final String itemName) {
        homePage.clickHeaderMenuItem(itemName);
    }

    public void clickLeftSideMenuItem(final String itemName) {
        homePage.clickLeftSideMenuItem(itemName);
    }

    public void clickItemInServiceHeader(final String itemName) {
        homePage.clickItemInService(itemName);
    }

    public void clickTheCheckboxWithLabel(final String itemName) {
        differentElementsPage.clickTheCheckboxWithLabel(itemName);
    }

    public void clickTheRadioWithLabel(final String itemName) {
        differentElementsPage.clickTheRadioWithLabel(itemName);
    }

    public void selectInTheDropDownThisColor(final String colorName) {
        differentElementsPage.selectColorInDropDown(colorName);
    }

}
