package hw5.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners({AttachmentListener.class})
public abstract class AbstractSeleniumTest {

    protected WebDriver driver;
    protected Properties userProperties;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().
                implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().
                pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().
                setScriptTimeout(30000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        WebDriverSingleton.INSTANCE.setDriver(driver);
        userProperties = new Properties();
        try {
            userProperties.load(new FileInputStream(
                    "src/main/resources/user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            driver.close();
        }
    }

    @AfterMethod
    public void tearDown() {
        // X. Close Browser
        // There we have a simple closing
        this.driver.close();
    }
}
