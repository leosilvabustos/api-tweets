package com.zenta.apitweets.dbaccess.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zenta.apitweets.dbaccess.models.Tweet;
import com.zenta.apitweets.dbaccess.models.inputs.TweetsByUserInput;
import com.zenta.apitweets.dbaccess.models.outputs.TweetsByUser;
import com.zenta.apitweets.dbaccess.repositories.TweetsRepository;
import com.zenta.apitweets.dbaccess.services.TweetsService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nb-Zenta
 */
@Component
public class QueryResolver implements GraphQLQueryResolver {
    
    private static final Logger LOG = LoggerFactory.getLogger(QueryResolver.class);
    
    private final TweetsService tweetsService;
    public final TweetsRepository tweetsRepository;
    
    @Autowired
    public QueryResolver(TweetsService t, TweetsRepository tr) {
        this.tweetsService = t;
        this.tweetsRepository = tr;
    }
    
    public List<Tweet> allTweets() {
        LOG.info("get all tweets...");
        return tweetsService.findAll();
    }
    
    public TweetsByUser tweets(TweetsByUserInput input) {
        TweetsByUser result = new TweetsByUser();
        LOG.debug("tweets: " + input);
        
        Page resultPage = tweetsRepository.findByMethod(input.getId(), new PageRequest(input.getPage(),input.getPageSize()));
        LOG.info("fooPage.totalElements: " + resultPage.getTotalElements());
        LOG.info("fooPage.getTotalPages: " + resultPage.getTotalPages());
        result.setPage(input.getPage());
        result.setTweets(resultPage.getContent());
        result.setPageSize(input.getPageSize());
        result.setTotalPages(resultPage.getTotalPages());
        LOG.info("result: " + result);
        return result;
    }
    
}
