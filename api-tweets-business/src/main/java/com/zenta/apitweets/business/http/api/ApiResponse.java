package com.zenta.apitweets.business.http.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Nb-Zenta
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    
    @JsonProperty("errors")
    private List<Errors> errors;

    public List<Errors> getErrors() {
        return errors;
    }
    
    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }
}