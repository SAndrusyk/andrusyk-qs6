package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HomeUser on 04.11.2014.
 */
public class WelcomePage {

    //Constants for WelcomePage objects
    private static final By profileNameFieldSelector = By.name("first_name");
    //End of constants for WelcomePage objects

    private static WebDriver driver;

    public WelcomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Boolean isOnPage()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(profileNameFieldSelector));

        return driver.findElement(profileNameFieldSelector).isDisplayed();
    }




}
