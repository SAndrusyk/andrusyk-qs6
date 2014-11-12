package Selenium;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;


/**
 * Created by bionic on 11/10/14.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String HTMLUNIT = "htmlunit";


    public static WebDriverWraper initDriver(String driverName)
    {
        WebDriverWraper driverWraper = null;
        if (driverName.equalsIgnoreCase(FIREFOX))
            driverWraper = new WebDriverWraper(new FirefoxDriver());
        else if (driverName.equalsIgnoreCase(HTMLUNIT))
            driverWraper = new WebDriverWraper(new HtmlUnitDriver());
        else
            Assert.fail("Invalid driver configuration");

        driverWraper.manage().deleteAllCookies();
//        driverWraper.manage().window().maximize();
        return driverWraper;
    }

}