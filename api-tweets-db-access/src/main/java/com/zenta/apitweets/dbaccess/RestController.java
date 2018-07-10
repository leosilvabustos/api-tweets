package com.zenta.apitweets.dbaccess;

import com.zenta.apitweets.dbaccess.graphql.GraphQLService;
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
        LOG.info("Request API: " + query);
        ExecutionResult result = graphQLService.execute(query);
        LOG.info("errors: "+result.getErrors());
        return ResponseEntity.ok(result.getData());
    }
    
}
