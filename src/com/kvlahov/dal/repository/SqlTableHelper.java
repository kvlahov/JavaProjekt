/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

import com.kvlahov.model.Appointment;
import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.PaymentMethod;
import com.kvlahov.model.Receipt;
import com.kvlahov.model.Service;
import com.kvlahov.model.enums.Sex;
import com.kvlahov.model.report.StatNewRecurringPatients;
import com.kvlahov.model.report.StatPatientsTreated;
import com.kvlahov.model.report.StatServiceSummary;
import com.sun.jmx.mbeanserver.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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

    static Appointment getAppointment(final ResultSet resultSet) throws SQLException {
        Appointment app = new Appointment();
        app.setId(resultSet.getInt("IDAppointment"));
        app.setAnamnesis(resultSet.getString("Anamnesis"));
        app.setDiagnosis(resultSet.getString("Diagnosis"));
        app.setDoctorId(resultSet.getInt("DoctorID"));
        app.setEndTime(resultSet.getTimestamp("EndTime").toLocalDateTime());
        app.setPatientId(resultSet.getInt("PatientID"));
        app.setStartTime(resultSet.getTimestamp("StartTime").toLocalDateTime());
        return app;
    }

    static StatNewRecurringPatients getNewRecurringPatient(ResultSet resultSet) throws SQLException {
        StatNewRecurringPatients p = new StatNewRecurringPatients();

        p.setDate(LocalDate.parse(resultSet.getString("Date")));
        p.setNoNewPatients(resultSet.getInt("NoNewPatients"));
        p.setNoRecurringPatients(resultSet.getInt("NoRecurringPatients"));

        return p;
    }

    static Patient getPatient(ResultSet resultSet) throws SQLException {
        return new Patient(
                resultSet.getInt("IDPatient"),
                resultSet.getString("Name"),
                resultSet.getString("Surname"),
                Sex.getValueForId(resultSet.getInt("SexID")),
                resultSet.getDate("DateOfBirth").toLocalDate()
        );
    }

    static StatPatientsTreated getPatientsTreated(ResultSet resultSet) throws SQLException {
        StatPatientsTreated patients = new StatPatientsTreated();

        patients.setDoctor(getDoctor(resultSet));
        patients.setNoPatientsTreated(resultSet.getDouble("AvgNoOfPatientsSeen"));

        return patients;
    }

    static StatServiceSummary getServiceSummary(ResultSet resultSet) throws SQLException {
        StatServiceSummary service = new StatServiceSummary();
        
        service.setPatient(getPatient(resultSet));
        service.setPrice(resultSet.getDouble("Price"));
        service.setDescription(resultSet.getString("Description"));
        service.setService(resultSet.getString("Type"));
        service.setTypeOfService(resultSet.getString("TypeOfService"));
        service.setQuantity(resultSet.getInt("Quantity"));
        
        return service;
    }
}
