package Class_action;

import Resuable_library.Abstract_class;
import Resuable_library.Reusable_Methods_reports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Yahoo_sign_Abstract extends Abstract_class {


        @Test
        public void usps() throws InterruptedException, IOException {
            driver.navigate().to("https://yahoo.com/");

            //click on yahoo sign in
            Reusable_Methods_reports.click(driver,"//*[text()='Sign in']","Sign in");

            //verify that stay signed in checkbox is selected
            Thread.sleep(4000);
            Boolean checkbox = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
            if(checkbox == true){
                System.out.println("Stay Signed in checkbox is selected");
                logger.log(LogStatus.PASS,"Stay Signed in checkbox is selected");
            } else {
                System.out.println("Stay Signed in checkbox is not selected");
                logger.log(LogStatus.FAIL,"Stay Signed in checkbox is not selected");
            }//end of if else for checkbox
Reusable_Methods_reports.click(driver,"//*text()='Create an account","account");



        }//end of test method

        @AfterMethod
        public void closeBrowser(){
            //driver.quit();
        }//end of after method



    }//end of java class
