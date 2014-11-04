package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by HomeUser on 04.11.2014.
 */
public class WelcomePage {

    //Constants for WelcomePage objects
    public static final String profileNameFieldSelector = "first_name";
    //End of constants for WelcomePage objects

    private static WebDriver driver;

    public WelcomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Boolean isOnPage()
    {
        return driver.findElement(By.name(profileNameFieldSelector)).isDisplayed();
    }




}
