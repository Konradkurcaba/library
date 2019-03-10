package library.dto;

import library.entities.User;

public class UserDto {

	private User user;

	public UserDto(User user) {
		super();
		this.user = user;
	}

	public long getId() {
		return user.getId();
	}

	public String getFirstName() {
		return user.getFirstName();
	}

	public void setFirstName(String firstName) {
		user.setFirstName(firstName);
	}

	public String getLastName() {
		return user.getLastName();
	}

	public void setLastName(String lastName) {
		user.setLastName(lastName);
	}

	public String getZipCode() {
		return user.getZipCode();
	}

	public void setZipCode(String zipCode) {
		user.setZipCode(zipCode);
	}

	public String getCity() {
		return user.getCity();
	}

	public void setCity(String city) {
		user.setCity(city);
	}

	public String getStreet() {
		return user.getStreet();
	}

	public void setStreet(String street) {
		user.setStreet(street);
	}

	public String getHouseNumber() {
		return user.getHouseNumber();
	}

	public void setHouseNumber(String houseNumber) {
		user.setHouseNumber(houseNumber);
	}

	public String getPhoneNumber() {
		return user.getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		user.setPhoneNumber(phoneNumber);
	}

	public String getEmail() {
		return user.getEmail();
	}

	public void setEmail(String email) {
		user.setEmail(email);
	}
	
	
}
