package hw5.ex2;

import hw5.utils.AbstractSeleniumTest;
import hw5.ex2.steps.ActionSteps;
import hw5.ex2.steps.AssertionSteps;
import hw5.ex2.steps.ModelSteps;
import hw5.utils.AttachmentListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Allure successful tests demo")
@Listeners({AttachmentListener.class})
public class SecondScenarioTest extends AbstractSeleniumTest {

    private ModelSteps modelSteps;
    private ActionSteps actionSteps;
    private AssertionSteps assertionSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        modelSteps = new ModelSteps(driver);
        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @Test
    @Story("Testing login and checking important elements on the Home Page")
    public void secondScenarioTest() {

        // 1. Open test site by URL
        // There's a simple opening of a site
        actionSteps.openEpamJdiSite();

        // 2. Assert Browser title
        assertionSteps.pageTitleShouldBe("Home Page");

        // 3. Perform login
        actionSteps.login(userProperties.getProperty("username"),
                userProperties.getProperty("password"));

        // 4. Assert User name in the left top side
        // of screen that user is logined
        assertionSteps.
                usernameOnThePageShouldBe("PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in
        // the header and check that drop down contains options
        actionSteps.clickHeaderMenuItem("SERVICE");
        assertionSteps.
                textsOnTheHeaderShouldBe(modelSteps.getExpectedHeaderItems());

        // 6. Click on Service subcategory in
        // the left section and check that drop down contains options
        actionSteps.clickLeftSideMenuItem("Service");
        assertionSteps.
                textsOnTheLeftSideShouldBe(
                        modelSteps.getExpectedLeftSideItems());

        // 7. Open through the header menu Service ->
        // Different Elements Page
        actionSteps.clickItemInServiceHeader(
                "DIFFERENT ELEMENTS");
        assertionSteps.currentUrlAfterGoingToDifferentElementsPageShouldBe(
                "https://epam.github.io/JDI/different-elements.html");

        // 8. Check interface on Different elements page,
        // it contains all needed elements
        assertionSteps.numberOfCheckbuttonsShouldBe(4);
        assertionSteps.numberOfRadiobuttonsShouldBe(4);
        assertionSteps.colorDropdownMenuOnThePageIsDisplayed();
        assertionSteps.defaultButtonOnThePageIsDisplayed();
        assertionSteps.buttonOnThePageIsDisplayed();

        // 9. Assert that there is Right Section
        assertionSteps.rightSideComponentOnThePageIsDisplayed();

        // 10. Assert that there is Left Section
        assertionSteps.leftSideComponentOnThePageIsDisplayed();

        // 11. Select checkboxes
        actionSteps.clickTheCheckboxWithLabel("Water");
        assertionSteps.assertThatTheCheckboxWithSuchLabelIsSelected("Water");
        actionSteps.clickTheCheckboxWithLabel("Wind");
        assertionSteps.assertThatTheCheckboxWithSuchLabelIsSelected("Wind");

        // 12. Assert that for each checkbox there is
        // an individual log row and value is corresponded
        // to the status of checkbox.
        assertionSteps.numberOfRowsInLogRowShouldBe(2);
        assertionSteps.logRowsShouldContainSuchInfoAbout("Water");
        assertionSteps.logRowsShouldContainSuchInfoAbout("Wind");

        // 13. Select radio
        actionSteps.clickTheRadioWithLabel("Selen");
        assertionSteps.assertThatTheRadioWithSuchLabelIsSelected("Selen");
        // 14. Assert that for radiobutton there is
        // a log row and value is corresponded to
        // the status of radiobutton.
        assertionSteps.logRowsShouldContainSuchInfoAbout("Selen");

        // 15. Select in dropdown
        actionSteps.selectInTheDropDownThisColor("Yellow");
        assertionSteps.selectedColorShouldBe("Yellow");

        // 16. Assert that for dropdown there is
        // a log row and value is corresponded
        // to the selected value.
        assertionSteps.logRowsShouldContainSuchInfoAbout("Yellow");

        // 17. Unselect and assert checkboxes
        actionSteps.clickTheCheckboxWithLabel("Water");
        assertionSteps.assertThatTheCheckboxWithSuchLabelIsUnselected("Water");
        actionSteps.clickTheCheckboxWithLabel("Wind");
        assertionSteps.assertThatTheCheckboxWithSuchLabelIsUnselected("Wind");

        // 18. Assert that for each checkbox there is
        // an individual log row and value is
        // corresponded to the status of checkbox.
        assertionSteps.logRowsShouldNotContainSuchInfoAbout("Water");
        assertionSteps.logRowsShouldNotContainSuchInfoAbout("Wind");
    }

}
