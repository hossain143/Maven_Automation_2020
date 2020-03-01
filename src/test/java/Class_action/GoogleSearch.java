package Class_action;

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

public class GoogleSearch {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeMethod
    public void openBrowser(){
        //define the path where you want to save the Extent Report
        reports = new ExtentReports("src/main/java/Extent_Reports/ Automation.html",true);
        //create a path to chrome
        System.setProperty("webdriver.chrome.driver", "/Users/mohossain/Desktop/Maven2020/src/main/resources/chromedriver");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome options
        options.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }//end of before method

    @Test
    public void googleSearch() throws InterruptedException, IOException {

        String[] cars;
        cars= new String[4];
        cars[0] = "BMW";
        cars[1] = "Mercedes";
        cars[2] = "Lexus";
        cars[3] = "Nissan";

        //define the logger for the report
        logger = reports.startTest("Google Search");

        for(int i = 0; i< 1;i++) {
            //navigate to google.com
            logger.log(LogStatus.INFO,"Navigating to google home");
            driver.navigate().to("https://www.google.com");
            //enter brooklyn in your search field
            Reusable_Methods_reports.type(driver,"//*[@name='q']",cars[i],logger,"Search Field");
            //submit on google search
            Reusable_Methods_reports.submit(driver,"//*[@name='btnK']",logger,"Search Button");

            //capture the text into a string variable
            //Thread.sleep(3000);
            String message = Reusable_Methods_reports.captureText(driver,"//*[@id='mBMHK']",logger,"Search Result");
            String[] arraymessage = message.split(" ");
            //print out search number
            System.out.println("My search number for " + cars[i] + " is " + arraymessage[1]);
            logger.log(LogStatus.INFO,"My search number for " + cars[i] + " is " + arraymessage[1]);
        }//end of for loop
        //end the logger
        reports.endTest(logger);

    }//end of test method

    @AfterMethod
    public void closeSession(){
        reports.flush();
        driver.quit();

    }//end of after method

}//end of parent class