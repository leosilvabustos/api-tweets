/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.createorupdateuser.http;

import com.zenta.apitweets.business.http.api.Errors;
import com.zenta.apitweets.business.pojo.User;
import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
public interface UserResponse {
    
    public User getUser();
    
    public List<Errors> getErrors();
}
