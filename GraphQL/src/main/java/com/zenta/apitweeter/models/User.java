/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.models;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


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
    @Field("_id")
    private String id;
    private String name;
    private String profileUrl;
    private String createdAt;
    private Boolean following;
    
    
    @Reference
    private List<Tweet> tweets;
    
    @Override
    public String toString() {
        return "{id: "+this.getId()+", name:"+this.getName()+", tweets: "+
                (tweets!=null?tweets.size():"null")+"}";
    }
}
