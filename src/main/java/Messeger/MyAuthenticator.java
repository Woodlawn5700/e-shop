package Messeger;

import org.apache.log4j.Logger;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * authenticator to MyMail
 * Created by pavelpetrov on 26.10.16.
 */
public class MyAuthenticator extends Authenticator {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(MyAuthenticator.class);

    /**
     * private string login of eMail Service
     */
    private final String LOGIN = "pavel124578@gmail.com";

    /**
     * private password of Mail Service
     */
    private final String PASSWORD = "14091939";

    /**
     * method return new password Authencation
     * @return The class PasswordAuthentication is a data holder that is used by
     * Authenticator.  It is simply a repository for a user name and a password.
     */
    public PasswordAuthentication getPasswordAuthentication() {
        String user = this.LOGIN;
        String password = this.PASSWORD;
        logger.info("Authentication created with login and password");
        return new PasswordAuthentication(user, password);
    }
}
