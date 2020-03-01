package ActionItem;

import Resuable_library.Reusable_Methods;
import Resuable_library.Reusable_Methods_reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;

public class ActionItems_Yahoo {
    WebDriver driver;
    ExtentTest logger;
    ExtentReports reports;
    @BeforeMethod
    public void openBrowser(){
        reports=new ExtentReports("/Users/mohossain/Desktop/Maven2020/src/main/java/Extent_reports/yahoo.html",true);

        System.setProperty("webdriver.chrome.driver","/Users/mohossain/Desktop/Maven2020/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        logger= reports.startTest("Yahoo");
        logger.log(LogStatus.INFO,"Navigate to Yahoo");

        //Step 1. Navigate to https://www.yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("incognito");
    }
    @Test
            public void yahoo() throws InterruptedException, IOException {
        //Step 2. Assert that we are on the correct page by checking the title = 'Yahoo‘
        Reusable_Methods_reports.verifyPageTitle(driver, "Yahoo");
        //Step 3. Display the count of options on the left side panel ('Mail', 'News', 'Sports‘ & ‘More Yahoo Sites’)//use contains with class property which has value mstart …
        List<WebElement> linkcount = driver.findElements(By.xpath("//*[contains(@id,'header-')]"));
        System.out.println(" My tab count is " + linkcount.size());
        //Step 4: Enter 'Nutrition' on the search bar on the top
        Reusable_Methods_reports.type(driver, "//*[@type='text']", "Nutrition",logger, "search");
        //Step 5: Click on ‘Search’ button
        Reusable_Methods_reports.click(driver, "//*[@type='submit']", "submit");
        logger.log(LogStatus.INFO,"click on Search");
        // Step 6. Scroll down to the page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,9000)");

        // Step 7: Capture the search result Number by splitting from the getText
        String result= Reusable_Methods_reports.captureText(driver, "//*[@class='compPagination']", logger,"result");
        String[] arraymessage = result.split("Next");
        System.out.println("my result is "+ result + arraymessage[1]);

        // Step 8: Scroll up and click on Image lin
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(900,0)");
        Reusable_Methods.click(driver,"//*[text()='Images']","images");
        logger.log(LogStatus.INFO,"click on Images");
        //Step 9: Display the count of all images appear on the page//don’t worry bout to too much if you can’t get the right count. Try to follow step 3
        List<WebElement> listImage= driver.findElements(By.xpath("//*[contains(@id,'yui_3')]"));
        System.out.println("image count"+ listImage.size());
        // Step 10: On top right Click on Sign In button
        Reusable_Methods.click(driver,"//*[@id='yucs-login_signIn']","sign");
        logger.log(LogStatus.INFO,"click on Sign in");
        //Step 11: Verify the Boolean state of checkbox if it is selected as default or not  on stay signed in
        Boolean checkbox=driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkbox==true){
            System.out.println("box is selected");
            logger.log(LogStatus.PASS,"pass");
        }else {
            System.out.println("box in enable");
            logger.log(LogStatus.FAIL,"box is not enable");
        }
        // Step 12: Enter invalid user name
        Reusable_Methods_reports.type(driver,"//*[@id='login-username']","user@gmail.com",logger,"name");
        //Step 13: click on ‘Next’ button
        Reusable_Methods.click(driver,"//*[@type='submit']","submit");
        logger.log(LogStatus.INFO,"click on Submit");
        //Step 14: Capture the error message and verify that if actual message matches the following string
        String errMsg="Sorry, we don't recognize this email.";
        String textmsg= Reusable_Methods_reports.captureText(driver,"//*[@id='username-error']",logger,"TEXT");
        //String errMsg = "Sorry, we don't recognize this email.";
        if (errMsg== textmsg){
            System.out.println("match");
            logger.log(LogStatus.PASS,"match");
        }else {System.out.println("Don't match"+errMsg);

        logger.log(LogStatus.FAIL,"Don't match" +errMsg);
        Thread.sleep(3000);
    }}

        @AfterMethod
                public void close(){
        driver.quit();
        reports.flush();


    }
}
