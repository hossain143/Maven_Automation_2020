package Cucumber.StepDefinations;

import Resuable_library.Reusable_Methods;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class GoogleTestCases {
    WebDriver driver;
    @Given("^I navigate to google home$")
    public void navigate() throws IOException, InterruptedException {
       // Runtime.getRuntime().exec("taskkill /im chromedriver/f/t ");
        //Thread.sleep(2500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        driver=new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
    }//end of given method
    @When("^I verify the expected title as google$")
    public void verifytile(){
        Reusable_Methods.verifyPageTitle(driver,"Google");
    }
    @When("^I type car (.*) in google search field$")
    public void typeOnSearch(String cars)throws IOException {
        Reusable_Methods.type(driver,"//*[@name='q']",cars,"cars");

    }


    @And("^I submit or click on google search$")
    public void clickOnSearch (){
        Reusable_Methods.Submit(driver,"//*[@name='q']","searchfield");
    }
    @Then("^I capture and extract the search number$")
    public void getSearchNumber(){
        String massage= Reusable_Methods.captureText(driver,"//*[@id='mBMHK' or @id='result-stats']","search");
        String[] arrayMsg= massage.split(" ");
        Reporter.addStepLog("My search number for car is" + arrayMsg[1]);
        System.out.println("MY search Number for cars is" + arrayMsg[1]);
    }

}
