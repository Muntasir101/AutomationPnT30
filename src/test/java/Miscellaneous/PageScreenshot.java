package Miscellaneous;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenshot extends BaseTest {
    @Test
    public void screenshotTest() throws IOException {
        initializeWebDriver();
        captureScreenshot("NewImage");
        tearDown();
    }
    public static void captureScreenshot(String screenShotName) throws IOException {
        driver.get("https://google.com");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/Screenshots/"+screenShotName+".png"),true);
    }
}
