package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class ContactPageTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testBookNowButtonPresenceAndNavigation() throws InterruptedException {
        driver.get(getLocalPagePath("resources/Contact.html"));

        // Check if the "Book Now" button is displayed
        WebElement bookNowButton = driver.findElement(By.xpath("//button[contains(text(),'Book Now')]"));
        Assert.assertTrue(bookNowButton.isDisplayed(), "'Book Now' button is not displayed.");

        // Click the button
        bookNowButton.click();

        // Allow some time for redirection
        Thread.sleep(2000);

        // Assert redirection to Book.html
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("Book.html"), "Navigation to Book page failed!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Utility method to generate file:// path from local file
    private String getLocalPagePath(String relativePath) {
        File file = new File(relativePath);
        return "file:///" + file.getAbsolutePath().replace("\\", "/");
    }
}
