package Class_action;

import Resuable_library.Reusable_Methods;
import Resuable_library.Reusable_Methods_reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class yahoo_signin {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
    @BeforeMethod
    public void openBrowser(){
        report= new ExtentReports("/Users/mohossain/Desktop/Maven2020/src/main/java/Extent_reports/yahoo.html",true);
        //quit all chrome driver whic is open
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        driver=new ChromeDriver(options);

        //initiate the implicit  wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }//end of before method
    @Test
    public void yahoosign() throws InterruptedException {

        driver.navigate().to("https://login.yahoo.com");
        //click on yahoo sign in
        Reusable_Methods.click(driver,"//*[text()='Sing in']","Sign in");
        //verify that stay signed in checkbox is selected
        Thread.sleep(3000);
        Boolean checkbox= driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkbox==true){
            System.out.println("stay signed in checkbox is selected");
        }else {
            System.out.println("stay signed in is not selected");
        }//end of if else

        Boolean creatAcc= driver.findElement(By.xpath("//*[@id='createacc']")).isEnabled();
        if (creatAcc==true){
            System.out.println(" Create account is not enabled");
        }else {
            System.out.println("Create account is not enable");
        }
    }//end o method
    @AfterMethod
    public void closeBrowser(){

    }//end of after method


}
