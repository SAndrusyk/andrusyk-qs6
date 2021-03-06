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
            Log4Test.info("Use Firefox driver");
            driverWraper = new WebDriverWraper(new FirefoxDriver());
        }
        else if (driverName.equalsIgnoreCase(HTMLUNIT)){
            Log4Test.info("Use HtmlUnit driver");
            driverWraper = new WebDriverWraper(new HtmlUnitDriver());
        }
        else
            Assert.fail("Invalid driver configuration");

        driverWraper.manage().deleteAllCookies();
        driverWraper.manage().window().maximize();
        return driverWraper;
    }

}