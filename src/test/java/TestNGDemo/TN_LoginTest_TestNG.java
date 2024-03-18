package TestNGDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;


import static TestNGDemo.BaseTest_For_TestNG.*;

public class TN_LoginTest_TestNG {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @BeforeMethod
    public void setUp() throws IOException {
        initializeWebDriver();
    }


    @Test(priority = 0, description = "Login Test Valid", successPercentage=100, timeOut= 5000)
    public void loginTestCase01() throws IOException {
        /*
        This is valid Test Case
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys(TestNGCommon.getTextFromFile("src/test/java/TutorialNinja/users.txt"));
        password.sendKeys("123456");
        loginButton.click();

        // verification by Logout Text
        WebElement LogoutLink = driver.findElement(By.cssSelector(".list-group .list-group-item:nth-of-type(13)"));
        String LogoutText = LogoutLink.getText();
       // Assert.assertEquals("Logout",LogoutText);

        // verification by URL
        String ExpectedAccountPageUrl = baseUrl +"?route=account/account";
        String ActualAccountPageUrl = driver.getCurrentUrl();
        //Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl);
        Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl,"Assertion Success.Test passed.");
    }

    @Test(priority = 1,description = "Login Test InValid")
    public void loginTestCase02() throws IOException {
        /*
        This is invalid Test Case.
        Email is Invalid but password valid
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys("invalidEmail@gmail.com"); // invalid Email
        password.sendKeys("123456"); // valid password
        loginButton.click();

        //verification by invalid email warning
        WebElement invalidEmailWarning = driver.findElement(By.cssSelector(".alert-dismissible"));
        String invalidEmailWarningText = invalidEmailWarning.getText();
        String ExpectedMessage = "Warning: No match for E-Mail Address and/or Password.";
       // Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",invalidEmailWarningText);
        Assert.assertEquals(ExpectedMessage,invalidEmailWarningText,"Assertion Success.Login Failed.");
    }

    @Test(priority = 3, description = "Login Test InValid")
    public void loginTestCase03() throws IOException {
        /*
        This is invalid Test Case.
        Email is valid but password invalid
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys(TestNGCommon.getTextFromFile("src/test/java/TutorialNinja/users.txt")); // email valid
        password.sendKeys("1111"); // password invalid
        loginButton.click();


        //verification by invalid email warning
        WebElement invalidEmailWarning = driver.findElement(By.cssSelector(".alert-dismissible"));
        String invalidEmailWarningText = invalidEmailWarning.getText();
        String ExpectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        // Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",invalidEmailWarningText);
        Assert.assertEquals(ExpectedMessage,invalidEmailWarningText,"Assertion Success.Login Failed.");

    }

    @Test(priority = 2, description = "Login Test InValid")
    public void loginTestCase04() throws IOException {
        /*
        This is invalid Test Case.
        Email is Invalid and password invalid
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys("super@cc.com"); // invalid email
        password.sendKeys("1"); // invalid password
        loginButton.click();


        //verification by invalid email warning
        WebElement invalidEmailWarning = driver.findElement(By.cssSelector(".alert-dismissible"));
        String invalidEmailWarningText = invalidEmailWarning.getText();
        String ExpectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        // Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",invalidEmailWarningText);
        Assert.assertEquals(ExpectedMessage,invalidEmailWarningText,"Assertion Success.Login Failed.");
    }

    @AfterMethod
    public void terminateTest(){
        tearDown();
    }

}
