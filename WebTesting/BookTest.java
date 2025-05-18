package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.time.Duration;

public class Test {

    public static void main(String[] args) {
        // Set path to EdgeDriver
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Load Book.html from local system
            File file = new File("resources/Book.html");
            String filePath = "file:///" + file.getAbsolutePath().replace("\\", "/");
            driver.get(filePath); 

            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();
            Thread.sleep(2000);

            driver.findElement(By.id("name")).sendKeys("John Doe");
            driver.findElement(By.id("phone")).sendKeys("9876543210");
            driver.findElement(By.id("email")).sendKeys("john@example.com");
            driver.findElement(By.id("date")).sendKeys("2030-12-31");
            driver.findElement(By.id("time")).sendKeys("18:30");
            driver.findElement(By.cssSelector("input[name='persons'][value='2']")).click();
            driver.findElement(By.id("booking-for")).sendKeys("Birthday");

            submitButton.click();
            Thread.sleep(2000);

            driver.switchTo().alert().accept();

            System.out.println("Test completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
