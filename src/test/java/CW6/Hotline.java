package CW6;

/**
 * Created by bionic on 11/5/14.
 */

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WelcomePage;
import actors.HW5User;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by HomeUser on 01.11.2014.
 */


public class Hotline {

    private static final By closeBtn = By.className("close");

    public static FirefoxDriver driver;

    @BeforeMethod
    public void envPrep()
    {
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "testData4Reg")



    public void registerOnHotline(HW5User user,  Boolean PositiveTestFlag)
    {





        driver.get("http://hotline.ua");
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));

        driver.findElement(closeBtn).click();
        driver.findElement(By.className("blue-button")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Бытовая техника')]")).click();





    }


    @AfterMethod
    public void envClean()
    {
        if (driver != null) {
            driver.close();
        }
    }




}
