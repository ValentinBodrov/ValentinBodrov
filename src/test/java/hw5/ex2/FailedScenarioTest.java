package hw5.ex2;

import hw5.ex2.steps.ActionSteps;
import hw5.ex2.steps.AssertionSteps;
import hw5.utils.AbstractSeleniumTest;
import hw5.utils.AttachmentListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Allure failed tests demo")
@Listeners({AttachmentListener.class})
public class FailedScenarioTest extends AbstractSeleniumTest {

    private ActionSteps actionSteps;
    private AssertionSteps assertionSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @Test(testName = "Failed Login Test")
    @Story("Making the login test from 1st exercise failed")
    public void failedScenarioTest() {

        // 1. Open test site by URL
        // There's a simple opening of a site
        actionSteps.openEpamJdiSite();

        // 2. Assert Browser title
        assertionSteps.pageTitleShouldBe("Home Page");

        // 3. Perform login
        actionSteps.login(userProperties.getProperty("username"),
                userProperties.getProperty("password"));

        // 4. Make the test failed
        assertionSteps.
                usernameOnThePageShouldBe("PITER CHAILOVSKII1");
    }

}
