package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;
import utils.Log4Test;

/**
 * Created by bionic on 11/5/14.
 */
public class GoodsPage {
    private static WebDriver driver;
    public GoodsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Boolean isOnPage(String textToFind)
    {
        // constants list
        final By elementOfListSelector = By.xpath("//a[contains(text(),'" + textToFind + "')]");
        // end of constants list

        try {driver.findElement(elementOfListSelector).isDisplayed();}
        catch (Exception e) {
            Log4Test.info("Expected good wasn't found on the page");
            return false;}
        Log4Test.info("Expected good was found on the page");
        return true;
    }

    public Integer countingGoodsOnPage(String textToFind)
    {
        // constants list
        final By elementOfListSelector = By.xpath("//a[contains(text(),'" + textToFind + "')]");
        // end of constants list

        try {driver.findElement(elementOfListSelector).isDisplayed();}
        catch (Exception e) {
            Log4Test.info("Expected elements was not found on result page");
            return 0;
        }
        Log4Test.info("Expected good was found on the page. Counting goods.");
        return driver.findElements(elementOfListSelector).size();
    }
}
