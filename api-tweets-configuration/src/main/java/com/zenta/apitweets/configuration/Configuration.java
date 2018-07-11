/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * @author Nb-Zenta
 */
@EnableConfigServer
@SpringBootApplication
public class Configuration {
    
    private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);
    
    public static void main(String[] args){        
        SpringApplication.run(Configuration.class, args);
        LOG.info("App Tweets Configuration IS UP!");
    }
    
}
