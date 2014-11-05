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
    private static final String popUpCloseButtonCSSSelector = "html body.fon div#lightbox-form.lightbox-form div.visa-pup span.close.hand.close-lightbox";
    private static final String selectCityCloseButtonCssSelector = "html body.fon div.bg_white.fix div.conteiner.fix div.header-box div.rgn-box.sbj.popup-box.region-doubtfulness-popup a.blue-button.success";
    private static final String lonigLinkCssSelector = "html body.fon div.bg_white.fix div.conteiner.fix div.header-box div.login.in a.reg";
    private static final String negConditionClassSelector = "errors";
    //End of constants for HomePage objects


    private static WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void closeADPopUp()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(popUpCloseButtonCSSSelector)));
        driver.findElement(By.cssSelector(popUpCloseButtonCSSSelector)).click();
    }

    public void selectCity()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectCityCloseButtonCssSelector)));
        driver.findElement(By.cssSelector(selectCityCloseButtonCssSelector)).click();
    }

    public void register()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(lonigLinkCssSelector)));
        driver.findElement(By.cssSelector(lonigLinkCssSelector)).click();
    }

    public Boolean negConditioon()
    {
        return driver.findElement(By.className(negConditionClassSelector)).isDisplayed();
    }

    public void findElement(String elementName)
    {
        driver.findElement(By.id("searchbox")).sendKeys(elementName);
        driver.findElement(By.id("doSearch")).click();
        return;
    }






}
