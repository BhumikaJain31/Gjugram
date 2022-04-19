package com.quinbay.usermicroservice.dto;
import com.quinbay.usermicroservice.entity.PostsEntity;
import java.util.List;
public class UserFeed {
    private UserProfileDetails userProfileDetails;
    private List<PostsEntity> postsEntity;
    public UserFeed() {
    }

    public UserFeed(UserProfileDetails userProfileDetails, List<PostsEntity> postsEntity) {
        this.userProfileDetails = userProfileDetails;
        this.postsEntity = postsEntity;
    }

    public UserProfileDetails getUserProfileDetails() {
        return userProfileDetails;
    }

    public void setUserProfileDetails(UserProfileDetails userProfileDetails) {
        this.userProfileDetails = userProfileDetails;
    }

    public List<PostsEntity> getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(List<PostsEntity> postsEntity) {
        this.postsEntity = postsEntity;
    }
}
