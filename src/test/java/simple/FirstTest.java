package simple;

import Task1.Task1;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bionic on 10/22/14.
 */
public class FirstTest {

    @Test
    public void firstTest()
    {
        int x = 1;
        int y = 2;
        int z = 3;

        Assert.assertEquals(Task1.plus(x,y), z);

    }




}
