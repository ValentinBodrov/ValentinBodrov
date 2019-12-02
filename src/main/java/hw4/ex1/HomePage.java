package hw4.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private static final String URL = "https://epam.github.io/JDI/index.html";

    public HomePage() {
        page(this);
    }

    public void login(final String username,
                      final String password) {
        $("#user-icon").click();
        $("#name").sendKeys(username);
        $("#password").sendKeys(password);
        $("#login-button").click();
    }

    public void clickItemInHeader(String linkText) {
        for (SelenideElement menuHeaderItem :
                $$(By.xpath("//nav[@role='navigation']//ul//li"))) {
            if (menuHeaderItem.getText().equals(linkText)) {
                menuHeaderItem.click();
                break;
            }
        }
    }

    public void clickItemInServiceHeader(String linkText) {
        $(By.linkText(linkText)).click();
    }

    public SelenideElement usernameTextLabel() {
        return $("#user-name");
    }

    public SelenideElement headerDropDown() {
        return $(By.xpath("//li[@class='dropdown']"));
    }

    public ElementsCollection headerDropDownMenuItems() {
        return $(By.xpath("//ul[@class='dropdown-menu']")).
                $$(By.tagName("li"));
    }

    public SelenideElement leftSideDropDown() {
        return $(".menu-title");
    }

    public ElementsCollection leftSideDropDownMenuItems() {
        return $(By.xpath("//ul[@class='sub']")).
                $$(By.tagName("li"));
    }

}
