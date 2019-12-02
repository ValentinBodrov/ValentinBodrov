package hw4.ex2.steps;

import com.codeborne.selenide.SelenideElement;
import hw4.ex2.MetalsAndColorsPage;
import hw4.utils.TestData;

public class ActionSteps extends AbstractSteps {

    public void fillFormOnThePage(MetalsAndColorsPage metalsAndColorsPage,
                                  TestData dataSet) {
        if (dataSet.getSummary() != null) {
            for (int summaryValue : dataSet.getSummary()) {
                for (SelenideElement summaryRadio : metalsAndColorsPage.summarySectionItems()) {
                    if (summaryRadio.getText().equals(Integer.toString(summaryValue))) {
                        summaryRadio.click();
                    }
                }
            }
        }

        if (dataSet.getElements() != null) {
            for (String elementValue : dataSet.getElements()) {
                for (SelenideElement elementCheckbox :
                        metalsAndColorsPage.elementsSectionItems()) {
                    if (elementCheckbox.getText().equals(elementValue)) {
                        elementCheckbox.click();
                    }
                }
            }
        }

        if (dataSet.getColors() != null) {
            metalsAndColorsPage.colorsSelect().click();
            for (SelenideElement colorSelectItem :
                    metalsAndColorsPage.colorsSelectDropDownItems()) {
                if (colorSelectItem.getText().equals(dataSet.getColors())) {
                    colorSelectItem.click();
                }
            }
        }

        if (dataSet.getMetals() != null) {
            metalsAndColorsPage.metalsSelectTextField().clear();
            metalsAndColorsPage.metalsSelectTextField().sendKeys(dataSet.getMetals());
        }

        if (dataSet.getVegetables() != null) {
            metalsAndColorsPage.vegetablesSelect().click();
            if (dataSet.getVegetables().size() > 0) {
                metalsAndColorsPage.resetVegetables();
                for (String vegetableValue : dataSet.getVegetables()) {
                    for (SelenideElement vegetablesSelectItem :
                            metalsAndColorsPage.vegetablesSelectDropDownItems()) {
                        if (vegetablesSelectItem.getText().equals(vegetableValue)) {
                            vegetablesSelectItem.click();
                        }
                    }
                }
            }
        }
    }

}
