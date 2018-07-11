/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.createtweet.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zenta.apitweets.business.http.api.ApiResponse;
import com.zenta.apitweets.business.pojo.Tweet;

/**
 *
 * @author Nb-Zenta
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTweetResponse extends ApiResponse{
        
    @JsonProperty("createTweet")
    private Tweet tweet;

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
    
    
}
