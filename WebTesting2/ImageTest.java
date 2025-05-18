import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class HomeBackgroundImageTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "path/to/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyBackgroundImagesDisplayed() {
        driver.get("file:///path/to/your/project/Home.html");

        boolean vegFound = true;
        boolean nonVegFound = true;

        try {
            WebElement vegImg = driver.findElement(By.xpath("//img[contains(@src,'Veg.jpg')]"));
            if (!vegImg.isDisplayed()) {
                vegFound = false;
                System.err.println("❌ Veg.jpg is not displayed on the page.");
            }
        } catch (NoSuchElementException e) {
            vegFound = false;
            System.err.println("❌ Veg.jpg not found in the DOM.");
        }

        try {
            WebElement nonVegImg = driver.findElement(By.xpath("//img[contains(@src,'Non-veg.jpg')]"));
            if (!nonVegImg.isDisplayed()) {
                nonVegFound = false;
                System.err.println("❌ Non-veg.jpg is not displayed on the page.");
            }
        } catch (NoSuchElementException e) {
            nonVegFound = false;
            System.err.println("❌ Non-veg.jpg not found in the DOM.");
        }

        assert vegFound && nonVegFound : "❌ One or both background images are not displayed.";
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
