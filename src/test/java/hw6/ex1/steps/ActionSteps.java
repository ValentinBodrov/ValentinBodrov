package hw6.ex1.steps;

import cucumber.api.java.en.When;

public class ActionSteps extends AbstractSteps {

    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on" +
            " the Home Page$")
    public void iLoginAsUserWithPasswordOnTheHomePage(
            String username, String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @When("^I click on subcategory '([^\"]+)' in the header on the Home Page$")
    public void iClickOnSubcategoryInTheHeaderOnTheHomePage(
            String itemName) {
        homePage.clickHeaderMenuItem(itemName);
    }

    @When("^I click on subcategory '([^\"]+)' in the left side menu on " +
            "the Home Page$")
    public void iClickOnSubcategoryInTheLeftSideMenuOnTheHomePage(
            String itemName) {
        homePage.clickLeftSideMenuItem(itemName);
    }

    @When("^I click on '([^\"]+)' in the dropdown menu on the Home Page$")
    public void iClickOnInTheDropdownMenuOnTheHomePage(
            String itemName) {
        homePage.clickItemInService(itemName);
    }

    @When("^I click on checkbox with label '([^\"]+)' on Different Elements Page$")
    public void iClickOnCheckboxWithLabelOnDifferentElementsPage(
            String itemName) {
        differentElementsPage.clickTheCheckboxWithLabel(itemName);
    }

    @When("^I click on radiobutton with label '([^\"]+)' on Different Elements Page$")
    public void iClickOnRadiobuttonWithLabelOnDifferentElementsPage(
            String itemName) {
        differentElementsPage.clickTheRadioWithLabel(itemName);
    }

    @When("^I select in a dropdown an element '([^\"]+)' on Different Elements Page$")
    public void iSelectInADrowdownAnElementOnDifferentElementsPage(
            String itemName) {
        differentElementsPage.selectColorInDropDown(itemName);
    }

}
