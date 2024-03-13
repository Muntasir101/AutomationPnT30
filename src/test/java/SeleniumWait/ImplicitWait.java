package SeleniumWait;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ImplicitWait extends BaseTest {
    private static final String baseUrl = "https://www.shohoz.com/bus-tickets";


    @Test
    public void implicitWaitTest() throws InterruptedException {
        initializeWebDriver();
        busTicketSearch();
    }
    public static void busTicketSearch() throws InterruptedException {
        driver.get(baseUrl); // navigate to  page

        // apply implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement fromLocation = driver.findElement(By.cssSelector("input#dest_from"));
        WebElement destinationLocation = driver.findElement(By.cssSelector("input#dest_to"));

        // Enter partial text to trigger auto-suggestions
        fromLocation.sendKeys("Dha");

        // Select the desired suggestion (for example, the first one)
        WebElement fromSuggestion = driver.findElement(By.linkText("Dhaka"));
        fromSuggestion.click();

        // Enter partial text to trigger auto-suggestions
        destinationLocation.sendKeys("Tan");

        // Select the desired suggestion (for example, the first one)
        WebElement toSuggestion = driver.findElement(By.linkText("Tangail"));
        toSuggestion.click();

        WebElement dateOfJourney = driver.findElement(By.cssSelector("#doj"));
        dateOfJourney.click();
        WebElement nextMonth1 = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
        nextMonth1.click();
        Thread.sleep(2000);
        WebElement nextMonth2 = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
        nextMonth2.click();

        WebElement chosenDOJ = driver.findElement(By.linkText("4"));
        chosenDOJ.click();

        WebElement dateOfReturn = driver.findElement(By.cssSelector("#dor"));
        dateOfReturn.click();
        WebElement nextMonth3 = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
        nextMonth3.click();
        WebElement nextMonth4 = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
        nextMonth4.click();

        WebElement chosenDOR = driver.findElement(By.linkText("5"));
        chosenDOR.click();

        WebElement search = driver.findElement(By.cssSelector("button[type='submit']"));
        search.click();

    }
}
