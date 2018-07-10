/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 *
 * @author Nb-Zenta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tweets")
public class Tweet implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Field("_id")
    private String id;
    private String text;
    private String source;
    private boolean truncated;
    private Integer inReplyToStatus;
    private Integer inReplyToUser;
    private Integer inReplyToScreen;
    
    private String user;
    //private User user;
    
    @Override
    public String toString(){
        return "["+
                "id: "+ this.id+
                ", text: "+ this.text+
                ", source: "+ this.source+
                ", truncated: "+ this.truncated+
                ", inReplyToStatus: "+ this.inReplyToStatus+
                ", inReplyToUser: "+ this.inReplyToUser+
                ", inReplyToScreen: "+ this.inReplyToScreen+
                ", user: "+ this.user+
                //"user: "+ this.userId+
            "]";
    }
}
