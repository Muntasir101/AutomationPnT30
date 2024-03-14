package BlazeDemo;

import Base.BaseTest;
import TutorialNinja.Common;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static BlazeDemo.BD_Common.handleAlert;
import static BlazeDemo.BD_Common.randomUsername;

public class BD_Signup extends BaseTest {
    private static final String baseUrl = "https://www.demoblaze.com/index.html";

    // Explicit wait
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static Alert alert;

    @Test
    public void signupTest() throws IOException {
        initializeWebDriver();
        userSignup();
        tearDown();
    }
    public static void userSignup() throws IOException {
        driver.get(baseUrl);

        WebElement signupMenu = driver.findElement(By.linkText("Sign up"));
        signupMenu.click();

        // wait for the modal to appear
        WebElement signupModal = driver.findElement(By.id("signInModal"));

        // inside modal, locate username and password
        WebElement usernameInput = signupModal.findElement(By.id("sign-username"));
        usernameInput.clear();
        usernameInput.sendKeys(randomUsername());
        Common.writeFile("src/test/java/BlazeDemo/bd_users.txt",randomUsername());

        WebElement passwordInput = signupModal.findElement(By.id("sign-password"));
        passwordInput.clear();
        passwordInput.sendKeys("1234567");

        WebElement signupButton = signupModal.findElement(By.cssSelector("div#signInModal > div[role='document'] .btn.btn-primary"));
        signupButton.click();

        // verify new user created by success message

        String successMessage = handleAlert(driver,alert);
        try {
            Assert.assertEquals(successMessage, "Sign up successful.");
            System.out.println("New user create success.");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
