package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */
public class HomePage {

    //Constants for HomePage objects
    private static final By popUpCloseButtonSelector = By.className("close");
    private static final By selectCityCloseSelector = By.className("blue-button");
    private static final By loginLinkSelector = By.xpath("//a[@href='/user/register/']");
    private static final By negConditionSelector =By.xpath("//*[contains(text(),'e-mail')]");

    private static final By searchFieldSelector = By.id("searchbox");
    private static final By searchButtonSelector = By.id("doSearch");

    //End of constants for HomePage objects


    private static WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void closeADPopUp()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(popUpCloseButtonSelector));
            driver.findElement(popUpCloseButtonSelector).click();
        } catch (TimeoutException e){
            Log4Test.info("PopUp banner not found");
        }
    }

    public void selectCity()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectCityCloseSelector));
            driver.findElement(selectCityCloseSelector).click();
        } catch (TimeoutException e) {
            Log4Test.info("City selection banner not found");
        }
    }

    public void register()
    {
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLinkSelector));
        driver.findElement(loginLinkSelector).click();
    }

    public Boolean negConditioon()
    {
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(negConditionSelector));
        return true;
    }

    public void findElement(String elementName)
    {
        driver.findElement(searchFieldSelector).sendKeys(elementName);
        driver.findElement(searchButtonSelector).click();
        return;
    }






}
