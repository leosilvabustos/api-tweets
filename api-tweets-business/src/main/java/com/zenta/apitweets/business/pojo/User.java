/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.business.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Nb-Zenta
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "profileUrl",
    "createdAt",
    "following"
})
public class User {
    
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("profileUrl")
    private String profileUrl;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("following")
    private Boolean following;

    public User(){}
    
    public User(String name,String profileUrl,String createdAt,Boolean following){
        this.name=name;
        this.profileUrl=profileUrl;
        this.createdAt=createdAt;
        this.following=following;
    }
    
    public User(String id,String name,String profileUrl,String createdAt,Boolean following){
        this.id=id;
        this.name=name;
        this.profileUrl=profileUrl;
        this.createdAt=createdAt;
        this.following=following;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }
    
    @Override
    public String toString(){
        return "[id: "+this.id+
                ", name:"+this.name+
                ", profileUrl:"+this.profileUrl+
                ", createdAt:"+this.createdAt+
                ", following:"+this.following+
                "]";
    }
}
