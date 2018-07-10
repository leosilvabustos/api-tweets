/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.graphql;

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
