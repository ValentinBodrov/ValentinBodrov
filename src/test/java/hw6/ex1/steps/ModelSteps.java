package hw6.ex1.steps;

import cucumber.api.java.en.Given;
import hw6.ex1.DifferentElementsPage;
import hw6.ex1.HomePage;
import hw6.utils.WebDriverSingleton;

public class ModelSteps extends AbstractSteps {

    @Given("^I open EPAM JDI Site$")
    public void iOpenEpamJdiSite() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open();
    }

}
