package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
        String s1 = Singleton.getInstance();
        //100 lines of code
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);//
        System.out.println("s2 = " + s2);//

    }


    @Test
    public void test1(){
        WebDriver driver = Driver.get();

        //driver.get("http://www.google.com");
        Driver.get().get("http://www.google.com");
        //driver  //
        //[Driver.get()]=[driver]
    }

    @Test
    public void test2(){
        //WebDriver driver = Driver.get();

        //driver.get("http://www.amazon.com");
        //driver.get("http://www.amazon.com");
        Driver.get().get(ConfigurationReader.get("url"));

    }
}