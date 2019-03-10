package library.dto;

import java.time.Year;

import library.entities.Book;
import library.entities.BookCategoryE;

public class BookDto {
	
	private Book book;

	public BookDto(Book book) {
		super();
		this.book = book;
	}

	public long getId() {
		return book.getId();
	}

	public String getTitle() {
		return book.getTitle();
	}

	public void setTitle(String title) {
		book.setTitle(title);
	}

	public String getIsbn() {
		return book.getIsbn();
	}

	public void setIsbn(String isbn) {
		book.setIsbn(isbn);
	}

	public BookCategoryE getCategory() {
		return book.getCategory();
	}

	public void setCategory(BookCategoryE category) {
		book.setCategory(category);
	}

	public String getAuthor() {
		return book.getAuthor();
	}

	public void setAuthor(String author) {
		book.setAuthor(author);
	}

	public Year getYearOfPublication() {
		return book.getYearOfPublication();
	}

	public void setYearOfPublication(Year yearOfPublication) {
		book.setYearOfPublication(yearOfPublication);
	}

	public int getQuantity() {
		return book.getQuantity();
	}

	public void setQuantity(int quantity) {
		book.setQuantity(quantity);
	}
	
	
	
}
