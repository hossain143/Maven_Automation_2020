package Page_objects.Google_POM;

import Resuable_library.Abstract_class;
import Resuable_library.Reusable_Methods_reports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Abstract_class {


    //declare your logger  locally when you use pg
    ExtentTest logger;
    //constructor method is when a child/sub-class having identical

    //name as parent class
    public Homepage(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        this.logger=super.logger;
    }//end of the page object  constructor

    String serchfieldLoc="//*[@name='q']";

    public Homepage UserSearch(String useValue){

        Reusable_Methods_reports.type(driver,"",useValue,logger,"");
        return new Homepage(driver);

    }

    //click on submit
    public Homepage SubmitOnSearchfield(){
        Reusable_Methods_reports.submit(driver,serchfieldLoc,logger,"");
        return new Homepage(driver);
    }

}//end of java class
