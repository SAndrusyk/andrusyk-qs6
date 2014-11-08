package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by bionic on 11/5/14.
 */

public class HotlineRegNeg extends functional
{
    @Test
    public void hotlineNegativeTest()
    {
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.register();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUserData(user);
        registerPage.register();
        Assert.assertTrue(homePage.negConditioon(), "Expected error not displayed");
    }

}
