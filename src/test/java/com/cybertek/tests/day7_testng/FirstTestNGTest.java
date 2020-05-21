package com.cybertek.tests.day7_testng;

import org.testng.annotations.Test;

public class FirstTestNGTest {

    //@Test--> this is an annotation, it means the method after this @Test is TestNG test method.
    // we can run testNg test methods.
    @Test
    public void test1(){
        System.out.println("Fist Test");
        //test code will come here
    }


    @Test
    public void test2(){
        System.out.println("Second Test");
        //test code will come here
    }
}
