package com.zenta.apitweets.dbaccess.graphql;


import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.coxautodev.graphql.tools.SchemaParser.newParser;
import com.zenta.apitweets.dbaccess.graphql.resolver.MutationResolver;
import com.zenta.apitweets.dbaccess.graphql.resolver.QueryResolver;
import com.zenta.apitweets.dbaccess.graphql.resolver.TweetsResolver;


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
