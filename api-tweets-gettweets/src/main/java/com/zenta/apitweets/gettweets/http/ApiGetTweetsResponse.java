/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.gettweets.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zenta.apitweets.business.http.api.ApiResponse;

/**
 *
 * @author Nb-Zenta
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiGetTweetsResponse extends ApiResponse{
    
    @JsonProperty("tweets")
    private TweetsResponse tweetsResponse;

    public TweetsResponse getTweetsResponse() {
        return tweetsResponse;
    }

    public void setTweetsResponse(TweetsResponse tweetsResponse) {
        this.tweetsResponse = tweetsResponse;
    }    
}
