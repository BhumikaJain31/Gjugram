package com.quinbay.usermicroservice.dto;

import java.util.List;

public class UserProfileDetails {

    private String userId;
    private String userName;
    private String name;
    private String userBio;
    private String userDp;
    private String accType;
    private String email;
    private List<String> userFollowers;
    private List<String> userFollowing;
    private List<String> userPid;
    private List<String> requestList;

    public UserProfileDetails() {
    }


    public UserProfileDetails(String userId,  String userName, String name, String userDp) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.userDp = userDp;
    }

    public UserProfileDetails(String userId,  String userName, String name, String userDp, String accType) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.userDp = userDp;
        this.accType = accType;
    }


    public UserProfileDetails(String userId, String userName, String name, String userBio, String userDp, List<String> userFollowers, List<String> userFollowing, List<String> userPid,String accType,String email) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.userBio = userBio;
        this.userDp = userDp;
        this.userFollowers = userFollowers;
        this.userFollowing = userFollowing;
        this.userPid = userPid;
        this.accType=accType;
        this.email = email;
    }

    public UserProfileDetails(String userId, String userName, String name, String userBio, String userDp, List<String> userFollowers, List<String> userFollowing, List<String> userPid, List<String> requestList) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.userBio = userBio;
        this.userDp = userDp;
        this.userFollowers = userFollowers;
        this.userFollowing = userFollowing;
        this.userPid = userPid;
        this.requestList = requestList;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public List<String> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<String> requestList) {
        this.requestList = requestList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public String getUserDp() {
        return userDp;
    }

    public void setUserDp(String userDp) {
        this.userDp = userDp;
    }

    public List<String> getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(List<String> userFollowers) {
        this.userFollowers = userFollowers;
    }

    public List<String> getUserFollowing() {
        return userFollowing;
    }

    public void setUserFollowing(List<String> userFollowing) {
        this.userFollowing = userFollowing;
    }

    public List<String> getUserPid() {
        return userPid;
    }

    public void setUserPid(List<String> userPid) {
        this.userPid = userPid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
