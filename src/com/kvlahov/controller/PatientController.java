/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.model.Patient;
import com.kvlahov.dal.repository.*;
import com.kvlahov.model.*;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.patientInfo.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 *
 * @author lordo
 */
public class PatientController {

    private static final IRepository repo = RepositoryFactory.getRepository();
    private static final MyObservable obs = new MyObservable();

    public static int insertBasicInformation(Patient p) {
        int patientId = repo.insertPatient(p);
        obs.setPatientChanged();
        obs.notifyObservers();
        return patientId;

    }

    public static void updatePatient(Patient p) {
        obs.setPatientChanged();
        obs.notifyObservers();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void insertExtendedInformation(Patient p, ExtendedPatientInformation extendedInfo) {
        int pid = p.getId();
        repo.insertComplaint(pid, extendedInfo.getComplaints());
        repo.insertLifestyle(pid, extendedInfo.getLifestyle());
        repo.insertPersonalInfo(pid, extendedInfo.getPersonalInfo());
        int nokId = repo.insertNextOfKin(pid, p.getNextOfKin());
        repo.insertNextOfKinAdd(nokId, extendedInfo.getNextOfKin().getContactInformation().getPermanentAddress());
        p.getNextOfKin()
                .getContactInformation()
                .getContacts().forEach((k, v) -> {
                    v.stream().forEach((contact) -> {
                        int contactId = repo.getContactTypeId(k);
                        repo.insertNextOfKinContact(nokId, contactId, contact);
                    });
                });

        repo.insertPatientAddress(pid, extendedInfo.getContactInfo().getPresentAddress(), 1);
        repo.insertPatientAddress(pid, extendedInfo.getContactInfo().getPermanentAddress(), 2);
        
        extendedInfo.getContactInfo()
                .getContacts().forEach((k, v) -> {
                    v.stream().forEach((contact) -> {
                        int contactId = repo.getContactTypeId(k);
                        repo.insertPatientContact(pid, contactId, contact);
                    });
                });
    }

    public static Map<String, Set<String>> getContactNumbersForPatient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Patient> getPatients() {
        return repo.getPatients();
    }

    public void setAppointment(Patient p) {
//        int calendar = CalendarController.getCalendarFor(p);
    }

    public static void addObserver(Observer o) {
        obs.addObserver(o);
    }

    private static class MyObservable extends Observable {

        public void setPatientChanged() {
            this.setChanged();
        }

    }
}
