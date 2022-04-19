package com.quinbay.usermicroservice.service;

import com.quinbay.usermicroservice.dto.UserNotifications;
import com.quinbay.usermicroservice.dto.UserPostFeed;
import com.quinbay.usermicroservice.dto.UserProfileDetails;

import java.util.List;

public interface UserPostService {

    UserProfileDetails getUserProfileDetails(String userId);

    boolean addBioAndDp(String userId, String dp, String bio);

    boolean setUserIdInPost(String userId);

    List<UserProfileDetails> getAllUsers();

    boolean updateFollowingAndFollower(String userId, String followingId);

    boolean setPostIdListInUserPost(String postId, String userId);

    List<UserPostFeed> getFeedForUser(String userId);

    boolean updateRequestList(String userId, String followingId);

    List<UserProfileDetails> getUserDetailsForRequest(String userId);

    boolean deleteUserFromRequest(String userId, String requestId);

    boolean addtoUserNotification(String userId,String postUserId,String notificationType);

    List<UserNotifications> getAllNotificationsByPostUserId(String postUserId);

}
