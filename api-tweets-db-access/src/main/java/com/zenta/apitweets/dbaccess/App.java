package com.zenta.apitweets.dbaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Nb-Zenta
 */
@SpringBootApplication
public class App {
    
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args){        
        SpringApplication.run(App.class, args);
        LOG.info("App api-weets-db-access IS UP!");
    }
    
}
