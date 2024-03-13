package Frames;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class iFrame extends BaseTest {
    private static final String baseUrl = "https://the-internet.herokuapp.com/iframe";

    @Test
    public void iFrameTest() {
        initializeWebDriver();
        switchToFrame();
        tearDown();
    }
    public void switchToFrame() {
        driver.get(baseUrl);
        driver.switchTo().frame("mce_0_ifr");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement frameBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        frameBody.clear();
        frameBody.sendKeys("Test from Selenium");
    }
}
