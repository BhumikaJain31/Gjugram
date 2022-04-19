package com.quinbay.usermicroservice.repository;

import com.quinbay.usermicroservice.entity.UserNotificationsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserNotificationRepository extends MongoRepository<UserNotificationsEntity,String> {
    List<UserNotificationsEntity> findByPostUserId(String postuserid);
}
