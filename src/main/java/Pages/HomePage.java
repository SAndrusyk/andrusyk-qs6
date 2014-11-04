package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by HomeUser on 01.11.2014.
 */
public class HomePage {

    //Constants for HomePage objects
    public static final String popUpCloseButtonCSSSelector = "html body.fon div#lightbox-form.lightbox-form div.visa-pup span.close.hand.close-lightbox";
    public static final String selectCityCloseButtonCssSelector = "html body.fon div.bg_white.fix div.conteiner.fix div.header-box div.rgn-box.sbj.popup-box.region-doubtfulness-popup a.blue-button.success";
    public static final String lonigLinkCssSelector = "html body.fon div.bg_white.fix div.conteiner.fix div.header-box div.login.in a.reg";
    //End of constants for HomePage objects


    private static WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void closeADPopUp()
    {
        driver.findElement(By.cssSelector(popUpCloseButtonCSSSelector)).click();
    }

    public void selectCity()
    {
        driver.findElement(By.cssSelector(selectCityCloseButtonCssSelector)).click();
    }

    public void register()
    {
        driver.findElement(By.cssSelector(lonigLinkCssSelector)).click();
    }


}
