package com.zenta.apitweets.dbaccess.services;

import com.zenta.apitweets.dbaccess.models.Tweet;
import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
public interface TweetsService {
    
    List<Tweet> findAllUserTweets(List<String> userId);
    List<Tweet> findAll();
    
}
