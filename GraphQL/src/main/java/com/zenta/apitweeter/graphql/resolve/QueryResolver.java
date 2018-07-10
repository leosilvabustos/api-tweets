/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.graphql.resolve;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zenta.apitweeter.models.Tweet;
import com.zenta.apitweeter.services.TweetsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nb-Zenta
 */
@Component
public class QueryResolver implements GraphQLQueryResolver {
    
    private final TweetsService tweetsService;
    
    @Autowired
    public QueryResolver(TweetsService t) {
        this.tweetsService = t;
    }
    
    public List<Tweet> tweets() {
        System.out.println("Resolviendo los tweets....");
        return tweetsService.findAll();
    }
    
}
