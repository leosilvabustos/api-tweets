package com.zenta.apitweets.dbaccess;

import com.zenta.apitweets.dbaccess.graphql.GraphQLService;
import graphql.ExecutionResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
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
        Map<String, Object> response = new HashMap<>();
        response.put("errors", result.getErrors());
        if(result.getErrors() == null || result.getErrors().isEmpty()) {
            LinkedHashMap mapData = ((LinkedHashMap) result.getData());
            Set<String> keys = mapData.keySet();
            keys.stream().forEach((_item) -> {
                response.put( (String)_item, mapData.get((String)_item));
            });
        }        
        return ResponseEntity.ok(response);
    }
    
}
