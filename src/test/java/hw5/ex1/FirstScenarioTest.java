package hw5.ex1;

import hw5.ex1.steps.ActionSteps;
import hw5.ex1.steps.AssertionSteps;
import hw5.ex1.steps.ModelSteps;
import hw5.utils.AbstractSeleniumTest;
import hw5.utils.AttachmentListener;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class, AttachmentListener.class})
public class FirstScenarioTest extends AbstractSeleniumTest {

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
    public void loginTest() {
        // 1. Open test site by URL
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

//        // 5. Assert Browser title
//        assertionSteps.pageTitleShouldBe("Home Page");
//
//        // 6. Assert that there are 4 items on the header
//        // section are displayed and they have proper texts
//        assertionSteps.
//                textsOnTheHeaderShouldBe(modelSteps.getExpectedHeaderItems());
//
//        // 7. Assert that there are 4 images on the Index Page and
//        // they are displayed
//        assertionSteps.
//                assertThatImagesOnThePageAreDisplayed();
//
//        // 8. Assert that there are 4 texts on the Index Page
//        // under icons and they have proper text
//        assertionSteps.benefitsTextsOnThePageShouldBe(
//                modelSteps.getExpectedBenefitsTexts());
//
//        // 9. Assert a text of the main headers
//        // There we have simple assertion of actual main headers texts
//        assertionSteps.mainHeaderOnThePageShouldBe(
//                modelSteps.getExpectedMainHeader());
//        assertionSteps.mainTextOnThePageShouldBe(
//                modelSteps.getExpectedMainText());
//
//        // 10. Assert that there is the iframe in the center of page
//        // We just check if there's an iframe in the centre of a page
//        assertionSteps.assertThatIframeOnThePageExists();
//
//        // 11. Switch to the iframe and check that there is Epam logo
//        // in the left top conner of iframe
//        actionSteps.switchToIframe();
//        assertionSteps.assertThatEpamLogoInTheIframeIsDisplayed();
//
//        // 12. Switch to original window back
//        // We switch back to the original page
//        actionSteps.switchBackToOriginalPage();
//
//        // 13. Assert a text of the sub header
//        assertionSteps.textInTheSubHeaderShouldBe("JDI GITHUB");
//
//        // 14. Assert that JDI GITHUB is a link and has
//        // a proper URL
//        assertionSteps.linkInTheSubHeaderElementShouldBe(
//                "https://github.com/epam/JDI");
//
//        // 15. Assert that there is Left Section
//        // We check here if the left sidebar section is displayed
//        assertionSteps.assertThatTheLeftSectionIsDisplayed();
//
//        // 16. Assert that there is Footer
//        // We check here if the footer is displayed
//        assertionSteps.assertThatTheFooterIsDisplayed();
    }

//    @Test(testName = "Failed Login Test")
//    public void failedLoginTest() {
//        // 1. Open test site by URL
//        actionSteps.openEpamJdiSite();
//
//        // 2. Assert Browser title
//        assertionSteps.pageTitleShouldBe("Home Page");
//
//        // 3. Perform login
//        actionSteps.login(userProperties.getProperty("username"),
//                userProperties.getProperty("password"));
//
//        // 4. Assert User name in the left top side
//        // of screen that user is logined
//        // NB! There's a failure
//        assertionSteps.
//                usernameOnThePageShouldBe("PITER CHAILOVSKII1");
//    }

}
