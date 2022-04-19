package com.quinbay.usermicroservice.service;

import com.quinbay.usermicroservice.dto.UserNotifications;
import com.quinbay.usermicroservice.dto.UserPostFeed;
import com.quinbay.usermicroservice.dto.UserProfileDetails;
import com.quinbay.usermicroservice.entity.PostsEntity;
import com.quinbay.usermicroservice.entity.UserEntity;
import com.quinbay.usermicroservice.entity.UserNotificationsEntity;
import com.quinbay.usermicroservice.entity.UserPostEntity;
import com.quinbay.usermicroservice.feign.GetAllPostsForUserFeed;
import com.quinbay.usermicroservice.repository.UserNotificationRepository;
import com.quinbay.usermicroservice.repository.UserPostRepository;
import com.quinbay.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserPostServiceImpl implements UserPostService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPostRepository userPostRepository;

    @Autowired
    UserNotificationRepository userNotificationRepository;

    @Autowired
    GetAllPostsForUserFeed getAllPostsForUserFeed;


    @Override
    public UserProfileDetails getUserProfileDetails(String userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);

        if (userEntity.isPresent() && userPostEntity.isPresent()) {
            return new UserProfileDetails(userEntity.get().getId(), userEntity.get().getUserName(), userEntity.get().getName(), userPostEntity.get().getUserBio(), userPostEntity.get().getUserDp(), userPostEntity.get().getFollowerList(), userPostEntity.get().getFollowingList(), userPostEntity.get().getPostId(),userEntity.get().getAccType(),userEntity.get().getEmail());
        }
        return null;
    }

    @Override
    public boolean addBioAndDp(String userId, String dp, String bio) {
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);
        if (userPostEntity.isPresent()) {
            userPostEntity.get().setUserBio(bio);
            userPostEntity.get().setUserDp(dp);
            userPostRepository.save(userPostEntity.get());
            return true;
        }
        return false;

    }

    @Override
    public boolean setUserIdInPost(String userId) {
        UserPostEntity userPostEntity = new UserPostEntity();
        userPostEntity.setUserId(userId);


        userPostRepository.save(userPostEntity);
        return true;

    }

    @Override
    public List<UserProfileDetails> getAllUsers() {

        List<UserProfileDetails> userProfileDetailsList = new ArrayList<>();

        List<UserPostEntity> list = userPostRepository.findAll();

        for (UserPostEntity userPostEntity : list) {

            String id = userPostEntity.getUserId();

            Optional<UserEntity> userEntity = userRepository.findById(id);


            if (userEntity.isPresent()) {

                UserProfileDetails userProfileDetails = new UserProfileDetails(id, userEntity.get().getUserName(), userEntity.get().getName(), userPostEntity.getUserDp(), userEntity.get().getAccType());
                userProfileDetailsList.add(userProfileDetails);
            }
        }

        return userProfileDetailsList;
    }


    @Override
    public boolean updateFollowingAndFollower(String userId, String followingId) {
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);
        Optional<UserPostEntity> userPostEntity1 = userPostRepository.findByUserId(followingId);
        if (userPostEntity.isPresent()) {
            if (userPostEntity.get().getFollowingList() == null) {
                List<String> followingList = new ArrayList<>();
                followingList.add(followingId);
                userPostEntity.get().setFollowingList(followingList);
                userPostRepository.save(userPostEntity.get());
                //return true;
            } else {
                List<String> list = userPostEntity.get().getFollowingList();
                if (!list.contains(followingId)) {
                    list.add(followingId);
                    userPostEntity.get().setFollowingList(list);
                    userPostRepository.save(userPostEntity.get());
                }
                //return true;
            }
        }
        if (userPostEntity1.isPresent()) {
            if (userPostEntity1.get().getFollowerList() == null) {
                List<String> followerList = new ArrayList<>();
                followerList.add(userId);
                userPostEntity1.get().setFollowerList(followerList);
                userPostRepository.save(userPostEntity1.get());
                return true;
            } else {
                List<String> list = userPostEntity1.get().getFollowerList();
                if (!list.contains(userId)) {
                    list.add(userId);
                    userPostEntity1.get().setFollowerList(list);
                    userPostRepository.save(userPostEntity1.get());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean setPostIdListInUserPost(String postId, String userId) {
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);
        //System.out.println(userPostEntity.get().getUserId());

        if (userPostEntity.isPresent()) {
            if (userPostEntity.get().getPostId() == null) {
                List<String> listofPosts = new ArrayList<>();
                listofPosts.add(postId);
                userPostEntity.get().setPostId(listofPosts);
                userPostRepository.save(userPostEntity.get());
                return true;
            } else {
                List<String> list = userPostEntity.get().getPostId();
                list.add(postId);
                userPostEntity.get().setPostId(list);
                userPostRepository.save(userPostEntity.get());
                return true;
            }


        }
        return false;

    }

    @Override
    public List<UserPostFeed> getFeedForUser(String userId) {


        List<UserPostFeed> feedList1 = new ArrayList<>();
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);
        List<String> list = userPostEntity.get().getFollowingList();
        for (String list1 : list) {
            List<PostsEntity> postsEntityList = getAllPostsForUserFeed.getFeedForUser(list1);
            for (PostsEntity postsEntity : postsEntityList) {
                UserProfileDetails userProfileDetails = getUserProfileDetails(list1);
//                System.out.println(userProfileDetails.getEmail());
                UserPostFeed userPostFeed = new UserPostFeed(userProfileDetails, postsEntity);
                feedList1.add(userPostFeed);
            }

        }
        return feedList1;

    }

    @Override
    public boolean updateRequestList(String userId, String followingId) {
        Optional<UserPostEntity> userPostEntity1 = userPostRepository.findByUserId(followingId);
        Optional<UserEntity> userEntity = userRepository.findById(followingId);

        if (userEntity.get().getAccType().equals("private")) {
            if (userPostEntity1.isPresent()) {
                if (userPostEntity1.get().getRequestList() == null) {
                    List<String> requestList = new ArrayList<>();
                    requestList.add(userId);
                    userPostEntity1.get().setRequestList(requestList);
                    userPostRepository.save(userPostEntity1.get());
                    return true;
                } else {
                    List<String> list = userPostEntity1.get().getRequestList();
                    if (!list.contains(userId)) {
                        list.add(userId);
                        userPostEntity1.get().setRequestList(list);
                        userPostRepository.save(userPostEntity1.get());
                        return true;
                    }
                }
            }
        }

        if (userEntity.get().getAccType().equals("public")) {
            return updateFollowingAndFollower(userId, followingId);
        }

        return false;

    }

    @Override
    public List<UserProfileDetails> getUserDetailsForRequest(String userId){
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);
        List<UserProfileDetails> userProfileDetailsList = new ArrayList<>();
        if(userPostEntity.isPresent()){
            if(userPostEntity.get().getRequestList()!=null){
            for (String user : userPostEntity.get().getRequestList()) {
                UserProfileDetails userProfileDetails = getUserProfileDetails(user);
                userProfileDetailsList.add(userProfileDetails);
            }}
        }
        return userProfileDetailsList;
    }

    @Override
    public boolean deleteUserFromRequest(String userId, String requestId){
        Optional<UserPostEntity> userPostEntity = userPostRepository.findByUserId(userId);
        if(userPostEntity.isPresent()){
            List<String> requestList =  userPostEntity.get().getRequestList();
            requestList.remove(requestId);
            userPostEntity.get().setRequestList(requestList);
            userPostRepository.save(userPostEntity.get());
            return true;
        }
        return  false;
    }

    @Override
    public boolean addtoUserNotification(String userId,String postUserId,String notificationType){
        Optional<UserPostEntity> userPostEntityOptional = userPostRepository.findByUserId(userId);
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if(userPostEntityOptional.isPresent() && userEntityOptional.isPresent()){
            UserNotificationsEntity userNotificationsEntity= new UserNotificationsEntity(userPostEntityOptional.get().getUserDp(), userEntityOptional.get().getUserName(), userId,postUserId,notificationType);
            userNotificationRepository.save(userNotificationsEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<UserNotifications> getAllNotificationsByPostUserId(String postUserId){
        List<UserNotificationsEntity> userNotificationsEntityList = userNotificationRepository.findByPostUserId(postUserId);
        List<UserNotifications> userNotificationsList = new ArrayList<>();
        if(!userNotificationsEntityList.isEmpty()){
            for (UserNotificationsEntity userNotificationsEntity : userNotificationsEntityList){
                UserNotifications userNotifications=new UserNotifications(userNotificationsEntity.getDp(), userNotificationsEntity.getUserName(),userNotificationsEntity.getUserId(),userNotificationsEntity.getPostUserId(), userNotificationsEntity.getNotificationType());
                userNotificationsList.add(userNotifications);
            }

        }
        return userNotificationsList;
    }




}
