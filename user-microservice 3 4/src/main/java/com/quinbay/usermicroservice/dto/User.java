package com.quinbay.usermicroservice.dto;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String userName;
    private String password;
    private String accType;
    private String email;
    private List<String> interest;

    public User(){}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public User(String id, String name, String userName, String password, String accType, String email, List<String> interest) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.accType = accType;
        this.email = email;
        this.interest = interest;
    }


    public User(String id, String name, String userName, String password, String accType, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.accType = accType;
        this.email = email;
    }
}
