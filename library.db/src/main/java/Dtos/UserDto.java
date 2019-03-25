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

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public StringProperty zipCodeProperty() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getHouseNumber() {
        return houseNumber.get();
    }

    public StringProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public boolean isPersisted() {
        return isPersisted;
    }
}
