package TestNGDemo;

import TutorialNinja.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class CrossBrowserTest {
    WebDriver driver;


    @BeforeMethod @Parameters("browserName")
    public void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Chrome browser is launched");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            System.out.println("Firefox browser is launched");
        }else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            System.out.println("EDGE browser is launched");
        }
        else{
            System.out.println("Unsupported Browser !!!");
        }
    }
    @Test
    public void registerUser() throws IOException {
        String newEmail = Common.randomEmail();
        try{
            System.out.println("Test start");
            driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");// navigate to register page
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
            Common.writeFile("src/test/java/TutorialNinja/users.txt",newEmail);
            telephone.sendKeys("123456");
            password.sendKeys("123456");
            confirmPassword.sendKeys("123456");
            privacy.click();
            continueButton.click();
        }
        catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }
    }
    @AfterMethod
    public void terminateTest(){
        if(driver != null){
            driver.quit();
            System.out.println("Test Complete");
        }
        else{
            System.out.println("No Driver found.");
        }
    }
}
