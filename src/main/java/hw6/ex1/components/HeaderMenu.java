package hw6.ex1.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu {

    private WebDriver driver;

    @FindBy(className = "navbar-nav")
    private WebElement header;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void headerMenuItemClick(final String menuItemName) {
        List<WebElement> headerAsList = header.findElements(By.
                xpath("//nav[@role='navigation']//ul//li"));
        for (WebElement menuHeaderItem : headerAsList) {
            if (menuItemName.equals(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }

    public void clickItemInService(String itemName) {
        this.headerMenuItemClick("SERVICE");
        header.findElement(By.linkText(itemName)).click();
    }

    public ArrayList<String> getServiceHeaderItems() {
        WebElement headerDropDownList = header.findElement(By.
                xpath("//ul[@class='dropdown-menu']"));
        List<WebElement> headerItems = headerDropDownList.
                findElements(By.tagName("li"));
        ArrayList<String> actualServiceHeaderTexts = new ArrayList<>();
        for (WebElement headerItem : headerItems) {
            actualServiceHeaderTexts.add(headerItem.getText());
        }
        return actualServiceHeaderTexts;
    }

}
