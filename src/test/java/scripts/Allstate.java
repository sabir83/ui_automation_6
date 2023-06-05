package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WindowHandler;

public class Allstate extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.allstate.com/");
    }
    @Test
    public void validateTitleExploreButton(){
        System.out.println(driver.getTitle()); // Allstate Insurance Company | You're In Good Hands.
        Assert.assertEquals(driver.getTitle(), "Allstate Insurance Company | You're In Good Hands.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.allstate.com/");

        WebElement exploreButton = driver.findElement(By.id("cf128f7c-3b92-47e9-b84c-0e79dd302f4f-close-navpopup"));
        Assert.assertEquals(exploreButton.getText(), "Explore Allstate");
        exploreButton.click();

        WebElement roadsideService = driver.findElement(By.id("cf128f7c-3b92-47e9-b84c-0e79dd302f4f_fbf767ea-de9f-4dd7-83eb-8c8535cf733e_2b0829a5-8b87-4da5-bd1e-df78b6731679-explore-more_section-links"));
        Assert.assertEquals(roadsideService.getText(), "Roadside Service");
        roadsideService.click();

        WindowHandler.switchToChildWindow();
        WebElement roadsideServiceButton = driver.findElement(By.cssSelector(".header-name"));
        Assert.assertEquals(roadsideServiceButton.getText(), "Roadside Assistance");

        WebElement alert1 = driver.findElement(By.cssSelector(".c-alert__bd >b>span"));
        Assert.assertTrue(alert1.isDisplayed());

        WebElement membershipInputBox = driver.findElement(By.id("membershipNumber"));
        membershipInputBox.sendKeys("123456");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys("asdfg");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WindowHandler.switchToMainWindow();

    }
    @Test
    public void validateRentersLabel(){
        WebElement renters = driver.findElement(By.id("lbl--renters"));
        renters.click();

    }
//div[@class='zip-spacing']/..//input
}
