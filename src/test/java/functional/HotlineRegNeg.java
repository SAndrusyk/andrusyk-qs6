package functional;


import Pages.HomePage;
import Pages.RegisterPage;
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
        Log4Test.info("Registration negative test");

        HomePage homePage = new HomePage(driver);
        homePage.register();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUserData(user);
        registerPage.register();

        Log4Test.info("Check result");
        if (homePage.emailErrorDetect()) {
            Log4Test.info("Hotline Registration negative test result - PASS");
            Assert.assertTrue(true);
            Log4Test.info("******************************************************");
        } else {
            Log4Test.info("Hotline Registration negative test result - FAIL");
            Assert.fail("Expected error wasn't found");
        }


    }

}
