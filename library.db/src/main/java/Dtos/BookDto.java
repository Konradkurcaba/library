package Dtos;

import java.time.Year;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Brokers.CategoryBroker;
import Entities.Book;


public class BookDto {

    private Book book;
    private boolean isPersisted;

    private StringProperty title;
    private StringProperty isbn;
    private StringProperty author;
    private StringProperty year;
    private StringProperty category;
    private StringProperty quantity;

    public BookDto(Book book) {
        super();
        this.book = book;

        title = new SimpleStringProperty(book.getTitle());
        isbn = new SimpleStringProperty(book.getIsbn());
        author = new SimpleStringProperty(book.getAuthor());
        year = new SimpleStringProperty(book.getYearOfPublication().toString());
        category = new SimpleStringProperty(book.getCategory().toString());
        quantity = new SimpleStringProperty(String.valueOf(book.getQuantity()));

        isPersisted = true;
    }

    public BookDto() {
        isPersisted = false;

        title = new SimpleStringProperty("");
        isbn = new SimpleStringProperty("");
        author = new SimpleStringProperty("");
        year = new SimpleStringProperty("");
        category = new SimpleStringProperty("");
        quantity = new SimpleStringProperty("");
    }

    public StringProperty getId() {
        return new SimpleStringProperty(Long.toString(book.getId()));
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String aTitle) {
        DtoValidator.checkText(aTitle);
        title.setValue(aTitle);
    }

    public StringProperty getIsbn() {
        return isbn;
    }

    public void setIsbn(String aIsbn) {
        isbn.setValue(aIsbn);
    }

    public StringProperty getCategory() {
        return category;
    }

    public void setCategory(String aCategory) {

        category.setValue(aCategory);
    }

    public StringProperty getAuthor() {
        return author;
    }

    public void setAuthor(String aAuthor) {
        author.setValue(aAuthor);
    }

    public StringProperty getYearOfPublication() {
        return year;
    }

    public void setYearOfPublication(String aYearOfPublication) throws NumberFormatException {

        year.setValue(aYearOfPublication);
    }

    public StringProperty getQuantity() {
        return quantity;
    }

    public void setQuantity(String aQuantity) throws NumberFormatException {
        quantity.setValue(aQuantity);
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book aEntity) {
        book = aEntity;
        isPersisted = true;
    }

    public boolean isPersisted() {
        return isPersisted;
    }

    public boolean wasNotificationSent()
    {
        return book.wasNotificationSent();
    }

    public void notificationSent()
    {
        book.setWasNotificationSent(true);
    }

    public void commitChanges() {
        book.setAuthor(author.getValue());
        book.setIsbn(isbn.getValue());
        book.setTitle(title.getValue());

        int convertedYear = Integer.valueOf(year.getValue());
        Year yearOfPublication = Year.of(convertedYear);
        book.setYearOfPublication(yearOfPublication);

        int convertedQuantity = Integer.valueOf(quantity.getValue());
        book.setQuantity(convertedQuantity);

        CategoryBroker categoryBroker = new CategoryBroker();
        CategoryDto catDto = categoryBroker.getCategory(category.getValue());
        book.setCategory(catDto.getCategory());
    }

}
