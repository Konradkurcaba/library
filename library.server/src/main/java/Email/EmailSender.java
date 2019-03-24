package Email;

import javax.imageio.IIOException;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;

public class EmailSender {

    private Session session;

    public EmailSender() throws IOException {
        SessionCreator creator = new SessionCreator();
        session = creator.getSession();
    }

    public void sendMail(String aRecipient,String aSubject, String aMessage) throws MessagingException
    {
        Message message = new MimeMessage(session);
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(aRecipient));
        message.setSubject(aSubject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(aMessage,"text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }



}
