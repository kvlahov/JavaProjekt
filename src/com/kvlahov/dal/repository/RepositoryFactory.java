/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

/**
 *
 * @author dnlbe
 */
public final class RepositoryFactory {
    
    private static IRepository instance;
    
    public static IRepository getRepository() {
        return new SqlRepository();
    }
    
}
