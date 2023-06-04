package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Extend_BeforeAndAfterMethods {
    public static WebDriver driver;//declaration

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver
        driver = new ChromeDriver(); // Launch a Chrome driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }
}
