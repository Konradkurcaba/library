package Dtos;

import Entities.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserDto {

    private User user;
    private boolean isPersisted;

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty zipCode;
    private StringProperty city;
    private StringProperty street;
    private StringProperty houseNumber;
    private StringProperty phoneNumber;
    private StringProperty email;

    public UserDto(User user) {
        this.user = user;
        firstName = new SimpleStringProperty(user.getFirstName());
        lastName = new SimpleStringProperty(user.getLastName());
        zipCode = new SimpleStringProperty(user.getZipCode());
        city = new SimpleStringProperty(user.getCity());
        street = new SimpleStringProperty(user.getStreet());
        houseNumber = new SimpleStringProperty(user.getHouseNumber());
        phoneNumber = new SimpleStringProperty(user.getPhoneNumber());
        email = new SimpleStringProperty(user.getEmail());

        isPersisted = true;
    }

    public UserDto()
    {
        firstName = new SimpleStringProperty("");
        lastName = new SimpleStringProperty("");
        zipCode = new SimpleStringProperty("");
        city = new SimpleStringProperty("");
        street = new SimpleStringProperty("");
        houseNumber = new SimpleStringProperty("");
        phoneNumber = new SimpleStringProperty("");
        email = new SimpleStringProperty("");

        isPersisted = false;
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public StringProperty getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public StringProperty getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User aUser){
        user = aUser;
        isPersisted = true;
    }

    public boolean isPersisted() {
        return isPersisted;
    }

    public void commitChanges()
    {
        user.setFirstName(firstName.getValue());
        user.setLastName(lastName.getValue());
        user.setCity(city.getValue());
        user.setHouseNumber(houseNumber.getValue());
        user.setPhoneNumber(phoneNumber.getValue());
        user.setStreet(street.getValue());
        user.setEmail(email.getValue());
        user.setZipCode(zipCode.getValue());


    }
}
