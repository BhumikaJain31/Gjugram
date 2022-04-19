package com.quinbay.usermicroservice.dto;

import java.util.List;

public class UserPost {

    private String id;
    private String userId;
    private String userDp;
    private String userBio;
    private List<String>postId;
    private List<String>followerList;
    private List<String>followingList;
    private List<String> requestList;

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public List<String> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<String> requestList) {
        this.requestList = requestList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserDp() {
        return userDp;
    }

    public void setUserDp(String userDp) {
        this.userDp = userDp;
    }

    public List<String> getPostId() {
        return postId;
    }

    public void setPostId(List<String> postId) {
        this.postId = postId;
    }

    public List<String> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<String> followerList) {
        this.followerList = followerList;
    }

    public List<String> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(List<String> followingList) {
        this.followingList = followingList;
    }

    public UserPost(String id, String userId, String userDp, String userBio, List<String> postId, List<String> followerList, List<String> followingList, List<String> requestList) {
        this.id = id;
        this.userId = userId;
        this.userDp = userDp;
        this.userBio = userBio;
        this.postId = postId;
        this.followerList = followerList;
        this.followingList = followingList;
        this.requestList = requestList;
    }

    public UserPost(String id, String userId, String userDp, String userBio, List<String> postId, List<String> followerList, List<String> followingList) {
        this.id = id;
        this.userId = userId;
        this.userDp = userDp;
        this.userBio = userBio;
        this.postId = postId;
        this.followerList = followerList;
        this.followingList = followingList;
    }

    public UserPost() {
    }
}
