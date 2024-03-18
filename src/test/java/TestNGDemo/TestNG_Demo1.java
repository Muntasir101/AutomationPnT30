package TestNGDemo;

import org.testng.annotations.*;

public class TestNG_Demo1 {

    @BeforeSuite
    public void setUpSuite(){
        System.out.println("Before Suite. Setup done.");
    }

    @BeforeTest
    public void  setUpTest(){
        System.out.println("Before Test. Setup done.");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before Class. Setup done.");
    }

    @BeforeMethod
    public void  setUp(){
        System.out.println("Before Method. Setup done.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method. Tear down done.");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After Class. Tear down done.");
    }
    @AfterTest
    public void tearDownTest(){
        System.out.println("After Test. Tear down done.");
    }
    @AfterSuite
    public void tearDownSuite(){
        System.out.println("After Suite. Tear down done.");
    }
}
