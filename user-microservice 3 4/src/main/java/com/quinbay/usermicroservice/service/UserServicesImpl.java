package com.quinbay.usermicroservice.service;

import com.quinbay.usermicroservice.dto.User;
import com.quinbay.usermicroservice.entity.UserEntity;
import com.quinbay.usermicroservice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        Optional<UserEntity> userEntity = userRepository.findByUserName(user.getUserName());
        if(userEntity.isPresent()){
            return null;
        }
        else {
            UserEntity userEntity1 = new UserEntity( user.getId(),user.getUserName(),user.getName(),user.getPassword(),user.getAccType(),user.getEmail(), user.getInterest());
            UserEntity userEntity2 = userRepository.save(userEntity1);
            User user1 = new User(userEntity2.getId(), userEntity2.getName(), userEntity2.getUserName(),userEntity2.getPassword(),userEntity2.getAccType(),userEntity2.getEmail(), userEntity2.getInterest());
            return user1;
        }


    }



    @Override
    public User getUserByUserId(String id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        System.out.println(userEntity.isPresent());
        if(userEntity.isPresent()) {
            System.out.println("if");
                User user = new User(userEntity.get().getId(), userEntity.get().getName(), userEntity.get().getUserName(), userEntity.get().getPassword(), userEntity.get().getAccType(), userEntity.get().getEmail(), userEntity.get().getInterest());
                System.out.println(user.getUserName());
                return user;
        }
        return null;

    }

    @Override
    public User update(User user) {

        Optional<UserEntity> userEntity = userRepository.findById(user.getId());

        UserEntity userEntity1 = new UserEntity();

        if(userEntity.isPresent()){
            userEntity1 = userEntity.get();

            userEntity1.setInterest(user.getInterest());
            userEntity1.setAccType(user.getAccType());
            userEntity1.setEmail(user.getEmail());
            userEntity1.setPassword(user.getPassword());
            userEntity1.setName(user.getName());
            userEntity1.setUserName(user.getUserName());


        UserEntity userEntity2 = userRepository.save(userEntity1);
        User user1= new User(userEntity2.getId(),userEntity2.getName(),userEntity2.getUserName(),userEntity2.getPassword(),userEntity2.getAccType(),userEntity2.getEmail(),userEntity2.getInterest());
        return user1;}
        return null;


    }

    @Override
    public User updateInterest(User user) {
        Optional<UserEntity> userEntity = userRepository.findById(user.getId());
        UserEntity userEntity1 = userEntity.get();
        userEntity1.setInterest(user.getInterest());
        UserEntity userEntity2=userRepository.save(userEntity1);
        User user1= new User(userEntity2.getId(),userEntity2.getName(),userEntity2.getUserName(),userEntity2.getPassword(),userEntity2.getAccType(),userEntity2.getEmail(),userEntity2.getInterest());
        return user1;
    }


    @Override
    public User authenticate(String userName, String password) {

        Optional<UserEntity> userEntity1 = userRepository.findByUserNameAndPassword(userName, password);

        if (userEntity1.isPresent()) {
            User user = new User(userEntity1.get().getId(), userEntity1.get().getName(), userEntity1.get().getUserName(), userEntity1.get().getPassword(), userEntity1.get().getAccType(), userEntity1.get().getEmail(), userEntity1.get().getInterest());
            return user;
        }
        return null;


    }
}



