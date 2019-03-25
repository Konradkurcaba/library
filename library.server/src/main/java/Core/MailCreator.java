package Core;

import Brokers.BookBroker;
import Dtos.BookDto;
import Email.EmailSender;

import java.util.List;

public class MailCreator {

    public String getMailBody()
    {
        List<BookDto> books = new BookBroker().getBooksToNotify();
        StringBuilder builder = new StringBuilder();

        books.stream()
                .map(bookDto -> {
                    return bookDto.getTitle().getValue() + " " + bookDto.getAuthor().getValue();
                })
                .forEach(builder::append);

        return builder.toString();
    }

}
