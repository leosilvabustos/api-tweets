/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.repositories;

import com.zenta.apitweeter.models.Tweet;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Nb-Zenta
 */
public interface TweetsRepository extends MongoRepository<Tweet, String>{
    
    public List<Tweet> findByIdIn(List<String> ids);
}
