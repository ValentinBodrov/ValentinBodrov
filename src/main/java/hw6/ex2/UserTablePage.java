package hw6.ex2;

import hw6.ex2.components.RightSideComponent;
import org.openqa.selenium.WebDriver;
import utils.AbstractBasePage;

public class UserTablePage extends AbstractBasePage {

    private RightSideComponent rightSideComponent;

    public UserTablePage(WebDriver driver) {
        super(driver);
        this.rightSideComponent = new RightSideComponent(driver);
    }
}
