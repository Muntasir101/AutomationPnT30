package TutorialNinja_DataProviderScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class TN_ProductSearch_DP {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";
    static WebDriver driver;

    @BeforeMethod
    @Parameters("browserName")
    public void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Reporter.log("Chrome browser is launched");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            Reporter.log("Firefox browser is launched");
        }else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            Reporter.log("EDGE browser is launched");
        }
        else{
            System.out.println("Unsupported Browser !!!");
            Reporter.log("Unsupported Browser !!!");
        }
    }

    @Test(dataProvider = "ProductSearchTestData_valid")
    public void productSearchTest(String dp_productName) throws IOException {
        /*
        This is valid Test Case
         */
        driver.get(baseUrl); // navigate to login page
        Reporter.log("Homepage open");

        WebElement searchBox = driver.findElement(By.cssSelector(".form-control"));
        WebElement searchButton = driver.findElement(By.cssSelector(".fa-search"));

        searchBox.sendKeys(dp_productName);
        Reporter.log("Name of product: " + dp_productName);
        searchButton.click();
        Reporter.log("Search Button Clicked");

        // verification by Product Name searched
        WebElement searchResult = driver.findElement(By.cssSelector("div#content > h1"));
        String searchResultText = searchResult.getAttribute("value");

        Reporter.log("Verification by Product Text: "+ searchResultText);

/*
        WebElement ProductLink = driver.findElement(By.linkText("MacBook"));
        String ProductText = ProductLink.getText();
        Reporter.log("Verification by Product Text: "+ ProductText);
        //Capture screenshot
        captureScreenshot("DataProviderSearchTest");
*/

        // Add screenshot to Report
        String screenShotPath = "Screenshots/DataProviderSearchTest.png";
        Reporter.log("<a href='" + screenShotPath + "' target ='_blank' >View Screenshot</a>");

        // Add image in report in small size
        Reporter.log("<img src ='"+ screenShotPath + "' width='200' height = '150' />");

        // verification by URL
        //String ExpectedAccountPageUrl = baseUrl;
                //+"?route=account/account";
        //String ActualAccountPageUrl = driver.getCurrentUrl();
        //Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl);
        //Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl,"Assertion Success.Test passed.");
    }

    @AfterMethod
    public void terminateTest(){
        if(driver != null){
            driver.quit();
            Reporter.log("Test Complete");
        }
        else{
            Reporter.log("No Driver found.");
        }
    }
    @DataProvider(name = "ProductSearchTestData_valid")
    public Object[][] loginData(){
        return new Object[][]{
                {"Macbook"},
                {"iPhone"}
        };
    }
    protected static void captureScreenshot(String screenShotName) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("test-output/Screenshots/"+screenShotName+".png"),true);
    }

}
