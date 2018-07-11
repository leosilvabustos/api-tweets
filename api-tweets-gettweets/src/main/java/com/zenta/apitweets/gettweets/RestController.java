/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.gettweets;

import com.zenta.apitweets.business.utils.ReadFile;
import com.zenta.apitweets.gettweets.http.ApiGetTweetsResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nb-Zenta
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/get-tweets")
public class RestController {
    
    private final Logger LOG = LoggerFactory.getLogger(RestController.class);
    
    private final RestTemplate restTemplate;
    private static final String API_URL = "http://localhost:8000/tweets";
    
    @Value("classpath:request-gettweets")
    private Resource requestGetTweets;
    
    @Autowired
    public RestController(RestTemplate rt) {
        this.restTemplate = rt;
    }
    
    @PostMapping
    public ResponseEntity getTweets(@RequestParam(value="userId") String userId, 
            @RequestParam(value="pageSize") String pageSize,
            @RequestParam(value="page") String page) throws IOException
    {
        
        String input = ReadFile.readFromInputStream(requestGetTweets.getInputStream())
                .replace("$userId", userId)
                .replace("$pageSize", pageSize)
                .replace("$page", page);
        ApiGetTweetsResponse res = requestToApi(input);
        return ResponseEntity.ok(res);
    }
    
    public ApiGetTweetsResponse requestToApi(String input) {
        
        LOG.info("Request api: " + input);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(input, headers);
        ApiGetTweetsResponse rest = restTemplate.postForObject(API_URL, entity, ApiGetTweetsResponse.class);
        return rest;
    }
}
