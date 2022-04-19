package com.quinbay.usermicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Document(collection = "user")
public class UserEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userName;
    private String name;
    private String password;
    private String accType;
    private String email;
    private List<String> interest;

    public UserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UserEntity(String id,String userName, String name, String password, String accType, String email, List<String> interest) {
        this.id=id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.accType = accType;
        this.email = email;
        this.interest = interest;
    }

    public UserEntity(String id, String userName, String name, String password, String accType, String email) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.accType = accType;
        this.email = email;
    }


}
