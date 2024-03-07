package WebElement;

import TN_Automation.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoSuggestionDropdown extends BaseTest {

    private static final String baseUrl = "https://www.shohoz.com/bus-tickets";

    @Test
    public void autoSuggestionTest(){
        initializeWebDriver();
        busTicketSearch();
    }
    public static void busTicketSearch(){
        driver.get(baseUrl); // navigate to  page

        WebElement fromLocation = driver.findElement(By.cssSelector("input#dest_from"));
        WebElement destinationLocation = driver.findElement(By.cssSelector("input#dest_to"));

        // Enter partial text to trigger auto-suggestions
        fromLocation.sendKeys("Dha");

        // Wait for auto-suggestions to appear (adjust the timeout as needed)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.linkText("Dhaka"))));

        // Select the desired suggestion (for example, the first one)
        WebElement fromSuggestion = driver.findElement(By.linkText("Dhaka"));
        fromSuggestion.click();

        // Enter partial text to trigger auto-suggestions
        destinationLocation.sendKeys("Tan");

        // Wait for auto-suggestions to appear (adjust the timeout as needed)
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated((By.linkText("Tangail"))));

        // Select the desired suggestion (for example, the first one)
        WebElement destinationSuggestion = driver.findElement(By.linkText("Tangail"));
        destinationSuggestion.click();


    }

}
