package EndToEnd;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageAllLinks extends BaseTest {
    private static final String baseUrl = "https://the-internet.herokuapp.com/checkboxes";

    @Test
    public void pageAllLinksTest(){
        initializeWebDriver();
        getAllLinks();
        tearDown();
    }
    public static void getAllLinks(){
        driver.get(baseUrl);

        // find all the links
        List <WebElement> links = driver.findElements(By.tagName("a"));
        int linksCount = links.size();
        System.out.println("Total Number of Links = "+linksCount);

        // open each link in new tab
        for(WebElement link : links) {
            String linkUrl = link.getAttribute("href");
            System.out.println(linkUrl);

            if(linkUrl != null && !linkUrl.isEmpty()){
                //open link i new tab
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.open(arguments[0])",linkUrl);
            }
        }
    }
}