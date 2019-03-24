package Email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.IOException;
import java.util.Properties;

public class SessionCreator {

    private String PROPERTIES_FILE = "email.properties";

    public Session getSession() throws IOException
    {
        final Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        final String user = prop.getProperty("mail.smtp.user");
        final String password = prop.getProperty("mail.smtp.password");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        return session;
    }


}
