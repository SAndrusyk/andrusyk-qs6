package functional;

import actors.HW5User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.Log4Test;

/**
 * Created by bionic on 11/5/14.
 */
public class functional {

    public String siteUrl = "http://hotline.ua"; //start URL
    public static HW5User user = new HW5User();    // generating user data

    public static FirefoxDriver driver;

    @BeforeSuite
    public void envPrep()
    {
        Log4Test.info("Starting FirefoxDriver");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void envClean()
    {
        Log4Test.info("Closing FirefoxDriver");
        if (driver != null) {
            driver.close();
        }
    }







}
