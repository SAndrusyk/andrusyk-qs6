package functional;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import actors.HW5User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by HomeUser on 01.11.2014.
 */

public class HotlineRegistration extends functional
{
    @Test
    public void registerOnHotline()
    {
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.register();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillUserData(user);
        registerPage.register();
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.isOnPage(), "Register fail");
    }
}