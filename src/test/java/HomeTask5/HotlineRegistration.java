package HomeTask5;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by HomeUser on 01.11.2014.
 */


public class HotlineRegistration {

//    @DataProvider(name="testData4Reg")
//    public Object[][] testData() {
//        String timerStr = Long.toString(System.currentTimeMillis());
//        return new Object[][] {
//                {timerStr, true},
////                {timerStr, false},
//
//        };
//
//    }



    public static FirefoxDriver driver;

    @BeforeSuite
    public void envPrep()
    {
        driver = new FirefoxDriver();
    }

    @Test //(dataProvider = "testData4Reg")
    public void registerOnHotline(/*String currentTimer, Boolean NegativeTestFlag*/)
    {
        driver.get("http://hotline.ua");
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.register();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillUserData();
        registerPage.register();

        WelcomePage welcomePage = new WelcomePage(driver);

        Assert.assertTrue(welcomePage.isOnPage(), "Register fail");



    }


    @AfterSuite
    public void envClean()
    {
        if (driver != null) {
            driver.close();
        }
    }




}
