package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Project3 extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
    }
    @Test
    public void test01(){
        List<WebElement> buttonLabels = driver.findElements(By.cssSelector(".is-flex label"));
        List<WebElement> buttonInput = driver.findElements(By.cssSelector(".is-flex input"));

        for (WebElement element : buttonInput) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            Assert.assertTrue(element.isSelected());
        }



    }
}
