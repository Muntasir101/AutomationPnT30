package EndToEnd;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ValidateLinks extends BaseTest {
    @Test
    public void brokenLinkTest(){
        initializeWebDriver();
        verifyBrokenLinks();
        tearDown();
    }

    public static void verifyBrokenLinks(){
        driver.get("https://www.daraz.com.bd/");

        // find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int linksCount = links.size();
        System.out.println("Total Number of Links = "+linksCount);

        // iterate over each links and validate
        for(WebElement link : links){
            String url = link.getAttribute("href");
            if(url != null && !url.isEmpty()){
                try{
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();

                    if(responseCode >=400){
                        System.out.println("Broken Link found: " + url + " - Response code: "+responseCode);
                    }
                    else{
                        System.out.println("Valid link: "+ url + " - Response code: "+responseCode);
                    }
                    connection.disconnect();
                }
                catch (IOException e){
                    System.out.println("Error connecting to URL: "+ url);
                    e.printStackTrace();
                }
            }
        }
    }
}
