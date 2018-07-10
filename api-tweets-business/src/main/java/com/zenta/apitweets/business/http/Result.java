/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.business.http;

/**
 *
 * @author Nb-Zenta
 */
public class Result {
    
    private boolean error;
    private String status;
    private String description;

    public Result(){}
    
    public Result(boolean e, String s, String d) {
        this.error = e;
        this.status = s;
        this.description = d;
    }
    
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
