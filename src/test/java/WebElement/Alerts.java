package WebElement;

import TN_Automation.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Alerts extends BaseTest {

    @Test
    public void AlertTest(){
        initializeWebDriver();
        allAlerts();
        tearDown();

    }
    public static void allAlerts(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement normalAlert = driver.findElement(By.cssSelector("li:nth-of-type(1) > button"));
        normalAlert.click();
        driver.switchTo().alert().accept(); // click on Ok Button

        WebElement confirmAlert = driver.findElement(By.cssSelector("li:nth-of-type(2) > button"));
        confirmAlert.click();
        driver.switchTo().alert().dismiss(); // click on cancel button

        WebElement promptAlert = driver.findElement(By.cssSelector("li:nth-of-type(3) > button"));
        promptAlert.click();
        driver.switchTo().alert().sendKeys("Test Automation");
        driver.switchTo().alert().accept();

    }
}
