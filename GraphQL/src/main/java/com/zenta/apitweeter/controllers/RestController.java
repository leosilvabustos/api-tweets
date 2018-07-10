/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.controllers;

import com.zenta.apitweeter.graphql.GraphQLService;
import graphql.ExecutionResult;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nb-Zenta
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/tweets")
public class RestController {
    
    private final GraphQLService graphQLService;
    private final Logger LOG = LoggerFactory.getLogger(RestController.class);
    
    
    @Autowired
    RestController(GraphQLService graphQLService) throws IOException {
        this.graphQLService = graphQLService;
    }
    
    @PostMapping
    public ResponseEntity query(@RequestBody String query){
        LOG.debug("Request API: " + query);
        ExecutionResult result = graphQLService.execute(query);
        LOG.debug("errors: "+result.getErrors());
        return ResponseEntity.ok(result.getData());
    }
    
}