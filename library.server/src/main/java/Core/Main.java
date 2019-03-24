package Core;

import Brokers.BookBroker;
import Dtos.BookDto;
import Email.EmailSender;


public class Main {

    public static void main(String... args)
    {
        try
        {
            EmailSender sender = new EmailSender();
            sender.sendMail("konradkurcaba@gmail.com","Hello","hello from java application");

            BookBroker broker = new BookBroker();
            broker.getBooksWithoutNotification().stream()
                    .map(BookDto::getTitle)
                    .forEach(System.out::print);


        }catch (Exception aEx)
        {
            aEx.printStackTrace();
        }
    }


}
