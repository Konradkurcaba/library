package Dtos;

import java.time.Year;

import Validator.DtoValidator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Brokers.CategoryBroker;
import Entities.Book;


public class BookDto implements DtoCaValue,DtoWithCa {

    private Book book;
    private boolean isPersisted;

    private CategoryDto categoryToDisplay;

    private StringProperty title;
    private StringProperty isbn;
    private StringProperty author;
    private StringProperty year;
    private StringProperty quantity;



    private DtoValidator dtoValidator = new DtoValidator();

    public BookDto(Book book) {
        super();
        this.book = book;

        title = new SimpleStringProperty(book.getTitle());
        isbn = new SimpleStringProperty(book.getIsbn());
        author = new SimpleStringProperty(book.getAuthor());
        year = new SimpleStringProperty(book.getYearOfPublication().toString());
        categoryToDisplay = new CategoryDto(book.getCategory());
        quantity = new SimpleStringProperty(String.valueOf(book.getQuantity()));

        isPersisted = true;
    }

    public BookDto() {
        isPersisted = false;

        title = new SimpleStringProperty("");
        isbn = new SimpleStringProperty("");
        author = new SimpleStringProperty("");
        year = new SimpleStringProperty("");
        categoryToDisplay = new CategoryDto();
        quantity = new SimpleStringProperty("");
    }

    public StringProperty getId() {
        return new SimpleStringProperty(Long.toString(book.getId()));
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String aTitle) {
     //   dtoValidator.checkNull(aTitle);
        title.setValue(aTitle);
    }

    public StringProperty getIsbn() {
        return isbn;
    }

    public void setIsbn(String aIsbn) {
        dtoValidator.checkISBN(aIsbn);
        isbn.setValue(aIsbn);
    }

    public CategoryDto getCategory() {
        return categoryToDisplay;
    }

    public void setCategory(CategoryDto aCategory) {

        categoryToDisplay = aCategory;
    }

    public StringProperty getAuthor() {
        return author;
    }

    public void setAuthor(String aAuthor) {
      //  dtoValidator.checkSmallFirstLetters(aAuthor);
        author.setValue(aAuthor);
    }

    public StringProperty getYearOfPublication() {
        return year;
    }

    public void setYearOfPublication(String aYearOfPublication) throws NumberFormatException {
        dtoValidator.checkNumber(aYearOfPublication);
        year.setValue(aYearOfPublication);
    }

    public StringProperty getQuantity() {
        return quantity;
    }

    public void setQuantity(String aQuantity) throws NumberFormatException {
        dtoValidator.checkNumber(aQuantity);
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

        book.setCategory(categoryToDisplay.getCategory());
    }

    @Override
    public String getCaName() {
        return getTitle().getValue() + " " + getIsbn().getValue();
    }

    @Override
    public DtoCaValue getCaValue(DtoType aExpectedDto)
    {
        if(aExpectedDto.equals(DtoType.Category)) {
            return categoryToDisplay;
        }
        else throw new IllegalArgumentException("illegal category");
    }

    @Override
    public void setCaValue(DtoCaValue aNewDtoValue) {
        categoryToDisplay = (CategoryDto) aNewDtoValue;
    }
}
