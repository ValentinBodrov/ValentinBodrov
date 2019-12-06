package hw5.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AttachmentListener implements ITestListener {

    @Attachment(value = "{0}", fileExtension = "png", type = "image/png")
    public byte[] makeScreenshot(String name) {
        byte[] array = null;
        try {
            array = ((TakesScreenshot) WebDriverSingleton
                    .INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot(tr.getName());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenshot(tr.getName());
    }

}

