package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Allstate2 extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://www.allstate.com/");
    }

    @Test
    public void validateRentersLabel(){
        WebElement renters = driver.findElement(By.id("lbl--renters"));
        renters.click();

    }
}
