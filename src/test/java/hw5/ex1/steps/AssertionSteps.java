package hw5.ex1.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends AbstractSteps {

    public AssertionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("The page title should be '{0}'")
    public void pageTitleShouldBe(final String expectedPageTitle) {
        assertEquals(homePage.getPageTitle(), expectedPageTitle);
    }

    @Step("Username should be '{0}' on the Home Page")
    public void usernameOnThePageShouldBe(final String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Step("Texts in the header of page should be '{0}'")
    public void textsOnTheHeaderShouldBe(
            final List<String> expectedHeaderTexts) {
        assertEquals(homePage.getHeaderItems(), expectedHeaderTexts);
    }

    @Step("Images on the Home Page should be displayed")
    public void assertThatImagesOnThePageAreDisplayed() {
        List<WebElement> actualBenefitsSpans = homePage.getBenefitsSpans();
        for (WebElement benefitsSpan : actualBenefitsSpans) {
            assertTrue(benefitsSpan.isDisplayed());
        }
    }

    @Step("There should be proper text under icons")
    public void benefitsTextsOnThePageShouldBe(
            final List<String> expectedBenefitsTexts) {
        assertEquals(homePage.getBenefitsTexts(), expectedBenefitsTexts);
    }

    @Step("The main header on the Home page should be '{0}'")
    public void mainHeaderOnThePageShouldBe(final String expectedMainHeader) {
        assertEquals(homePage.getMainHeaderText(), expectedMainHeader);
    }

    @Step("There should be the main text under main header")
    public void mainTextOnThePageShouldBe(final String expectedMainText) {
        assertEquals(homePage.getMainTextText(), expectedMainText);
    }

    @Step("Iframe on the Home Page should exist")
    public void assertThatIframeOnThePageExists() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("EPAM logo in the iframe on the Home Page should be displayed")
    public void assertThatEpamLogoInTheIframeIsDisplayed() {
        assertTrue(homePage.getEpamLogo().isDisplayed());
    }

    @Step("Text in the sub header should be '{0}'")
    public void textInTheSubHeaderShouldBe(
            final String expectedSubHeaderText) {
        assertEquals(homePage.getSubHeaderText(), expectedSubHeaderText);
    }

    @Step("The link in the sub header should be '{0}'")
    public void linkInTheSubHeaderElementShouldBe(
            final String expectedLinkUrl) {
        assertEquals(homePage.getLinkElementUrl(), expectedLinkUrl);
    }

    @Step("The left section should be displayed")
    public void assertThatTheLeftSectionIsDisplayed() {
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    @Step("The footer should be displayed")
    public void assertThatTheFooterIsDisplayed() {
        assertTrue(homePage.getFooter().isDisplayed());
    }

}
