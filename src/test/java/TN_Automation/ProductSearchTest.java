package TN_Automation;
import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProductSearchTest extends BaseTest {
    private static final String baseUrl = "https://tutorialsninja.com/demo/";

    @Test
    public void explicitWaitTest() throws InterruptedException {
        initializeWebDriver();
        DemoSearch();
    }
    public static void DemoSearch(){
        driver.get(baseUrl); // navigate to  page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#search > input[name='search']")));
        searchBox.sendKeys("macbook");
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-search\n")));
        searchButton.click();
    }
}
