package Core;

import Email.EmailSender;


public class Main {

    public static void main(String... args)
    {
        try
        {
            EmailSender sender = new EmailSender();
            sender.sendMail("konradkurcaba@gmail.com","hello from java application");
        }catch (Exception aEx)
        {
            aEx.printStackTrace();
        }
    }


}
