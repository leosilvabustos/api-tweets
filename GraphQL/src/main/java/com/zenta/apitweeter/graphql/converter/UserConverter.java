/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweeter.graphql.converter;

import com.zenta.apitweeter.models.User;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nb-Zenta
 */
@Service
public class UserConverter implements Converter<ObjectId, User> {

    @Override
    public User convert(ObjectId s) {
        System.out.println("Convertir object id en user....");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
