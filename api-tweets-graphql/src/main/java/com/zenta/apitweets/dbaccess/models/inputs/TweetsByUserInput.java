package com.zenta.apitweets.dbaccess.models.inputs;

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
public class TweetsByUserInput {
    
    public String id;
    public Integer pageSize;
    public Integer page;
    
    @Override
    public String toString(){
        return "["+
                "id: " + this.id +
                ", pageSize: " + this.pageSize +
                ", page: " + this.page +
            "]";
    }
}
