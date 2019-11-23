package hw2.ex2;

import hw2.utils.AbstractSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class SecondScenarioTest extends AbstractSeleniumTest {

    private SoftAssert sa;

    @Test
    public void secondScenarioTest() {
        // 0. We should declare this soft assert
        this.sa = new SoftAssert();

        // 1. Open test site by URL
        // There's a simple opening of a site
        driver.get("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        // There's a getting of a title and
        // comparing it with expected title -- "Home page"
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if actual title isn't
        // equal to expected
        String actualTitle = driver.getTitle();
        sa.assertEquals(actualTitle, "Home Page");

        // 3. Perform login
        // There we have a simple login steps:
        // - clicking on icon
        // - entering username and password
        // - clicking on a login-button
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Assert User name in the left top side
        // of screen that user is logined
        // There we have a getting of username and
        // comparing it with expected -- "PITER CHAILOVSKII"
        // (We should compare it as is - even if it's
        // written in upper case)
        WebElement actualUserName = driver.findElement(By.id("user-name"));
        assertEquals(actualUserName.getText(), "PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in
        // the header and check that drop down contains options
        // There is a clicking on "Service" header and getting actual
        // header texts from service-dropdown menu. Then we create
        // a list of expected text and compare them
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        WebElement headerDropDownList = driver.findElement(By.
                xpath("//ul[@class='dropdown-menu']"));
        List<WebElement> headerItems = headerDropDownList.
                findElements(By.tagName("li"));
        ArrayList<String> actualServiceHeaderTexts = new ArrayList<>();
        for (WebElement headerItem : headerItems) {
            actualServiceHeaderTexts.add(headerItem.getText());
        }
        List<String> expectedServiceHeaderTexts = Arrays.
                asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                        "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES",
                        "DIFFERENT ELEMENTS", "PERFORMANCE");
        assertEquals(actualServiceHeaderTexts, expectedServiceHeaderTexts);

        // 6. Click on Service subcategory in
        // the left section and check that drop down contains options
        // There is a clicking on "Service" in the left section
        // and getting actual texts from service-dropdown menu. Then
        // we create a list of expected text and compare them
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if there elements aren't exist
        // (we'll not use them in the further steps)
        driver.findElement(By.className("menu-title")).click();
        WebElement leftSectionDropDownList = driver.findElement(By.
                xpath("//ul[@class='sub']"));
        List<WebElement> leftSectionItems = leftSectionDropDownList.
                findElements(By.tagName("li"));
        ArrayList<String> actualServiceLeftSectionTexts = new ArrayList<>();
        for (WebElement headerItem : leftSectionItems) {
            actualServiceLeftSectionTexts.add(headerItem.getText());
        }
        List<String> expectedServiceLeftSectionTexts = Arrays.
                asList("Support", "Dates", "Complex Table", "Simple Table",
                        "Search", "User Table", "Table with pages",
                        "Different elements", "Performance");
        sa.assertEquals(actualServiceLeftSectionTexts,
                expectedServiceLeftSectionTexts);

        // 7. Open through the header menu Service ->
        // Different Elements Page
        // There is a simple opening of new
        // page -- https://epam.github.io/JDI/different-elements.html
        // and checking if the page is really opened
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        driver.findElement(By.linkText("Different elements")).click();
        assertEquals(driver.getCurrentUrl(),
                "https://epam.github.io/JDI/different-elements.html");

        // 8. Check interface on Different elements page,
        // it contains all needed elements
        // There we get all needable elements and check if there's
        // really 4 checkboxes, 4 radios, 1 dropdown menu and 2
        // different buttons
        List<WebElement> checkButtons = driver.findElements(By.
                className("label-checkbox"));
        assertEquals(checkButtons.size(), 4);
        List<WebElement> radioButtons = driver.findElements(By.
                className("label-radio"));
        assertEquals(radioButtons.size(), 4);
        WebElement colorDropDown = driver.findElement(By.
                className("colors"));
        assertTrue(colorDropDown.isDisplayed());
        WebElement defaultButton = driver.findElement(By.
                xpath("//button[@name='Default Button']"));
        assertTrue(defaultButton.isDisplayed());
        defaultButton = driver.findElement(By.
                xpath("//input[@class='uui-button']"));
        assertTrue(defaultButton.isDisplayed());

        // 9. Assert that there is Right Section
        // There we check if the right section is displayed
        assertTrue(driver.findElement(By.
                xpath("//div[@name='navigation-sidebar']")).isDisplayed());

        // 10. Assert that there is Left Section
        // There we check if the left section is displayed
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if left section doesn't exist
        // (we'll not use them in the further steps)
        sa.assertTrue(driver.findElement(By.
                xpath("//div[@name='log-sidebar']")).isDisplayed());

        // 11. Select checkboxes
        // There we should click on checkboxes with labels
        // "Water" and "Wind" and check if they are checked
        List<WebElement> checkboxLabels = driver.findElements(By.
                className("label-checkbox"));
        List<WebElement> checkboxes = driver.findElements(By.
                cssSelector("input[type=checkbox]"));
        checkboxLabels.get(0).click();
        WebElement waterCheckBox = checkboxes.get(0);
        assertTrue(waterCheckBox.isSelected());
        checkboxLabels.get(2).click();
        WebElement windCheckBox = checkboxes.get(2);
        assertTrue(windCheckBox.isSelected());

        // 12. Assert that for each checkbox there is
        // an individual log row and value is corresponded
        // to the status of checkbox.
        // There we get the panel with informations about
        // checkings and selections and get the number of
        // rows here. We should have 2 rows. After that we
        // check if the panel with information really contains
        // such infos as "Water" and "Wind" and the labels "true" here
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if info about these checkboxes doesn't
        // display (we'll not use it in the further steps)
        WebElement actualLogRowsWebElement = driver.findElement(By.
                className("info-panel-section"));
        List<WebElement> actualLogRowsItems = actualLogRowsWebElement.
                findElements(By.tagName("li"));
        sa.assertEquals(actualLogRowsItems.size(), 2);
        sa.assertTrue(actualLogRowsWebElement.getText().
                contains("Wind") && actualLogRowsWebElement.getText().
                contains("true"));
        sa.assertTrue(actualLogRowsWebElement.getText().
                contains("Water") && actualLogRowsWebElement.getText().
                contains("true"));

        // 13. Select radio
        // There we should click on radio with label
        // "Selen" and check if it is checked
        List<WebElement> radioLabels = driver.findElements(By.
                className("label-radio"));
        List<WebElement> radios = driver.findElements(By.
                cssSelector("input[type=radio]"));
        radioLabels.get(3).click();
        WebElement selenRadioButton = radios.get(3);
        assertTrue(selenRadioButton.isSelected());

        // 14. Assert that for radiobutton there is
        // a log row and value is corresponded to
        // the status of radiobutton.
        // There we we check if the panel with information
        // really contains such info as "Selen"
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if info about theis radio doesn't
        // display (we'll not use it in the further steps)
        sa.assertTrue(actualLogRowsWebElement.getText().contains("Selen"));

        // 15. Select in dropdown
        // There we should get the 'select' element with help of
        // Select-class. Then we select "Yellow" here and check
        // if the checked option is really "Yellow"
        Select selectColorDropDown = new Select(driver.findElement(By.
                xpath("//select[@class='uui-form-element']")));
        selectColorDropDown.selectByVisibleText("Yellow");
        WebElement actuallySelected = selectColorDropDown.
                getFirstSelectedOption();
        assertEquals(actuallySelected.getText(), "Yellow");

        // 16. Assert that for dropdown there is
        // a log row and value is corresponded
        // to the selected value.
        // There we we check if the panel with information
        // really contains such info as "Yellow"
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if info about this selection doesn't
        // display (we'll not use it in the further steps)
        sa.assertTrue(actualLogRowsWebElement.getText().contains("Yellow"));

        // 17. Unselect and assert checkboxes
        // There we should click on checkboxes with labels
        // "Water" and "Wind" again and check if they are unchecked
        checkboxLabels.get(0).click();
        checkboxLabels.get(2).click();
        assertFalse(waterCheckBox.isSelected());
        assertFalse(windCheckBox.isSelected());

        // 18. Assert that for each checkbox there is
        // an individual log row and value is
        // corresponded to the status of checkbox.
        // We check if the panel with information really contains
        // such infos as "Water" and "Wind" and the labels "false" here
        // NB! Soft Assert can be placed here 'cause we can
        // continue test even if info about these checkboxes doesn't
        // display (we'll not use it in the further steps)
        sa.assertTrue(actualLogRowsWebElement.getText().
                contains("Water") && actualLogRowsWebElement.getText().
                contains("false"));
        sa.assertTrue(actualLogRowsWebElement.getText().
                contains("Wind") && actualLogRowsWebElement.getText().
                contains("false"));
    }

}
