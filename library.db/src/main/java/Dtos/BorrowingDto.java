package Dtos;

import Entities.Book;
import Entities.Borrowing;
import Entities.Employee;
import Entities.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Set;

public class BorrowingDto implements DtoWithCa {

	private Borrowing borrowing;

	private StringProperty startDate = new SimpleStringProperty("");
	private StringProperty endDate = new SimpleStringProperty("");

    private EmployeeDto employeeToPersist;
    private UserDto userToPersist;

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


    @Override
    public DtoCaValue getCaValue(DtoType aExpectedDto) {

        switch (aExpectedDto)
        {
            case Employee:
                return new EmployeeDto(getEmployee());
            case User:
                return new UserDto(getUser());
            default: throw new IllegalArgumentException("This class doesn't contain expectedDto type");
        }
    }

    @Override
    public void setCaValue(DtoCaValue aNewDtoValue) {
        if(aNewDtoValue instanceof EmployeeDto)
        {
            employeeToPersist = (EmployeeDto) aNewDtoValue;
        }
        else if(aNewDtoValue instanceof UserDto)
        {
            userToPersist = (UserDto) aNewDtoValue;
        }
    }
}
