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
public enum UserRole {
    REGULAR(1), DOCTOR(2),  ADMIN(3);

    public static UserRole getRole(String roleType) {
        for (UserRole role : UserRole.values()) {
            if(role.name().toLowerCase().equals(roleType.toLowerCase())) return role;
        }
        throw new IllegalArgumentException("No such role!");
    }
    
    private final int id;
    
    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
