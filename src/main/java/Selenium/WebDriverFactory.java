package Selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import utils.Log4Test;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by bionic on 11/10/14.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String HTMLUNIT = "htmlunit";
    public static final String FIREXOX_REMOTE = "firefox_remote";


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
        else if (driverName.equalsIgnoreCase(FIREXOX_REMOTE)){
            Log4Test.info("Use Firefox Remote driver");

            DesiredCapabilities capability = DesiredCapabilities.firefox();
            try{
                driverWraper = new WebDriverWraper( new RemoteWebDriver(new URL(PropertyLoader.loadProperty("selenium.hub")), capability));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }
        else
            Assert.fail("Invalid driver configuration");

        driverWraper.manage().deleteAllCookies();
        driverWraper.manage().window().maximize();
        return driverWraper;
    }

}