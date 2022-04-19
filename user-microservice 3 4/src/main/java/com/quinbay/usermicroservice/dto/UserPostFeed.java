package com.quinbay.usermicroservice.dto;

import com.quinbay.usermicroservice.entity.PostsEntity;

import java.util.List;

public class UserPostFeed {
    private UserProfileDetails userProfileDetails;
    private PostsEntity postsEntity;

    public UserPostFeed(UserProfileDetails userProfileDetails, PostsEntity postsEntity) {
        this.userProfileDetails = userProfileDetails;
        this.postsEntity = postsEntity;
    }

    public UserProfileDetails getUserProfileDetails() {
        return userProfileDetails;
    }

    public void setUserProfileDetails(UserProfileDetails userProfileDetails) {
        this.userProfileDetails = userProfileDetails;
    }

    public PostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(PostsEntity postsEntity) {
        this.postsEntity = postsEntity;
    }
}
