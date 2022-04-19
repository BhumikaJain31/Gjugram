package com.quinbay.usermicroservice.controller;


import com.quinbay.usermicroservice.dto.UserNotifications;
import com.quinbay.usermicroservice.dto.UserPostFeed;
import com.quinbay.usermicroservice.dto.UserProfileDetails;
import com.quinbay.usermicroservice.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-post")
@CrossOrigin(origins = "http://localhost:8081")
public class UserPostController {

    @Autowired
    UserPostService userPostService;

    @PutMapping(value = "/update-posts-in-userposts")
    boolean sendPostId(@RequestParam String postId, @RequestParam String userId) {
        return userPostService.setPostIdListInUserPost(postId, userId);
    }


    @PostMapping(value = "/set-userid-in-userpost")
    public boolean setUserInPost(@RequestParam String userId) {

        return userPostService.setUserIdInPost(userId);
    }

    @PutMapping(value = "/update-bio-dp")
    public boolean setBioAndDp(@RequestParam String userId, @RequestParam String dp, @RequestParam String bio) {

        return userPostService.addBioAndDp(userId, dp, bio);
    }

    @GetMapping(value = "/get-user-profile-details")
    public UserProfileDetails getUserProfileDetails(@RequestParam String userId) {
        return userPostService.getUserProfileDetails(userId);
    }


    @GetMapping(value = "/get-all-users")
    public List<UserProfileDetails> getAllUsers() {
        return userPostService.getAllUsers();
    }

    @PutMapping(value = "/update-following-list")
    boolean updateFollowingList(@RequestParam String userId, @RequestParam String followingId) {
        return userPostService.updateFollowingAndFollower(userId, followingId);
    }

    @GetMapping(value = "/user-feed")
    public List<UserPostFeed> getFeedForUser(@RequestParam String userId) {
        return userPostService.getFeedForUser(userId);
    }

    @PutMapping(value = "/update-request-list")
    public boolean updateRequestList(@RequestParam String userId, @RequestParam String followingId) {
        return userPostService.updateRequestList(userId, followingId);
    }

    @GetMapping("/get-user-details-for-request")
    public List<UserProfileDetails> getUserDetailsForRequest(@RequestParam String userId) {
        return userPostService.getUserDetailsForRequest(userId);
    }



    @DeleteMapping("/delete-request")
    public boolean deleteUserFromRequest(@RequestParam String userId, @RequestParam String requestId){
        return userPostService.deleteUserFromRequest(userId, requestId);
    }

    @PostMapping("/add-to-notification")
    public  boolean addToNotification(@RequestParam String userId, @RequestParam String postUserId,@RequestParam String notificationType){
        return userPostService.addtoUserNotification(userId, postUserId, notificationType);
    }

    @GetMapping("/get-all-notification-by-postUserId")
    public List<UserNotifications> getAllNotification(@RequestParam String postUserId){
        return userPostService.getAllNotificationsByPostUserId(postUserId);
    }

}
