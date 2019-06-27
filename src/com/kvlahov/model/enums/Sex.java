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
public enum Sex {
    MALE(1), FEMALE(2);
    
    private int id;
    Sex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Sex getValueForId(int id) {
        for (Sex val : Sex.values()) {
            if(val.getId() == id) {
                return val;
            }
        }
        throw new IllegalArgumentException("No sex with given id");
    }
    
    @Override
    public String toString() {
        if(id == 1) {
            return "Male";
        }
        return "Female";
    }
    
    
    
}
