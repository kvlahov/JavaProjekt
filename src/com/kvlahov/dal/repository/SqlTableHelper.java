/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

import com.kvlahov.model.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lordo
 */
public class SqlTableHelper {

    public static Service getService(ResultSet resultSet) throws SQLException {
        Service service = new Service();

        service.setId(resultSet.getInt("IDService"));
        service.setDescription(resultSet.getString("Description"));
        service.setPrice(resultSet.getDouble("Price"));
        service.setType(resultSet.getString("Type"));
        service.setTypeOfServiceId(resultSet.getInt("TypeOfServiceID"));
        
        return service;

    }
}
