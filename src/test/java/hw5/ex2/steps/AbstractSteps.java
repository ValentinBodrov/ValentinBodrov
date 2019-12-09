package hw5.ex2.steps;

import hw3.ex2.DifferentElementsPage;
import hw3.ex2.HomePage;
import org.openqa.selenium.WebDriver;

public class AbstractSteps {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.differentElementsPage = new DifferentElementsPage(driver);
    }
}
