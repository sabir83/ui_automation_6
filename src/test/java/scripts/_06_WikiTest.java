package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _06_WikiTest extends Base {
    /*
    Go to "https://www.wikipedia.org/"
    Search for "Tesla"
    Validate the main header of the page is displayed and is "Tesla"
     */
    @BeforeMethod
    public void setPage() {
    driver.get("https://www.wikipedia.org/");
    }
    @Test
    public static void validateWikiSearch(){

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Tesla" + Keys.ENTER);

        WebElement mainHeader = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(mainHeader.getText(), "Tesla");
    }


}