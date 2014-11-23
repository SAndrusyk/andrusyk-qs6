package Pages;

import Selenium.WebDriverWraper;
import actors.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */
public class RegisterPage {

    //Constants for RegisterPage objects
    public static final By emailFieldSelector = By.name("email");
    public static final By nickFieldSelector = By.name("nick");
    public static final By password1FieldSelector = By.id("passw1");
    public static final By password2FieldSelector = By.id("passw2");
    public static final By regButtonSelector = By.className("blue-button");

    private static final By emailErrorSelector =By.xpath("//form/div[1]/span[contains(text(),'e-mail')]");
    //End of constants for RegisterPage objects

    private static WebDriverWraper driver;

    public RegisterPage(WebDriverWraper driver)
    {
        this.driver = driver;
    }

    public void fillUserData(User user)
    {
        Log4Test.info("Fill user data");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailFieldSelector)));

        driver.findElement(emailFieldSelector).sendKeys(user.email);
        driver.findElement(nickFieldSelector).sendKeys(user.nickname);
        driver.findElement(password1FieldSelector).sendKeys(user.passwd);
        driver.findElement(password2FieldSelector).sendKeys(user.passwd);
    }

    public void register()
    {
        Log4Test.info("Click on 'Register' button");
        driver.findElement(regButtonSelector).click();
    }

    public Boolean emailErrorDetect()
    {
        Log4Test.info("Searching for e-mail error");

        try {driver.findElement(emailErrorSelector).isDisplayed();}
        catch (TimeoutException e) {
            Log4Test.error("Expected error wasn't found");
            return false;
        }
        Log4Test.info("Expected error was found");
        return true;
    }
}
