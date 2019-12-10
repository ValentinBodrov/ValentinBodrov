package hw6;

import hw6.components.RightSideComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.AbstractBasePage;

import java.util.*;

public class UserTablePage extends AbstractBasePage {

    private RightSideComponent rightSideComponent;

    @FindBy(id = "user-table")
    private WebElement userTable;

    @FindBy(xpath = "//tbody//tr//td[1]")
    private List<WebElement> numbersList;

    @FindBy(xpath = "//tbody//tr//td//select")
    private List<WebElement> dropdownList;

    @FindBy(xpath = "//tbody//tr//td[3]")
    private List<WebElement> usersList;

    @FindBy(xpath = "//tbody//tr//td//img")
    private List<WebElement> descriptionImagesList;

    @FindBy(xpath = "//tbody//tr//td//div//span")
    private List<WebElement> descriptionTextsList;

    @FindBy(xpath = "//tbody//tr//td//div//input")
    private List<WebElement> checkboxesList;

    public UserTablePage(WebDriver driver) {
        super(driver);
        this.rightSideComponent = new RightSideComponent(driver);
    }

    public List<WebElement> getNumbersList() {
        return numbersList;
    }

    public List<WebElement> getUsersList() {
        return usersList;
    }

    public List<WebElement> getDropdownList() {
        return dropdownList;
    }

    public List<WebElement> getDescriptionImagesList() {
        return descriptionImagesList;
    }

    public List<WebElement> getDescriptionTextsList() {
        return descriptionTextsList;
    }

    public List<WebElement> getCheckboxesList() {
        return checkboxesList;
    }

    public ArrayList<Map<String, String>> getActualUserData() {
        ArrayList<Map<String, String>> userDataMapArrayList =
                new ArrayList<>();
        for (int i = 0; i < getUsersList().size(); i++) {
            HashMap<String, String> userDataHashMap = new HashMap<>();
            userDataHashMap.put("Number", getNumbersList().get(i).getText());
            userDataHashMap.put("User", getUsersList().get(i).getText());
            String descriptionText = getDescriptionTextsList().get(i).
                    getText().replace("\n", " ");
            userDataHashMap.put("Description", descriptionText);
            userDataMapArrayList.add(userDataHashMap);
        }
        return userDataMapArrayList;
    }

    public void clickVipCheckboxForName(String expectedName) {
        for (int i = 0; i < getUsersList().size(); i++) {
            if (expectedName.equals(getUsersList().get(i).getText())) {
                getCheckboxesList().get(i).click();
            }
        }
    }

    public void clickDropdownForName(String expectedName) {
        for (int i = 0; i < getDropdownList().size(); i++) {
            if (expectedName.equals(getUsersList().get(i).getText())) {
                getDropdownList().get(i).click();
            }
        }
    }

    public boolean isThereAnInfoAboutThisLabelInLogRow(
            final String labelName, final String condition) {
        return rightSideComponent.
                isThereAnInfoAboutLabelInLogRow(labelName, condition);
    }

    public ArrayList<String> getActualDropdownValues() {
        List<WebElement> dropDownItems = new Select(
                getDropdownList().get(0)).getOptions();
        ArrayList<String> actualDropdownValues = new ArrayList<>();
        for (WebElement dropdownItem : dropDownItems) {
            actualDropdownValues.add(dropdownItem.getText());
        }
        return actualDropdownValues;
    }
}
