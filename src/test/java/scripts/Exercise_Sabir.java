package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Exercise_Sabir extends Base{

    @BeforeMethod
    public static void setPage(){
       driver.get("https://www.etsy.com/");
    }
    @Test
    public static void validateEtsy(){
        WebElement etsy = driver.findElement(By.cssSelector("a[class='wt-display-table wt-width-full wt-text-link-no-underline']>span"));
        Assert.assertTrue(etsy.isDisplayed());
        Assert.assertEquals(etsy.getText(), "Home Favorites");
        Assert.assertTrue(etsy.isEnabled());
        etsy.click();

        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("girl's party dresses" + Keys.ENTER);


    }
    @Test
    public static void validateEtsy2(){
        WebElement etsy2 = driver.findElement(By.cssSelector("p[class^='wt-text-title-01']"));
        Assert.assertTrue(etsy2.isDisplayed());
        Assert.assertEquals(etsy2.getText(), "Unique Gifts for Dad");
        etsy2.click();

        driver.navigate().back();


        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("stitchedbypicky");

        WebElement companySearchBox = driver.findElement(By.cssSelector("span[class='normal shop-suggestion-item']"));
        companySearchBox.click();

        WebElement companyA = driver.findElement(By.cssSelector("a[class^='wt-card__link']"));
        companyA.click();

    }
    @Test
    public static void validateEtsy3(){
        WebElement etsy3 = driver.findElement(By.id("catnav-primary-link-10855"));
        Assert.assertTrue(etsy3.isDisplayed());
        Assert.assertEquals(etsy3.getText(), "Jewelry & Accessories");

        WebElement menu1 = driver.findElement(By.id("side-nav-category-link-10883"));
        Assert.assertFalse(menu1.isDisplayed());
        Assert.assertEquals(menu1.getText(), "Rings");

        WebElement menu2 = driver.findElement(By.id("catnav-l3-10887"));
        menu2.click();



        WebElement menu3 = driver.findElement(By.id("p[class^='hobby-title-custom-size']"));
        Assert.assertTrue(menu3.isDisplayed());
        Assert.assertEquals(menu3.getText(), "Minimalist");
        menu3.click();


    }


    }
    // (//h3[@class='Xpath_subheader__VOtsU'])[1]/../ul/li[1] -- locate Java ->Xpath-CSS Locators page of training

// hobby-title-custom-size wt-text-title-01 truncate_after_two_lines