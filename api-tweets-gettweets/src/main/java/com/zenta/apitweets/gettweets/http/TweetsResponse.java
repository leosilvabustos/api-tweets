/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.gettweets.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zenta.apitweets.business.pojo.Tweet;
import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetsResponse {
    
    @JsonProperty("pageSize")
    private String pageSize;
    @JsonProperty("page")
    private String page;
    @JsonProperty("totalPages")
    private String totalPages;
    @JsonProperty("tweets")
    private List<Tweet> tweets;

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
    
    
    
}
