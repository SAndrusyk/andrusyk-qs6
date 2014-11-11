package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
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

public class HotlineRegNeg extends functional
{
    @Test
    public void hotlineNegativeTest()
    {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting Hotline Registration negative test");
        Log4Test.info("******************************************************");
        Log4Test.info("Open Homepage URL");
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        Log4Test.info("Close AD PopUp if it exist");
        homePage.closeADPopUp();
        Log4Test.info("Select City on popup if it exist");
        homePage.selectCity();
        Log4Test.info("Click on register link");
        homePage.register();
        RegisterPage registerPage = new RegisterPage(driver);
        Log4Test.info("Fill user data");
        registerPage.fillUserData(user);
        Log4Test.info("Click on 'Register' button");
        registerPage.register();
        WelcomePage welcomePage = new WelcomePage(driver);
        Log4Test.info("Check result");
        if (homePage.emailErrorDetect()) {
            Log4Test.info("Hotline Registration negative test result - PASS");
            Assert.assertTrue(true);
            Log4Test.info("******************************************************");
        } else {
            Log4Test.info("Hotline Registration negative test result - FAIL");
            Assert.fail();
        }


    }

}
