package TN_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;


public class Registration_Test {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";
    private static final String newEmail = Common.randomEmail();


    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();  // maximize window size
        driver.get(baseUrl +"?route=account/register"); // navigate to register page

        WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement telephone = driver.findElement(By.cssSelector("#input-telephone"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement confirmPassword = driver.findElement(By.cssSelector("#input-confirm"));
        WebElement privacy = driver.findElement(By.cssSelector("input[name='agree']"));
        WebElement continueButton = driver.findElement(By.cssSelector(".btn-primary"));

        firstName.sendKeys("Test first name");
        lastName.sendKeys("Test last name");
        email.sendKeys(newEmail);
        Common.writeFile("src//main//java//TN_Automation//users.txt",newEmail);
        telephone.sendKeys("123456");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacy.click();
        continueButton.click();

        driver.quit();
    }
}
