package Entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class LoginData {

    @Column(name = "account_name")
    private String accountName;
    private String type;
    private byte[] password;
    @JoinColumn(name= "employee_id")
    private Employee employee;



}
