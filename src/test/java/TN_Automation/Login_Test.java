package TN_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;

public class Login_Test {

    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";

    private static WebDriver driver;

    public static void main(String[] args) throws IOException {
        initializeWebDriver();
        loginUser();
        tearDown();
    }
    private static void initializeWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // maximize window size
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
    private static void tearDown() {
        if(driver != null){
            driver.quit();
        }
        else{
            System.out.println("No Driver found.");
        }

    }
}
