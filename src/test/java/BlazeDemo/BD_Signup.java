package BlazeDemo;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BD_Signup extends BaseTest {
    private static final String baseUrl = "https://www.demoblaze.com/index.html";

    // Explicit wait
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void signupTest(){
        initializeWebDriver();
        userSignup();
        tearDown();
    }
    public static void userSignup(){
        driver.get(baseUrl);

        WebElement signupMenu = driver.findElement(By.linkText("Sign up"));
        signupMenu.click();

        // wait for the modal to appear
        WebElement signupModal = driver.findElement(By.id("signInModal"));

        // inside modal, locate username and password
        WebElement usernameInput = signupModal.findElement(By.id("sign-username"));
        usernameInput.clear();
        usernameInput.sendKeys(randomUsername());

        WebElement passwordInput = signupModal.findElement(By.id("sign-password"));
        passwordInput.clear();
        passwordInput.sendKeys("1234567");

        WebElement signupButton = signupModal.findElement(By.cssSelector("div#signInModal > div[role='document'] .btn.btn-primary"));
        signupButton.click();

    }
    private static String randomUsername() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        // Generate a random username
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            username.append(allowedChars.charAt(randomIndex));
        }
        return username.toString();
    }

}
