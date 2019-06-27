/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.UserRole;
import java.util.List;

/**
 *
 * @author dnlbe
 */
public interface IRepository {    
    int insertPatient(Patient patient);
    void updatePatient(Patient newPatient, int idPatient);
    Patient getPatient(int id);
    int insertDoctor(Doctor doctor);
    Doctor getDoctor(int idDoctor);
    List<Doctor> getDoctors();    
    List<Patient> getPatientsForDoctor(int idDoctor);
    boolean isValidUser(User user);
    UserRole getUserRole(int id);

    public UserRole getRoleForUser(User user);
    
//    void updateDoctor(Doctor dummy, int idDoctor);
//    void deleteDoctor(int idDoctor);
}
