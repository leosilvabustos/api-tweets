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
public class UserInput {
    
    private String name;
    private String profileUrl;
    private String createdAt;
    private Boolean following;
    
    @Override
    public String toString() {
        return "[" +
                "name: " + this.name + 
                ", profileUrl: " + this.profileUrl +
                ", createdAt: " + this.createdAt +
                ", following: " + this.following +
                "]";
    }
}
