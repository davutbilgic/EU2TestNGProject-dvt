package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioBtnTest1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //how to check is radio button selected ?
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());//true
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());//false

        //verify blue is selected red is not selected
        Assert.assertTrue(blueRadioButton.isSelected(),"Verify Blue is selected");//assert vermicek
        Assert.assertFalse(redRadioButton.isSelected(),"Verify Red is NOT selected");//assert vermicek

        //how to select radio button ?
        //we use click method to select radio buttons
        redRadioButton.click();

        //verify blue is not selected red is selected
        Assert.assertFalse(blueRadioButton.isSelected(),"Verify Blue is NOT selected");//assert vermicek
        Assert.assertTrue(redRadioButton.isSelected(),"Verify Red is selected");//assert vermicek

        driver.quit();

    }
}
