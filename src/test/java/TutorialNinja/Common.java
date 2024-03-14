package TutorialNinja;

import java.io.*;
import java.util.Random;

public class Common {
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
