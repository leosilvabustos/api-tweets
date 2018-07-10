/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.createorupdateuser.http;

import com.zenta.apitweets.business.http.UserResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zenta.apitweets.business.pojo.User;

/**
 *
 * @author Nb-Zenta
 */
public class CreateUser implements UserResponse{
    
    @JsonProperty("createUser")
    private User user;

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString(){
        return "[user:"+user+"]";
    }
    
}
