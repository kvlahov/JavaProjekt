/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.exceptions.InvalidModelException;
import com.kvlahov.model.Doctor;
import java.util.List;

/**
 *
 * @author lordo
 */
public class DoctorController {
    private static final IRepository repo = RepositoryFactory.getRepository();
    
    public static void insertDoctor(Doctor d) throws InvalidModelException {
        if(!d.isValid()) throw new InvalidModelException("Doctor is not valid!");
        repo.insertDoctor(d);
    }
    
    public static Doctor getDoctor(Doctor d) {
        return repo.getDoctor(d.getId());
    }
    
    public static List<Doctor> getAllDoctors() {
        return repo.getDoctors();
    }
    
    public static Doctor getDoctorForPatient(int pid) {
        return repo.getDoctorForPatient(pid);
    }
    
    public static void updateDoctor(Doctor d) throws InvalidModelException {
        if(!d.isValid()) throw new InvalidModelException("Doctor is not valid!");
        repo.updateDoctor(d);
    }
    
    public static List<Doctor> getGeneralPhysicians() {
        return repo.getGeneralPhysicians();
    }
}
