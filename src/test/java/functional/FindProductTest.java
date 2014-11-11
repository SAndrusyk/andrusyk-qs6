package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Log4Test;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProductTest extends functional {

    public static final String textToFind = "ASUS";

    @Test
    public void FindProduct() {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting Hotline Find text test");
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
//        driver.get("http://hotline.ua/sr/?q=ASUS");
        Log4Test.info("Check result");
        GoodsPage goodsPage = new GoodsPage(driver);
        try {Thread.sleep(10000);} catch (InterruptedException e) {Log4Test.error("Thread.sleep() Exception");}

        if (goodsPage.isOnPage(textToFind)) {
            Assert.assertTrue(true);
            Log4Test.info("Hotline Find text test result - PASS!");
            Log4Test.info("******************************************************");
        } else {
            Log4Test.error("Hotline Find text test result - FAIL!");
            Assert.fail("Expected product wasn't found on result page.");
        }
    }
}
