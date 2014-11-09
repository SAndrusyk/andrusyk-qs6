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
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + textToFind + "')]")));
        } catch (Exception e) {return false;}
        return driver.findElement(By.xpath("//a[contains(text(),'" + textToFind + "')]")).isDisplayed();
    }

    public Integer amountGoodsOnPage(String textToFind)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + textToFind + "')]")));
        } catch (Exception e) {
            Log4Test.info("Expected elements was not found on result page");
            return 0;
        }
        return driver.findElements(By.xpath("//a[contains(text(),'" + textToFind + "')]")).size();
    }
}
