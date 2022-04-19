package com.quinbay.usermicroservice.service;

import com.quinbay.usermicroservice.dto.User;
import com.quinbay.usermicroservice.entity.UserEntity;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserByUserId(String id);

    User update(User user);

    User updateInterest(User user);

    User authenticate(String userName,String password);



}
