package hw3.ex2.steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class AssertionSteps extends AbstractSteps {

    private SoftAssert sa;

    public AssertionSteps(WebDriver driver) {
        super(driver);
        this.sa = new SoftAssert();
    }

    public void pageTitleShouldBe(final String expectedPageTitle) {
        sa.assertEquals(homePage.getPageTitle(), expectedPageTitle);
    }

    public void usernameOnThePageShouldBe(final String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    public void textsOnTheHeaderShouldBe(
            final List<String> expectedHeaderTexts) {
        assertEquals(homePage.getServiceHeaderItems(), expectedHeaderTexts);
    }

    public void textsOnTheLeftSideShouldBe(
            final List<String> expectedHeaderTexts) {
        sa.assertEquals(
                homePage.getServiceLeftSideItems(), expectedHeaderTexts);
    }

    public void currentUrlAfterGoingToDifferentElementsPageShouldBe(
            final String expectedUrl) {
        assertEquals(
                differentElementsPage.getCurrentUrl(), expectedUrl);
    }

    public void numberOfCheckbuttonsShouldBe(final int expectedNumber) {
        assertEquals(differentElementsPage.getCheckButtons().size(),
                expectedNumber);
    }

    public void numberOfRadiobuttonsShouldBe(final int expectedNumber) {
        assertEquals(differentElementsPage.getRadioButtons().size(),
                expectedNumber);
    }

    public void colorDropdownMenuOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.getColorDropDown().isDisplayed());
    }

    public void defaultButtonOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    public void buttonOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    public void rightSideComponentOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.isRightSideComponentDisplayed());
    }

    public void leftSideComponentOnThePageIsDisplayed() {
        sa.assertTrue(differentElementsPage.isLeftSideMenuDisplayed());
    }

    public void assertThatTheCheckboxWithSuchLabelIsSelected(
            final String itemName) {
        assertTrue(differentElementsPage.isCheckBoxWithSuchLabelSelected(
                itemName));
    }

    public void assertThatTheRadioWithSuchLabelIsSelected(
            final String itemName) {
        assertTrue(differentElementsPage.isRadioWithSuchLabelSelected(
                itemName));
    }

    public void assertThatTheCheckboxWithSuchLabelIsUnselected(
            final String itemName) {
        assertFalse(differentElementsPage.isCheckBoxWithSuchLabelSelected(
                itemName));
    }

    public void numberOfRowsInLogRowShouldBe(final int expectedNumber) {
        sa.assertEquals(differentElementsPage.getNumberOfLogsInLogRow(),
                expectedNumber);
    }

    public void logRowsShouldContainSuchInfoAbout(final String labelName) {
        sa.assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(labelName, "true"));
    }

    public void logRowsShouldNotContainSuchInfoAbout(final String labelName) {
        sa.assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(labelName, "false"));
    }

    public void selectedColorShouldBe(final String colorName) {
        assertEquals(differentElementsPage.actuallySelectedInColorDropDown(),
                colorName);
    }

}
