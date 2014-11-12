package Pages;

import Selenium.WebDriverWraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        try {driver.findElement(profileNameFieldSelector).isDisplayed();}
        catch (Exception e) {
            Log4Test.error("Expected page wasn't found");
            return false;
        }
        Log4Test.info("Expected error was found");
        return true;
    }




}
