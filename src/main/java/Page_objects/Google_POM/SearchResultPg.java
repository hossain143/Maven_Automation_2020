package Page_objects.Google_POM;

import Resuable_library.Abstract_class;
import Resuable_library.Reusable_Methods_reports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPg extends Abstract_class {
    //declare your logger  locally when you use pg
    ExtentTest logger;
    //constructor method is when a child/sub-class having identical

    //name as parent class
    public SearchResultPg(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        this.logger=super.logger;
    }//end of the page object  constructor
    //define locators here
    String resultLoc= "//*[@id='result-stats']";

    //capturing and printing out the number to the report
    public SearchResultPg captureSearchNumber(){
        String searchResult = Reusable_Methods_reports.captureText(driver,resultLoc,logger,"" );
        String[] arraysearch
    }


}
