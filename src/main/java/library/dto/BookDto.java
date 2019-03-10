package library.dto;

import java.time.Year;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.entities.Book;
import library.entities.BookCategoryE;

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

	public void setTitle(String title) {
		//to do 
	}

	public StringProperty getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		//todo
	}

	public StringProperty getCategory() {
		return category;
	}

	public void setCategory(BookCategoryE category) {
		//todo
	}

	public StringProperty getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		//todo
	}

	public StringProperty getYearOfPublication() {
		return year;
	}

	public void setYearOfPublication(Year yearOfPublication) {
		//todo
	}

	public StringProperty getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		//todo
	}
	
	
	
}
