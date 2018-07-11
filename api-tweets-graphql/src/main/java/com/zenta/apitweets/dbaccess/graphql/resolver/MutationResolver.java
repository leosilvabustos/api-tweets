package com.zenta.apitweets.dbaccess.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.zenta.apitweets.dbaccess.models.Tweet;
import com.zenta.apitweets.dbaccess.models.User;
import com.zenta.apitweets.dbaccess.models.inputs.TweetInput;
import com.zenta.apitweets.dbaccess.models.inputs.UserInput;
import com.zenta.apitweets.dbaccess.repositories.TweetsRepository;
import com.zenta.apitweets.dbaccess.repositories.UserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nb-Zenta
 */
@Component
public class MutationResolver implements GraphQLMutationResolver {
    
    private static final Logger LOG = LoggerFactory.getLogger(MutationResolver.class);
    
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
        u.setProfileUrl(uInput.getProfileUrl());
        u.setCreatedAt(uInput.getCreatedAt());
        u.setFollowing(uInput.getFollowing());
        this.userRepository.save(u);
        return u;
    }
    
    @Transactional
    public Tweet createTweet(TweetInput input) {
        
        LOG.info("createTweet: ["+input+"]");        
        Tweet tweet = new Tweet();
        tweet.setText(input.getText());
        tweet.setSource(input.getSource());
        tweet.setTruncated(input.isTruncated());
        tweet.setInReplyToScreen(input.getInReplyToScreen());
        tweet.setInReplyToStatus(input.getInReplyToStatus());
        tweet.setInReplyToUser(input.getInReplyToUser());
        tweet.setCreatedAt(input.getCreatedAt());
        tweet.setFavorited(input.getFavorited());
        tweet.setFavoritedCount(input.getFavoritedCount());
        tweet.setRetweeted(input.getRetweeted());
        tweet.setRetweetedCount(input.getRetweetedCount());
        tweet.setUrls(input.getUrls());
        tweet.setHashtags(input.getHashtags());        
        User user = null;
        try {
            user = this.userRepository.findByProfileUrl(input.getUser().getProfileUrl());            
        } catch (Exception e) {
            LOG.error("Error al checkear al usuario", e);
        }
        if(user == null) {
            LOG.info("Nuevo usuario");
            user = new User();
        } else {
            LOG.info("Usuario existente...");
        }
        user.setName(input.getUser().getName());
        user.setCreatedAt(input.getUser().getCreatedAt());
        user.setFollowing(input.getUser().getFollowing());
        user.setProfileUrl(input.getUser().getProfileUrl());
        this.userRepository.save(user);
        LOG.info("Usuario guardado...");
        tweet.setUser(user.getId());
        this.tweetsRepository.save(tweet);
        LOG.info("Tweet guardado");
        return tweet;
    }
    
    public User checkUser(String id, String userUrl) {
        return id==null?this.userRepository.findByProfileUrl(userUrl) : 
                this.userRepository.findOne(id);
    }
    
    @Transactional
    public User updateUser(String id, UserInput uInput) {
        User u = this.userRepository.findOne(id);
        u.setName(uInput.getName());
        u.setProfileUrl(uInput.getProfileUrl());
        u.setCreatedAt(uInput.getCreatedAt());
        u.setFollowing(uInput.getFollowing());
        this.userRepository.save(u);
        return u;
    }
}
