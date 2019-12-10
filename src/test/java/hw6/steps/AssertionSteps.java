package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.DifferentElementsPage;
import hw6.UserTablePage;
import hw6.utils.WebDriverSingleton;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class AssertionSteps extends AbstractSteps {

    @Then("^username should be '([^\"]+)' on the Home Page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Then("^Browser title should be '([^\"]+)' on the Home Page$")
    public void browserTitleShouldBeOnTheHomePage(String expectedTitle) {
        assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @Then("^the four pictures should be displayed on the Home Page$")
    public void theFourPicturesShouldBeDisplayedOnTheHomePage() {
        List<WebElement> actualBenefitsSpans = homePage.getBenefitsSpans();
        for (WebElement benefitsSpan : actualBenefitsSpans) {
            assertTrue(benefitsSpan.isDisplayed());
        }
    }

    @Then("^the four texts should be displayed under pictures on" +
            " the Home Page$")
    public void theFourTextsShouldBeDisplayedUnderPicturesOnTheHomePage() {
        List<WebElement> actualBenefitsTexts = homePage.
                getBenefitsTextsElements();
        for (WebElement benefitsTextElement : actualBenefitsTexts) {
            assertTrue(benefitsTextElement.isDisplayed());
        }
    }

    @Then("^the headline should be displayed on the Home Page$")
    public void theHeadlineShouldBeDisplayedOnTheHomePage() {
        assertTrue(homePage.getMainHeader().isDisplayed());
    }

    @Then("^the description should be displayed under the headline on" +
            " the Home Page$")
    public void theDescriptionShouldBeDisplayedUnderTheHeadlineOnTheHomePage() {
        assertTrue(homePage.getMainText().isDisplayed());
    }

    @Then("^service subcategory in the header should have data$")
    public void serviceSubcategoryInTheHeaderShouldHaveData(
            List<String> expectedServiceHeaderTexts) {
        assertEquals(homePage.getServiceHeaderItems(), expectedServiceHeaderTexts);
    }

    @Then("^service subcategory in the left side menu should have data$")
    public void serviceSubcategoryInTheLeftSideMenuShouldHaveData(
            List<String> expectedServiceHeaderTexts) {
        assertEquals(homePage.getServiceLeftSideItems(), expectedServiceHeaderTexts);
    }

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(String expectedPageTitle) {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.
                INSTANCE.getDriver());
        userTablePage = new UserTablePage(WebDriverSingleton.
                INSTANCE.getDriver());
        assertEquals(differentElementsPage.getPageTitle(), expectedPageTitle);
    }

    @Then("^the (\\d+) checkboxed should be displayed on Different Elements Page$")
    public void theCheckboxesShouldBeDisplayedOnDifferentElementsPage(
            int expectedNumber) {
        assertEquals(differentElementsPage.getCheckButtons().size(),
                expectedNumber);
    }

    @Then("^the (\\d+) radiobuttons should be displayed on Different Elements Page$")
    public void theRadiobuttonsShouldBeDisplayedOnDifferentElementsPage(
            int expectedNumber) {
        assertEquals(differentElementsPage.getRadioButtons().size(),
                expectedNumber);
    }

    @Then("^the dropdown should be displayed on Different Elements Page$")
    public void theDropDownShouldBeDisplayedOnDifferentElementsPage() {
        assertTrue(differentElementsPage.getColorDropDown().isDisplayed());
    }

    @Then("^a default button should be displayed on Different Elements Page$")
    public void aDefaultButtonShouldBeDisplayedOnDifferentElementsPage() {
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Then("^a button should be displayed on Different Elements Page$")
    public void aButtonShouldBeDisplayedOnDifferentElementsPage() {
        assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    @Then("^the Right Section should be displayed on Different Elements Page$")
    public void theRightSectionShouldBeDisplayedOnDifferentElementsPage() {
        assertTrue(differentElementsPage.isRightSideComponentDisplayed());
    }

    @Then("^the Left Section should be displayed on Different Elements Page$")
    public void theLeftSectionShouldBeDisplayedOnDifferentElementsPage() {
        assertTrue(differentElementsPage.isLeftSideMenuDisplayed());
    }

    @Then("^the checkbox with label '([^\"]+)' should be checked on Different Elements Page$")
    public void theCheckboxWithLabelShouldBeCheckedOnDifferentElementsPage(
            String itemName) {
        assertTrue(differentElementsPage.isCheckBoxWithSuchLabelSelected(
                itemName));
    }

    @Then("^the log rows should contain information about checkbox with label '([^\"]+)' on Different Elements Page$")
    public void theLogRowsShouldContainInformationAboutCheckboxWithLabelOnDifferentElementsPage(
            String expectedItemName) {
        assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(
                        expectedItemName, "true"));
    }

    @Then("^the checkbox with label '([^\"]+)' should not be checked on Different Elements Page$")
    public void theCheckboxWithLabelShouldNotBeCheckedOnDifferentElementsPage(
            String expectedItemName) {
        assertFalse(differentElementsPage.isCheckBoxWithSuchLabelSelected(
                expectedItemName));
    }

    @Then("^the log rows should not contain information about checkbox with label '([^\"]+)' on Different Elements Page$")
    public void theLogRowsShouldNotContainInformationAboutCheckboxWithLabelOnDifferentElementsPage(
            String expectedItemName) {
        assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(
                        expectedItemName, "false"));
    }

    @Then("^the radiobutton with label '([^\"]+)' should be checked on Different Elements Page$")
    public void theRadiobuttonWithLabelShouldBeCheckedOnDifferentElementsPage(
            String expectedItemName) {
        assertTrue(differentElementsPage.isRadioWithSuchLabelSelected(
                expectedItemName));
    }

    @Then("^the log rows should contain information about radiobutton with label '([^\"]+)' on Different Elements Page$")
    public void theLogRowsShouldContainInformationAboutRadiobuttonWithLabelOnDifferentElementsPage(
            String expectedItemName) {
        assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(expectedItemName, "true"));
    }

    @Then("^the element '([^\"]+)' in a dropdown should be selected on Different Elements Page$")
    public void theElementInADropdownShouldBeSelectedOnDifferentElementsPage(
            String expectedItemName) {
        assertEquals(differentElementsPage.actuallySelectedInColorDropDown(),
                expectedItemName);
    }

    @Then("^the log rows should contain information about dropdown element '([^\"]+)' on Different Elements Page$")
    public void theLogRowsShouldContainInformationAboutDropdownElementOnDifferentElementsPage(
            String expectedItemName) {
        assertTrue(differentElementsPage.
                isThereAnInfoAboutThisLabelInLogRow(expectedItemName, "true"));
    }

    @Then("^(\\d+) Type Dropdowns are displayed on Users Table on" +
            " User Table Page$")
    public void numberTypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(
            int expectedNumber) {
        assertEquals(userTablePage.getDropdownList().size(),
                expectedNumber);
    }

    @Then("^(\\d+) User names are displayed on Users Table on " +
            "User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(
            int expectedNumber) {
        assertEquals(userTablePage.getUsersList().size(),
                expectedNumber);
    }

    @Then("^(\\d+) Description images are displayed on Users Table on" +
            " User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(
            int expectedNumber) {
        assertEquals(userTablePage.getDescriptionImagesList().size(),
                expectedNumber);
    }

    @Then("^(\\d+) Description texts under images are displayed on Users" +
            " Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(
            int expectedNumber) {
        assertEquals(userTablePage.getDescriptionTextsList().size(),
                expectedNumber);
    }

    @Then("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(
            int expectedNumber) {
        assertEquals(userTablePage.getCheckboxesList().size(),
                expectedNumber);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(
            DataTable expectedUserData) {
        List<Map<String, String>> expectedUserMapList =
                expectedUserData.asMaps(String.class, String.class);
        assertEquals(expectedUserMapList, userTablePage.getActualUserData());
    }

    @Then("^1 log row has '([^\"]+)' text in log section$")
    public void logRowHasTextInLogSection(String expectedText) {
        assertTrue(userTablePage.isThereAnInfoAboutThisLabelInLogRow(
                expectedText, "true"));
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(DataTable expectedDropdownValues) {
        List<String> expectedDropdownValuesList = new LinkedList<>(
                expectedDropdownValues.asList(String.class));
        expectedDropdownValuesList.remove(0);
        assertEquals(userTablePage.getActualDropdownValues(),
                expectedDropdownValuesList);
    }

}
