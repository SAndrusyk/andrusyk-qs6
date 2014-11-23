package functional;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */

public class RegisterPositive extends functional
{
    @Test
    public void registerPos()
    {
        Log4Test.info("Registration test");

        HomePage homePage = new HomePage(driver);
        homePage.register();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUserData(user);
        registerPage.register();

        WelcomePage welcomePage = new WelcomePage(driver);

        Log4Test.info("Check result");
        Assert.assertTrue(welcomePage.isOnPage(), "Expected page not detected.");
    }
}
