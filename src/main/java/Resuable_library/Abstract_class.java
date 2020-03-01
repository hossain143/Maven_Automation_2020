package Resuable_library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.UUID;

public class Abstract_class {
    public static WebDriver driver;
    public static ExtentReports report;
   public static ExtentTest logger;
//@Parameters("browser")
    @BeforeSuite
    public void OpenBrowser(String browser){
    report = new ExtentReports("src/main/java/Extent_Reports/ Automation" + UUID.randomUUID()+".html",true);
    if (browser.equalsIgnoreCase("Chrome")){
        //quit all chrome driver whic is open
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);}
    else if (browser.equalsIgnoreCase("Firefox")){
        //quit all chrome driver whic is open
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
    }
    }//end of suite
    //before method will be use to capture and start the

    @BeforeMethod
    public void getTestName(Method methodName){
        logger=report.startTest(methodName.getName());
    }//end of before method

    //after method will end your test report
@AfterMethod
    public void endReport(){
        report.endTest(logger);
}//end of after method

    //After suite
    @AfterSuite
    public void quitSession(){
        //write all your logs back to the report
        report.flush();
        //quit driver if you need to
        driver.quit();
    }


}//end of abstract class
