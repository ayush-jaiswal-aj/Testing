package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class Test {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testFormValidationEmptyFields() {
        driver.get(getLocalPagePath("resources/Book.html"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Please correct the following errors"), "Alert message mismatch!");
        alert.accept();
    }

    @Test(priority = 2)
    public void testValidBookingFormSubmission() throws InterruptedException {
        driver.get(getLocalPagePath("resources/Book.html"));
        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("date")).sendKeys("2030-12-31");
        driver.findElement(By.id("time")).sendKeys("18:00");
        driver.findElement(By.cssSelector("input[name='persons'][value='2']")).click();
        driver.findElement(By.id("booking-for")).sendKeys("Birthday");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Booking submitted successfully"), "Success alert mismatch!");
        alert.accept();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String getLocalPagePath(String relativePath) {
        File file = new File(relativePath);
        return "file:///" + file.getAbsolutePath().replace("\\", "/");
    }
}
