package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_TGStaticTableTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-11")).click();
    }
    /*
    Verify the headers of the table
    Go to https://techglobal-training.com/frontend/
    Click on the "Static Tables" card
    Check that the headers of the table are "Rank", "Company", "Employees", and "Country"
    Verify the rows of the table
     */
    @Test
    public void validateTableHeader(){
        List<WebElement> headers = driver.findElements(By.cssSelector("tr:nth-child(1) th"));
        String[] expectedHeaders ={"Rank", "Company", "Employees","Country"};

        for (int i = 0; i < expectedHeaders.length; i++) {
            Assert.assertEquals(headers.get(i).getText(),expectedHeaders[i]);
        }
    }
    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Static Tables" card
    Check that the first row of the table has the values "1", "Amazon", "1,523,000", and "USA"
    Verify the columns of the table
     */
    @Test
    public void validateFirstRow() {
       // List<WebElement> rows = driver.findElements(By.cssSelector("tr:nth-child(1) td"));
        List<WebElement> rows = TableHandler.getTableRow(1);
        String[] expectedHeaders = {"1", "Amazon", "1,523,000", "USA"};

        for (int i = 0; i < expectedHeaders.length; i++) {
            Assert.assertEquals(rows.get(i).getText(), expectedHeaders[i]);
        }
    }
    /*
     Go to https://techglobal-training.com/frontend/
     Click on the "Static Tables" card
     Check that the "Country" column of the table has the values "USA", "China", "USA", "USA", "S. Korea"
     Verify the entire table
     */
    @Test
    public void validateCountryRow(){
        // List<WebElement> countries = driver.findElements(By.cssSelector("td:nth-child(4)"));
        List<WebElement> countries = TableHandler.getTableColumn(4);
        String[] expectedHeaders = {"USA", "China", "USA", "USA", "S. Korea"};

        for (int i = 0; i < expectedHeaders.length; i++) {
            Assert.assertEquals(countries.get(i).getText(), expectedHeaders[i]);
        }
    }
    @Test
    public void validateEachCell() {
        WebElement mainTable = driver.findElement(By.id("company_table"));
        List<List<WebElement>> tableData = TableHandler.getTableData(mainTable);

        // Just to debug purposes, we don't need this
        //        for(List<WebElement> row: tableData){
        //            for(WebElement cell : row){
        //                System.out.println(cell.getText());
        //            }
        //        }

        List<List<String>> table = new ArrayList<>();
        table.add(Arrays.asList("1", "Amazon", "1,523,000", "USA"));    // 1st element of my list
        table.add(Arrays.asList("2", "Alibaba", "245,700", "China"));   // 2nd element of my list
        table.add(Arrays.asList("3", "Microsoft", "221,000", "USA"));   // 3rd element of my list
        table.add(Arrays.asList("4", "Apple", "154,000", "USA"));       // 4th element of my list
        table.add(Arrays.asList("5", "Samsung", "116,915", "S. Korea"));// 5th element of my list

        Assert.assertEquals(tableData.get(2).get(1).getText(), table.get(2).get(1));

        for (int i = 0; i < tableData.size(); i++) {
            for (int j = 0; j < tableData.get(i).size(); j++) {
                Assert.assertEquals(tableData.get(i).get(j).getText(), table.get(i).get(j));
            }
        }
    }
}
