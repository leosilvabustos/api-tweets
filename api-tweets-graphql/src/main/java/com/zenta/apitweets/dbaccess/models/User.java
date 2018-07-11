package com.zenta.apitweets.dbaccess.models;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author Nb-Zenta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String profileUrl;
    private String createdAt;
    private Boolean following;
    
    
    @Reference
    private List<Tweet> tweets;
    
    @Override
    public String toString() {
        return "[id: "+this.getId()+", name:"+this.getName()+", tweets: "+
                (tweets!=null?tweets.size():"null")+"]";
    }
}
