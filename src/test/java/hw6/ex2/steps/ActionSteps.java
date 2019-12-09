package hw6.ex2.steps;

import cucumber.api.java.en.When;

public class ActionSteps extends AbstractSteps {

    @When("^I click on '([^\"]+)' button in Header$")
    public void iClickOnButtonInHeader(
            String itemName) {
        homePage.clickHeaderMenuItem(itemName.toUpperCase());
    }

    @When("^I click on '([^\"]+)' button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(
            String itemName) {
        homePage.clickItemInService(itemName.toUpperCase());
    }

}
