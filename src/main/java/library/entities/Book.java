package library.entities;

import java.time.Year;
import java.util.UUID;

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
	private String uuid = UUID.randomUUID().toString();
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
	
}
