package _Old.HomeTask5;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import actors.HW5User;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Created by HomeUser on 01.11.2014.
 */


public class HotlineRegistration {

    public HW5User user = new HW5User();

    @DataProvider(name="testData4Reg")
    public Object[][] testData() {
        return new Object[][] {
                {user, true},
                {user, false},

        };

    }



    public static FirefoxDriver driver;

    @BeforeMethod
    public void envPrep()
    {
        driver = new FirefoxDriver();
    }

    @Test (dataProvider = "testData4Reg")
    public void registerOnHotline(HW5User user,  Boolean PositiveTestFlag)
    {
        driver.get("http://hotline.ua");
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.register();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillUserData(user);
        registerPage.register();

        if (PositiveTestFlag) {
            WelcomePage welcomePage = new WelcomePage(driver);
            Assert.assertTrue(welcomePage.isOnPage(), "Register fail");
        } else {
            Assert.assertTrue(homePage.negConditioon(), "Expected error not displayed");
        }




    }


    @AfterMethod
    public void envClean()
    {
        if (driver != null) {
            driver.close();
        }
    }




}
