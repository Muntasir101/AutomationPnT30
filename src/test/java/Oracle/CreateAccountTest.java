package Oracle;


import JunitTest.Common;
import TN_Automation.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class CreateAccountTest extends BaseTest {
    private static final String accountCreateUrl = "https://profile.oracle.com/myprofile/account/create-account.jspx";

    @Test
    public void AccountCreateTestValid() throws IOException, InterruptedException {
        /*
        Valid Test Suite
         */
        initializeWebDriver();
        accountCreateTestCase01();
        //tearDown();
    }
    private static void accountCreateTestCase01() throws IOException, InterruptedException {
        /*
        This is valid Test Case
         */
        driver.get(accountCreateUrl); // navigate to login page
        Thread.sleep(5000);

        WebElement email = driver.findElement(By.cssSelector("input[name='sView1:r1:0:email']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='sView1:r1:0:password']"));
        WebElement reTypePassword = driver.findElement(By.cssSelector("input[name='sView1:r1:0:retypePassword']"));
        WebElement countryDropDown = driver.findElement(By.cssSelector("select[name='sView1:r1:0:country']"));


        email.sendKeys("test@mail.com");
        Thread.sleep(2000);
        password.click();
        password.sendKeys("if^z*{0-5P&6");
        Thread.sleep(2000);
        reTypePassword.click();
        reTypePassword.sendKeys("if^z*{0-5P&6");

        Select objSelect = new Select(countryDropDown);
        List<WebElement> countyCount = objSelect.getOptions();
        System.out.println("Total Country: " + countyCount.size());
        // verify country count
        Assert.assertEquals(243, countyCount.size());
        //Select County: Australia
        objSelect.selectByVisibleText("Australia");



    }
}
