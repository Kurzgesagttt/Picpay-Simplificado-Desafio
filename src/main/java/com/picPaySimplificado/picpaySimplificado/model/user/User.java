package com.picPaySimplificado.picpaySimplificado.model.user;

import com.picPaySimplificado.picpaySimplificado.dto.UserDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserTypes userType;

    public User(UserTypes userType, BigDecimal balance, String password, String email, String lastName, String document, String firstName) {
        this.userType = userType;
        this.balance = balance;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.document = document;
        this.firstName = firstName;

    }

    public User() {
    }

    public User(UserDTO data){
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.document = data.document();
        this.email = data.email();
        this.password = data.password();
        this.userType = data.userTypes();
        this.balance = data.balance();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }
}

