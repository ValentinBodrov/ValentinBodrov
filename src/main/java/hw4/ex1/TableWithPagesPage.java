package hw4.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TableWithPagesPage {

    public SelenideElement tableWithPagesLength() {
        return $(By.name("table-with-pages_length"));
    }

    public SelenideElement rightSection() {
        return $(By.xpath("//div[@name='navigation-sidebar']"));
    }

    public SelenideElement leftSection() {
        return $(By.xpath("//div[@name='log-sidebar']"));
    }

    public ElementsCollection infoPanelItems() {
        return $(".info-panel-section").$$(By.tagName("li"));
    }

    public SelenideElement tableWithPages() {
        return $("#table-with-pages");
    }

    public SelenideElement tableWithPagesBody() {
        return tableWithPages().$(By.tagName("tbody"));
    }

    public ElementsCollection tableWithPagesRows() {
        return tableWithPagesBody().
                $$(By.tagName("tr"));
    }

    public void typeSomeTextInSearchTextField(String charSequence) {
        $(("input[type='search']")).sendKeys(charSequence);
    }

    public void logout() {
        $("#user-name").click();
        $(By.xpath("//div[@class='logout']")).click();
    }

}
