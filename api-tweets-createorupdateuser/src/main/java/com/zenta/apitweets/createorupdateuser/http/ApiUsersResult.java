/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.createorupdateuser.http;

import com.zenta.apitweets.business.http.Result;
import com.zenta.apitweets.business.pojo.User;

/**
 *
 * @author Nb-Zenta
 */
public class ApiUsersResult extends Result{
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
