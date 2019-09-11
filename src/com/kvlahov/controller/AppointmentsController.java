/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.exceptions.InvalidModelException;
import com.kvlahov.model.Appointment;
import java.util.List;

/**
 *
 * @author lordo
 */
public class AppointmentsController {
    private static final IRepository repo = RepositoryFactory.getRepository();
    
    public static void setAppointment(Appointment appointment) throws InvalidModelException {
        if(!appointment.isValid()) throw new InvalidModelException("Appointment is not valid!");
        
        //TODO add detailed errors about validations (errors variable to each model)
        
        repo.insertAppointment(appointment);
    }
    
    public static List<Appointment> getScheduledAppointments(int doctorId) {
        return repo.getScheduledAppointments(doctorId);
    }
    
    public static Appointment getAppointment(int id) {
        Appointment appointment = repo.getAppointment(id);
        
        return appointment;
    }
    
    public static void updateAppointment(Appointment appointment) throws InvalidModelException {
        if(!appointment.isValid()) throw new InvalidModelException("Appointment is not valid!");
        
        repo.updateAppointment(appointment);
    }
    
    public static void deleteAppointment(int appointmentId) {
        repo.deleteAppointment(appointmentId);
    }
    
    public static List<Appointment> getAppointmentsForPatient(int pid) {
        return repo.getAppointmentsForPatient(pid);
    }
}
