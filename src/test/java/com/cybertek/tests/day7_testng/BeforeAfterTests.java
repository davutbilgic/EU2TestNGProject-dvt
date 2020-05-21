package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {

    @Test
    public void test1() throws Exception{

        System.out.println("This is my test 1");

        //close browser, quit
    }

    @Ignore//@Ignore --> we can put on top of the @Test that we want to ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
    }


    //@BeforeMethod -->runs once before each method with @Test annotations
    @BeforeMethod
    public void setUp(){
        //WebDriver part
        System.out.println("BEFORE METHOD HERE");
        System.out.println("WebDriver Part");
    }

    //@AfterMethod --> runs once after each method with @Test annotations
    @AfterMethod
    public void tearDown(){
        //close browser, quit
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver quit");
    }

    //@BeforeClass --> runs only once before everything in the class
    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
    }

    //@AfterClass --> runs only once after everything in the class
    @AfterClass
    public void afterClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
        System.out.println("GENERATE REPORT");
    }


}

//NOTE:Whatever your test case fail or not , your before and after method will executed always.
// So even if your code fails, you can quit from your driver.