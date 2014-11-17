package functional;

import Pages.HomePage;
import Selenium.WebDriverFactory;
import Selenium.WebDriverWraper;
import actors.User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.Log4Test;
import utils.PropertyLoader;

/**
 * Created by bionic on 11/5/14.
 */
public class functional {

    public String siteUrl = "http://hotline.ua"; //start URL
    public static User user = new User();    // generating user data

    public static WebDriverWraper driver;

    @BeforeSuite
    public void envPrep()
    {
        Log4Test.info("Starting WebDriver");
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));

    }

    @BeforeMethod
    public void runBrowserAndCloseBunners()
    {
        Log4Test.info("******************************************************");
        Log4Test.info("Starting new test");
        driver.get(PropertyLoader.loadProperty("site.url"));
        Log4Test.info("Open Homepage URL");
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
    }

    @AfterMethod
    public void endTest()
    {

        Log4Test.info("******************************************************");
    }


    @AfterSuite
    public void envClean()
    {
        Log4Test.info("Closing WebDriver");
        if (driver != null) {
            driver.close();
        }
    }







}
