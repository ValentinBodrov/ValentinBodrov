package hw2.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    protected WebDriver driver;

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
    }

    @AfterMethod
    public void tearDown() {
        // X. Close Browser
        // There we have a simple closing
        this.driver.close();
    }
}
