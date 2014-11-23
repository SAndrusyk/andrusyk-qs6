package functional;

import Pages.FridgesPage;
import Pages.HomePage;
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
        Log4Test.info("SortLgFridgeByPrice test");

        HomePage homePage = new HomePage(driver);
        homePage.selectFridgeCat();

        FridgesPage fridgesPage = new FridgesPage(driver);
        fridgesPage.fridgeLGbyPriceSelect();

        Assert.assertTrue(fridgesPage.priceListSortByIncrease(), Log4Test.fail("Second price less then first."));

    }

}
