package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest extends Extend_BeforeAndAfterMethods{
    /*
    Go to https://www.google.com/
    Validate that the user see a search input box
     */

    @Test(priority = 2)
    public void validateSearchbar(){
        driver.get("https://www.google.com/");

        WebElement searchInputBox = driver.findElement(By.id("APjFqb"));
        Assert.assertTrue(searchInputBox.isDisplayed());

    }
        /*
      Go to https://www.google.com/
      Validate that the title is "Google"
      Validate that the URL is "https://www.google.com/"
       */
    @Test(priority = 1)
    public void validateTitleAndURL(){
        driver.get("https://www.google.com/");
        //Validate of title and URL
        System.out.println(driver.getTitle()); //Google
        System.out.println(driver.getCurrentUrl());// https://www.google.com/

        Assert.assertEquals(driver.getTitle(), "Google");// assertion means validating
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }
    /*
    Go to https://www.google.com/
    Refresh page
    Navigate to https://www.amazon.com/
    Navigate back
    Navigate forward
    Validate that the title is "Amazon.com. Spend less. Smile more."
     */
    @Test
    public void validateNavigattion() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/");//driver.get-navigate is faster

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");

    }
    /*
    Go to https://www.google.com/
    Validate that the user "Google Search" button
    Validate its text is "Google Search"
    Validate that it is clickable

    validateGoogleSearchButton
    */
    @Test
    public void validateGoogleSearchButton(){
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        Assert.assertTrue(searchBox.isDisplayed()); // make sure that it is visible
        System.out.println(searchBox.getAttribute("value")); // Google Search
        Assert.assertEquals(searchBox.getAttribute("value"), "Google Search");
        Assert.assertTrue(searchBox.isEnabled());
    }
}
