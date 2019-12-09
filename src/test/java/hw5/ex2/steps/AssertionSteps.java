package hw5.ex2.steps;

import io.qameta.allure.Step;
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

    @Step("The page title should be '{0}'")
    public void pageTitleShouldBe(final String expectedPageTitle) {
        sa.assertEquals(homePage.getPageTitle(), expectedPageTitle);
    }

    @Step("Username should be '{0}' on the Home Page")
    public void usernameOnThePageShouldBe(final String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Step("Texts in the header of page should be '{0}'")
    public void textsOnTheHeaderShouldBe(
            final List<String> expectedHeaderTexts) {
        assertEquals(homePage.getServiceHeaderItems(), expectedHeaderTexts);
    }

    @Step("Texts in the left side menu should be '{0}'")
    public void textsOnTheLeftSideShouldBe(
            final List<String> expectedHeaderTexts) {
        sa.assertEquals(
                homePage.getServiceLeftSideItems(), expectedHeaderTexts);
    }

    @Step("The current URL after going to 'Different Elements' page " +
            "should be '{0}'")
    public void currentUrlAfterGoingToDifferentElementsPageShouldBe(
            final String expectedUrl) {
        assertEquals(
                differentElementsPage.getCurrentUrl(), expectedUrl);
    }

    @Step("The number of checkbuttons should be '{0}'")
    public void numberOfCheckbuttonsShouldBe(final int expectedNumber) {
        assertEquals(differentElementsPage.getCheckButtons().size(),
                expectedNumber);
    }

    @Step("The number of radiobuttons should be '{0}'")
    public void numberOfRadiobuttonsShouldBe(final int expectedNumber) {
        assertEquals(differentElementsPage.getRadioButtons().size(),
                expectedNumber);
    }

    @Step("The color dropdown menu should be displayed")
    public void colorDropdownMenuOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.getColorDropDown().isDisplayed());
    }

    @Step("The default button should be displayed")
    public void defaultButtonOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Step("The button should be displayed")
    public void buttonOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    @Step("The right side component should be displayed")
    public void rightSideComponentOnThePageIsDisplayed() {
        assertTrue(differentElementsPage.isRightSideComponentDisplayed());
    }

    @Step("The left side component should be displayed")
    public void leftSideComponentOnThePageIsDisplayed() {
        sa.assertTrue(differentElementsPage.isLeftSideMenuDisplayed());
    }

    @Step("The checkbox with label '{0}' should be selected")
    public void assertThatTheCheckboxWithSuchLabelIsSelected(
            final String itemName) {
        assertTrue(differentElementsPage.isCheckBoxWithSuchLabelSelected(
                itemName));
    }

    @Step("The radio with label '{0}' should be selected")
    public void assertThatTheRadioWithSuchLabelIsSelected(
            final String itemName) {
        assertTrue(differentElementsPage.isRadioWithSuchLabelSelected(
                itemName));
    }

    @Step("The checkbox with label '{0}' should be unselected")
    public void assertThatTheCheckboxWithSuchLabelIsUnselected(
            final String itemName) {
        assertFalse(differentElementsPage.isCheckBoxWithSuchLabelSelected(
                itemName));
    }

    @Step("The number of rows in log should be '{0}'")
    public void numberOfRowsInLogRowShouldBe(final int expectedNumber) {
        sa.assertEquals(differentElementsPage.getNumberOfLogsInLogRow(),
                expectedNumber);
    }

    @Step("The logs should contain true-information about '{0}'")
    public void logRowsShouldContainSuchInfoAbout(final String labelName) {
        sa.assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(labelName, "true"));
    }

    @Step("The logs should contain false-information about '{0}'")
    public void logRowsShouldNotContainSuchInfoAbout(final String labelName) {
        sa.assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(labelName, "false"));
    }

    @Step("The selected colour should be '{0}'")
    public void selectedColorShouldBe(final String colorName) {
        assertEquals(differentElementsPage.actuallySelectedInColorDropDown(),
                colorName);
    }

}
