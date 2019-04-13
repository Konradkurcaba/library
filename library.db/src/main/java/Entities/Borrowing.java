package Entities;

import java.sql.Date;
import java.sql.SQLData;
import java.time.LocalDate;
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
	Set<Book> books;

	@Column(name = "start_borrow_date")
	private LocalDate startBorrowDate;

	@Column(name = "end_borrow_date")
	private LocalDate endBorrowDate;


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
}
