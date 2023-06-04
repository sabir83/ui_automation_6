package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _02_AppleTest {
    /*
    Go to https://www.apple.com/
    Validate its title is apple
    Validate its URL is https://www.apple.com/
     */

    public static WebDriver driver;//declaration
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver
        driver = new ChromeDriver(); // Launch a Chrome driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.apple.com/");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void validateTitleAndURL(){
        //Validate of title and URL
        System.out.println(driver.getTitle()); //Apple
        System.out.println(driver.getCurrentUrl());// https://www.apple.com/

        Assert.assertEquals(driver.getTitle(), "Apple");// assertion means validating
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.apple.com/");
    }
}
