package Page_objects.Google_POM;

import Resuable_library.Abstract_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Baseclass extends Abstract_class {
    public Baseclass(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        this.logger=super.logger;
    }//end of the page object  constructor

    //object for google home pg
    public static  Homepage homepage(){
        Homepage homepage= new Homepage(driver);
        return homepage;
    }

    //object for Search result pg
    public static  SearchResultPg searchResultPg(){
        SearchResultPg searchResultPg = new SearchResultPg(driver);
        return searchResultPg;
    }
}


