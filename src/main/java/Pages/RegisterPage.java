package Pages;

import actors.HW5User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    //End of constants for RegisterPage objects

    private static WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void fillUserData(HW5User user)
    {
        driver.findElement(emailFieldSelector).sendKeys(user.email);
        driver.findElement(nickFieldSelector).sendKeys(user.nickname);
        driver.findElement(password1FieldSelector).sendKeys(user.passwd);
        driver.findElement(password2FieldSelector).sendKeys(user.passwd);
    }

    public void register()
    {
        driver.findElement(regButtonSelector).click();
    }



}
