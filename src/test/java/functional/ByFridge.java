package functional;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Log4Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by HomeUser on 14.11.2014.
 */

public class ByFridge extends functional{



    @Test
    public void buyFrige() {
        driver.get(siteUrl);
        HomePage homePage = new HomePage(driver);
        homePage.closeADPopUp();
        homePage.selectCity();

        Actions actions = new Actions(driver.getOriginarDriver());
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='/bt/']")));
        actions.perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/bt/holodilniki/']")).click();


        driver.findElement(By.className("op_all")).click();
        moveMouseDown();

        ((JavascriptExecutor)driver.getOriginarDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                driver.findElement(By.className("jspPane")), "style", "padding: 0px 20px 0px 0px; width: 185px; top: -688px;");



        driver.findElement(By.xpath("//*[@id='filters']//a[contains(text(),'West')]")).click();

        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}

    }

    public void moveMouseDown()
    {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(900);
        robot.mouseWheel(-10);
    }

}








