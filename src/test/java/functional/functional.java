package functional;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import actors.HW5User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by bionic on 11/5/14.
 */
public class functional {

    public String siteUrl = "http://hotline.ua"; //start URL
    public static HW5User user = new HW5User();    // generating user data



    public static FirefoxDriver driver;

//    @DataProvider(name="testData4Reg")
//    public Object[][] testData() {
//        return new Object[][] {
//                {user, true},
//                {user, false},
//
//        };
//
//    }


    @BeforeSuite
    public void envPrep()
    {
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void envClean()
    {
        if (driver != null) {
            driver.close();
        }
    }







}
