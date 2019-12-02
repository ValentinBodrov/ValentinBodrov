package hw4.ex2;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MetalsAndColorsPage {

    public ElementsCollection summarySectionItems() {
        return $("#summary-block").$$(".radio");
    }

    public SelenideElement elementsSection() {
        return $("#elements-block");
    }

    public SelenideElement colorsSelect() {
        return $("#colors").$(By.tagName("div"));
    }

    public ElementsCollection colorsSelectDropDownItems() {
        return colorsSelect().$$(By.tagName("li"));
    }

    public ElementsCollection elementsSectionItems() {
        return elementsSection().$$(".checkbox");
    }

    public SelenideElement metalsSelectTextField() {
        return $("#metals").$(By.tagName("input"));
    }

    public SelenideElement vegetablesSelect() {
        return $("#salad-dropdown");
    }

    public ElementsCollection vegetablesSelectDropDownItems() {
        return vegetablesSelect().$$(By.tagName("li"));
    }

    public ElementsCollection infoPanelResults() {
        return $(By.xpath("//ul[@class='panel-body-list results']")).$$(By.tagName("li"));
    }

    public void resetVegetables() {
        for (SelenideElement vegetablesSelectItem :
                this.vegetablesSelectDropDownItems()) {
            if (vegetablesSelectItem.getText().equals("Vegetables")) {
                vegetablesSelectItem.click();
                break;
            }
        }
    }

    public void submit() {
        $("#submit-button").click();
    }

    public void logout() {
        $("#user-name").click();
        $(By.xpath("//div[@class='logout']")).click();
    }

}
