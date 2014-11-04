package Pages;

import actors.HW5User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by HomeUser on 01.11.2014.
 */
public class RegisterPage {

    //Constants for RegisterPage objects
    public static final String emailFieldNameSelector = "email";
    public static final String nickFieldNameSelector = "nick";


    public static final String password1FieldNameSelector = "passw1";
    public static final String password2FieldNameSelector = "passw2";
    public static final String regButtonClassNameSelector = "blue-button";

    //End of constants for RegisterPage objects

    private static WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void fillUserData()
    {
        driver.findElement(By.name(emailFieldNameSelector)).sendKeys(HW5User.email);
        driver.findElement(By.name(nickFieldNameSelector)).sendKeys(HW5User.nickname);
        driver.findElement(By.id(password1FieldNameSelector)).sendKeys(HW5User.passwd);
        driver.findElement(By.id(password2FieldNameSelector)).sendKeys(HW5User.passwd);
    }

    public void register()
    {
        driver.findElement(By.className(regButtonClassNameSelector)).click();
    }



}
