package Selenium;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import utils.Log4Test;


/**
 * Created by bionic on 11/10/14.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String HTMLUNIT = "htmlunit";


    public static WebDriverWraper initDriver(String driverName)
    {
        WebDriverWraper driverWraper = null;
        if (driverName.equalsIgnoreCase(FIREFOX)) {
            driverWraper = new WebDriverWraper(new FirefoxDriver());
            Log4Test.info("Use WebDriver - Firefox driver");
        }
        else if (driverName.equalsIgnoreCase(HTMLUNIT)){
            driverWraper = new WebDriverWraper(new HtmlUnitDriver());
            Log4Test.info("Use WebDriver - HtmlUnit driver");
        }
        else
            Assert.fail("Invalid driver configuration");

        driverWraper.manage().deleteAllCookies();
        driverWraper.manage().window().maximize();
        return driverWraper;
    }

}