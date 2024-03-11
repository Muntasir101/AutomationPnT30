package TN_Automation;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductOrderTest extends BaseTest{
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Test
    public void priceTest(){
        initializeWebDriver();
        productPriceTest();
        tearDown();
    }

    public static void productPriceTest(){
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement macBookAddToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content [class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']:nth-of-type(1) .hidden-md")));
        macBookAddToCartButton.click();

        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-inverse")));
        cartButton.click();

        WebElement viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a:nth-of-type(1) > strong")));
        viewCart.click();

        String macExpectedUnitPrice = "$602.00";

        WebElement macUnitPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table.table-bordered > tbody > tr > td:nth-of-type(5)")));
        String macActualUnitPrice =  macUnitPrice.getText();

        if(macExpectedUnitPrice.equals(macActualUnitPrice)){
            System.out.println("Unit price match.Test Passed.");
        }
        else{
            System.out.println("Unit price not match.Test Failed.");
        }

    }
}
