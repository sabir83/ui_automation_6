package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _15_TGFileUpload extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-13")).click();
    }
    @Test
    public void fileUpload(){
        WebElement fileUploadButton = driver.findElement(By.id("file_upload"));
        fileUploadButton.sendKeys("/Users/sabirburcu/Desktop/UI Automation.docx");

        WebElement uploadButton = driver.findElement(By.id("file_submit"));
        uploadButton.click();
    }
    @Test
    public void fileUpload2(){
        WebElement fileUpload = driver.findElement(By.id("file_upload"));
        String filePath = "/Users/sabirburcu/IdeaProjects/ui_automation_6/hello.txt";
        fileUpload.sendKeys(filePath);

        WebElement uploadButton2 = driver.findElement(By.id("file_submit"));
        uploadButton2.click();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You Uploaded '" +
                filePath.substring(filePath.lastIndexOf('/')+1) + "'");
    }


}
