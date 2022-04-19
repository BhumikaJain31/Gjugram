package com.quinbay.usermicroservice.repository;

import com.quinbay.usermicroservice.dto.UserPost;
import com.quinbay.usermicroservice.entity.UserPostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPostRepository extends MongoRepository<UserPostEntity,String> {

    Optional<UserPostEntity> findByUserId(String userId);
//    List<UserPostEntity> findByUserId(String userId);



}
