package Pages;

import Selenium.WebDriverWraper;
import org.openqa.selenium.By;
import utils.Log4Test;

/**
 * Created by HomeUser on 04.11.2014.
 */
public class WelcomePage {

    //Constants for WelcomePage objects
    private static final By profileNameFieldSelector = By.name("first_name");
    //End of constants for WelcomePage objects

    private static WebDriverWraper driver;

    public WelcomePage(WebDriverWraper driver)
    {
        this.driver = driver;
    }

    public Boolean isOnPage()
    {
        Log4Test.info("Detecting Welcome page.");
        if (driver.findElements(profileNameFieldSelector).size()>0){
            Log4Test.info("Expected page was found");
            return true;
        } else {
            Log4Test.error("Expected page wasn't found");
            return false;
        }
    }




}
