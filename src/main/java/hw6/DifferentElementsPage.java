package hw6;

import hw6.components.LeftSideMenu;
import hw6.components.RightSideComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.AbstractBasePage;

import java.util.List;

public class DifferentElementsPage extends AbstractBasePage {

    private LeftSideMenu leftSideMenu;
    private RightSideComponent rightSideComponent;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkButtonsLabels;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonsLabels;

    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> checkButtons;

    @FindBy(css = "input[type=radio]")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement colorDropDown;

    @FindBy(xpath = "//button[@name='Default Button']")
    private WebElement defaultButton;

    @FindBy(xpath = "//input[@class='uui-button']")
    private WebElement button;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.leftSideMenu = new LeftSideMenu(driver);
        this.rightSideComponent = new RightSideComponent(driver);
    }

    public void clickTheCheckboxWithLabel(final String itemName) {
        for (WebElement item : checkButtonsLabels) {
            if (itemName.equals(item.getText())) {
                item.click();
                break;
            }
        }
    }

    public void clickTheRadioWithLabel(final String itemName) {
        for (WebElement item : radioButtonsLabels) {
            if (itemName.equals(item.getText())) {
                item.click();
                break;
            }
        }
    }

    public void selectColorInDropDown(final String colorName) {
        Select selectColorDropDown = new Select(colorDropDown);
        selectColorDropDown.selectByVisibleText(colorName);
    }

    public List<WebElement> getCheckButtons() {
        return checkButtons;
    }

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }

    public WebElement getColorDropDown() {
        return colorDropDown;
    }

    public WebElement getDefaultButton() {
        return defaultButton;
    }

    public WebElement getButton() {
        return button;
    }

    public boolean isRightSideComponentDisplayed() {
        return rightSideComponent.isRightComponentDisplayed();
    }

    public boolean isLeftSideMenuDisplayed() {
        return leftSideMenu.isLeftSideMenuDisplayed();
    }

    public boolean isCheckBoxWithSuchLabelSelected(final String itemName) {
        boolean isChecked = false;
        for (int i = 0; i < checkButtonsLabels.size(); i++) {
            WebElement item = checkButtonsLabels.get(i);
            if (itemName.equals(item.getText())) {
                isChecked = checkButtons.get(i).isSelected();
                break;
            }
        }
        return isChecked;
    }

    public boolean isRadioWithSuchLabelSelected(final String itemName) {
        boolean isChecked = false;
        for (int i = 0; i < radioButtonsLabels.size(); i++) {
            WebElement item = radioButtonsLabels.get(i);
            if (itemName.equals(item.getText())) {
                isChecked = radioButtons.get(i).isSelected();
                break;
            }
        }
        return isChecked;
    }

    public boolean isThereAnInfoAboutThisLabelInLogRow(
            final String labelName, final String condition) {
        return rightSideComponent.
                isThereAnInfoAboutLabelInLogRow(labelName, condition);
    }

    public String actuallySelectedInColorDropDown() {
        Select selectColorDropDown = new Select(colorDropDown);
        WebElement actuallySelected = selectColorDropDown.
                getFirstSelectedOption();
        return actuallySelected.getText();
    }

}
