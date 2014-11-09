package functional;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import actors.HW5User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;
import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */

public class HotlineRegistration extends functional
{
    @Test
    public void registerOnHotline()
    {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting Hotline Registration test");
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
        if (welcomePage.isOnPage()) {
            Assert.assertTrue(true);
            Log4Test.info("Registration test result - PASS!");
            Log4Test.info("******************************************************");
        } else {
            Log4Test.error("Registration test result - FAIL!");
            Assert.fail("Expected page not detected.");
        }

//        Assert.assertTrue(welcomePage.isOnPage(), "Register fail");
    }
}
