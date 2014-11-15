package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProductTestNeg extends functional {

    public static final String textToFind = "iuqyiquyeiqy";

    @Test
    public void FindProduct()
    {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting Hotline Find text Negative test");
        Log4Test.info("******************************************************");
        Log4Test.info("Open Homepage URL");
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        Log4Test.info("Find text: '" +textToFind+"'");
        homePage.findElement(textToFind);
        Log4Test.info("Check result");
        GoodsPage goodsPage = new GoodsPage(driver);

        try {Thread.sleep(10000);} catch (InterruptedException e) {Log4Test.error("Thread.sleep() Exception");}

        if (goodsPage.isOnPage(textToFind)) {
            Log4Test.error("Hotline Find text Negative test result - FAIL!");
            Assert.fail("Expected product was found on result page.");
        } else {Assert.assertTrue(true);
            Log4Test.info("Hotline Find text Negative test result - PASS!");
            Log4Test.info("******************************************************");
        }
    }

}
