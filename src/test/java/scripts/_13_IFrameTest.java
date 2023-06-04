package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _13_IFrameTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }
    /*
    TEST CASE
    Got to https://techglobal-training.com/frontend/iframes
    Validate the "Please fill out your information below" paragraph
     */

    @Test(priority = 1, description = "TC123: Validate the IFrame Page content paragraph")
    public void validateTheParagraph(){
        //WebElement iframe = driver.findElement(By.id("form_frame"));
        //driver.switchTo().frame(iframe);

        //driver.switchTo().frame(0);
        driver.switchTo().frame("form_frame");// best way - more secure
        WebElement paragraph = driver.findElement(By.cssSelector("#mountHere p"));
        Assert.assertTrue(paragraph.isDisplayed());
        Assert.assertEquals(paragraph.getText(), "Please fill out your information below");
    }
    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Enter name as "John"
    Enter last name as "Doe"
    Click on "SUBMIT" button
    Validate that the Result is "You entered: John Doe"
      */

    @Test(priority = 2, description = "TC345 Validate the form submission")
    public void validateTheFormSubmission(){

        driver.switchTo().frame("form_frame");
        WebElement form1 = driver.findElement(By.id("first_name"));
        form1.sendKeys("John");

        WebElement form2 = driver.findElement(By.id("last_name"));
        form2.sendKeys("Doe");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        driver.switchTo().defaultContent();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(), "You entered: John Doe");

    }


}
