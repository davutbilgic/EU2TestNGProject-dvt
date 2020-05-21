package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class deneme {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }


    @Test
    public void test() throws InterruptedException {

        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("cybertek");
        searchbox.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//a[@href ='https://cybertekschool.com/']")).click();//bu da calisiyor
        driver.findElement(By.xpath("//h3[.='Cybertek']")).click();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://cybertekschool.com/";

        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
