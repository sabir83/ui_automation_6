package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Project2 extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test
    public void case01(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        usernameInputBox.isDisplayed();

        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        passwordInputBox.isDisplayed();

        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.isDisplayed();
        loginButton.isEnabled();
        Assert.assertEquals(loginButton.getText(), "LOGIN");

        WebElement forgotPasswordLink = driver.findElement(By.xpath("//button[@type='submit']/..//a"));
        forgotPasswordLink.isDisplayed();
        forgotPasswordLink.isEnabled();
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");
    }
    @Test
    public void case02(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        passwordInputBox.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement successMessage = driver.findElement(By.id("success_lgn"));
        Assert.assertEquals(successMessage.getText(), "You are logged in");

        WebElement logOut = driver.findElement(By.id("logout"));
        Assert.assertEquals(logOut.getText(), "LOGOUT");

    }
    @Test
    public void case03(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        passwordInputBox.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement logOut = driver.findElement(By.id("logout"));
        logOut.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".is-size-2"));
        Assert.assertTrue(loginForm.isDisplayed());
    }
    @Test
    public void case04(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//button[@type='submit']/..//a"));
        forgotPasswordLink.click();

        WebElement modalHeading = driver.findElement(By.id("modal_title"));
        Assert.assertTrue(modalHeading.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector(".delete"));
        Assert.assertTrue(closeButton.isDisplayed());

        WebElement resetLabel = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement resetInputBox = driver.findElement(By.id("email"));
        Assert.assertEquals(resetLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }
    @Test
    public void case05(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//button[@type='submit']/..//a"));
        forgotPasswordLink.click();

        WebElement modalSubHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertTrue(modalSubHeading.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector(".delete"));
        closeButton.click();

        Assert.assertFalse(modalSubHeading.isDisplayed()); // gives error

    }
    @Test
    public void case06(){


        WebElement forgotPasswordLink = driver.findElement(By.xpath("//button[@type='submit']/..//a"));
        forgotPasswordLink.click();

        WebElement resetLabel = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement resetInputBox = driver.findElement(By.id("email"));
        resetInputBox.sendKeys("abc@gmail.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(confirmationMessage.getText(), "A link to reset your password has been sent to your email address.");
    }
    @Test
    public void case07(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }
    @Test
    public void case08(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        usernameInputBox.sendKeys("John");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        passwordInputBox.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");

    }
    @Test
    public void case09(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        passwordInputBox.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Password entered!");
    }
    @Test
    public void case10(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        usernameInputBox.sendKeys("John");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        passwordInputBox.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }
}
