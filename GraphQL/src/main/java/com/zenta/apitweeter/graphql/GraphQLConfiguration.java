/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.graphql;

import com.zenta.apitweeter.graphql.resolve.QueryResolver;
import com.zenta.apitweeter.graphql.resolve.MutationResolver;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.coxautodev.graphql.tools.SchemaParser.newParser;
import com.zenta.apitweeter.graphql.resolve.TweetsResolver;

/**
 *
 * @author Nb-Zenta
 */
@Configuration
public class GraphQLConfiguration {
    
    private final QueryResolver query;
    private final MutationResolver mutation;
    private final TweetsResolver tweetsResolver;

    @Autowired
    public GraphQLConfiguration(QueryResolver query, MutationResolver mutation, TweetsResolver tweetsResolver){
        this.query = query;
        this.mutation = mutation;
        this.tweetsResolver = tweetsResolver;
    }
    
    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL(graphQLSchema())
                .build();
    }

    @Bean
    public GraphQLSchema graphQLSchema() {
        return newParser()
                .file("tweets.graphqls")
                .resolvers(tweetsResolver, query, mutation)
                .build()               
                .makeExecutableSchema();
    }
    
    
}
