package Class_action;

import Resuable_library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Implicit {



        WebDriver driver;
        Workbook readable;
        Sheet readableSheet;
        int rowCount;
        WritableWorkbook writable;
        WritableSheet wSheet;


        @BeforeMethod
        public void openBrowser() throws IOException, BiffException {
            //Step 1 define path of readable file
            readable = Workbook.getWorkbook(new File("src/main/resources/Express_DatDriven.xls"));
            //Step 2 define the worksheet for the data
            readableSheet = readable.getSheet(0);
            //Step 3 get count of all non empty rows in your excel sheet
            rowCount = readableSheet.getRows();
            //step 4 create a duplicate work book to write back so doesn't mess up your readable workbook
            writable = Workbook.createWorkbook(new File("src/main/resources/ExpressRes.xls"), readable);
            //Step 5 define the writeable work sheet to read the data
            wSheet = writable.getSheet(0);

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("incognito", "start-maximized");
            driver = new ChromeDriver(option);
        }//end of before method annotation

        @Test
        public void endTwoEnd() throws InterruptedException, WriteException {
            //initiate implicit wait for all elements
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            for (int i = 1; i < 2; i++) {
                String size = wSheet.getCell(0, i).getContents();
                String qty = wSheet.getCell(1, i).getContents();
                String firstName = wSheet.getCell(2, i).getContents();
                String lastName = wSheet.getCell(3, i).getContents();
                String email = wSheet.getCell(4, i).getContents();
                String phoneNumber = wSheet.getCell(5, i).getContents();
                String address = wSheet.getCell(6, i).getContents();
                String zipCode = wSheet.getCell(7, i).getContents();
                String city = wSheet.getCell(8, i).getContents();
                String state = wSheet.getCell(9, i).getContents();
                String cardNummber = wSheet.getCell(10, i).getContents();
                String expMonth = wSheet.getCell(11, i).getContents();
                String expYear = wSheet.getCell(12, i).getContents();
                String cvv = wSheet.getCell(13, i).getContents();

                //navigate to webpage
                driver.navigate().to("https://www.express.com/");
                //Thread.sleep(2000);
                //verify title
                Reusable_Methods.verifyPageTitle(driver,"Men’s and Women’s Clothing");
                Reusable_Methods.mouseHover(driver,"//*[contains(@href,'womens-clothing')]","Women");
                //Thread.sleep(2000);
                Reusable_Methods.click(driver,"//*[contains(@href,'/dresses')]","Dresses");
                //Thread.sleep(2000);
                //implemnt scroll
                JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
                scrollDown.executeScript("scroll(0,500)");
                //clicking on the dress
                Reusable_Methods.click(driver,"//*[@class='swatch-images active']","Skirt");
               // Thread.sleep(2000);
                //selecting size
                Reusable_Methods.click(driver,"//*[text()='"+ size +"']","Size");
               // Thread.sleep(2000);
                //adding dress to cart
                Reusable_Methods.click(driver,"//*[text()='Add to Bag']","Add to Bag");
                //Thread.sleep(2000);
                // click on view bag on the right side
                Reusable_Methods.click(driver, "//*[text() ='View Bag']", "view bag");
                //driver.navigate().to("https://www.express.com/bag");
                //ReusableMethod.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ']","Shopping Bag");
                //Thread.sleep(2000);
                //drop down change item
                Reusable_Methods.dropDownSelect(driver,"//*[@id='qdd-0-quantity']",qty,"Quantity");
                //Thread.sleep(2000);
                //going to checkout menu
                Reusable_Methods.click(driver,"//*[text()='Checkout']","Checkout");
                //Thread.sleep(2000);
                //clicking on check out as guest
                Reusable_Methods.click(driver,"//*[text()='Continue as Guest']","Continue as Guest");
                //Thread.sleep(2000);
                //Selecting first name and last name
                Reusable_Methods.type(driver,"//*[@name='firstname']",firstName,"First Name");
                //Thread.sleep(1000);
                Reusable_Methods.type(driver,"//*[@name='lastname']",lastName,"Last Name");
                //Thread.sleep(1000);
                //entering email and then confirming email
                Reusable_Methods.type(driver,"//*[@name='email']",email,"Email");
                //Thread.sleep(1000);
                Reusable_Methods.type(driver,"//*[@name='confirmEmail']",email,"Enter Email Again");
                //Thread.sleep(1000);
                //entering the phone number
                Reusable_Methods.type(driver,"//*[@name='phone']",phoneNumber,"Phone Number");
                //Thread.sleep(1000);
                //hitting continue
                Reusable_Methods.click(driver,"//*[text()='Continue']","Continue");
                //Thread.sleep(1500);
                //selecting shipping method
                Reusable_Methods.click(driver,"//*[text()='Continue']","Continue");
                //Thread.sleep(1000);
                //filling address
                Reusable_Methods.type(driver,"//*[@name='shipping.line1']",address,"Address 1");
                //Thread.sleep(1000);
                Reusable_Methods.type(driver, "//*[@name='shipping.postalCode']",zipCode,"Postal Code");
               // Thread.sleep(1000);
                Reusable_Methods.type(driver, "//*[@name='shipping.city']",city,"City");
                //Thread.sleep(1000);
                Reusable_Methods.dropDownSelect(driver,"//*[@name='shipping.state']",state,"State");
                //Thread.sleep(1000);
                //hitting continue after address fill in
                Reusable_Methods.click(driver,"//*[text()='Continue']","Continue");
                //Thread.sleep(1000);
                //entering card number
                Reusable_Methods.type(driver,"//*[@id='creditCardNumberInput']",cardNummber,"Credit Card");
               // Thread.sleep(1000);
                //entering card exp Month and year
                Reusable_Methods.dropDownSelect(driver,"//*[@name='expMonth']",expMonth,"Exp Month");
                //Thread.sleep(1000);
                Reusable_Methods.dropDownSelect(driver,"//*[@name='expYear']",expYear,"Exp Year");
               // Thread.sleep(1000);
                //entering card number cvv
                Reusable_Methods.type(driver,"//*[@name='cvv']",cvv,"CVV Card");
                //Thread.sleep(1000);
                //placing order
                Reusable_Methods.click(driver,"//*[text()='Place Order']","Place Order");
               // Thread.sleep(2000);
                //error message output
                String err = Reusable_Methods.captureText(driver,"//*[@id ='rvn-note-NaN']","Error Message");
                Label errMess = new Label(14,i,err);
                wSheet.addCell(errMess);

                driver.manage().deleteAllCookies();



            }//end of for loop
        }//end of @Test

        @AfterMethod
        public void closeDriver() throws IOException, WriteException {
            writable.write();
            writable.close();
            readable.close();
            driver.quit();
        }//end of after method

    }//end of java class

