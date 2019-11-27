package hw3.ex1.steps;

import hw3.ex1.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

    protected HomePage homePage;

    public AbstractSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }
}
