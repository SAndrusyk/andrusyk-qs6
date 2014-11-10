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
    public void FindProduct() throws InterruptedException {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting Hotline Find text Negative test");
        Log4Test.info("******************************************************");
        Log4Test.info("Open Homepage URL");
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        Log4Test.info("Close AD PopUp if it exist");
        homePage.closeADPopUp();
        Log4Test.info("Select City on popup if it exist");
        homePage.selectCity();
        Log4Test.info("Find text: '" +textToFind+"'");
        homePage.findElement(textToFind);
        Log4Test.info("Check result");
        GoodsPage goodsPage = new GoodsPage(driver);

        Thread.sleep(10000);


//        Assert.assertFalse(goodsPage.isOnPage(textToFind));

        if (goodsPage.isOnPage(textToFind)) {
            Log4Test.error("Hotline Find text Negative test result - FAIL!");
            Assert.fail("Expected product was found on result page.");
        } else {Assert.assertTrue(true);
            Log4Test.info("Hotline Find text Negative test result - PASS!");
            Log4Test.info("******************************************************");
        }
    }

}
