package TestNGDemo;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest_For_TestNG {
    protected static WebDriver driver;

    protected static void initializeWebDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();  // maximize window size
    }

    protected static void tearDown() {
        if(driver != null){
            driver.quit();
        }
        else{
            System.out.println("No Driver found.");
        }
    }

    protected static void captureScreenshot(String screenShotName) throws IOException, IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/Screenshots/"+screenShotName+".png"),true);
    }

}
