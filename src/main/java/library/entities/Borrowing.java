package library.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany
	@JoinColumn(name = "book_id")
	Set<Book> books;
	
}
