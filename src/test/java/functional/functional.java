package functional;

import Pages.HomePage;
import Selenium.WebDriverFactory;
import Selenium.WebDriverWraper;
import actors.User;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import utils.Log4Test;
import utils.PropertyLoader;
import utils.ScreenShotMaker;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by bionic on 11/5/14.
 */
public class functional {

    public static User user = new User();    // generating user data

    public static WebDriverWraper driver;

    @BeforeSuite
    public void envPrep()
    {
        Log4Test.info("Starting TestSuite");
        ScreenShotMaker.clearScreenShotSubDirectory();


        Log4Test.info("Starting WebDriver");
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
    }

    @BeforeMethod
    public void runBrowserAndCloseBunners()
    {
        Log4Test.info("******************************************************");
        Log4Test.info("Open Homepage URL");
        driver.get(PropertyLoader.loadProperty("site.url"));
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();
    }

    @AfterMethod(alwaysRun=true)
    public void catchExceptions(ITestResult result){
        String methodName = result.getName();
        if(!result.isSuccess()){
            ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
            screenShotMaker.takeScreenShot("failure_screenshot_" + methodName);
        }
    }

    @AfterMethod
    public void endTest()
    {

        Log4Test.info("End of test");
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
