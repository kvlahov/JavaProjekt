/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.sql;

//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author dbele
 */
public class DataSourceSingleton {
    
    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "JavaProjekt";
    private static final String USER = "none"; 
    private static final String PASSWORD = "none"; 
//    private static final String SERVER_NAME = "den1.mssql8.gear.host";
//    private static final String DATABASE_NAME = "java4";
//    private static final String USER = "java4"; 
//    private static final String PASSWORD = "Hi8f24!x~jit"; 
//    private static final String USER = "sa"; 
//    private static final String PASSWORD = "SQL"; 


    private DataSourceSingleton() {}

    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }
    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setIntegratedSecurity(true);
        
//        dataSource.setUser(USER);
//        dataSource.setPassword(PASSWORD);
        
        return dataSource;
    }
    
}
