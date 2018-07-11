package com.zenta.apitweets.dbaccess.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
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
    @Id
    private String id;
    private String text;
    private String source;
    private boolean truncated;
    private Integer inReplyToStatus;
    private Integer inReplyToUser;
    private Integer inReplyToScreen;
    private String createdAt;
    private Boolean favorited;
    private Integer favoritedCount;
    private Boolean retweeted;
    private Integer retweetedCount;
    private List<String> urls;
    private List<String> hashtags;
    
    private String user;
    
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
            "]";
    }
}
