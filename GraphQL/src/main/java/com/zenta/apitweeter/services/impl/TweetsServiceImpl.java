/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.services.impl;

import com.zenta.apitweeter.models.Tweet;
import com.zenta.apitweeter.repositories.TweetsRepository;
import com.zenta.apitweeter.services.TweetsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nb-Zenta
 */
@Service
public class TweetsServiceImpl implements TweetsService{

    private final TweetsRepository tweetsRepository;
    
    @Autowired
    TweetsServiceImpl(TweetsRepository repository){
        this.tweetsRepository = repository;
    }
    
    @Override
    public List<Tweet> findAllUserTweets(List<String> userId) {
        return tweetsRepository.findByIdIn(userId);
    }
    
    @Override
    public List<Tweet> findAll(){
        return (List<Tweet>) tweetsRepository.findAll();
    }
}
