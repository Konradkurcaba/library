package library.dto;

import library.entities.Employee;

public class EmployeeDto {

	private Employee employee;

	public EmployeeDto(Employee employee) {
		super();
		this.employee = employee;
	}

	public long getId() {
		return employee.getId();
	}

	public String getFirstName() {
		return employee.getFirstName();
	}

	public void setFirstName(String firstName) {
		employee.setFirstName(firstName);
	}

	public String getLastName() {
		return employee.getLastName();
	}

	public void setLastName(String lastName) {
		employee.setLastName(lastName);
	}

	public String getZipCode() {
		return employee.getZipCode();
	}

	public void setZipCode(String zipCode) {
		employee.setZipCode(zipCode);
	}

	public String getCity() {
		return employee.getCity();
	}

	public void setCity(String city) {
		employee.setCity(city);
	}

	public String getStreet() {
		return employee.getStreet();
	}

	public void setStreet(String street) {
		employee.setStreet(street);
	}

	public String getHouseNumber() {
		return employee.getHouseNumber();
	}

	public void setHouseNumber(String houseNumber) {
		employee.setHouseNumber(houseNumber);
	}
	
	
	
}
