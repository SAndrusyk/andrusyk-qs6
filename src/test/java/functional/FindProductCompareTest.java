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
        Log4Test.info("******************************************************");
        Log4Test.info("Starting Hotline Compare test");
        Log4Test.info("******************************************************");
        Log4Test.info("Open Homepage URL");
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        Log4Test.info("Close AD PopUp if it exist");
        homePage.closeADPopUp();
        Log4Test.info("Select City on popup if it exist");
        homePage.selectCity();
        Log4Test.info("Find text: '" + textToFind + "'");
        homePage.findElement(textToFind);
        Log4Test.info("Check result");
        GoodsPage goodsPage = new GoodsPage(driver);

        try {Thread.sleep(10000);} catch (InterruptedException e) {Log4Test.error("Thread.sleep() Exception");}

        if (goodsPage.countingGoodsOnPage(textToFind)>1) {
            Assert.assertTrue(true);
            Log4Test.info("Hotline Compare test result - PASS!");
            Log4Test.info("******************************************************");
        } else {
            Log4Test.error("Hotline Compare test result - FAIL!");
            Assert.fail("Less then 2 goods on Find result page!");
        }
    }
}
