package Pages;

import Selenium.WebDriverWraper;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    private static WebDriverWraper driver;

    public HomePage(WebDriverWraper driver)
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
        driver.findElement(searchFieldSelector).clear();
        driver.findElement(searchFieldSelector).sendKeys(elementName + Keys.RETURN);
//        driver.findElement(searchFieldSelector).submit();
        Log4Test.info("Press Search button");
//        driver.findElement(searchButtonSelector).click();
//        driver.findElement(searchFieldSelector).sendKeys(Keys.RETURN);
    }

//    private static final By btCatSelector = By.xpath("//a[@href='/bt/']");
    private static final By btCatSelector = By.id("lv-1-548");
    private static final By lgRefregLinkSelector = By.xpath("//a[@href='/bt/holodilniki/627/']");
    private static final By sortByXpathSelector = By.xpath("//div[2]/div[contains(@class,'type')]/span[contains(@class,'ddopener')]/i");
    private static final By sortByPriceLinkSelector = By.xpath("//div[2]/div[contains(@class,'type')]/div[contains(@class,'choice')]/a[1]");



    public void selectBtCat()  {

        Actions actions = new Actions(driver.getOriginarDriver());
        Log4Test.info("Oprn menu 'BT'");
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='/bt/']")));
        actions.perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Log4Test.info("Select Fridge category");
        driver.findElement(By.xpath("//a[@href='/bt/holodilniki/']")).click();
        Log4Test.info("Select LG brand");
        driver.findElement(lgRefregLinkSelector).click();
        Log4Test.info("Open sort menu");
        driver.findElement(sortByXpathSelector).click();
        Log4Test.info("Select Sort by price");
        driver.findElement(sortByPriceLinkSelector).click();

        Log4Test.info("Get list of price from web-page");
        WebElement element = driver.findElement(By.xpath("//div[@class='price']"));
        List<WebElement> prices = element.findElements(By.xpath("//span[@class='orng']"));
        Log4Test.info("Get price1string");
        String price1string = prices.get(0).getText();
        Log4Test.info(price1string);
        Log4Test.info("Get price2string");
        String price2string = prices.get(1).getText();
        Log4Test.info(price2string);
        Log4Test.info("Get Integer prices from String. Price 1");
        Integer price1 = getIntPriceFromString(price1string);
        Log4Test.info(price1.toString());
        Log4Test.info("Get Integer prices from String. Price 1");
        Integer price2 = getIntPriceFromString(price2string);
        Log4Test.info(price2.toString());
        Log4Test.info("Check assert conditions");
        Assert.assertTrue( price1 <= price2 , "Second price higher then first") ;

    }

    private Integer getIntPriceFromString (String textWithPrice)
    {
        return Integer.parseInt(textWithPrice.substring(0, textWithPrice.indexOf("грн")).trim().replaceAll(" ",""));
    }





}
