/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.enums;

/**
 *
 * @author lordo
 */
public enum AddressType {
    PERMANENT("Permanent"), 
    PRESENT("Present");
    
    private final String type;
    
    AddressType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
    
    
}
