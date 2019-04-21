package Entities;

import javax.persistence.*;

@Entity
public class LoginData {

    @Id
    @Column(name = "account_name")
    private String accountName;
    private AccountType type;
    private byte[] password;
    @OneToOne
    @JoinColumn(name= "employee_id")
    private Employee employee;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
