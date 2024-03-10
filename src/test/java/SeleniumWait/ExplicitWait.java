package SeleniumWait;

import TN_Automation.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ExplicitWait extends BaseTest {
    private static final String baseUrl = "https://www.shohoz.com/bus-tickets";

    @Test
    public void explicitWaitTest() throws InterruptedException {
        initializeWebDriver();
        busTicketSearch();
    }
    public static void busTicketSearch() throws InterruptedException {
        driver.get(baseUrl); // navigate to  page

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement fromLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#dest_from")));
        WebElement destinationLocation= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#dest_to")));

        // Enter partial text to trigger auto-suggestions
        fromLocation.sendKeys("Dha");

        // Select the desired suggestion (for example, the first one)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dhaka")));
        WebElement fromSuggestion = driver.findElement(By.linkText("Dhaka"));
        fromSuggestion.click();

        // Enter partial text to trigger auto-suggestions
        destinationLocation.sendKeys("Tan");

        // Select the desired suggestion (for example, the first one)
        WebElement toSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tangail")));
        toSuggestion.click();

        WebElement dateOfJourney = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#doj")));
        dateOfJourney.click();

        WebElement nextMonth1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")));
        nextMonth1.click();

        WebElement nextMonth2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")));
        nextMonth2.click();

        WebElement chosenDOJ = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("5")));
        chosenDOJ.click();

        WebElement dateOfReturn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dor")));
        dateOfReturn.click();

        WebElement nextMonth3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")));
        nextMonth3.click();

        WebElement nextMonth4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")));
        nextMonth4.click();

        WebElement chosenDOR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("5")));
        chosenDOR.click();

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        search.click();

    }
}
