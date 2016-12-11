package Messeger;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


/**
 * MailSendler class sends mail to client
 * Created by pavelpetrov on 26.10.16.
 */
public class MailSendler {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(MailSendler.class);

    /**
     * string root mail address
     */
    private final String MAILSERVICE = "pavel124578@gmail.com";


    /**
     * method sends mail to client
     *
     * @param clientEmail     client's mail
     * @param subject         subject of mail
     * @param messageToClient text of message
     */
    public void sendEmalToCLient(String clientEmail, String subject, String messageToClient) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Authenticator auth = new MyAuthenticator();
        Session session = Session.getInstance(props, auth);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MAILSERVICE));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(clientEmail));
            message.setSubject(subject);

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(messageToClient, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(
                    "/Users/pavelpetrov/Documents/JavaSchool1/my-webapp/src/main/webapp/resources/logo.png");

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);

            logger.info("Message have been sent");

        } catch (MessagingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}

