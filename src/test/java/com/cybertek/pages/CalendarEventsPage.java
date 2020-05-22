package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    //I added this for test1(), TestCase3
    @FindBy(xpath = "//div[@href='#']")
    public WebElement options;

    //I added this for test2(), TestCase3
    @FindBy(xpath = "//input[@value='1']")
    public WebElement pageNumber;

    //I added this for test3(), TestCase3
    @FindBy(css = "button[data-toggle='dropdown'][class='btn dropdown-toggle ']")
    public WebElement pageNumber25;

}