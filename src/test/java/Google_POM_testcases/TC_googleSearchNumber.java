package Google_POM_testcases;

import Page_objects.Google_POM.Baseclass;
import Resuable_library.Abstract_class;
import org.testng.annotations.Test;

public class TC_googleSearchNumber extends Abstract_class {
    @Test
    public void googleSerchResult(){
        driver.navigate().to("https://www.google.com");
        Baseclass.homepage().UserSearch()
    }

}
