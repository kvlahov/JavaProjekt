/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.model.enums.UserRole;

/**
 *
 * @author lordo
 */
public class User {
    private int id;
    private String username;
    private String password;
    private UserRole role;

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }    

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
}
