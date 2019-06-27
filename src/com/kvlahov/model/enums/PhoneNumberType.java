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
public enum PhoneNumberType {
    WORK("Work"), 
    HOME("Home"),
    PAGER("Pager"),
    MOBILE("Mobile"),
    FAX("Fax");

    private String contactType;
    private PhoneNumberType(String type) {
        this.contactType = type;
    }

    @Override
    public String toString() {
        return contactType;
    }
    
    
    
    
    
    
}
