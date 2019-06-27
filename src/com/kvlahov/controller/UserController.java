/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.UserRole;

/**
 *
 * @author lordo
 */
public class UserController {
    private static final IRepository repo = RepositoryFactory.getRepository();
    
    public static boolean isUserValid(User user) {
        return repo.isValidUser(user);
    }

    public static void setUserRole(User user) {
        UserRole role = repo.getRoleForUser(user);
        user.setRole(role);
    }
    
}
