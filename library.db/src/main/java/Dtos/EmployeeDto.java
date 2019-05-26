package Dtos;

import Validator.DtoValidator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Entities.Employee;

public class EmployeeDto implements DtoCaValue {

    private Employee employee;
    private boolean isPersisted;

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty zipCode;
    private StringProperty city;
    private StringProperty street;
    private StringProperty houseNumber;

    private DtoValidator dtoValidator = new DtoValidator();


    public EmployeeDto(Employee employee) {
        super();
        this.employee = employee;
        firstName = new SimpleStringProperty(employee.getFirstName());
        lastName = new SimpleStringProperty(employee.getLastName());
        zipCode = new SimpleStringProperty(employee.getZipCode());
        city = new SimpleStringProperty(employee.getCity());
        street = new SimpleStringProperty(employee.getStreet());
        houseNumber = new SimpleStringProperty(employee.getHouseNumber());
        isPersisted = true;
    }

    public EmployeeDto() {
        super();
        firstName = new SimpleStringProperty("");
        lastName = new SimpleStringProperty("");
        zipCode = new SimpleStringProperty("");
        city = new SimpleStringProperty("");
        street = new SimpleStringProperty("");
        houseNumber = new SimpleStringProperty("");
        isPersisted = false;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public boolean isPersisted() {
        return isPersisted;
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public StringProperty getLastName() {
        return lastName;
    }


    public StringProperty getZipCode() {
        return zipCode;
    }


    public StringProperty getCity() {
        return city;
    }


    public StringProperty getStreet() {
        return street;
    }


    public StringProperty getHouseNumber() {
        return houseNumber;
    }

    public void setFirstName(String firstName) {
        dtoValidator.checkSmallFirstLetters(firstName);
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        dtoValidator.checkSmallFirstLetters(lastName);
        this.lastName.set(lastName);
    }

    public void setZipCode(String zipCode) {
        dtoValidator.checkZipCode(zipCode);
        this.zipCode.set(zipCode);
    }

    public void setCity(String city) {
        dtoValidator.checkSmallFirstLetters(city);
        this.city.set(city);
    }

    public void setStreet(String street) {
        dtoValidator.checkNull(street);
        this.street.set(street);
    }

    public void setHouseNumber(String houseNumber) {
        dtoValidator.checkNumber(houseNumber);
        this.houseNumber.set(houseNumber);
    }

    public void commitChanges() {
        employee.setFirstName(firstName.getValue());
        employee.setLastName(lastName.getValue());
        employee.setZipCode(zipCode.getValue());
        employee.setCity(city.getValue());
        employee.setHouseNumber(houseNumber.getValue());
        employee.setStreet(street.getValue());

        isPersisted = true;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getCaName() {
        if(lastName.getValue().isEmpty() || firstName.getValue().isEmpty()) return "";
        else
        return lastName.getValue() + " " + firstName.getValue() + " " + getEmployee().getId();
    }

}
