package com.zenta.apitweets.dbaccess.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.zenta.apitweets.dbaccess.models.Tweet;
import com.zenta.apitweets.dbaccess.models.User;
import com.zenta.apitweets.dbaccess.repositories.UserRepository;

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
        return userRepository.findOne(t.getUser());
    }
}
