package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */
public class HomePage {

    //Constants for HomePage objects
    private static final By popUpCloseButtonSelector = By.className("close");
    private static final By selectCityCloseSelector = By.className("blue-button");
    private static final By loginLinkSelector = By.xpath("//a[@href='/user/register/']");
    private static final By emailErrorSelector =By.xpath("//form/div[1]/span[contains(text(),'e-mail')]");

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

            if (driver.findElement(popUpCloseButtonSelector).isDisplayed()) {
                driver.findElement(popUpCloseButtonSelector).click();
                Log4Test.info("Banner was found and closed");
            } else {
                Log4Test.info("Banner wasn't found");
            }

    }

    public void selectCity()
    {
            if (driver.findElement(selectCityCloseSelector).isDisplayed()) {
                driver.findElement(selectCityCloseSelector).click();
                Log4Test.info("City select Banner was found and closed");
            } else {
                Log4Test.info("City selection banner wasn't found");
            }

    }

    public void register()
    {
        if (driver.findElement(loginLinkSelector).isDisplayed()) {
            driver.findElement(loginLinkSelector).click();
            Log4Test.info("Register link was found and clicked");
        } else {Assert.fail("Register link wasn't found");}
    }

    public Boolean emailErrorDetect()
    {
        Log4Test.info("Searching for e-mail error");
        try {driver.findElement(emailErrorSelector).isDisplayed();}
        catch (Exception e) {
            Log4Test.error("Expected error wasn't found");
            return false;
        }
    Log4Test.info("Expected error was found");
    return true;
    }

    public void findElement(String elementName)
    {
        Log4Test.info("Enter text for search to the search field");
        driver.findElement(searchFieldSelector).sendKeys(elementName + Keys.RETURN);
        Log4Test.info("Press Search button");
//        driver.findElement(searchButtonSelector).click();
//        driver.findElement(searchFieldSelector).sendKeys(Keys.RETURN);
    }

//    private static final By btCatSelector = By.xpath("//a[@href='/bt/']");
    private static final By btCatSelector = By.id("lv-1-548");

    public void selectBtCat()
    {
//        driver.findElement(btCatSelector).submit();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(btCatSelector);
        actions.moveToElement(element).build().perform();

        try {Thread.sleep(100000);} catch (InterruptedException e) {Log4Test.error("Thread.sleep() Exception");}



    }






}
