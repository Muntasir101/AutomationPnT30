package Miscellaneous;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.basic.BasicMenuUI;
import java.util.Set;

public class CookieManage {
    @Test
    public void CookieTest(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

        // Adds the cookie into current browser context
        driver.manage().addCookie(new Cookie("OCSESSID", "1d3ef251b61f75be70e82289fb"));
        driver.navigate().refresh();

        // Get All available cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Total Cookies: " + cookies.size());
        System.out.println("Cookies:");
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }

        driver.manage().deleteCookieNamed("currency");
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("Total Cookies after Delete one: " + cookies2.size());
        System.out.println("Cookies:");
        for (Cookie cookie : cookies2) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }

        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println("Total Cookies after Delete all: " + cookies3.size());
        System.out.println("Cookies:");
        for (Cookie cookie : cookies3) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }

    }

}
