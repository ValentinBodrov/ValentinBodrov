package hw7.jdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.jdi.entities.MetalsAndColorsFormFiller;
import hw7.jdi.forms.MetalColorsForm;

public class MetalsColorsPage extends WebPage {

    public MetalColorsForm metalColorsForm;

    @Css(".info-panel-body-result li")
    private WebList resultRows;

    @Css("#user-icon")
    private Button userIcon;

    @Css(".logout button")
    private Button logout;

    public String getActualResultSet() {
        String actualResultSet = "";
        for (UIElement resultRow : resultRows) {
            actualResultSet += resultRow.getText();
            actualResultSet += "\n";
        }
        return actualResultSet;
    }

    public void fillForm(MetalsAndColorsFormFiller metalsAndColorsFormFiller) {
        metalColorsForm.fillForm(metalsAndColorsFormFiller);
    }

    public void logout() {
        userIcon.click();
        logout.click();
    }
}
