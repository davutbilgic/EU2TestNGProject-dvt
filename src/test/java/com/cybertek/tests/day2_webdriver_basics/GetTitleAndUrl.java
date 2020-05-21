package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

/*        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com");
        
        driver.navigate().to("https://facebook.com");

        //getting title with selenium4
        String title = driver.getTitle();//short cut ALT + Enter + Enter
        System.out.println("title = " + title);//soutv + enter to print variable


        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource-->gets the source code of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



    }
}
