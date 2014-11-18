package utils;

import Selenium.WebDriverWraper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by bionic on 11/17/14.
 */
public class ScreenShotMaker {
    protected WebDriverWraper driver;
    private static String screenShotDirectory;

    public static void clearScreenShotSubDirectory()
    {
        File scrSubDir = new File(PropertyLoader.loadProperty("project.dir"),(new File(screenShotDirectory,PropertyLoader.loadProperty("screenshot.folder"))).toString());

        if (scrSubDir.exists()) {
            try {
                FileUtils.cleanDirectory(scrSubDir);
            } catch (IOException e) {

            }
        }
    }

    public ScreenShotMaker(WebDriverWraper driver)
    {
        this.driver = driver ;
        screenShotDirectory = PropertyLoader.loadProperty("screenshot.folder");
        File scrDir = new File (screenShotDirectory);
        if (!scrDir.exists())
            scrDir.mkdirs();
    }

    public void takeScreenShot(String scrName)
    {
        String scrFormat = PropertyLoader.loadProperty("screenshot.format");
        try {
            Augmenter augmenter = new Augmenter();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            File scrFile = ((TakesScreenshot)augmenter.augment(driver)).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotDirectory + scrName + formater.format(calendar.getTime()) + scrFormat));

            Log4Test.info("Error screenshot link: " + PropertyLoader.loadProperty("project.dir")+ screenShotDirectory + scrName + formater.format(calendar.getTime()) + scrFormat);
        }
        catch (Exception e)
        {

        }
    }
}

