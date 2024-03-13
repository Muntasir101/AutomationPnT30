package TN_Automation;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductOrderTest extends BaseTest {
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

        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        WebElement verificationMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#common-home > .alert.alert-dismissible.alert-success")));
        String actualSuccessMessage =  verificationMessage.getText();

        if(expectedSuccessMessage.equals(actualSuccessMessage)){
            System.out.println("Verification message match.Test Passed.");
        }
        else{
            System.out.println("Verification message not match.Test Failed.Actual Message:"+ actualSuccessMessage);
        }


        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-inverse")));
        cartButton.click();

        WebElement viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a:nth-of-type(1) > strong")));
        viewCart.click();

        String macExpectedUnitPriceText = "$602.00";
        // Remove the dollar sign
        String priceWithoutDollar = macExpectedUnitPriceText.replace("$", "");
        // Convert to double
        double macExpectedUnitPrice = Double.parseDouble(priceWithoutDollar);


        WebElement macUnitPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table.table-bordered > tbody > tr > td:nth-of-type(5)")));
        String macActualUnitPriceText =  macUnitPrice.getText();
        // Remove the dollar sign
        String macActualUnitPriceWithoutDollar = macActualUnitPriceText.replace("$", "");
        // Convert to double
        double macActualUnitPrice = Double.parseDouble(macActualUnitPriceWithoutDollar);

        if(macActualUnitPrice==macExpectedUnitPrice){
            System.out.println("Unit price match.Test Passed.");
        }
        else{
            System.out.println("Unit price not match.Test Failed.");
        }

        WebElement macQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-block .form-control")));
        String macActualQuantity = macQuantity.getAttribute("value");
        double quantityDouble = Double.parseDouble(macActualQuantity);


        double expectedTotalPrice = quantityDouble * macExpectedUnitPrice;

        WebElement macActualTotalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody > tr > td:nth-of-type(6)")));
        String macFinalTotalPriceText =  macActualTotalPrice.getText();
        // Remove the dollar sign
        String macFinalTotalPriceWithoutDollar = macFinalTotalPriceText.replace("$", "");
        // Convert to double
        double macFinalTotalPrice = Double.parseDouble(macFinalTotalPriceWithoutDollar);

        if(macFinalTotalPrice==expectedTotalPrice){
            System.out.println("Total price match.Test Passed.");
        }
        else{
            System.out.println("Total price not match.Test Failed.");
        }

    }
}