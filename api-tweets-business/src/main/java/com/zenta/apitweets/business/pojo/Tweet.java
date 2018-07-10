/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.business.pojo;

import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
public class Tweet {
    
    private String id;
    private String text;
    private String source;
    private boolean truncated;
    private Integer inReplyToStatus;
    private Integer inReplyToUser;
    private Integer inReplyToScreen;
    private String createdAt;
    private Boolean favorited;
    private Integer favoritedCount;
    private Boolean retweeted;
    private Integer retweetedCount;
    private List<String> urls;
    private List<String> hashtags;
    private User user;
    
    public Tweet(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public Integer getInReplyToStatus() {
        return inReplyToStatus;
    }

    public void setInReplyToStatus(Integer inReplyToStatus) {
        this.inReplyToStatus = inReplyToStatus;
    }

    public Integer getInReplyToUser() {
        return inReplyToUser;
    }

    public void setInReplyToUser(Integer inReplyToUser) {
        this.inReplyToUser = inReplyToUser;
    }

    public Integer getInReplyToScreen() {
        return inReplyToScreen;
    }

    public void setInReplyToScreen(Integer inReplyToScreen) {
        this.inReplyToScreen = inReplyToScreen;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Integer getFavoritedCount() {
        return favoritedCount;
    }

    public void setFavoritedCount(Integer favoritedCount) {
        this.favoritedCount = favoritedCount;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Integer getRetweetedCount() {
        return retweetedCount;
    }

    public void setRetweetedCount(Integer retweetedCount) {
        this.retweetedCount = retweetedCount;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
