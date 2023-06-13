package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AlertHandler;
import utils.Waiter;

public class _12_TGAlertsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-8")).click();
    }

    /**
     * WARNING ALERT
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Alerts" card
     * Click on the "Warning alert" button
     * Validate the alert text equals "You are on TechGlobal Training application."
     * Click on the "OK" button on the alert
     * Validate the result message equals "You accepted warning by clicking OK."
     */
    @Test
    public void warningAlert(){
        WebElement warningAlert = driver.findElement(By.id("warning_alert"));
        warningAlert.click();

        Waiter.pause(2);
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You are on TechGlobal Training application.");
        Waiter.pause(2);

        alert.accept();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You accepted warning by clicking OK.");
        Waiter.pause(2);

    }
    /**
    Click on the "Alerts" card
    Click on the "Confirmation alert" button
    Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
    Click on the "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on the "Confirmation alert" button again
    Click on the "OK" button on the alert
    Validate the result message equals "You confirmed the alert by clicking OK."
     */

    @Test
    public void confirmationAlert(){
        WebElement confirmationAlert = driver.findElement(By.id("confirmation_alert"));
        confirmationAlert.click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "Would you like to stay on TechGlobal Training application?");
        alert.dismiss();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You rejected the alert by clicking Cancel.");

        confirmationAlert.click();
        AlertHandler.acceptAlert();
        Assert.assertEquals(resultText.getText(), "You confirmed the alert by clicking OK.");


    }
    /**
    Go to https://techglobal-training.com/frontend/
    Click on the "Alerts" card
    Click on the "Prompt alert" button
    Validate the alert text equals "What would you like to say to TechGlobal?"
    Click on the "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on the "Prompt alert" button again
    Click on the "OK" button on the alert
    Validate the result message equals "You entered "" in the alert and clicked OK."
    Click on the "Prompt alert" button again
    Enter "Hello" to alert the input box
    Click on the "OK" button on the alert
    Validate the result message equals "You entered "Hello" in the alert and clicked OK."
     */
    @Test
    public void promptAlert(){
        WebElement promptAlert = driver.findElement(By.id("prompt_alert"));
        promptAlert.click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "What would you like to say to TechGlobal?");
        alert.dismiss();

        WebElement resultAlert = driver.findElement(By.id("action"));
        Assert.assertEquals(resultAlert.getText(), "You rejected the alert by clicking Cancel.");

        promptAlert.click();
        AlertHandler.acceptAlert();
        Assert.assertEquals(resultAlert.getText(), "You entered \"\" in the alert and clicked OK.");

        promptAlert.click();
        alert.sendKeys("Hello");
        AlertHandler.acceptAlert();
        Assert.assertEquals(resultAlert.getText(), "You entered \"Hello\" in the alert and clicked OK.");
    }

}
