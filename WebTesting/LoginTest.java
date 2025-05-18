package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/login");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        driver.findElement(By.id("loginButton")).click();
        boolean isDashboard = driver.getCurrentUrl().contains("dashboard");
        assert isDashboard;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
