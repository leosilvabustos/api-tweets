package com.zenta.apitweets.dbaccess.models.inputs;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nb-Zenta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetInput {
    
    private String text;
    private String source;
    private boolean truncated;
    private int inReplyToStatus;
    private int inReplyToUser;
    private int inReplyToScreen;
    private String createdAt;
    private Boolean favorited;
    private Integer favoritedCount;
    private Boolean retweeted;
    private Integer retweetedCount;
    private List<String> urls;
    private List<String> hashtags;
    private UserInput user;
    
    @Override
    public String toString(){
        return 
                "[" +
                "text: " + this.text +
                ", source: " + this.source + 
                ", truncated: " + this.truncated + 
                ", inReplyToStatus: " + this.inReplyToStatus + 
                ", inReplyToUser: " + this.inReplyToUser + 
                ", inReplyToScreen: " + this.inReplyToScreen + 
                ", createdAt: " + this.createdAt + 
                ", favorited: " + this.favorited + 
                ", favoritedCount: " + this.favoritedCount + 
                ", retweeted: " + this.retweeted + 
                ", retweetedCount: " + this.retweetedCount + 
                ", urls: " + (this.urls!=null?this.urls.size():"0") + 
                ", hashtags: " + (this.hashtags!=null?this.hashtags.size():"0") + 
                ", UserInput: " + this.user +
                "]";
    }
}
