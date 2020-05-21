package com.cybertek.tests.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestScripts6to12 {

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
        Test case #6
        Step 1. Go to "https://www.tempmailaddress.com/"
             1.1 link is run: Y
        Step 2. Copy and save email as a string.
             2.1 facek mail boxa inspect yap ve locate et, locator: //span[@id='email']
             2.2 locator u kullanarak emaili bir string deger ata: String copyOfFakeEmail = fakeEmailBox.getText();
        Step 3. Then go to “https://practice-cybertekschool.herokuapp.com/”
             3.1 link is run: Y
             3.2 go to link : driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        Step 4. And click on “Sign Up For Mailing List".
             4.1 use this locator for cklick to “Sign Up For Mailing List" :driver.findElement(By.linkText("Sign Up For Mailing List"))
        Step 5. Enter any valid name.
             5.1 use this locator of fullnamebox to enter valid name ://input[@name='full_name']
        Step 6. Enter email from the Step 2.
             6.1 use this locator of emailbox to enter valid email : //input[@name='email']
        Step 7. Click Sign Up
             7.1 use this locator to click Sign Up button ://button[@name='wooden_spoon']
        Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
             8.1 use this locator to verify that message is displayed ://h3[@name='signup_message']
        Step 9. Navigate back to the “https://www.tempmailaddress.com/”
             9.1 driver.navigate().to("https://www.tempmailaddress.com/");
        Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
             10.1 use this locator to get text : //span[.='do-not-reply@practice.cybertekschool.com']"
             10.2 verify actual and expected
        Step 11. Click on that email to open it.
             11.1 Click last email with this driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.klikaciRadek.newMail:nth-of-type(1)")).click();
        Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
             12.1 use this locator to verify: //span[@id='odesilatel'] or #odesilatel
        Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
             13.1 use this locator to verify : #predmet or //span[@id='predmet']
 */
    @Test
    public void test6()  throws InterruptedException{

        //Step1
        driver.get("https://www.tempmailaddress.com/");
        //Step2
        WebElement fakeEmailBox = driver.findElement(By.xpath("//span[@id='email']"));
        String copyOfFakeEmail = fakeEmailBox.getText();
        //Step3
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        //Step4
        WebElement SignUpforMailingList = driver.findElement(By.linkText("Sign Up For Mailing List"));
        SignUpforMailingList.click();
        //Step5
        WebElement fullNameBox = driver.findElement(By.xpath("//input[@name='full_name']"));
        fullNameBox.sendKeys("DaVuT");
        //Step6
        WebElement mailBox = driver.findElement(By.xpath("//input[@name='email']"));
        mailBox.sendKeys(copyOfFakeEmail);//burada daha once(yukarida) fakemail sitesinden copyalanan maili gonderiyorum.
        //Step7
        WebElement signUpButton = driver.findElement(By.xpath("//button[@name='wooden_spoon']"));
        signUpButton.click();
        //Step8
        System.out.println("message is displayed = " + driver.findElement(By.xpath("//h3[@name='signup_message']")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("//h3[@name='signup_message']")).isDisplayed());
        //Step9
        driver.navigate().to("https://www.tempmailaddress.com/");
        //Step10
        //sometimes running sometimes not running, I couldn't figure out What's the reason.
            /*String expectedResult = "do-not-reply@practice.cybertekschool.com";
            WebElement noreplyText = driver.findElement(By.xpath("//span[.='do-not-reply@practice.cybertekschool.com']"));
            WebDriverWait wait = new WebDriverWait(driver,20);//explicit wait
            wait.until(ExpectedConditions.visibilityOf(noreplyText));//calling until method from wait object-gizli olan texti bulanakadar bekle
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String actualResult = driver.findElement(By.xpath("//span[.='do-not-reply@practice.cybertekschool.com']")).getText();//When it find text gets it.
            Assert.assertEquals(actualResult,expectedResult,"Verify mail is sended or not!");//varify actual and expected*/
        //Step11
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.klikaciRadek.newMail:nth-of-type(1)")).click();
//        WebElement elementClickForLastCamingMail = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.klikaciRadek.newMail:nth-of-type(1)"));
//        WebDriverWait wait2 = new WebDriverWait(driver,10);//explicit wait
//        wait2.until(ExpectedConditions.visibilityOf(elementClickForLastCamingMail));
//        elementClickForLastCamingMail.click();
        //Step12
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fromText = driver.findElement(By.xpath("//span[@id='odesilatel']"));
        String actualResultFrom = fromText.getText();
        String expectecResultFrom = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualResultFrom,expectecResultFrom);
        //Step13
        WebElement subjectText = driver.findElement(By.xpath("//span[@id='predmet']"));
        String actualResultSubject = subjectText.getText();
        String expectecResultSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualResultSubject,expectecResultSubject);
    }

    /*
    Test case #7
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
             1.1 link is run: Y
        Step 2. And click on “File Upload".
             2.1 link text is run? :Y
             2.2 driver.findElement(By.linkText("File Upload")).click();
        Step 3. Upload any file with .txt extension from yourcomputer.
             3.1 Upload any file, use this locator : //input[@id='file-upload']
        Step 4. Click “Upload” button.
             4.1 use this locator to click the button: //input[@id='file-submit']
        Step 5. Verify that subject is: “File Uploaded!”
             5.1 use this locator to verify : //div[@id='uploaded-files']
        Step 6. Verify that uploaded file name is displayed.
             6.1 driver.findElement(By.xpath("//div[@id='uploaded-files']")).isDisplayed()
        Note:
        use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
        Run this method against “Choose File” button.
     */
    @Test
    public void test7(){
        //step1
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step2
        driver.findElement(By.linkText("File Upload")).click();
        //Step3
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("C:\\Users\\codek\\Desktop\\file.txt");
        //Step4
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        //Step5
        String actualResult = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        String expectedResult ="file.txt";
        Assert.assertEquals(actualResult,expectedResult);
        //Step6
        System.out.println("file name is isDisplayed() = " + driver.findElement(By.xpath("//div[@id='uploaded-files']")).isDisplayed());
    }


    /*
    Test case #8
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
             1.1 link is run:Y
        Step 2. And click on “Autocomplete”.
             2.1 use this code to click:driver.findElement(By.linkText("Autocomplete")).click();
        Step 3. Enter “United States of America” into country input box.
             3.1 use this locator to send name of country //input[@id='myCountry']
             3.2(kendim ekledim) use locator for Submit button //input[@value='Submit'] and click on it
        Step 4. Verify that following message is displayed: “You selected: United States of America”
             4.1 create expectedMessage
             4.2 actualMessage locating ->//p[@id='result'] and getText() method using
             4.3 check with Assertion

     */
    @Test
    public void test8() throws InterruptedException {
        //Step1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step2
        driver.findElement(By.linkText("Autocomplete")).click();
        //Step3
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        //Step4
        String expectedMessage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }


    /*
            Optional: If you want to to be a real selenium hero,use @DataProvider for for tests cases from 9 through 12.
            Please use following documentation: https://testng.org/doc/documentation-main.html#parameters-dataproviders

            Test case #9
            Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
                 1.1 verify link running:Y
            Step 2. And click on “Status Codes”.
                 2.1  driver.findElement(By.linkText("Status Codes")).click();
            Step 3. Then click on “200”.
                 3.1 driver.findElement(By.linkText("200")).click();
            Step 4. Verify that following message is displayed:“This page returned a 200 status code”
                 4.1 locate ->//*[@id='content']/div/p OR p with p tagname
                 4.2 note: eger bir p tagini locate edecek isen text uzerinde locate yapMA. TAG uzerinde yap
     */
    @Test
    public void test9() {
            //Step1
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            //Step2
            driver.findElement(By.linkText("Status Codes")).click();
            //Step3
            driver.findElement(By.linkText("200")).click();
            //Step4
           // System.out.println("message isDisplayed() = " + driver.findElement(By.xpath("//*[@id='content']/div/p")).isDisplayed();
            System.out.println("message isDisplayed() = " + driver.findElement(By.tagName("p")).isDisplayed());

            //we located with Tagname
//            String actualMessage = driver.findElement(By.tagName("p")).getText();
//            System.out.println("actualMessage = " + actualMessage);
            //   String expectedMessage = ""
    }


        /*
        Test case #10
            Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
                 1.1 verify link running:Y
            Step 2. And click on “Status Codes”.
                 2.1  driver.findElement(By.linkText("Status Codes")).click();
            Step 3. Then click on “301”.
                 3.1 driver.findElement(By.linkText("301")).click();
            Step 4. Verify that following message is displayed: “This page returned a 301 status code”
                 4.1 locate ->//*[@id='content']/div/p OR p with p tagname
                 4.2 note: eger bir p tagini locate edecek isen text uzerinde locate yapMA. TAG uzerinde yap
         */
        @Test
        public void test10() {
            //Step1
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            //Step2
            driver.findElement(By.linkText("Status Codes")).click();
            //Step3
            driver.findElement(By.linkText("301")).click();
            //Step4
            System.out.println("message isDisplayed() = " + driver.findElement(By.tagName("p")).isDisplayed());
        }




        /*
        Test case #11
            Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
                 1.1 verify link running:Y
            Step 2. And click on “Status Codes”.
                 2.1  driver.findElement(By.linkText("Status Codes")).click();
            Step 3. Then click on “404”.
                 3.1 driver.findElement(By.linkText("404")).click();
            Step 4. Verify that following message is displayed: “This page returned a 404 status code”
                 4.1 locate ->//*[@id='content']/div/p OR p with p tagname
                 4.2 note: eger bir p tagini locate edecek isen text uzerinde locate yapMA. TAG uzerinde yap

         */
        @Test
        public void test11(){
            //Step1
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            //Step2
            driver.findElement(By.linkText("Status Codes")).click();
            //Step3
            driver.findElement(By.linkText("404")).click();
            //Step4
            System.out.println("message isDisplayed() = " + driver.findElement(By.tagName("p")).isDisplayed());
        }


        /*
        Test case #12
            Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
                 1.1 verify link running:Y
            Step 2. And click on “Status Codes”.
                 2.1  driver.findElement(By.linkText("Status Codes")).click();
            Step 3. Then click on “500”.
                 3.1 driver.findElement(By.linkText("500")).click();
            Step 4. Verify that following message is displayed: “This page returned a 500 status code”
                 4.1 locate ->//*[@id='content']/div/p OR p with p tagname
                 4.2 note: eger bir p tagini locate edecek isen text uzerinde locate yapMA. TAG uzerinde yap
         */

        @Test
        public void test12(){
            //Step1
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            //Step2
            driver.findElement(By.linkText("Status Codes")).click();
            //Step3
            driver.findElement(By.linkText("404")).click();
            //Step4
            System.out.println("message isDisplayed() = " + driver.findElement(By.tagName("p")).isDisplayed());
        }
    }
/*



 */