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


    public static final String password1FieldIdSelector = "passw1";
    public static final String password2FieldIdSelector = "passw2";
    public static final String regButtonClassNameSelector = "blue-button";

    //End of constants for RegisterPage objects

    private static WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void fillUserData(HW5User user)
    {
        driver.findElement(By.name(emailFieldNameSelector)).sendKeys(user.email);
        driver.findElement(By.name(nickFieldNameSelector)).sendKeys(user.nickname);
        driver.findElement(By.id(password1FieldIdSelector)).sendKeys(user.passwd);
        driver.findElement(By.id(password2FieldIdSelector)).sendKeys(user.passwd);
    }

    public void register()
    {
        driver.findElement(By.className(regButtonClassNameSelector)).click();
    }



}
