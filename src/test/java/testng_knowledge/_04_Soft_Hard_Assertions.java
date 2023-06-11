package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _04_Soft_Hard_Assertions {

    @Test
    public void test1(){
        // Hard assertion
        Assert.assertEquals("hello", "world");// test fails and not execute below print because hard assertion

        System.out.println("The rest of the test");
    }
    @Test
    public void test2(){
        // Soft assertion
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("hello", "world");// test fails but print the below message because of soft assertion.

        System.out.println("The rest of the test");

        softAssert.assertAll(); // this will attach all the soft assert failures to the reports
    }
}
