package TN_Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Registration_Test {
    private static final String baseUrl = "https://tutorialsninja.com/demo/index.php";

    // Function to generate a random email address
    private static String randomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate a random username
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            email.append(allowedChars.charAt(randomIndex));
        }

        // Append a domain name
        email.append("@gmail.com");

        return email.toString();
    }


    public static void main(String[] args) {
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
        email.sendKeys(randomEmail());
        telephone.sendKeys("123456");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacy.click();
        continueButton.click();
    }
}
