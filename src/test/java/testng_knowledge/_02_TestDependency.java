package testng_knowledge;

import org.testng.annotations.Test;

public class _02_TestDependency {

    @Test(priority = 2, dependsOnMethods = "test2") // even priority is 2 it will execute after test 2 as test 3.
    public void test1(){
        System.out.println("This is test1");
    }
    @Test(priority = 3)
    public void test2(){
        System.out.println("This is test2");
    }
    @Test(priority = 1, dependsOnMethods = "test1")
    public void test3(){
        System.out.println("This is test3");

        // print result is 2-1-3
    }


}
