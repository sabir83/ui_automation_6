package testng_knowledge;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class _03_IgnoringTest {

    @Test
    public void test1() {

        System.out.println("This is test1");
    }
    @Ignore // this test won't execute
    @Test
    public void test2() {

        System.out.println("This is test2");
    }

    @Test(enabled = false) // makes it ignored. it won't execute
    public void test3() {
        System.out.println("This is test3");
    }
}