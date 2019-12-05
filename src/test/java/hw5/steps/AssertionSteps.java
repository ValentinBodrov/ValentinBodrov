package hw5.steps;

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

    public void textsOnTheHeaderShouldBe(
            final List<String> expectedHeaderTexts) {
        assertEquals(homePage.getHeaderItems(), expectedHeaderTexts);
    }

    public void assertThatImagesOnThePageAreDisplayed() {
        List<WebElement> actualBenefitsSpans = homePage.getBenefitsSpans();
        for (WebElement benefitsSpan : actualBenefitsSpans) {
            assertTrue(benefitsSpan.isDisplayed());
        }
    }

    public void benefitsTextsOnThePageShouldBe(
            final List<String> expectedBenefitsTexts) {
        assertEquals(homePage.getBenefitsTexts(), expectedBenefitsTexts);
    }

    public void mainHeaderOnThePageShouldBe(final String expectedMainHeader) {
        assertEquals(homePage.getMainHeaderText(), expectedMainHeader);
    }

    public void mainTextOnThePageShouldBe(final String expectedMainText) {
        assertEquals(homePage.getMainTextText(), expectedMainText);
    }

    public void assertThatIframeOnThePageExists() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    public void assertThatEpamLogoInTheIframeIsDisplayed() {
        assertTrue(homePage.getEpamLogo().isDisplayed());
    }

    public void textInTheSubHeaderShouldBe(
            final String expectedSubHeaderText) {
        assertEquals(homePage.getSubHeaderText(), expectedSubHeaderText);
    }

    public void linkInTheSubHeaderElementShouldBe(
            final String expectedLinkUrl) {
        assertEquals(homePage.getLinkElementUrl(), expectedLinkUrl);
    }

    public void assertThatTheLeftSectionIsDisplayed() {
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    public void assertThatTheFooterIsDisplayed() {
        assertTrue(homePage.getFooter().isDisplayed());
    }

}
