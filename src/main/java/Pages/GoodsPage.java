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

    public Boolean isOnPage(String text)
    {
//        driver.findElement(By.xpath("//a[conteins(text(),"+ text +")]"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[conteins(text()," + text + ")]")));

        return true;
    }



}
