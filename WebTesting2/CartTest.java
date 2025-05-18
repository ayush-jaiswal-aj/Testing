package Test2;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Test2 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCartCountUpdate() {
        driver.get("file:///project/Menu_SpiceHub.html");
        WebElement addItemBtn = driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        addItemBtn.click();
        driver.navigate().to("file:///project/Home.html");

        WebElement cartCount = driver.findElement(By.id("cart-count"));
        assert Integer.parseInt(cartCount.getText()) > 0;
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
