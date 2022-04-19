package com.quinbay.usermicroservice.dto;

public class UserNotifications {
    private String dp;
    private String userName;
    private String userId;
    private String postUserId;
    private String notificationType;

    public UserNotifications() {
    }

    public UserNotifications(String dp, String userName, String userId, String postUserId, String notificationType) {
        this.dp = dp;
        this.userName = userName;
        this.userId = userId;
        this.postUserId = postUserId;
        this.notificationType = notificationType;
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
