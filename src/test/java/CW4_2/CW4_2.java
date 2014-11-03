package CW4_2;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by bionic on 10/27/14.
 */
public class CW4_2 {

    @Test(dataProvider = "testData")
    public void TestHW3(String text1, String text2, int number)
    {
        Assert.assertEquals(true,true);
    }

    @DataProvider(name = "testData")
    public Object[][] createData1() {
        return new Object[][] {
                {"moloko", "o", 3},
                {"zoloto", "o", 3},
                {"sobaka", "a", 3}

        };
    }



}
