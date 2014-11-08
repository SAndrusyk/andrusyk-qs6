package _Old.HW3_Test;

import _Old.HW3.HW3;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by HomeUser on 24.10.2014.
 */

public class HW3_Test {

    @Test
    @Parameters({"emailForSmokeTest"})
    public void TestHW3Smoke(String eMail)
    {
        Assert.assertEquals(HW3.emailValidation(eMail), true, "Error! " + eMail);
    }

    @Test (dataProvider = "emailList")
    public void TestHW3(String eMail, boolean result)
    {
        Assert.assertEquals(HW3.emailValidation(eMail), result, "Error! " + eMail);
    }

    @DataProvider(name = "emailList")
    public Object[][] createData1() {
        return new Object[][] {
                {"abd@gmail.com", true },
                {"abc-555@i.ua", true},
                {"cde_444@got.com", true},
                {"hjk+888@wer.com.kiev.ua", true},
//                {"qwerty@192.168.0.1", true},
                {"af?j@i.ua", false},
                {"kasjhdlasda", false},
                {"lkjsdf@.com.ua", false},
                {"ljks@fgh..com", false},
                {"lkjh@kjhlj@fog.ru", false}
        };
    }

}
