package hw2.ex1;

import hw2.utils.AbstractSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstScenarioTest extends AbstractSeleniumTest {

    @Test
    public void firstScenarioTest() {
        // 1. Open test site by URL
        // There's a simple opening of a site
        driver.get("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        // There's a getting of a title and
        // comparing it with expected title -- "Home page"
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Home Page");

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
        // written in upper case
        WebElement actualUserName = driver.findElement(By.id("user-name"));
        assertEquals(actualUserName.getText(), "PITER CHAILOVSKII");

        // 5. Assert Browser title
        // There's a getting of a title and
        // comparing it with expected title -- "Home page"
        // NB! We take expectedTitle from above
        actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Home Page");

        // 6. Assert that there are 4 items on the header
        // section are displayed and they have proper texts
        // There's a creating of array list with expected texts
        // in header, getting a web element with actual header
        // texts, getting list of these texts and comparing them
        List<String> expectedHeaderTexts = Arrays.
                asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        WebElement header = driver.findElement(By.
                xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']"));
        List<WebElement> headerItems = header.findElements(By.tagName("li"));
        ArrayList<String> actualHeaderTexts = new ArrayList<>();
        for (WebElement headerItem : headerItems) {
            if (headerItem.getText().equals("")) {
                continue;
            }
            actualHeaderTexts.add(headerItem.getText());
        }
        assertEquals(actualHeaderTexts, expectedHeaderTexts);

        // 7. Assert that there are 4 images on the Index Page and
        // they are displayed
        // There's a simple assertion of existing
        // and displaying of 4 icons
        WebElement benefits = driver.findElement(By.
                xpath("//div[@class='row clerafix benefits']"));
        List<WebElement> benefitsSpans = benefits.findElements(By.
                className("icons-benefit"));
        for (WebElement benefitsSpan : benefitsSpans) {
            assertTrue(benefitsSpan.isDisplayed());
        }

        // 8. Assert that there are 4 texts on the Index Page
        // under icons and they have proper text
        // There's a creating of expected benefits texts list and
        // filling it with values. Then we get the list of elements
        // with actual benefits texts, get texts from them
        // and compare actual texts and expected ones
        List<String> expectedBenefitsTexts = Arrays.asList(
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
        List<WebElement> actualBenefitsTextsElements = driver.findElements(By.
                className("benefit-txt"));
        ArrayList<String> actualBenefitsTexts = new ArrayList<>();
        for (WebElement element : actualBenefitsTextsElements) {
            actualBenefitsTexts.add(element.getText());
        }
        assertEquals(actualBenefitsTexts, expectedBenefitsTexts);

        // 9. Assert a text of the main headers
        // There we have simple assertion of actual main headers texts
        // (we get them with help of a driver)
        // with expected ones (we create them by this step)
        // NB! These texts should be in upper case ('cause we see
        // it as is)
        WebElement actualMainHeader = driver.findElement(By.
                xpath("//h3[@name='main-title']"));
        WebElement actualMainText = driver.findElement(By.
                xpath("//p[@name='jdi-text']"));
        String expectedMainHeader = "EPAM FRAMEWORK WISHES…";
        String expectedMainText = "Lorem ipsum dolor sit amet, consectetur" +
                " adipisicing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad " +
                "minim veniam, quis nostrud exercitation " +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat " +
                "Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        expectedMainText = expectedMainText.toUpperCase();
        assertEquals(actualMainHeader.getText(), expectedMainHeader);
        assertEquals(actualMainText.getText(), expectedMainText);

        // 10. Assert that there is the iframe in the center of page
        // We just check if there's an iframe in the centre of a page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        // 11. Switch to the iframe and check that there is Epam logo
        // in the left top conner of iframe
        // There's a switching in an iframe and checking if the
        // Epam logo displays here
        driver.switchTo().frame(driver.findElement(By.id("iframe")));
        assertTrue(driver.findElement(By.
                cssSelector("#epam_logo")).isDisplayed());

        // 12. Switch to original window back
        // We switch back to the original page
        driver.switchTo().defaultContent();

        // 13. Assert a text of the sub header
        // We get an actual subheader and compare it
        // with expected -- JDI GITHUB
        WebElement actualSubHeader = driver.findElement(By.
                xpath("//h3[@class='text-center']"));
        assertEquals(actualSubHeader.getText(), "JDI GITHUB");

        // 14. Assert that JDI GITHUB is a link and has
        // a proper URL
        // There we should get a link from JDI GITHUB and
        // check its URL -- it should be https://github.com/epam/JDI
        WebElement link = actualSubHeader.findElement(By.
                linkText("JDI GITHUB"));
        assertEquals(link.getAttribute("href"),
                "https://github.com/epam/JDI");

        // 15. Assert that there is Left Section
        // We check here if the left sidebar section is displayed
        assertTrue(driver.findElement(By.
                xpath("//div[@name='navigation-sidebar']")).isDisplayed());

        // 16. Assert that there is Footer
        // We check here if the footer is displayed
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

}
