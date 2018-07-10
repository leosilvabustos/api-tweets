/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.business.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "text",
    "source",
    "truncated",
    "inReplyToStatus",
    "inReplyToUser",
    "inReplyToScreen",
    "createdAt",
    "favorited",
    "favoritedCount",    
    "retweeted",
    "retweetedCount",
    "urls",
    "hashtags",
    "user"
})
public class Tweet {
    
    @JsonProperty("id")
    private String id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("source")
    private String source;
    @JsonProperty("truncated")
    private boolean truncated;
    @JsonProperty("inReplyToStatus")
    private Integer inReplyToStatus;
    @JsonProperty("inReplyToUser")
    private Integer inReplyToUser;
    @JsonProperty("inReplyToScreen")
    private Integer inReplyToScreen;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("favorited")
    private Boolean favorited;
    @JsonProperty("favoritedCount")
    private Integer favoritedCount;
    @JsonProperty("retweeted")
    private Boolean retweeted;
    @JsonProperty("retweetedCount")
    private Integer retweetedCount;
    @JsonProperty("urls")
    private List<String> urls;
    @JsonProperty("hashtags")
    private List<String> hashtags;
    @JsonProperty("user")
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
    
    @Override
    public String toString() {
        return "["+
            "id: " + this.id +
            ", text: " + this.text +
            ", source: " + this.source +
            ", truncated: " + this.truncated +
            ", inReplyToStatus: " + this.inReplyToStatus +
            ", inReplyToUser: " + this.inReplyToUser +
            ", inReplyToScreen: " + this.inReplyToScreen +
            ", createdAt: " + this.createdAt +
            ", favorited: " + this.favorited +
            ", favoritedCount: " + this.favoritedCount +
            ", retweeted: " + this.retweeted +
            ", retweetedCount: " + this.retweetedCount +
            ", urls: " + (this.urls!=null?this.urls.size():"0") +
            ", hashtags: " + (this.hashtags!=null?this.hashtags.size():"0") +
            ", user: " + this.user +
            "]";
    }
}
