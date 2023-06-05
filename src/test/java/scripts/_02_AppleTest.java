package scripts;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class _02_AppleTest extends Base{
    /*
    Go to https://www.apple.com/
    Validate its title is apple
    Validate its URL is https://www.apple.com/
     */


    @BeforeMethod
    public void setPage(){
        driver.get("https://www.apple.com/");
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
