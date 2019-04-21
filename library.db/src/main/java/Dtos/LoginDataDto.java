package Dtos;

import Entities.AccountType;
import Entities.Employee;
import Entities.LoginData;

public class LoginDataDto {

    private LoginData loginData;

    public LoginDataDto(LoginData loginData) {
        this.loginData = loginData;
    }

    public String getAccountName() {
        return loginData.getAccountName();
    }

    public void setAccountName(String accountName) {
        loginData.setAccountName(accountName);
    }

    public AccountType getType() {
        return loginData.getType();
    }

    public void setType(AccountType type) {
        loginData.setType(type);
    }

    public byte[] getPassword() {
        return loginData.getPassword();
    }

    public void setPassword(byte[] password) {
        loginData.setPassword(password);
    }

    public Employee getEmployee() {
        return loginData.getEmployee();
    }

    public void setEmployee(Employee employee) {
        loginData.setEmployee(employee);
    }
}
