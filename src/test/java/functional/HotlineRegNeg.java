package functional;

import Pages.GoodsPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by bionic on 11/5/14.
 */
public class HotlineRegNeg {

    public static String textToFind = "ASUS";



    public static FirefoxDriver driver;

    @BeforeSuite
    public void envPrep()
    {
        driver = new FirefoxDriver();
    }


    @Test
    public void FindProduct() throws InterruptedException {

        driver.get("http://hotline.ua");
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();

        homePage.findElement(textToFind);

        GoodsPage goodsPage = new GoodsPage(driver);

//        Assert.assertTrue(goodsPage.isOnPage(textToFind));


        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + textToFind + "')]")));

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + textToFind + "')]")).isDisplayed());


    }






    @AfterSuite
    public void envClean()
    {
        if (driver != null) {
            driver.close();
        }
    }


}
