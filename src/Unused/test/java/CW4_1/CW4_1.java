package _Old.CW4_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by bionic on 10/27/14.
 */
public class CW4_1 {

    public static WebDriver driver;

    @DataProvider
    public Object[][] filters() {
        return new Object[][] {
                new Object[] {"http://testng.org/doc/index.html", "TestNG"},
                new Object[] {"http://google.com.ua", "testing"},
                new Object[] {"http://bigmir.net", "trololo"},
        };
    }

    @BeforeSuite
    public void initEnv()
    {
        driver = new HtmlUnitDriver();
    }


    @Test (dataProvider = "filters")
    public void numberOfFilteredElementsTest(String siteUrl, String text)
    {
        driver.get(siteUrl);
        Assert.assertTrue(driver.findElements(By.linkText(text)).size()>0);

    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null)
            driver.quit();
    }


}
