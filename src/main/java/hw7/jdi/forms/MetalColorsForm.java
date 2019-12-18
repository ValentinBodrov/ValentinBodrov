package hw7.jdi.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.jdi.entities.TestData;

public class MetalColorsForm extends Form<TestData> {

    @Css("#summary-block label")
    private WebList summaryRadioButtons;

    @Css("#elements-block label")
    private WebList elementsCheckBoxes;

    @Css("#colors button")
    private Button colorExpander;

    @Css("div[ui=dropdown]")
    private DropdownExpand colors;

    @Css("#metals button")
    private Button metalsExpander;

    @Css("#metals a ")
    private WebList metalsItems;

    @Css("#vegetables button")
    private Button vegetablesExpander;

    @Css("#vegetables label")
    private WebList vegetablesCheckBoxes;

    @Css("#submit-button")
    private Button submit;

    public void fillForm(TestData testData) {
        for (int currentSummary : testData.getSummary()) {
            summaryRadioButtons.select(Integer.toString(currentSummary));
        }
        elementsCheckBoxes.select(testData.getElements());
        colorExpander.click();
        colors.select(testData.getColor());
        metalsExpander.click();
        metalsItems.select(testData.getMetals());
        vegetablesExpander.click();
        vegetablesCheckBoxes.select("Vegetables");
        vegetablesCheckBoxes.select(testData.getVegetables());
        submit.click();
    }
}
