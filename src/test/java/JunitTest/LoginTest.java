package JunitTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginTest extends BaseTest {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Test
    public void LoginTestValid() throws IOException {
        /*
        Valid Test Suite
         */
        initializeWebDriver();
        loginTestCase01();
        tearDown();
    }
    @Test
    public void LoginTestInValid() throws IOException {
        /*
         InValid Test Suite
         */
        initializeWebDriver();
        loginTestCase02();
        tearDown();

        initializeWebDriver();
        loginTestCase03();
        tearDown();

        initializeWebDriver();
        loginTestCase04();
        tearDown();
    }


    private static void loginTestCase01() throws IOException {
        /*
        This is valid Test Case
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys(Common.getTextFromFile("src/test/java/TN_Automation/users.txt"));
        password.sendKeys("123456");
        loginButton.click();

        // verification by Logout Text
        WebElement LogoutLink = driver.findElement(By.cssSelector(".list-group .list-group-item:nth-of-type(13)"));
        String LogoutText = LogoutLink.getText();
        Assert.assertEquals("Logout",LogoutText);

        // verification by URL
        String ExpectedAccountPageUrl = baseUrl +"?route=account/account";
        String ActualAccountPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedAccountPageUrl,ActualAccountPageUrl);
    }
    private static void loginTestCase02() {
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
    }
    private static void loginTestCase03() throws IOException {
        /*
        This is invalid Test Case.
        Email is valid but password invalid
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys(Common.getTextFromFile("src/test/java/TN_Automation/users.txt")); // email valid
        password.sendKeys("1111"); // password invalid
        loginButton.click();
    }
    private static void loginTestCase04() throws IOException {
        /*
        This is invalid Test Case.
        Email is Invalid and password invalid
         */
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys("mail.com"); // invalid email
        password.sendKeys("1"); // invalid password
        loginButton.click();
    }

}
