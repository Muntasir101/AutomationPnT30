package Miscellaneous;

import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyCustom {
    private static final String baseUrl = "https://www.google.com/";

    @Test
    public void testProxy() {
        setupProxy();
    }
    public static void setupProxy() {
        //Create proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("http-proxy-url:port"); // (http://localhost.com:8888)
        proxy.setSslProxy("https-proxy-url:port");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // set proxy capabilities
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        // Chrome
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(baseUrl);

    }
}
