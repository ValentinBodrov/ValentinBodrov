package hw6.ex1.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RightSideComponent {

    private WebDriver driver;

    @FindBy(xpath = "//div[@name='log-sidebar']")
    private WebElement rightComponent;

    @FindBy(className = "info-panel-section")
    private WebElement logRowsWebElement;

    public RightSideComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isRightComponentDisplayed() {
        return rightComponent.isDisplayed();
    }

    public boolean isThereAnInfoAboutLabelInLogRow(
            final String labelName, final String condition) {
        boolean contains = false;
        List<WebElement> logRowsItems = logRowsWebElement.
                findElements(By.tagName("li"));
        for (WebElement logRowsItem : logRowsItems) {
            if (logRowsItem.getText().contains(labelName)) {
                if (logRowsItem.getText().contains("condition")) {
                    if (logRowsItem.getText().contains(condition)) {
                        contains = true;
                        break;
                    }
                } else {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }
}
