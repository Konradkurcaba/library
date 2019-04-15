package Email;

import Brokers.BookBroker;
import Dtos.BookDto;
import Email.EmailSender;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class MailCreator {

    private static final String NOTIFICATION_EMAIL_BODY = "notificationEmail.html";

    public String getMailBody() throws IOException
    {
        Document rawEmailPattern = readPatternFromFile();
        Document createdEmailBody = pepareBody(rawEmailPattern);
        String parsed = createdEmailBody.html();
        return parsed;
    }

    private Document readPatternFromFile() throws IOException
    {
        String rawEmailBody;
        try(DataInputStream inputStream = new DataInputStream(getClass().getClassLoader().getResourceAsStream(NOTIFICATION_EMAIL_BODY));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
            {
                rawEmailBody = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        return Jsoup.parse(rawEmailBody);
    }

    private Document pepareBody(Document aEmail)
    {
        Element mainTable = aEmail.getElementById("mainTable");
        Element tableContent = mainTable.selectFirst("tbody");
        List<BookDto> books = new BookBroker().getBooksToNotify();

        books.stream()
                .map(this::createRow)
                .forEach(tableContent::append);

        return aEmail;
    }

    private String createRow(BookDto aBook)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<tr> \n");
        builder.append("<td>" + aBook.getAuthor().getValue()+ "</td> \n");
        builder.append("<td>" + aBook.getTitle().getValue()+ "</td> \n");
        builder.append("<td>" + aBook.getIsbn().getValue()+ "</td> \n");
        builder.append("<td>" + aBook.getQuantity().getValue()+ "</td> \n");
        builder.append("</tr>");
        return builder.toString();
    }

}
