package utils;

import org.apache.log4j.Logger;
import org.testng.Reporter;

/**
 * Created with IntelliJ IDEA.
 * User: Viktozhu
 * Date: 30.08.13
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */
public class Log4Test {
    private Log4Test() {}

    private static final Logger LOGGER = Logger.getLogger(Log4Test.class);

    // ****************** Default message content ********************
    private static final String INFO_LOG = "INFO: \"%s\"";
    private static final String ERROR_LOG = "ERROR: \"%s\" !";

    public static String error (String message)
    {
        LOGGER.error(String.format(ERROR_LOG, message));
        Reporter.log(String.format(ERROR_LOG, message));
        return String.format(ERROR_LOG, message);
    }

    public static String info (String message)
    {
        LOGGER.info(String.format(INFO_LOG, message));
        Reporter.log(String.format(INFO_LOG, message));
        return String.format(INFO_LOG, message);
    }

    public static String beforeTest (String message)
    {
        LOGGER.info("******************************************************");
        LOGGER.info("*** Prepare for new test : '"+ message + "'");
        Reporter.log("*** Prepare for new test : '"+ message + "'");
        return "Prepare for new test : '"+ message + "'";
    }

    public static String testpass (String message)
    {
        LOGGER.info("*** Test : '"+ message + "' - PASS");
        LOGGER.info("******************************************************\n");
        Reporter.log("*** Test : '"+ message + "' - PASS");
        return "Test : '"+ message + "' - PASS";
    }

    public static String testfail (String message)
    {
        LOGGER.error("*** Test : '"+ message + "' - FAIL");
        LOGGER.info("******************************************************\n");
        Reporter.log("*** Test : '"+ message + "' - FAIL");
        return "Test : '"+ message + "' - FAIL";
    }
}