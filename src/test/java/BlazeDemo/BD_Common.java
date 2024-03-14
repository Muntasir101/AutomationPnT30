package BlazeDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Random;

public class BD_Common {
    public static String randomUsername() {
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

    public static String handleAlert(WebDriver driver, Alert alert){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        String alertTxt = alert.getText();
        alert.accept();
        return alertTxt;
    }
    public static String randomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate a random username
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            email.append(allowedChars.charAt(randomIndex));
        }

        // Append a domain name
        email.append("@gmail.com");

        return email.toString();
    }
    public static void writeFile(String filePath, String content) throws IOException {
        // Create a BufferedWriter to write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the content to the file
            writer.write(content);
        } catch (IOException e) {
            // Handle any errors that may occur during writing
            throw e; // Rethrow the exception to be handled by the caller
        }
    }

    public static String getTextFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        reader.close();
        return line;
    }
}
