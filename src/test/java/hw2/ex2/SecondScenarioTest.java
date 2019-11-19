package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SecondScenarioTest {

    private WebDriver driver;
    private SoftAssert sa;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.sa = new SoftAssert();
        driver.manage().timeouts().
                implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().
                pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().
                setScriptTimeout(30000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void secondScenarioTest() {
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
        List<String> actualServiceHeaderTexts = Arrays.
                asList(headerDropDownList.getText().split("\n"));
        ArrayList<String> expectedServiceHeaderTexts = new ArrayList<>();
        expectedServiceHeaderTexts.add("SUPPORT");
        expectedServiceHeaderTexts.add("DATES");
        expectedServiceHeaderTexts.add("SEARCH");
        expectedServiceHeaderTexts.add("COMPLEX TABLE");
        expectedServiceHeaderTexts.add("SIMPLE TABLE");
        expectedServiceHeaderTexts.add("USER TABLE");
        expectedServiceHeaderTexts.add("TABLE WITH PAGES");
        expectedServiceHeaderTexts.add("DIFFERENT ELEMENTS");
        expectedServiceHeaderTexts.add("PERFORMANCE");
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
        List<String> actualServiceLeftSectionTexts = Arrays.
                asList(leftSectionDropDownList.getText().split("\n"));
        ArrayList<String> expectedServiceLeftSectionTexts = new ArrayList<>();
        expectedServiceLeftSectionTexts.add("Support");
        expectedServiceLeftSectionTexts.add("Dates");
        expectedServiceLeftSectionTexts.add("Complex Table");
        expectedServiceLeftSectionTexts.add("Simple Table");
        expectedServiceLeftSectionTexts.add("Search");
        expectedServiceLeftSectionTexts.add("User Table");
        expectedServiceLeftSectionTexts.add("Table with pages");
        expectedServiceLeftSectionTexts.add("Different elements");
        expectedServiceLeftSectionTexts.add("Performance");
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
        driver.findElement(By.
                xpath("//div[@class='main-content']//div[2]//label[1]")).
                click();
        WebElement waterCheckBox = driver.findElement(By.
                xpath("//div//div//div//div[2]//label[1]//input[1]"));
        assertTrue(waterCheckBox.isSelected());
        driver.findElement(By.
                xpath("//div[@class='main-content']//div[2]//label[3]")).
                click();
        WebElement windCheckBox = driver.findElement(By.
                xpath("//div//div//div//div[2]//label[3]//input[1]"));
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
        List<String> actualLogRowsValues = Arrays.
                asList(actualLogRowsWebElement.getText().split("\n"));
        sa.assertEquals(actualLogRowsValues.size(), 2);
        sa.assertTrue(actualLogRowsWebElement.getText().
                contains("Wind") && actualLogRowsWebElement.getText().
                contains("true"));
        sa.assertTrue(actualLogRowsWebElement.getText().
                contains("Water") && actualLogRowsWebElement.getText().
                contains("true"));

        // 13. Select radio
        // There we should click on radio with label
        // "Selen" and check if it is checked
        driver.findElement(By.xpath("//div[3]//label[4]")).click();
        WebElement selenRadioButton = driver.findElement(By.
                xpath("//div[3]//label[4]//input[1]"));
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
        driver.findElement(By.
                xpath("//div[@class='main-content']//div[2]//label[1]")).
                click();
        driver.findElement(By.
                xpath("//div[@class='main-content']//div[2]//label[3]")).
                click();
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

    @AfterTest
    public void tearDown() {
        // X. Close Browser
        // We should do it
        driver.close();
    }

}
