package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProductTest extends functional {

    public static final String textToFind = "ASUS";

    @Test
    public void FindProduct() throws InterruptedException {
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.findElement(textToFind);
        GoodsPage goodsPage = new GoodsPage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(goodsPage.isOnPage(textToFind));
    }

}
