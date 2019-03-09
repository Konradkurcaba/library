package library.entities;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "book_id")
	private long bookId;
	
	private String title;
	private String isbn;
	private BookCategoryE category;
	private String author;
	@Column(name = "year_of_publication")
	private Year yearOfPublication;
	private int quantity;
	public long getId() {
		return bookId;
	}
	public void setId(long id) {
		this.bookId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BookCategoryE getCategory() {
		return category;
	}
	public void setCategory(BookCategoryE category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Year getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(Year yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
