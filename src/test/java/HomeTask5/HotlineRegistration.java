package HomeTask5;

import Pages.HomePage;
import actors.MyMailBox;
import Pages.RegisterPage;
import actors.HW5User;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by HomeUser on 01.11.2014.
 */



@Test
public class HotlineRegistration {



    public void registerOnHotline(HW5User user) {
        HomePage homePage = new HomePage();
        homePage.closeADPopUp();
        homePage.selectCity();
        homePage.register();
        RegisterPage registerPage = new RegisterPage();
        registerPage.fillUserData();
        registerPage.register();
        MyMailBox myMailBox = new MyMailBox();
        myMailBox.confirmRegistration();
        Assert.assertTrue(homePage.login(), "result of login attempt");
        Assert.assertTrue(homePage.checkAlreadyLogged(), "result already logged or not logged");


    }







}
