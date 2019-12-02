package hw4.utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractSelenideTest {

    protected Properties userProperties;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "CHROME";
        Configuration.startMaximized = true;

        userProperties = new Properties();
        try {
            userProperties.load(new FileInputStream(
                    "src/main/resources/user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
