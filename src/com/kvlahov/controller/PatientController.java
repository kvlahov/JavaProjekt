/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.model.Patient;
import com.kvlahov.dal.repository.*;
import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.patientInfo.*;
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
                .getContacts()
                .forEach((c) -> {
                    repo.insertNextOfKinContact(nokId, c.getId(), c.getContact());
                });

        repo.insertPatientAddress(pid, extendedInfo.getContactInfo().getPresentAddress(), 1);
        repo.insertPatientAddress(pid, extendedInfo.getContactInfo().getPermanentAddress(), 2);

        extendedInfo.getContactInfo()
                .getContacts()
                .forEach((c) -> {
                    repo.insertPatientContact(nokId, c.getId(), c.getContact());
                });
    }

    public static ExtendedPatientInformation getExtendedInfo(int pid) {
        ExtendedPatientInformation ei = new ExtendedPatientInformation();

        NextOfKin nok = repo.getNextOfKin(pid);
        ContactInfo nokContact = new ContactInfo();
        nokContact.setContacts(repo.getNextOfKinContact(nok.getId()));
        nokContact.setPermanentAddress(repo.getNextOfKinAdd(nok.getId()));
        nok.setContactInformation(nokContact);

        ContactInfo patientContact = new ContactInfo();
        patientContact.setContacts(repo.getPatientContact(pid));

        repo.getPatientAddress(pid).forEach(add -> {
            if (add == null) {
                return;
            }
            if (add.getType() == AddressType.PERMANENT) {
                patientContact.setPermanentAddress(add);
            } else if (add.getType() == AddressType.PRESENT) {
                patientContact.setPresentAddress(add);
            }
        });

        ei.setComplaints(repo.getComplaint(pid));
        ei.setContactInfo(patientContact);
        ei.setLifestyle(repo.getLifestyle(pid));
        ei.setNextOfKin(nok);
        ei.setPersonalInfo(repo.getPersonalInfo(pid));

        return ei;
    }

    public static List<Patient> getPatients() {
        return repo.getPatients();
    }

    public static Patient getPatient(int pid) {
        return repo.getPatient(pid);
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
