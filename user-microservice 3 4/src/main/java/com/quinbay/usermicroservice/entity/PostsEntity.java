package com.quinbay.usermicroservice.entity;

import java.util.Date;
import java.util.List;

public class PostsEntity {

    private String id;
    private String userId;
    private String location;
    private String caption;
    private Date timestamp = new Date(System.currentTimeMillis());
    private String mediaType;
    private List<String> likes;
    private List<String> comment;

    public PostsEntity() {
    }

    public PostsEntity(String id, String userId, String location, String caption, Date timestamp, String mediaType, List<String> likes, List<String> comment) {
        this.id = id;
        this.userId = userId;
        this.location = location;
        this.caption = caption;
        this.timestamp = timestamp;
        this.mediaType = mediaType;
        this.likes = likes;
        this.comment = comment;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMediaType() {
        return mediaType;
    }


    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public List getLikes() {
        return likes;
    }

    public void setLikes(List likes) {
        this.likes = likes;
    }

    public List getComment() {
        return comment;
    }

    public void setComment(List comment) {
        this.comment = comment;
    }
}
