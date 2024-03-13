package Miscellaneous;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;

public class AddPlugins {

    @Test
    public void addPluginsTest(){
       // To add a Packed extension
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/test/Plugins/ToDoIst.crx"));
        ChromeDriver driver = new ChromeDriver(chromeOptions);
    }
}
