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
    private static final String BEFORE_TEST_LOG = "BEFORE TEST: \"%s\" !";
    private static final String AFTER_TEST_LOG = "AFTER TEST: \"%s\" !";

    public static String error (String message)
    {
        LOGGER.error(String.format(ERROR_LOG, message));
        Reporter.log(String.format(ERROR_LOG, message));
        return String.format(ERROR_LOG, message);
    }

    public static String info (String message)
    {
        LOGGER.info(String.format(INFO_LOG, message));
        Reporter.log(String.format(INFO_LOG,"222" + message));
        return String.format(INFO_LOG, message);
    }

    public static String beforeTest (String message)
    {
        Log4Test.info("******************************************************");
        LOGGER.info(String.format(BEFORE_TEST_LOG, message));
        Reporter.log(String.format(BEFORE_TEST_LOG, message));
        return String.format(BEFORE_TEST_LOG, message);
    }

    public static String afterTest (String message)
    {
        LOGGER.info(String.format(AFTER_TEST_LOG, message));
        Reporter.log(String.format(AFTER_TEST_LOG, message));
        Log4Test.info("******************************************************");
        return String.format(AFTER_TEST_LOG, message);
    }
}