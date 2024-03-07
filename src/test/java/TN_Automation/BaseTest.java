package TN_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
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
}
