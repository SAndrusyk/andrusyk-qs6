package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProductCompareTest extends functional {

    public static final String textToFind = "ASUS";

    @Test
    public void FindProduct() {
        Log4Test.info("Compare test");
        Log4Test.info("Find text: '" + textToFind + "'");

        HomePage homePage = new HomePage(driver);
        homePage.findElement(textToFind);

        GoodsPage goodsPage = new GoodsPage(driver);
        try {Thread.sleep(10000);} catch (InterruptedException e) {Assert.fail("Thread.sleep() Exception");}

        Log4Test.info("Check result");
        Assert.assertTrue(goodsPage.countingGoodsOnPage(textToFind) > 1, "Less then 2 products found");

    }
}
