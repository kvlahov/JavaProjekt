/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.dal.repository;

import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.enums.UserRole;
import com.kvlahov.model.patientInfo.ComplaintsInfo;
import com.kvlahov.model.patientInfo.ContactInfo;
import com.kvlahov.model.patientInfo.LifestyleInfo;
import com.kvlahov.model.patientInfo.NextOfKin;
import com.kvlahov.model.patientInfo.PersonalInfo;
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
    List<Patient> getPatients();
    List<Patient> getPatientsForDoctor(int idDoctor);
    
    //info
    void insertComplaint(int pid, ComplaintsInfo complaints);
    void insertLifestyle(int pid, LifestyleInfo lifestyle);
    int insertNextOfKin(int pid, NextOfKin nok);
    void insertNextOfKinAdd(int nokId, ContactInfo.Address add);
    void insertNextOfKinContact(int nokId, int contactType, String contact);
    
    void insertPatientAddress(int pid, ContactInfo.Address add, int addType);
    void insertPatientContact(int pid, int contactType, String contact);
    void insertPersonalInfo(int pid, PersonalInfo personal);
    
    //info get
    
    ComplaintsInfo getComplaint(int pid);
    LifestyleInfo getLifestyle(int pid);
    NextOfKin getNextOfKin(int pid);
    ContactInfo.Address getNextOfKinAdd(int nok);
    ContactInfo getNextOfKinContact(int nok);
    
    List<ContactInfo.Address> getPatientAddress(int pid);
    ContactInfo getPatientContact(int pid);
    PersonalInfo getPersonalInfo(int pid);
    
    int getContactTypeId(ContactType type);
    Doctor getDoctor(int idDoctor);
    List<Doctor> getDoctors();    
    
    boolean isValidUser(User user);
    UserRole getUserRole(int id);

    public UserRole getRoleForUser(User user);
    
}
