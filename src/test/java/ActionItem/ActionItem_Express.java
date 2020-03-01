package ActionItem;

import Resuable_library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarException;

public class ActionItem_Express {
WebDriver driver;
Workbook readable;
Sheet Rsheet;
WritableWorkbook writableWorkbook;
WritableSheet Wsheet;
int rowcount;
@BeforeMethod
public void OpenBrowser() throws IOException, BiffException, InterruptedException {
    readable=Workbook.getWorkbook(new File("/Users/mohossain/Desktop/Maven2020/src/main/resources/ExpressShope Autom.xls"));
    Rsheet=readable.getSheet(0);
    rowcount = Rsheet.getRows();
    writableWorkbook=Workbook.createWorkbook(new File("/Users/mohossain/Desktop/Maven2020/src/main/resources/ExpressResult.xls"), readable);
    Wsheet=writableWorkbook.getSheet(0);



    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
    ChromeOptions options= new ChromeOptions();
    options.addArguments("start-maximized");
    driver=new ChromeDriver(options);
    Thread.sleep(2000);}

    @Test (priority = 0)
    private void Testcase1() throws InterruptedException, WriteException {
        for (int i=1; i < rowcount;i++) {
        //  Step 1. Navigate to http://www.express.com
        driver.navigate().to("https://www.express.com");
        //Step 2. Verify we are on following page title contains ‘Men’s and Women’s Clothing’
        Reusable_Methods.verifyPageTitle(driver, "Men’s and Women’s Clothing");
        // Step 3: Hover on ‘Women’ tab using Actions //use contains @href property
        Reusable_Methods.mouseHover(driver, "//*[@href='/womens-clothing']", "Women");
        Thread.sleep(2000);
        // Step 4: click on  ‘Dresses’ link //use contains @href property or you can use text() property
        Reusable_Methods.click(driver, "//*[@href='/womens-clothing/dresses/cat550007']", "dress");
        // Step 5: wait few seconds using Thread.sleep and Scroll about 400 to 500 pixels
        Thread.sleep(3000);
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,400)");

        //Step 6. Click on second image //use @class property with index number  as 1. you can use clickByIndex() method from your reusable
        Reusable_Methods.clickindex(driver, "//*[@class='active loaded']", 1, "Dress");
        //Step 7: wait few seconds on next page
        Thread.sleep(4000);

        // Step 8 On size page click on specific size(choose different size each time on excel) and the value should be passed in xpath locator as text() or @value property
        String Size = Wsheet.getCell(0, i).getContents();
        Reusable_Methods.click(driver, "//*[text()='" + Size + "']", "XS");
        //  Step 9: Click on ‘Add to Bag’ button
        Reusable_Methods.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']", "beg");
        // Step 10: on pop up to the right side click on ‘View Bag’ tab  then wait few seconds
        Reusable_Methods.click(driver, "//*[text()='View Bag']", "View bag");
        Thread.sleep(3000);
        //Step 11: Select a quantity(choose different one each time) //you can use dropdown reusable method by visible text which i created for you in reusable method class
        String quality = Wsheet.getCell(1, i).getContents();
        Reusable_Methods.click(driver, "//*[@id='qdd-0-quantity']", "q");
        Reusable_Methods.dropDownSelect(driver, "//*[@id='qdd-0-quantity']", quality, "q");
        //Step 12: Click on  ‘Checkout’ button then wait few seconds
        Reusable_Methods.click(driver, "//*[text()='Checkout']", "checkOut");
        Thread.sleep(2000);
        // Step 13: on pop up click on ‘Continue as Guest’ button then wait few seconds
        Reusable_Methods.click(driver, "//*[text()='Continue as Guest']", "guest");
        Thread.sleep(3000);
        // Step 14: Enter first name
        String Fname = Wsheet.getCell(2, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='firstname']", Fname, "first name");
        Thread.sleep(2000);
        // Step 15:  Enter last name
        String Lname = Wsheet.getCell(3, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='lastname']", Lname, "last name");
        // Step 16: Enter Email address(put invalid address)
        String address = Wsheet.getCell(4, i).getContents();
        Reusable_Methods.type(driver, "//*[@type='email']", address, "address");
        // Step 17: Re-enter Email address(put same email above)
        String Email = Wsheet.getCell(4, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='confirmEmail']", Email, "email");
        //Step 18: enter phone number(invalid numeric 10 digit number)
        String phone = Wsheet.getCell(5, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='phone']", phone, "phone");
        //  Step 19: Click on ‘Continue’ button
        Thread.sleep(3000);
        Reusable_Methods.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", "continue");
        Thread.sleep(2000);
        //  Step 20: Click on ‘Continue’ button again
        Reusable_Methods.click(driver, "//*[@type='submit']", "continue");
        Thread.sleep(3000);
        //  Step 21: Enter address(invalid one. For instance, 111, 222, etc…)
        String Street = Wsheet.getCell(6, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='shipping.line1']", Street, "street");
        // Step 22: Enter zip code(different boroughs zipcode)
        String zipcode = Wsheet.getCell(7, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='shipping.postalCode']", zipcode, "zipcode");
        //  Step 23: Enter city(different boroughs)
        String borough = Wsheet.getCell(8, i).getContents();
        Reusable_Methods.type(driver, "//*[@name='shipping.city']", borough, "borough");
        //   Step 24: Select state(keep as NY for zip codes)
        String state = Wsheet.getCell(9, i).getContents();
        Reusable_Methods.click(driver, "//*[@name='shipping.state']", "Dropdown");
        Reusable_Methods.dropDownSelect(driver, "//*[@name='shipping.state']", state, "state");
        //  Ste[ 25: click on continue button
        Reusable_Methods.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", "continue");
        Thread.sleep(5000);
        //  Step 26: Clear and Enter card number(use invalid card number for different card type. Look into examples of American express, discover, master & visa)
        String card = Wsheet.getCell(10, i).getContents();
        Reusable_Methods.type(driver, "//*[@id='creditCardNumberInput']", card, "card");
        //expression month.
        String exp = Wsheet.getCell(11, i).getContents();
        Reusable_Methods.click(driver, "//*[@name='expMonth']", "exp");
        Reusable_Methods.dropDownSelect(driver, "//*[@name='expMonth']", exp, "exp");
        //exp year
        String year = Wsheet.getCell(12, i).getContents();
        Reusable_Methods.click(driver, "//*[@name='expYear']", "exp");
        Reusable_Methods.dropDownSelect(driver, "//*[@name='expYear']", year, "year");
        //cvv #
        String CVV = Wsheet.getCell(13, i).getContents();
        Reusable_Methods.type(driver, "//*[@'name='cvv']", CVV, "cvv");

        Reusable_Methods.type(driver, "//*[@name='cvv']", CVV, "cvv");
        Thread.sleep(2000);
        //   Step 27. Click on ‘Place Order’ button
        Reusable_Methods.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", "submit");
        //  Step 28: capture the error message for card number field and send it back to  errorMessage column in excel
        String result = Reusable_Methods.captureText(driver, "//*[@id='rvn-note-NaN']", "Error");
        Label ErroeM=new Label(14,i,result);
        Wsheet.addCell(ErroeM);

    //  Step 29. type on your @Test method inside loop at the end ‘driver.manage().DeleteAllCookies(); so your address info and cart items doesn’t get stored once you navigate again to the site and checkout. It will delete the cache
        driver.manage().deleteAllCookies();
}
}//end loop
@AfterMethod
     public void closedrive() throws IOException, WriteException {
    writableWorkbook.write();
    writableWorkbook.close();
    readable.close();
    driver.close();
}//end of method




}//end class
