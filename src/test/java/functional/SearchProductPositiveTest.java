package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by HomeUser on 17.11.2014.
 */
public class SearchProductPositiveTest extends functional {

    public static final String textToFind = "ASUS";

    @Test
    public void SearchProductPos() {

        Log4Test.info("Search text test");

        HomePage homePage = new HomePage(driver);
        homePage.findElement(textToFind);

        GoodsPage goodsPage = new GoodsPage(driver);
        try {Thread.sleep(10000);} catch (Exception e) {Assert.fail(Log4Test.fail("Thread.sleep() exception"));}

        Log4Test.info("Check result");
        Assert.assertTrue(goodsPage.countingGoodsOnPage(textToFind) > 0,"Expected product wasn't found on result page.");
    }



}
