package hw6.ex1.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LeftSideMenu {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='sidebar-menu']")
    private WebElement leftSide;

    public LeftSideMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void leftSideMenuItemClick(final String menuItemName) {
        List<WebElement> leftSideMenuItems = leftSide.
                findElements(By.tagName("li"));
        for (WebElement leftSideItem : leftSideMenuItems) {
            if (menuItemName.equals(leftSideItem.getText())) {
                leftSideItem.click();
                break;
            }
        }
    }

    public ArrayList<String> getServiceLeftSideItems() {
        WebElement leftSideDropDownList = leftSide.findElement(By.
                className("menu-title"));
        List<WebElement> leftSideItem = leftSideDropDownList.
                findElements(By.tagName("li"));
        ArrayList<String> actualServiceHeaderTexts = new ArrayList<>();
        for (WebElement headerItem : leftSideItem) {
            actualServiceHeaderTexts.add(headerItem.getText());
        }
        return actualServiceHeaderTexts;
    }

    public boolean isLeftSideMenuDisplayed() {
        return leftSide.isDisplayed();
    }

}
