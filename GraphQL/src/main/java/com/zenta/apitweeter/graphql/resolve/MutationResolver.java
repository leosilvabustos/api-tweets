/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.graphql.resolve;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.zenta.apitweeter.models.Tweet;
import com.zenta.apitweeter.models.User;
import com.zenta.apitweeter.models.inputs.TweetInput;
import com.zenta.apitweeter.models.inputs.UserInput;
import com.zenta.apitweeter.repositories.TweetsRepository;
import com.zenta.apitweeter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nb-Zenta
 */
@Component
public class MutationResolver implements GraphQLMutationResolver {
    
    public final UserRepository userRepository;
    public final TweetsRepository tweetsRepository;
    
    @Autowired
    public MutationResolver(UserRepository u, TweetsRepository t){
        this.userRepository = u;
        this.tweetsRepository = t;
    }
    
    @Transactional
    public User createUser(UserInput uInput) {
        User u = new User();
        u.setName(uInput.getName());
        this.userRepository.save(u);
        return u;
    }
    
    @Transactional
    public Tweet createTweet(TweetInput input) {
        Tweet tweet = new Tweet();
        tweet.setText(input.getText());
        tweet.setSource(input.getSource());
        tweet.setTruncated(input.isTruncated());
        tweet.setInReplyToScreen(input.getInReplyToScreen());
        tweet.setInReplyToStatus(input.getInReplyToStatus());
        tweet.setInReplyToUser(input.getInReplyToUser());
        this.tweetsRepository.save(tweet);
        return tweet;
    }
}
