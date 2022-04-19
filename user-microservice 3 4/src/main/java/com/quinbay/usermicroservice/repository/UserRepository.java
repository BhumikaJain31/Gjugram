package com.quinbay.usermicroservice.repository;

import com.quinbay.usermicroservice.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {

    Optional<UserEntity> findByUserName(String userName);
    Optional<UserEntity> findById(String id);
    Optional<UserEntity> findByUserNameAndPassword(String userName,String password);

}
