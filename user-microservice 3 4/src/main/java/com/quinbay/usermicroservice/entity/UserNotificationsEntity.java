package com.quinbay.usermicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "user-notification")
public class UserNotificationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String dp;
    private String userName;
    private String userId;
    private String postUserId;
    private String notificationType;

    public UserNotificationsEntity() {
    }

    public UserNotificationsEntity(String id, String dp, String userName, String userId, String postUserId, String notificationType) {
        this.id = id;
        this.dp = dp;
        this.userName = userName;
        this.userId = userId;
        this.postUserId = postUserId;
        this.notificationType = notificationType;
    }

    public UserNotificationsEntity(String dp, String userName, String userId, String postUserId, String notificationType) {
        this.dp = dp;
        this.userName = userName;
        this.userId = userId;
        this.postUserId = postUserId;
        this.notificationType = notificationType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(String postUserId) {
        this.postUserId = postUserId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
