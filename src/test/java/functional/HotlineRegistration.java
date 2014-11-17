package functional;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Log4Test;
import utils.PropertyLoader;

/**
 * Created by HomeUser on 01.11.2014.
 */

public class HotlineRegistration extends functional
{
    @Test
    public void registerOnHotline()
    {
        Log4Test.info("Registration test");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUserData(user);
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
    }
}
