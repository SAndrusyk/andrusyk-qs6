package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

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
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + textToFind + "')]")));

        return driver.findElement(By.xpath("//a[contains(text(),'" + textToFind + "')]")).isDisplayed();
    }



}
