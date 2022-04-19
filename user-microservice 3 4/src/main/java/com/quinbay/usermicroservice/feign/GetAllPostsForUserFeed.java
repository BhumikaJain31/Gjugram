package com.quinbay.usermicroservice.feign;

import com.quinbay.usermicroservice.entity.PostsEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "get-post-for-feed", url = "http://localhost:8082")
public interface GetAllPostsForUserFeed {
    @GetMapping("post/get-user-post")
    List<PostsEntity> getFeedForUser(@RequestParam(value = "userId") String userId);
}