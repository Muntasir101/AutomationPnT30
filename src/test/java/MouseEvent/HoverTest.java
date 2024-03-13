package MouseEvent;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;


public class HoverTest extends BaseTest {
    private static final String baseUrl = "https://tutorialsninja.com/demo/";

    @Test
    public void subMenuTest(){
        initializeWebDriver();
        menuAndSubMenu();
        tearDown();
    }
    public static void menuAndSubMenu(){
        driver.get(baseUrl);

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //initialize Action class
        Actions actionObj = new Actions(driver);

        WebElement desktops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle")));

        actionObj.moveToElement(desktops).perform();

        WebElement mac1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-of-type(1) > .dropdown-menu  .list-unstyled > li:nth-of-type(2) > a")));

        mac1.click();

    }
}
