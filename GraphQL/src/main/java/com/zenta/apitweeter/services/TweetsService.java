/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.services;

import com.zenta.apitweeter.models.Tweet;
import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
public interface TweetsService {
    
    List<Tweet> findAllUserTweets(List<String> userId);
    List<Tweet> findAll();
    
}
