package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.IOException;


public class DataProviderTest {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";
    WebDriver driver;

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

    @Test(dataProvider = "LoginTestData_valid")
    public void loginTest(String dp_email, String dp_password) throws IOException {
        /*
        This is valid Test Case
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page
        Reporter.log("Login Page open");

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys(dp_email);
        Reporter.log("Enter Email");
        password.sendKeys(dp_password);
        Reporter.log("Enter Password");
        loginButton.click();
        Reporter.log("Login Button Clicked");

        // verification by Logout Text
        WebElement LogoutLink = driver.findElement(By.cssSelector(".list-group .list-group-item:nth-of-type(13)"));
        String LogoutText = LogoutLink.getText();
        Reporter.log("Verification by Logout Text: "+ LogoutText);
        // Assert.assertEquals("Logout",LogoutText);

        // verification by URL
        String ExpectedAccountPageUrl = baseUrl +"?route=account/account";
        String ActualAccountPageUrl = driver.getCurrentUrl();
        //Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl);
        Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl,"Assertion Success.Test passed.");
    }

    @AfterMethod
    public void terminateTest(){
        if(driver != null){
            driver.quit();
            System.out.println("Test Complete");
            Reporter.log("Test Complete");
        }
        else{
            System.out.println("No Driver found.");
            Reporter.log("No Driver found.");
        }
    }
    @DataProvider(name = "LoginTestData_valid")
    public Object[][] loginData(){
        return new Object[][]{
                {"mail123@gmail.com", "123456"},
                {"y07e0ctih4@gmail.com", "123456"}
        };
    }

}
