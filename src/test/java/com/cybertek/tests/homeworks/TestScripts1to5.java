package com.cybertek.tests.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestScripts1to5 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    /*
    Test case #1
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
         1.1 link run:Y
    Step 2. Click on “Registration Form”
         2.1 link run:Y
         2.2 What is element adress: //*[@id="content"]/ul/li[40]/a  or linkText kullanilabilir.
    Step 3. Enter “wrong_dob” into date of birth inputbox.
         3.1 is there date of birth inputbox? :Y
         3.2 there is name selector : "birthday"
         3.3 send wrong_dob”
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”
         4.1 What is warning message : "The date of birth is not valid"
         4.2 What is warning message element address : //small[.='The date of birth is not valid']
 */
    @Test
    public void test1() {
        //Step 1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2
        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();
        //Step 3
        WebElement inputBox = driver.findElement(By.name("birthday"));
        inputBox.sendKeys("wrong_dob");
        //Step 4
//        String expectedResult = "The date of birth is not valid";
//        String actualResult = driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).getText();
//
//        Assert.assertEquals(expectedResult, actualResult);

        System.out.println("warning message isDisplayed() = " + driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).isDisplayed());

    }

    /*
    Test case #2
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
             1.1 link run: Y
        Step 2. Click on “Registration Form”
             2.1 link running: Y
             2.2 click "Registration Form"
        Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
             3.1 locator c++://input[@id='inlineCheckbox1']
             3.2 locator java://input[@id='inlineCheckbox2']
             3.3 locator JavaScript: //input[@id='inlineCheckbox3']

     */
    @Test
    public void test2() {
        //Step 1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2
        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();
        //Step 3
        WebElement cPlusPlus = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        WebElement java = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        WebElement javaScript = driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));

        System.out.println("cPlusPlus.isDisplayed() = " + cPlusPlus.isDisplayed());
        System.out.println("java.isDisplayed() = " + java.isDisplayed());
        System.out.println("javaScript.isDisplayed() = " + javaScript.isDisplayed());

    }


    /*
    Test case #3
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
             1.1 is it run? : Y
        Step 2. Click on “Registration Form”
             2.1 link running: Y
             2.2 click "Registration Form"
        Step 3. Enter only one alphabetic character into first name input box.
             3.1  fist input name locator ://input[@name='firstname']
             3.2 senkey kulanarak : enter your character
        Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
             4.1 actual result locator://small[.='first name must be more than 2 and less than 64 characters long']
     */
    @Test
    public void test3(){

        //Step 1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2
        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();
        //Step 3
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameInput.sendKeys("a");
        //Step 4
        //String expectedResult = "first name must be more than 2 and less than 64 characters long";
        //String actualResult = driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']")).getText();

        System.out.println("warning message isDisplayed() = " + driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']")).isDisplayed());
    }


    /*
    Test case #4
        Step 1. Go to https://practice-cybertekschool.herokuapp.com/
             1.1 is it run:Y
        Step 2. Click on “Registration Form”
             2.1 link running: Y
             2.2 click "Registration Form"
        Step 3. Enter only one alphabetic character into last name input box.
             3.1  fist input name locator ://input[@name='lastname']
             3.2 sendkey kulanarak : enter your character
        Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
             4.1 actual result : //small[.='The last name must be more than 2 and less than 64 characters long']
     */
    @Test
    public void test4(){

        //Step 1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2
        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();
        //Step 3
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameInput.sendKeys("a");
        //Strep 4
        //String expectedResult = "The last name must be more than 2 and less than 64 characters long";
        //String actualResult = driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']")).getText();

        System.out.println("warning message isDisplayed() = " + driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']")).isDisplayed());

    }

    /*
    Test case #5
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
             1.1 is it running: Y
        Step 2. Click on “Registration Form”
             2.1 link running: Y
             2.2 click "Registration Form"
        Step 3. Enter any valid first name.
             3.1 is there first name box : Y
             3.2 use sendKey and send first name : //input[@name='firstname']
        Step 4. Enter any valid last name.
             4.1 is there last name box : Y
             4.2 use sendKey and send last name
             4.3 locator for last name box://input[@name='lastname']
        Step 5. Enter any valid user name.
             5.1 use sendkey and enter valid username
             5.2 locator for user name box://input[@name='username']
        Step 6. Enter any valid password.
             6.1 use sendkey and enter valid pass.
             6.2 locator for valid password://input[@name='password']
        Step 7. Enter any valid phone number.
             7.1 use sendkey and enter valid phone number
             7.2 locator for phone number: //input[@name='phone']
        Step 8. Select gender.
             8.1 first locate your radio button, then click your gender radio button
             8.2 locator for male : //input[@value='male']
        Step 9. Enter any valid date of birth.
             9.1 use this valid date of birth***:08/11/1993
             9.2 locator for date of birth box://input[@name='birthday']
        Step 10. Select any department.
             10.1 use this locator for dropdown ://select[@name='department']
        Step 11. Enter any job title.
             11.1 use this locator for dropdown : //select[@name='job_title']
        Step 12. Select java as a programming language.
             12.1 use this locator to select java : //input[@id='inlineCheckbox2']
        Step 13. Click Sign up.
             13.1 use this locator to click button : //button[@id='wooden_spoon']
        Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
             14.1 use this locator to verify message ://p[.="You've successfully completed registration!"]
        Note: for using dropdown, please refer to the documentation: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html or, please watch short video about dropdowns that is posted on canvas.

     */

    @Test
    public void test5() throws InterruptedException {
        //Step 1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2
        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();
        //Step 3
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Selim");
        //Step 4
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Efe");
        //Step 5
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("abc123");
        //-----------soruda yok sonradan eklendi
        WebElement mailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        mailInputBox.sendKeys("codekafa@gmail.com");
        //---------
        //Step 6
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("e4r5e4r5");
        //Step 7
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("571-000-0000");
        //Step 8
        WebElement radioButtonFemale = driver.findElement(By.xpath("//input[@value='female']"));
        radioButtonFemale.click();
        //Step 9
        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("08/11/1993");
        //Step 10
        Select departmentOptions = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departmentOptions.getOptions().get(2).click();
        //Step 11
        Select jobOptions = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobOptions.getOptions().get(5).click();
        //Step 12
        WebElement java = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        java.click();
        //Step 13
        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();
       //Step 14
        Thread.sleep(4000);
        System.out.println("message is displayed isDisplayed() = " + driver.findElement(By.xpath("//p[.=\"You've successfully completed registration!\"]")).isDisplayed());

    }


}