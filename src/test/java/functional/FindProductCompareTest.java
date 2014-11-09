package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProductCompareTest extends functional {

    public static final String textToFind = "ASUS";

    @Test
    public void FindProduct() throws InterruptedException {
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.findElement(textToFind);
        GoodsPage goodsPage = new GoodsPage(driver);
        Assert.assertTrue(goodsPage.amountGoodsOnPage(textToFind)>1, "Less then 2 goods on find result page!");
    }

}
