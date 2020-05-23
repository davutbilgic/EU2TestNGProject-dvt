package com.cybertek.pages;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@href='#']")
    public WebElement options;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement pageNumber;

    @FindBy(css = "button[data-toggle='dropdown'][class='btn dropdown-toggle ']")
    public WebElement viewPerPageNumber;

    @FindBy(xpath = "//button[@data-toggle='dropdown'][@class='btn dropdown-toggle ']")
    public WebElement viewPerPage;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement viewPerPageSelect100;

//    @FindBy(css = "tr.grid-row")
//    public WebElement rows;

    @FindBy(xpath = "//label[starts-with(text(), 'Total')]")
    public WebElement textOFnumberOfEvents;

    @FindBy(xpath = "//button[@data-toggle='dropdown']/input[@type='checkbox']")
    public WebElement checkboxClickableAll;


    public int calculateNumberOfEvents() {
        viewPerPage.click();
        viewPerPageSelect100.click();
        int selectedRowsNumber = Integer.parseInt(viewPerPageNumber.getText());

        String pathRows = null;
        int countPageNumber = 0;
        for (int i = 1; i <= selectedRowsNumber; i++) {
            pathRows = "tr.grid-row:nth-of-type(" + i + ")";

            try {
                if (!(Driver.get().findElement(By.cssSelector(pathRows)).equals(null))) {
                    countPageNumber++;
                }

                if (i == selectedRowsNumber) {
                    Driver.get().findElement(By.cssSelector(".fa-chevron-right.hide-text")).click();
                    waitUntilLoaderScreenDisappear();
                    i = 0;
                }
            } catch (NoSuchElementException e) {//NoSuchElementException coming from org.openga.selenium.
                //System.out.println(e.toString());
                return countPageNumber;
            }
        }
        return countPageNumber;
    }


    public void verifyAllCheckbox() {
        viewPerPage.click();
        viewPerPageSelect100.click();

        int selectedRowsNumber = Integer.parseInt(viewPerPageNumber.getText());

        if (checkboxClickableAll.isSelected()) {
            try {
                String pathChecksboxOfEveryRows = null;
                for (int i = 1; i <= selectedRowsNumber; i++) {
                    pathChecksboxOfEveryRows = "tr.grid-row:nth-of-type(" + i + ")>td>input";
                    if (!(Driver.get().findElement(By.cssSelector(pathChecksboxOfEveryRows)).isSelected())) {
                        Assert.assertTrue(Driver.get().findElement(By.cssSelector(pathChecksboxOfEveryRows)).isSelected());
                    }

                    if (i == selectedRowsNumber) {
                        Driver.get().findElement(By.cssSelector(".fa-chevron-right.hide-text")).click();
                        waitUntilLoaderScreenDisappear();
                        i = 0;
                    }
                }
            } catch (NoSuchElementException e) {
                Assert.assertTrue(checkboxClickableAll.isSelected());
            }

        } else {
            Assert.assertTrue(checkboxClickableAll.isSelected());
        }


    }

}