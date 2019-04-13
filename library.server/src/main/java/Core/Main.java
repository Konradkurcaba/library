package Core;

import Email.EmailSender;
import Email.MailCreator;


public class Main {

    public static void main(String... args)
    {
        try
        {
            MailCreator mailCreator = new MailCreator();
            String message = mailCreator.getMailBody();
        

            EmailSender sender = new EmailSender();
            sender.sendMail("konradkurcaba@gmail.com","Hello",message);



        }catch (Exception aEx)
        {
            aEx.printStackTrace();
        }
    }


}
