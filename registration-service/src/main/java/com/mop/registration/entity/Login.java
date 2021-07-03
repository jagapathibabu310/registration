package com.mop.registration.entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  long Id;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "password")
    private  String password;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login() {
    }

    public Login(long id, String userName, String password) {
        Id = id;
        this.userName = userName;
        this.password = password;
    }

}

