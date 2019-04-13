package Dtos;

import Entities.Book;
import Entities.Borrowing;
import Entities.Employee;
import Entities.User;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.Set;

public class BorrowingDto {

	private Borrowing borrowing;

	private StringProperty startDate;
	private StringProperty endDate;

	public BorrowingDto(Borrowing borrowing) {
		super();
		this.borrowing = borrowing;
		startDate.setValue(borrowing.getStartBorrowDate().toString());
		endDate.setValue(borrowing.getEndBorrowDate().toString());
	}

    public StringProperty startDateProperty() {
        return startDate;
    }

    public StringProperty endDateProperty() {
        return endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDate.set(endDate);
    }

    public Employee getEmployee() {
        return borrowing.getEmployee();
    }

    public User getUser() {
        return borrowing.getUser();
    }

    public Set<Book> getBooks() {
        return borrowing.getBooks();
    }

}
