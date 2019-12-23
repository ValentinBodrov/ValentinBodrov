package hw7.jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw7.dataproviders.TestDataProvider;
import hw7.jdi.entities.JdiUser;
import hw7.jdi.entities.MetalsAndColorsFormFiller;
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
    public void metalsAndColorsPageFormTest(
            MetalsAndColorsFormFiller metalsAndColorsFormFiller) {
        JdiSite.open();
        JdiSite.login(JdiUser.ROMAN);
        String actualUserName = JdiSite.jdiHomePage.getUserName();
        assertEquals(actualUserName, JdiUser.ROMAN.getFullName(),
                format("Expected loginned user: %s, but get %s",
                        actualUserName, JdiUser.ROMAN.getFullName()));
        JdiSite.openPageInHeaderMenu(METALS_COLORS);
        assertTrue(JdiSite.metalsColorsPage.isOpened(),
                format("%s page didn't open", METALS_COLORS));
        JdiSite.metalsColorsPage.fillForm(metalsAndColorsFormFiller);
        String actualResultSet = JdiSite.metalsColorsPage.getActualResultSet();
        assertEquals(metalsAndColorsFormFiller.toString(), actualResultSet,
                format("Expected actual result set is %s, but got %s",
                        metalsAndColorsFormFiller, actualResultSet));
        JdiSite.metalsColorsPage.logout();
    }

}
