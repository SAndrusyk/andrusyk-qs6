package actors;

import utils.Log4Test;

/**
 * Created by HomeUser on 01.11.2014.
 */
public class User
{
    public String email;
    public String nickname;
    public String passwd;

    public User()
    {
        Log4Test.info("======================================================");
        Log4Test.info("Generating user data:");
        this.email = "asd"+ Long.toString(System.currentTimeMillis()) +"@i.ua";
        Log4Test.info("User email:    "+ email);
        this.nickname = "asd";
        Log4Test.info("User nickname: "+ nickname);
        this.passwd = "qwerty";
        Log4Test.info("User passwd:   "+ passwd);
        Log4Test.info("End of user data.");
        Log4Test.info("======================================================");
    }
}