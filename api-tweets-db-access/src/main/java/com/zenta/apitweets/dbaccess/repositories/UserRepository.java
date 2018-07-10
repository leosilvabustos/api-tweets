package com.zenta.apitweets.dbaccess.repositories;

import com.zenta.apitweets.dbaccess.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Nb-Zenta
 */
public interface UserRepository extends MongoRepository<User, String>{
    @Override
    public User save(User user);
    
    @Query("{ 'profileUrl' : ?0 }")
    public User findByProfileUrl(String url);
    
    
}
