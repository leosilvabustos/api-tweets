package com.zenta.apitweets.createtweet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nb-Zenta
 */
@SpringBootApplication
public class App {
    
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args){        
        SpringApplication.run(App.class, args);
        LOG.info("App apit-tweets-createorupdateuser IS UP!");
    }
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}