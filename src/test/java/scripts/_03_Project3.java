package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;

public class _03_Project3 extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get(" https://techglobal-training.com/frontend/project-3");
        project3Page = new Project3Page();
    }

    @Test
    public void test1(){
        Assert.assertTrue(project3Page.oneWayButtonInput.isDisplayed());
        Assert.assertTrue(project3Page.oneWayButtonInput.isEnabled());
        Assert.assertTrue(project3Page.oneWayButtonInput.isSelected());

        Assert.assertTrue(project3Page.roundTripButtonInput.isDisplayed());
        Assert.assertTrue(project3Page.roundTripButtonInput.isEnabled());
        Assert.assertFalse(project3Page.roundTripButtonInput.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.datePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertFalse(project3Page.returnDatePicker.isEnabled());

        Assert.assertTrue(project3Page.numberOfPassengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerDropdown.isDisplayed());
        Assert.assertEquals(project3Page.passengerDropdown.getAttribute("value"), "1");


    }

    @Test
    public void test2(){
        Assert.assertTrue(project3Page.oneWayButtonInput.isDisplayed());
        Assert.assertTrue(project3Page.oneWayButtonInput.isEnabled());
        Assert.assertTrue(project3Page.oneWayButtonInput.isSelected());

        Assert.assertTrue(project3Page.roundTripButtonInput.isDisplayed());
        Assert.assertTrue(project3Page.roundTripButtonInput.isEnabled());
        Assert.assertFalse(project3Page.roundTripButtonInput.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.datePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertFalse(project3Page.returnDatePicker.isEnabled());

        Assert.assertTrue(project3Page.numberOfPassengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerDropdown.isDisplayed());
        Assert.assertEquals(project3Page.passengerDropdown.getAttribute("value"), "1");

    }
}
