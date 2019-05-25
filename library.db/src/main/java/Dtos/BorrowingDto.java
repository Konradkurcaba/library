package Dtos;

import Entities.Book;
import Entities.Borrowing;
import Entities.Employee;
import Entities.User;
import Validator.DtoValidator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.Set;

public class BorrowingDto implements DtoWithCa {

	private Borrowing borrowing;

	private StringProperty startDate = new SimpleStringProperty("");
	private StringProperty endDate = new SimpleStringProperty("");
	private BooleanProperty returned = new SimpleBooleanProperty(false);

    private EmployeeDto employeeToDisplay;
    private UserDto userToDisplay;
    private boolean isPersisted;

    private DtoValidator dtoValidator = new DtoValidator();

	public BorrowingDto(Borrowing borrowing) {
		super();
		this.borrowing = borrowing;
		startDate.setValue(borrowing.getStartBorrowDate().toString());
		endDate.setValue(borrowing.getEndBorrowDate().toString());
		userToDisplay = new UserDto(borrowing.getUser());
		employeeToDisplay = new EmployeeDto(borrowing.getEmployee());
		returned.setValue(borrowing.isReturned());
		isPersisted = true;
	}

	public BorrowingDto()
    {
        isPersisted = false;
        userToDisplay = new UserDto();
        employeeToDisplay = new EmployeeDto();
    }

    public Borrowing getBorrowing()
    {
        return borrowing;
    }

    public void setBorrowing(Borrowing aBorrowing)
    {
        borrowing = aBorrowing;
        isPersisted = true;
    }

    public StringProperty startDateProperty() { return startDate;
    }

    public StringProperty endDateProperty() {
        return endDate;
    }


    public BooleanProperty returnedProperty() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned.set(returned);
    }

    public void setStartDate(String startDate) {
	    dtoValidator.checkDate(startDate);
        this.startDate.set(startDate);
    }

    public void setEndDate(String endDate) {
        dtoValidator.checkDate(endDate);
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

    public boolean isPersisted()
    {
        return isPersisted;
    }


    @Override
    public DtoCaValue getCaValue(DtoType aExpectedDto) {
        switch (aExpectedDto)
        {
            case Employee:
                return employeeToDisplay;
            case User:
                return userToDisplay;
            default: throw new IllegalArgumentException("This class doesn't contain expectedDto value");
        }
    }

    @Override
    public void setCaValue(DtoCaValue aNewDtoValue) {
        if(aNewDtoValue instanceof EmployeeDto)
        {
            employeeToDisplay = (EmployeeDto) aNewDtoValue;
        }
        else if(aNewDtoValue instanceof UserDto)
        {
            userToDisplay = (UserDto) aNewDtoValue;
        }
    }

    public void commitChanges()
    {
        LocalDate startDate = LocalDate.parse(startDateProperty().getValue());
        borrowing.setStartBorrowDate(startDate);

        LocalDate endDate = LocalDate.parse(endDateProperty().getValue());
        borrowing.setEndBorrowDate(endDate);

        if(employeeToDisplay != null)
        {
            borrowing.setEmployee(employeeToDisplay.getEmployee());
        }
        if(userToDisplay != null)
        {
            borrowing.setUser(userToDisplay.getUser());
        }

        borrowing.setReturned(returned.get());

    }
}
