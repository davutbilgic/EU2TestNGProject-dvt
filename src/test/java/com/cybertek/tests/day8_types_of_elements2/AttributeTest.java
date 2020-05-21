package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));

        //get the value of type attribute
        System.out.println(blueRadioButton.getAttribute("type"));
        //get the value of name attribute
        System.out.println(blueRadioButton.getAttribute("name"));
        //get the value of checked

        //since checked attribute does not keep any value it will return true or false based on the condition
        System.out.println(blueRadioButton.getAttribute("checked"));


        //trying to get attribute does not exist
        //when we use non exist attribute it will return NULL to us.
        System.out.println(blueRadioButton.getAttribute("href"));

        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        driver.quit();

    }
}