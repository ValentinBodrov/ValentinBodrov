package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractBasePage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/index.html";

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

    @FindBy(className = "navbar-nav")
    private WebElement header;

    @FindBy(className = "benefits")
    private WebElement benefits;

    @FindBy(name = "main-title")
    private WebElement mainHeader;

    @FindBy(name = "jdi-text")
    private WebElement mainText;

    @FindBy(xpath = "//h3[@class='text-center']")
    private WebElement subHeader;

    @FindBy(id = "iframe")
    private WebElement iframe;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement linkElement;

    @FindBy(name = "navigation-sidebar")
    private WebElement leftSection;

    public HomePage(WebDriver driver) {
        super(driver);
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

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public ArrayList<String> getHeaderItems() {
        List<WebElement> headerItems = header.findElements(By.tagName("li"));
        ArrayList<String> actualHeaderTexts = new ArrayList<>();
        for (WebElement headerItem : headerItems) {
            if ("".equals(headerItem.getText())) {
                continue;
            }
            actualHeaderTexts.add(headerItem.getText());
        }
        return actualHeaderTexts;
    }

    public List<WebElement> getBenefitsSpans() {
        return benefits.findElements(By.className("icons-benefit"));
    }

    public List<String> getBenefitsTexts() {
        List<WebElement> actualBenefitsTextsElements = benefits.
                findElements(By.className("benefit-txt"));
        ArrayList<String> actualBenefitsTexts = new ArrayList<>();
        for (WebElement element : actualBenefitsTextsElements) {
            actualBenefitsTexts.add(element.getText());
        }
        return actualBenefitsTexts;
    }

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public String getMainTextText() {
        return mainText.getText();
    }

    public WebElement getIframe() {
        return this.iframe;
    }

    public WebElement getEpamLogo() {
        return this.epamLogo;
    }

    public String getSubHeaderText() {
        return subHeader.getText();
    }

    public String getLinkElementUrl() {
        return linkElement.getAttribute("href");
    }

    public WebElement getLeftSection() {
        return this.leftSection;
    }

}
