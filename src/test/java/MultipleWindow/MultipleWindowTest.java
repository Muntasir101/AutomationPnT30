package MultipleWindow;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;

public class MultipleWindowTest extends BaseTest {
    private static final String baseUrl = "https://the-internet.herokuapp.com/windows";

    @Test
    public void multipleWindowHandle(){
        initializeWebDriver();
        switchWindow();
    }
    public static void switchWindow(){
        driver.get(baseUrl);

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement newWindowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".example [target]")));
        newWindowButton.click();

        Set<String> windows = driver.getWindowHandles();

        //switch to child window
        for(String window : windows ){
            driver.switchTo().window(window);
        }
        driver.get("https://google.com");

        //close new window
        driver.close();

        // back to parent window
        driver.switchTo().window(windows.iterator().next());

    }
}
