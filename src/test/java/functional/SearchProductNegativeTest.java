package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by HomeUser on 17.11.2014.
 */
public class SearchProductNegativeTest extends functional {

    public static final String textToFind = "iuqyiquyeiqy";

    @Test
    public void SearchProductNeg()
    {
        Log4Test.info("Search text negative test");

        HomePage homePage = new HomePage(driver);
        homePage.findElement(textToFind);

        GoodsPage goodsPage = new GoodsPage(driver);
        try {Thread.sleep(10000);} catch (Exception e) {Assert.fail("Thread.sleep() exception");}

        Log4Test.info("Check result");
        Assert.assertTrue(goodsPage.countingGoodsOnPage(textToFind) < 1,"Expected product was found on result page.");
    }
}
