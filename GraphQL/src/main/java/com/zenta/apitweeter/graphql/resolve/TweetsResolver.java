/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.graphql.resolve;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.zenta.apitweeter.models.Tweet;
import com.zenta.apitweeter.models.User;
import com.zenta.apitweeter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nb-Zenta
 */
@Service
public class TweetsResolver  implements GraphQLResolver<Tweet>{

    private final UserRepository userRepository;
    
    @Autowired
    public TweetsResolver(UserRepository repository) {
        this.userRepository = repository;
    }
    
    public User user(Tweet t) {
        System.out.println("Return user ID: " + t);
        return userRepository.findOne(t.getUser());
    }
}
