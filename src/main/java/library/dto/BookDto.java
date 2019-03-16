package library.dto;

import java.time.Year;
import java.util.Optional;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.broker.CategoryBroker;
import library.entities.Book;
import library.entities.Category;

public class BookDto {

	private Book book;

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
	}

	public StringProperty getId() {
		return new SimpleStringProperty(Long.toString(book.getId()));
	}

	public StringProperty getTitle() {
		return title;
	}

	public void setTitle(String aTitle) {
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
	
	public void commitChanges()
	{
		book.setAuthor(author.getValue());
		book.setIsbn(isbn.getValue());
		book.setTitle(title.getValue());
		
		int convertedYear = Integer.valueOf(year.getValue());
		Year yearOfPublication = Year.of(convertedYear);
		book.setYearOfPublication(yearOfPublication);
		
		int convertedQuantity = Integer.valueOf(quantity.getValue());
		book.setQuantity(convertedQuantity);
		
		CategoryBroker categoryBroker = new CategoryBroker();
		CategoryDto catDto = categoryBroker.CreateCategory(category.getValue());
		book.setCategory(catDto.getCategory());
	}

}
