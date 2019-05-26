package Entities;


import javax.persistence.*;

@Entity
public class LoginData {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "account_name")
    private String accountName;
    private String email;
    private AccountType type;
    private byte[] password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
