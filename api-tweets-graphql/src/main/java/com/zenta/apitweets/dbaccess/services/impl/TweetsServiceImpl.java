package com.zenta.apitweets.dbaccess.services.impl;

import com.zenta.apitweets.dbaccess.models.Tweet;
import com.zenta.apitweets.dbaccess.repositories.TweetsRepository;
import com.zenta.apitweets.dbaccess.services.TweetsService;
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
