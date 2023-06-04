package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Waiter;

public class _08_TGWaitsTest extends Base {

    @BeforeMethod
    public static void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-4")).click();
    }

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Waits" card
    Click on the "Click on me to see a red box" button
    Validate that a red box is displayed
     */
    @Test
    public static void waitForRedBox() {
        WebElement redBox = driver.findElement(By.id("red"));
        redBox.click();
        WebElement redBoxDisplayed = driver.findElement(By.cssSelector("button[class*='red_box']"));
        Assert.assertTrue(redBoxDisplayed.isDisplayed());
    }

    @Test
    public static void waitForBlueBox() {
        WebElement blueBox = driver.findElement(By.id("blue"));
        blueBox.click();
        WebElement blueBoxDisplayed = driver.findElement(By.cssSelector("button[class*='blue_box']"));

        Waiter.waitForVisibilityOfElement(blueBoxDisplayed, 40);

        Assert.assertTrue(blueBoxDisplayed.isDisplayed());
    }
}