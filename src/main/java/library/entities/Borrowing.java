package library.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Borrowing {

	@Id
	@GeneratedValue
	@Column(name = "borrowing_id")
	private long borrowingId;
	
	@OneToOne
	@JoinColumn(name = "employe_id")
	Employee employee;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToMany()
	@JoinColumn(name = "book_id")
	Set<Book> books;

	
	
	
	
	public long getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(long borrowingId) {
		this.borrowingId = borrowingId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	
	
}
