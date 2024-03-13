package Miscellaneous;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HttpCertification extends BaseTest {
    private static final String baseUrl = "https://www.cacert.org/";

    @Test
    public void testHttpCertification() {
        ignoreHttpsCertification();
    }
    public static void ignoreHttpsCertification() {
        // Chrome
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(baseUrl);

    }
}
