package Entities;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Borrowing {

	@Id
	@GeneratedValue
	@Column(name = "borrow_id")
	private long borrowingId;
	
	@OneToOne
	@JoinColumn(name = "employe_id")
	Employee employee;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToMany()
	@JoinColumn(name = "book_id")
	Set<Book> books = new HashSet<>();

	@Column(name = "start_borrow_date")
	private LocalDate startBorrowDate;

	@Column(name = "end_borrow_date")
	private LocalDate endBorrowDate;

	@Column(name = "is_returned")
	private Boolean isReturned;


	public Boolean isReturned() {
		return isReturned;
	}

	public void setReturned(Boolean returned) {
		isReturned = returned;
	}

	public long getBorrowingId() {
		return borrowingId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public User getUser() {
		return user;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public LocalDate getStartBorrowDate() {
		return startBorrowDate;
	}

	public LocalDate getEndBorrowDate() {
		return endBorrowDate;
	}

	public void setBorrowingId(long borrowingId) {
		this.borrowingId = borrowingId;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void setStartBorrowDate(LocalDate startBorrowDate) {
		this.startBorrowDate = startBorrowDate;
	}

	public void setEndBorrowDate(LocalDate endBorrowDate) {
		this.endBorrowDate = endBorrowDate;
	}
}
