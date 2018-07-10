/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.createtweet.http;

import com.zenta.apitweets.business.http.Result;
import com.zenta.apitweets.business.pojo.Tweet;

/**
 *
 * @author Nb-Zenta
 */
public class ApiTweetResult extends Result {
    
    private Tweet tweet;

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
    
    @Override
    public String toString() {
        return "[tweet: "+tweet+"]";
    }
}
