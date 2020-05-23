package com.cybertek.tests.homeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase3 extends TestBase {

    @Test
    public void test1(){
        /*
            1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Verify that page subtitle "Options" is displayed
         */

        extentLogger = report.createTest("Test Case1");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Store Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        extentLogger.info("Verify that page subtitle 'Options' is displayed");
        Assert.assertTrue(new CalendarEventsPage().options.isDisplayed());

        extentLogger.pass("PASS: TestCase3-test1() Test");
    }

    @Test
    public void test2(){
        /*
            1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Verify that page number is equals to "1"
         */
        extentLogger = report.createTest("Test Case2");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Store Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        extentLogger.info("Verify that page number is equals to '1'");
        Assert.assertEquals(new CalendarEventsPage().pageNumber.getAttribute("value"),"1");

        extentLogger.pass("PASS: TestCase3-test2() Test");
    }

    @Test
    public void test3() {
        /*
            1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Verify that view per page number is equals to "25"
         */
        extentLogger = report.createTest("Test Case3");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Store Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        new CalendarEventsPage().waitUntilLoaderScreenDisappear();//net yavas oldugu icin biraz daha beklemesini istedim

        extentLogger.info("Verify that view per page number is equals to '25'");
        Assert.assertEquals(new CalendarEventsPage().viewPerPageNumber.getText(),"25");

        extentLogger.pass("PASS: TestCase3-test3() Test");
    }

    @Test
    public void test4() {
        /*
            1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Verify that number of calendar events (rows in the table) is equals to number of records
         */
        extentLogger = report.createTest("Test Case3");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Store Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        BrowserUtils.waitFor(5);
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
        String totalRecordText = calendarEventsPage.textOFnumberOfEvents.getText();//Get text Total of .... Records
        int expectedNumberOfEvents = Integer.valueOf(totalRecordText.replaceAll("[^0-9]", ""));//select number of in it
        int actualNumberOfEvents = calendarEventsPage.calculateNumberOfEvents();
        Assert.assertEquals(actualNumberOfEvents,expectedNumberOfEvents);

        extentLogger.pass("PASS: TestCase3-test4() Test");
    }

    @Test
    public void test5(){
        /*
            1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Click on the top checkbox to select all
            5. Verify that all calendar events were selected
         */

        extentLogger = report.createTest("Test Case3");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Store Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);

        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.checkboxClickableAll.click();
        Assert.assertTrue(calendarEventsPage.checkboxClickableAll.isSelected());

        extentLogger.info("Verify that all calendar events were selected");
        calendarEventsPage.verifyAllCheckbox();

        extentLogger.pass("PASS: TestCase3-test5() Test");
    }
//
//    @Test
//    public void test6(){
//
//    }

}
