package com.zenta.apitweets.dbaccess.repositories;

import com.zenta.apitweets.dbaccess.models.Tweet;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Nb-Zenta
 */
public interface TweetsRepository extends MongoRepository<Tweet, String>{
    
    public List<Tweet> findByIdIn(List<String> ids);
    
    @Query(value="{'user': ?0}")
    public Page<Tweet> findByMethod(String user, Pageable pageable);
}
