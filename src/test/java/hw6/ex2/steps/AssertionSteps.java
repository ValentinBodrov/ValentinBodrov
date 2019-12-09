package hw6.ex2.steps;

import cucumber.api.java.en.Then;

import static org.testng.Assert.assertEquals;

public class AssertionSteps extends AbstractSteps {

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(String expectedPageTitle) {
        assertEquals(userTablePage.getPageTitle(), expectedPageTitle);
    }

}
