/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.dbaccess.models.outputs;

import com.zenta.apitweets.dbaccess.models.Tweet;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nb-Zenta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetsByUser {
    
    public Integer pageSize;
    public Integer page;
    public Integer totalPages;
    public List<Tweet> tweets;
    
    @Override
    public String toString() {
    
        return "["+
                "pageSize: " + this.pageSize + 
                ", page: " + this.page +
                ", page: " + this.totalPages +
                ", tweets: " + (this.tweets != null? this.tweets.size(): "0") +
            "]";
    }
    
    
}
