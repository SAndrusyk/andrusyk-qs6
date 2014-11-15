package functional;

import Pages.FridgesPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

import java.util.List;

/**
 * Created by HomeUser on 11.11.2014.
 */
public class SortLgFridgeByPrice extends functional {

    @Test
    public void selectCategory ()
    {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting SortLgFridgeByPrice test");
        Log4Test.info("******************************************************");
        Log4Test.info("Open Homepage URL");
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        Log4Test.info("Close AD PopUp if it exist");
        homePage.closeADPopUp();
        Log4Test.info("Select City on popup if it exist");
        homePage.selectCity();
        homePage.selectFridgeCat();
        FridgesPage fridgesPage = new FridgesPage(driver);
        fridgesPage.fridgeLGbyPriceSelect();
        Assert.assertTrue(fridgesPage.priceListSortByIncrease());
        Log4Test.info("SortLgFridgeByPrice test result - PASS!");
        Log4Test.info("******************************************************");
    }

}
