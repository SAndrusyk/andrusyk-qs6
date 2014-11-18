package Pages;

import Selenium.WebDriverWraper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import utils.Log4Test;

/**
 * Created by bionic on 11/5/14.
 */
public class GoodsPage {
    private static WebDriverWraper driver;
    // constants list
    private String findTextByXPath = "//a[contains(text(),'%s')]";
    // end of constants list

    public GoodsPage(WebDriverWraper driver)
    {
        this.driver = driver;
    }

    public Integer countingGoodsOnPage(String textToFind)
    {
        final By elementOfListSelector = By.xpath(String.format(findTextByXPath,textToFind));

        Log4Test.info("Finding goods on the page");
        try {driver.findElement(elementOfListSelector).isDisplayed();}
        catch (TimeoutException e) {
            Log4Test.info("Expected elements wasn't found on the page");
            return 0;
        }
        Log4Test.info("Expected good was found on the page. Counting goods.");
        return driver.findElements(elementOfListSelector).size();
    }
}
