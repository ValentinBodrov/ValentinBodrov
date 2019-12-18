package hw7.jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw7.dataproviders.TestDataProvider;
import hw7.jdi.entities.JdiUser;
import hw7.jdi.entities.TestData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiSiteTests {

    public static final String METALS_COLORS = "METALS & COLORS";
    protected Properties userProperties;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        userProperties = new Properties();
        try {
            userProperties.load(new FileInputStream(
                    "src/main/resources/jdiuser.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProviderClass = TestDataProvider.class,
            dataProvider = "Data Sets Provider")
    public void metalsAndColorsPageFormTest(TestData testData) {
        JdiUser jdiUser = new JdiUser(userProperties.getProperty("username"),
                userProperties.getProperty("password"),
                userProperties.getProperty("fullname"));
        JdiSite.open();
        JdiSite.login(jdiUser);
        String actualUserName = JdiSite.jdiHomePage.getUserName();
        assertEquals(actualUserName, jdiUser.getFullName(),
                format("Expected loginned user: %s, but get %s",
                        actualUserName, jdiUser.getFullName()));
        JdiSite.openPageInHeaderMenu(METALS_COLORS);
        assertTrue(JdiSite.metalsColorsPage.isOpened(),
                format("%s page didn't open", METALS_COLORS));
        JdiSite.metalsColorsPage.fillForm(testData);
        String actualResultSet = JdiSite.metalsColorsPage.getActualResultSet();
        assertEquals(testData.toString(), actualResultSet,
                format("Expected actual result set is %s, but got %s",
                        testData, actualResultSet));
        JdiSite.metalsColorsPage.logout();
    }

}
