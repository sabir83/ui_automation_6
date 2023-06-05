package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class _03_TGLocatorsTest extends Base{
    /*
    Test case 1:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Kiwi" paragraph
     */


    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/locators");

    }


    @Test
    public void validateKiwiParagraph() {
        WebElement kp = driver.findElement(By.id("item_kiwi"));
        Assert.assertTrue(kp.isDisplayed());
        Assert.assertEquals(kp.getText(), "Kiwi");
        Assert.assertTrue(kp.isEnabled());
    }

    /*
    Test case 2
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Orange" paragraph
     */
    @Test
    public void validateOrangeParagraph() {
        WebElement orange = driver.findElement(By.name("item_orange"));
        Assert.assertTrue(orange.isDisplayed());
        Assert.assertEquals(orange.getText(), "Orange");


        // Learning Purposes
        System.out.println(orange.getAttribute("id")); // empty
        System.out.println(orange.getAttribute("name")); // item_orange
        System.out.println(orange.getTagName());// p

        System.out.println(orange.getCssValue("font-size")); // 14.4px
        System.out.println(orange.getCssValue("color")); // rgba(105, 105, 105, 1)
        System.out.println(orange.getCssValue("line-height")); // 21.6px
        System.out.println(orange.getCssValue("font-family")); // Poppins, Helvetica, Arial, sans-serif
        System.out.println(orange.getCssValue("box-sizing")); // border-box

        // getText() vs getAttribute() vs getCssValue() vs getTagName()
        // getText() 			  : is used to read the visible text of the element
        // getAttribute(string)   : is used to read some attributes of the element
        // getCssValue(string)    : is used to read some css-style values
        // getTagName() 		  : is used to read the tag name of the element
    }

    /*
    Test case 3:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Grapes" paragraph
     */
    @Test
    public void validateGrapesParagraph() {
        WebElement grapes = driver.findElement(By.className("item_grapes"));
        Assert.assertTrue(grapes.isDisplayed());
        Assert.assertEquals(grapes.getText(), "Grapes");
    }

    /*
   Test case 4:
   Go to "https://techglobal-training.com/frontend/locators"
   Validate the "Kiwi", "Orange", "Grapes" paragraphs
    */
    @Test
    public void validateAllParagraphs() {

        List<WebElement> allParagraphs = driver.findElements(By.tagName("p"));// Kiwi, Orange, Grapes


        // System.out.println(allParagraphs.size()); // 5
        String[] expectedTexts = {"Kiwi", "Orange", "Grapes"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allParagraphs.get(i).isDisplayed());
            Assert.assertEquals(allParagraphs.get(i).getText(), expectedTexts[i]);
        }
    }

    /*
    Test case 5:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Red Apple" link (displayed and enabled)
    Validate it navigates user to the "https://en.wikipedia.org/wiki/Red_apple"
     */
    @Test
    public void validateRedAppleLink() {
        WebElement redApple = driver.findElement(By.linkText("Red Apple")); // one element
        Assert.assertTrue(redApple.isDisplayed());
        Assert.assertTrue(redApple.isEnabled());

        Assert.assertEquals(redApple.getAttribute("href"), "https://en.wikipedia.org/wiki/Red_apple");
        //redApple.click();
        //Assert.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Red_apple");
    }
    /*
    Test case 6:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Red Apple", "Green Apple" and "Pineapple" links (displayed and enabled and their text)
    Validate they navigate user to the "https://en.wikipedia.org/wiki/Red_apple", "https://en.wikipedia.org/wiki/Green_apple" and "https://en.wikipedia.org/wiki/Pineapple"
    */

    @Test
    public void validateAllLink() {
        List<WebElement> allLinks = driver.findElements(By.partialLinkText("pple")); // 3 links
        String[] expectedVTexts = {"Red Apple", "Green Apple", "Pineapple"};
        String[] expectedLinks = {"https://en.wikipedia.org/wiki/Red_apple", "https://en.wikipedia.org/wiki/Green_apple", "https://en.wikipedia.org/wiki/Pineapple"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allLinks.get(i).isDisplayed());
            Assert.assertTrue(allLinks.get(i).isEnabled());
            Assert.assertEquals(allLinks.get(i).getText(), expectedVTexts[i]);
            Assert.assertEquals(allLinks.get(i).getAttribute("href"), expectedLinks[i]);
        }
    }
}
