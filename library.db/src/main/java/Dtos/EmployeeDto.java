package Dtos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Entities.Employee;

public class EmployeeDto {

    private Employee employee;
    private boolean isPersisted;

    StringProperty firstName;
    StringProperty lastName;
    StringProperty zipCode;
    StringProperty city;
    StringProperty street;
    StringProperty houseNumber;


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

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }


    public StringProperty zipCodeProperty() {
        return zipCode;
    }


    public StringProperty cityProperty() {
        return city;
    }


    public StringProperty streetProperty() {
        return street;
    }


    public StringProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public void setHouseNumber(String houseNumber) {
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
}