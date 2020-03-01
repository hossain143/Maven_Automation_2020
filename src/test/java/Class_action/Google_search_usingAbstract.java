package Class_action;

import Resuable_library.Abstract_class;
import Resuable_library.Reusable_Methods_reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.UUID;

public class Google_search_usingAbstract extends Abstract_class {


        @Test(priority = 1)
        public void googleSearch() throws InterruptedException, IOException {

            String[] cars;
            cars= new String[4];
            cars[0] = "BMW";
            cars[1] = "Mercedes";
            cars[2] = "Lexus";
            cars[3] = "Nissan";

           //for(int i = 0; i< 1;i++) {
                //navigate to google.com

                logger.log(LogStatus.INFO,"Navigating to google home");
                driver.navigate().to("https://www.google.com");
                //enter brooklyn in your search field
                Reusable_Methods_reports.type(driver,"//*[@name='q']","BMW",logger,"Search Field");
                //submit on google search
                Reusable_Methods_reports.submit(driver,"//*[@name='btnK']",logger,"Search Button");
        }

                @Test(priority = 2)
                       public void googleSearchresult() throws InterruptedException, IOException {
                //capture the text into a string variable
                Thread.sleep(3000);
                String message = Reusable_Methods_reports.captureText(driver,"//*[@id='mBMHK']",logger,"Search Result");
                String[] arraymessage = message.split(" ");
                //print out search number
            Thread.sleep(3000);
                System.out.println("My search number for "  + " is " + arraymessage[1]);
                logger.log(LogStatus.INFO,"My search number for " +" is " + arraymessage[1]);}
           // }//end of for loop
            //end the logger


        }//end of test method



//end of parent class
