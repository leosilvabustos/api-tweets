/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.models.inputs;

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
    private String userId;
}
