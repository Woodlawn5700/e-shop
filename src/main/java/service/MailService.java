package service;

import Messeger.MailSendler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Mail Service, sending mails, depends of situation
 * Created by pavelpetrov on 27.10.16.
 */
@Service
public class MailService {


    /**
     * class Logger
     */
    private static Logger logger = Logger.getLogger(MailService.class);

    /**
     * subject string mo clients Mail
     */
    private String subject;

    /**
     * message to client
     */
    private String messageToClient;

    /**
     * pattern message to new Client
     *
     * @param clientMail client's Mail
     */
    public void sendMessageToNewClient(String clientMail, String clientName, String loging, String password) {

        subject = "Registration to E-Shop";
        messageToClient = "<h4>Thank you for registration " + clientName + " in E-shop.</h4> \n " +
                "<p>Login: " + loging + "</p> \n" +
                "<p>Password: " + password + "</p>";
        new MailSendler().sendEmalToCLient(clientMail, subject, messageToClient);
        logger.info("message to new Client have been sent");
    }

    /**
     *
     * @param clientMail client's mail
     * @param clientName clinet's name
     * @param hash client's unique hash
     *
     */
    public void completeRegistration(String clientMail, String clientName, String hash) {

        subject = "Registration to E-Shop";
        messageToClient = "<h4>Thank you for registration " + clientName + " in E-shop.</h4> \n " +
                "<p>For complete registration please click the link </p> \n" +
                "<p>Link:  http://localhost:8080/CompleteRegistration?hash=" + hash + "</p>";
        new MailSendler().sendEmalToCLient(clientMail, subject, messageToClient);
        logger.info("message to new Client have been sent");
    }



    /**
     * String osubject getter
     * @return subject of mail
     */
    public String getSubject() {
        return subject;
    }

    /**
     * String subject setter of mail
     * @param subject subject of mail
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * message to client getter
     * @return messageToClient
     */
    public String getMessageToClient() {
        return messageToClient;
    }

    /**
     * message to client setter
     * @param messageToClient message to client in mail
     */
    public void setMessageToClient(String messageToClient) {
        this.messageToClient = messageToClient;
    }
}
