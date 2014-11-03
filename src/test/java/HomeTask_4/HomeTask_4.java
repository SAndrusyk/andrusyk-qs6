package HomeTask_4;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by HomeUser on 28.10.2014.
 */
public class HomeTask_4 {

    public static PrintWriter outputFile;
    public String fileName = "HomeTask_4.result.txt";

    @DataProvider(name="testString")
    public Object[][] testData() {
        return new Object[][] {
                {"qwertyudfg dfg dfg dfgdf  dfgsdgd gsdfg sdfg sdfg iop", "ty"},
                {"asdflg sdfhg ;lj ghglsd sldkjg; hfgks l;sdl gghjkl", "ghj"},
                {"zxcffffffffffffffffffffffffffvbnm", "vbn"},
        };

    }


    @BeforeClass
    public void fileOpen()
    {


        File file = new File(fileName);
        try
        {
            if (!file.exists())
            {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            outputFile = new PrintWriter(fileName);
        } catch (IOException e) {System.out.println("File access error!");}

    }

    @Test(dataProvider = "testString")
    public void testStrings(String text1, String text2) {

        outputFile.println("Text1:" +text1);
        outputFile.println("Text2:" +text2);
        outputFile.println();

        Assert.assertTrue(text1.contains(text2));
    }

    @AfterClass
    public void  fileClose()
    {
        outputFile.close();
    }







}
