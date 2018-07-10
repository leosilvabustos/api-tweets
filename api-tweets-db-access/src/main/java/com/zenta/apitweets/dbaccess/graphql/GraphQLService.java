package com.zenta.apitweets.dbaccess.graphql;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nb-Zenta
 */

@Service
public class GraphQLService {
    
    private final GraphQL graphQL;

    @Autowired
    public GraphQLService(GraphQL graphQL) {
        this.graphQL = graphQL;
    }
    
    public ExecutionResult execute(String query) {        
        return graphQL.execute(query);
    }
}
