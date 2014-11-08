package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HomeUser on 01.11.2014.
 */
public class HomePage {

    //Constants for HomePage objects
    private static final By popUpCloseButtonSelector = By.className("close");
    private static final By selectCityCloseSelector = By.className("blue-button");
    private static final By loginLinkSelector = By.xpath("//a[@href='/user/register/']");

    private static final By negConditionSelector =By.xpath("//*[.='Извините, но такой e-mail уже занят']");
    //End of constants for HomePage objects


    private static WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void closeADPopUp()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(popUpCloseButtonSelector));
        if (driver.findElement(popUpCloseButtonSelector).isDisplayed()) {driver.findElement(popUpCloseButtonSelector).click();}
    }

    public void selectCity()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(selectCityCloseSelector));
        if (driver.findElement(selectCityCloseSelector).isDisplayed()) {driver.findElement(selectCityCloseSelector).click();}
    }

    public void register()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginLinkSelector));
        if (driver.findElement(loginLinkSelector).isDisplayed()) {driver.findElement(loginLinkSelector).click();}
    }

    public Boolean negConditioon()
    {
        return driver.findElement(negConditionSelector).isDisplayed();
    }

    public void findElement(String elementName)
    {
        driver.findElement(By.id("searchbox")).sendKeys(elementName);
        driver.findElement(By.id("doSearch")).click();
        return;
    }






}
