package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocatorDemo {

    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//
//        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//
//        WebElement button2 = driver.findElement(By.xpath("//button[2]"));
//
//        button2.click();


        /**
         * TASK
         * go to amazon.com
         * search for selenium
         * click search button
         * print 1-48 of 304 results for "selenium"
         *
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");
        Thread.sleep(2000);
        //finding search button and clicking directly
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("result.getText() = " + result.getText());

    }

}
