package TN_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class LoginTest extends BaseTest {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";

    public static void main(String[] args) throws IOException {
        initializeWebDriver();
        loginUser();
        tearDown();
    }

    private static void loginUser() throws IOException {
        driver.get(baseUrl +"?route=account/login"); // navigate to login page

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"].btn.btn-primary"));

        email.sendKeys(Common.getTextFromFile("src/test/java/TN_Automation/users.txt"));
        password.sendKeys("123456");
        loginButton.click();
    }

}
