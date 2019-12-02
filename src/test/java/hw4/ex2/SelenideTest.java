package hw4.ex2;

import hw4.ex1.HomePage;
import hw4.ex2.steps.ActionSteps;
import hw4.ex2.steps.ModelSteps;
import hw4.utils.AbstractSelenideTest;
import hw4.utils.TestData;
import hw4.utils.TestDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;


public class SelenideTest extends AbstractSelenideTest {

    private ActionSteps actionSteps;
    private ModelSteps modelSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        actionSteps = new ActionSteps();
        modelSteps = new ModelSteps();
    }

    @Test(dataProviderClass = TestDataProvider.class,
            dataProvider = "Data Sets Provider")
    public void secondExerciseTest(TestData dataSet) {
        // 1. Open test site by URL
        open("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        HomePage homePage = modelSteps.initHomePage();
        assertEquals(title(), "Home Page");

        // 3. Perform login
        homePage.login(userProperties.getProperty("username"),
                userProperties.getProperty("password"));

        // 4. Click on the link on the Header section
        homePage.clickItemInHeader("METALS & COLORS");
        MetalsAndColorsPage metalsAndColorsPage =
                modelSteps.initMetalsAndColorsPage();

        // 5. Fill the form with data
        actionSteps.fillFormOnThePage(metalsAndColorsPage, dataSet);

        // 6. Click "Submit" button
        metalsAndColorsPage.submit();

        // 7. Check Results block in the right section and assert
        ArrayList<String> expectedResultSet = modelSteps.getActualResultSet(metalsAndColorsPage.infoPanelResults(), dataSet);
        ArrayList<String> actualResultSet = modelSteps.getExpectedResultSet(dataSet);
        assertEquals(actualResultSet, expectedResultSet);

        // X. Log out
        metalsAndColorsPage.logout();
    }

}
