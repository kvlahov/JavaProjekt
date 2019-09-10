/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

import com.kvlahov.model.Doctor;
import com.kvlahov.model.PaymentMethod;
import com.kvlahov.model.Receipt;
import com.kvlahov.model.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lordo
 */
public class SqlTableHelper {

    static Service getService(ResultSet resultSet) throws SQLException {
        Service service = new Service();

        service.setId(resultSet.getInt("IDService"));
        service.setDescription(resultSet.getString("Description"));
        service.setPrice(resultSet.getDouble("Price"));
        service.setType(resultSet.getString("Type"));
        service.setTypeOfServiceId(resultSet.getInt("TypeOfServiceID"));

        return service;
    }

    static PaymentMethod getPaymentMethod(ResultSet resultSet) throws SQLException {
        // IDPaymentMethod Type
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setId(resultSet.getInt("IDPaymentMethod"));
        paymentMethod.setType(resultSet.getString("Type"));

        return paymentMethod;
    }

    static Receipt getReceipt(final ResultSet resultSet) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setId(resultSet.getInt("IDReceipt"));
        receipt.setComment(resultSet.getString("Comment"));
        receipt.setDate(resultSet.getDate("Date").toLocalDate());
        receipt.setPatientId(resultSet.getInt("PatientID"));
        receipt.setReceiptNumber(resultSet.getString("ReceiptNumber"));

        receipt.setPaymentMethod(getPaymentMethod(resultSet));

        return receipt;
    }
    
    static Doctor getDoctor(final ResultSet resultSet) throws SQLException {
        return new Doctor(
                resultSet.getInt("IDDoctor"),
                resultSet.getString("Name"),
                resultSet.getString("Surname"),
                resultSet.getInt("DepartmentID"));
    }
}
