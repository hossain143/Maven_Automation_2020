package Class_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class USPS_count_tab {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        driver=new ChromeDriver(options);

        //initiate the implicit  wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }//end of before method
    @Test
    private void usps() throws InterruptedException {
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);
        //declare and define the Webdriverwait for explicit wait
        WebDriverWait wait =new WebDriverWait(driver,7);
      //  List<WebElement>linkcount=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'lang-')]")));
//store your find elements using list command to get the group cont
        List<WebElement>linkcount=driver.findElements(By.xpath("//*[contains(@class,'lang-')]"));
        //print out the size get the count
        System.out.println("my link is count is" + linkcount.size ());

    }//end o method
    @AfterMethod
    private void closeBrowser(){

    }//end of after method

}
