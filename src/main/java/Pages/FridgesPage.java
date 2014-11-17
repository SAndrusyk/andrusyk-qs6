package Pages;

import Selenium.WebDriverWraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Log4Test;

import java.util.List;

/**
 * Created by HomeUser on 15.11.2014.
 */
public class FridgesPage
{


    private static final By lgRefregLinkSelector = By.xpath("//a[@href='/bt/holodilniki/627/']");
    private static final By sortByXpathSelector = By.xpath("//div[2]/div[contains(@class,'type')]/span[contains(@class,'ddopener')]/i");
    private static final By sortByPriceLinkSelector = By.xpath("//div[2]/div[contains(@class,'type')]/div[contains(@class,'choice')]/a[1]");
    private static final By priceListElementsSelector = By.xpath("//div[@class='price']");
    private static final By priceTextSelector = By.xpath("//span[@class='orng']");

    private static WebDriverWraper driver;

    public FridgesPage(WebDriverWraper driver)
    {
        this.driver = driver;
    }

    public void fridgeLGbyPriceSelect ()
    {
        Log4Test.info("Select LG brand");
        driver.findElement(lgRefregLinkSelector).click();
        Log4Test.info("Open sort menu");
        driver.findElement(sortByXpathSelector).click();
        Log4Test.info("Select Sort by price");
        driver.findElement(sortByPriceLinkSelector).click();

    }

    public Boolean priceListSortByIncrease()
    {
        Log4Test.info("Compare first and second prices");
        WebElement element = driver.findElement(priceListElementsSelector);
        List<WebElement> prices = element.findElements(priceTextSelector);
        Integer firstPrice = getIntPriceFromString(prices.get(0).getText());
        Log4Test.info("Firs price = " + firstPrice);
        Integer secondPrice = getIntPriceFromString(prices.get(1).getText());
        Log4Test.info("Second price = " + secondPrice);
        if (firstPrice <= secondPrice) {
            Log4Test.info("Second price higher then first");
            return true;
        } else {
            Log4Test.info("Second price smaller then first");
            return false;
        }
    }


    private Integer getIntPriceFromString (String textWithPrice)
    {
        String[] a = textWithPrice.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (Integer i = 0; i< a.length; i++)
        {
            try {Integer.parseInt(a[i]);} catch (NumberFormatException e){break;}
            buffer.append(a[i]);
        }
        return Integer.parseInt(buffer.toString());
    }



}
