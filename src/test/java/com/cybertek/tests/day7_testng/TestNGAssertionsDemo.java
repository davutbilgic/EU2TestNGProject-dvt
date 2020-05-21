package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    //Assert --> this is the class in testing, it has methods used to do assertions like when we compare values
/*
Assert.assertEquals(actual,expected)-->it checks two value same or not

Assert.assertTrue(condition) --> it checks whatever condition return true or not

Assert.assertFalse(condition) --> it checks whatever condition return false or not

Assert.assertNotEquals(actual,expected) -->verifies that two values are NOT equal to each other

we can add message all of our assertions to see what we are checking

Assert.assertTrue(condition,message)
Assert.assertEquals(actual,expected,message)
 */
    @Test
    public void test1(){
        System.out.println("First Assertion");

        //Assert.assertEquals(actual,expected)-->it checks two value same or not
        Assert.assertEquals("title","tiTle","verify title");

        System.out.println("Second Assertion");
        //Assert.assertEquals(actual,expected)-->it checks two value same or not
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        System.out.println("second test case");
        //Assert.assertEquals(actual,expected)-->it checks two value same or not
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle ="Cybertek";
        //verify that your title is starting with Cyb
        //Assert.assertTrue(condition) --> it checks whatever condition return true or not
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
        Assert.assertTrue(1>1,"i am checking is 2 greater than 1");
    }

    @Test
    public void test4(){
        //verify that email contains @
        String email = "mikesmith.com";
        Assert.assertTrue(email.contains("@"),"Verify email has @ sign");
    }

    @Test
    public void test5(){
        //verify something is false
        //Assert.assertFalse(condition) --> it checks whatever condition return false or not
        Assert.assertFalse(0>1,"verify that 0 is NOT greater than 1");
    }

    @Test
    public void test6(){
        //Assert.assertNotEquals(actual,expected) -->verifies that two values are NOT equal to each other
        Assert.assertNotEquals("one","two");
    }

}
