package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Project1 extends Base {
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate the heading is “Contact Us”
    Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
    Validate the email is “info@techglobalschool.com"
    Validate the phone number is “(773) 257-3010”
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test
    public void testCase1(){

        WebElement testHeading = driver.findElement(By.className("is-size-2"));
        WebElement testAddress = driver.findElement(By.id("address"));
        WebElement testEmail = driver.findElement(By.id("email"));
        WebElement testPhoneN = driver.findElement(By.id("phone-number"));

        Assert.assertEquals(testHeading.getText(), "Contact Us");

        Assert.assertEquals(testAddress.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");

        Assert.assertEquals(testEmail.getText(), "info@techglobalschool.com");

        Assert.assertEquals(testPhoneN.getText(), "(773) 257-3010");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Full name input box is displayed
    Validate that the Full name input box is required
    Validate that the label of the Full name input box is “Full name *”
    Validate that the placeholder of the Full name input box is “Enter your full name”
     */
    @Test
    public void testCase2(){

       WebElement fullName = driver.findElement(By.xpath("//div[@class='field']/label[1]"));
       Assert.assertTrue(fullName.isDisplayed());
       Assert.assertEquals(fullName.getAttribute("required"), "true");
       Assert.assertEquals(fullName.getText(), "Full name *");

       WebElement nameBox = driver.findElement(By.xpath("//div[@class='control']/input[1]"));
       Assert.assertEquals(nameBox.getText(), "Enter your full name");
    }

    /*
    Validate the label is “Gender”
    Validate that the Gender is required
    Validate the options are “Female”, “Male” and “Prefer not to disclose”
    Validate the options are clickable and not selected
    Click on the “Male” option and validate it is selected while the others are not selected
    Click on the “Female” option and validate it is selected while the others are not selected
     */

    @Test
    public void testCase3(){

        WebElement gender = driver.findElement(By.xpath("//div[@class='control']/label[1]"));
        Assert.assertFalse(Boolean.parseBoolean(gender.getAttribute("required")));

        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='control']/label"));
        List<WebElement> buttonsinput = driver.findElements(By.xpath("//div[@class='control']/input"));

        for (WebElement button : buttons) {
            Assert.assertTrue(button.isDisplayed());
            Assert.assertTrue(button.isEnabled());
            Assert.assertFalse(button.isSelected());
        }
        buttons.get(0).click();

    }

    @Test
    public void testCase4(){

    }

}
