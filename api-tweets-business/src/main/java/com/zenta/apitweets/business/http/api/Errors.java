/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.business.http.api;

/**
 *
 * @author Nb-Zenta
 */
public class Errors {
    
    private String validationErrorType;
    private String message;
    private String errorType;

    public String getValidationErrorType() {
        return validationErrorType;
    }

    public void setValidationErrorType(String validationErrorType) {
        this.validationErrorType = validationErrorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
    
    
}
