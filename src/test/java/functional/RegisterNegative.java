package functional;

import Pages.HomePage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */

public class RegisterNegative extends functional
{
    @Test
    public void registerNeg()
    {
        Log4Test.info("Registration negative test");

        HomePage homePage = new HomePage(driver);
        homePage.register();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUserData(user);
//        registerPage.register();   // Special for screenshot demonstration.

        Log4Test.info("Check result");
        Assert.assertTrue(homePage.emailErrorDetect(), "Expected error wasn't found.");
    }
}
