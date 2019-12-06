package hw5.ex2;

import hw5.ex2.components.HeaderMenu;
import hw5.ex2.components.LeftSideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractBasePage;

import java.util.ArrayList;

public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/index.html";
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    public HomePage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.leftSideMenu = new LeftSideMenu(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void setTextUsernameTextField(final String username) {
        usernameTextField.sendKeys(username);
    }

    public void setTextPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickHeaderMenuItem(String itemName) {
        headerMenu.headerMenuItemClick(itemName);
    }

    public void clickLeftSideMenuItem(String itemName) {
        leftSideMenu.leftSideMenuItemClick(itemName);
    }

    public void clickItemInService(String itemName) {
        headerMenu.clickItemInService(itemName);
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public ArrayList<String> getServiceHeaderItems() {
        return getHeaderMenu().getServiceHeaderItems();
    }

    public ArrayList<String> getServiceLeftSideItems() {
        return getLeftSideMenu().getServiceLeftSideItems();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

}
