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
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author lordo
 */
public class PatientController {

    private static final IRepository repo = RepositoryFactory.getRepository();
    private static final MyObservable obs = new MyObservable();

    public static int insertBasicInformation(Patient p) {
        int patientId = repo.insertPatient(p);
        NextOfKin nextOfKin = p.getNextOfKin();
        int nokID = repo.insertNextOfKin(patientId, nextOfKin);

        repo.insertNextOfKinContact(nokID, nextOfKin.getContactInformation().getContacts().get(0));

        ComplaintsInfo ci = new ComplaintsInfo();
        ci.setStatementComplaint(p.getStmtOfComplaint());
        repo.insertComplaint(patientId, ci);

        Contact contact = p.getContact();
        repo.insertPatientContact(patientId, contact);
        return patientId;
    }

    public static void updatePatient(Patient p) {
        obs.setPatientChanged();
        obs.notifyObservers();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void insertExtendedInformation(Patient p, ExtendedPatientInformation extendedInfo) {
        int pid = p.getId();
        repo.updateComplaints(pid, extendedInfo.getComplaints());
        repo.insertLifestyle(pid, extendedInfo.getLifestyle());
        repo.insertPersonalInfo(pid, extendedInfo.getPersonalInfo());
        NextOfKin nok = repo.getNextOfKin(p.getId());

        ContactInfo nokContactInfo = extendedInfo.getNextOfKin().getContactInformation();
        repo.insertNextOfKinAdd(nok.getId(), nokContactInfo.getPermanentAddress());
        nokContactInfo
                .getContacts()
                .forEach((c) -> {
                    repo.insertNextOfKinContact(nok.getId(), c);
                });

        repo.insertPatientAddress(pid, extendedInfo.getContactInfo().getPresentAddress());
        repo.insertPatientAddress(pid, extendedInfo.getContactInfo().getPermanentAddress());

        extendedInfo.getContactInfo()
                .getContacts()
                .forEach((c) -> {
                    repo.insertPatientContact(nok.getId(), c);
                });
    }

    public static ExtendedPatientInformation getExtendedInfo(int pid) {
        ExtendedPatientInformation ei = new ExtendedPatientInformation();

        NextOfKin nok = repo.getNextOfKin(pid);
        nok.setContactInformation(getNokContactInfo(nok.getId()));

        ContactInfo patientContact = new ContactInfo();
        patientContact.setContacts(repo.getPatientContact(pid));

        repo.getPatientAddress(pid).forEach(add -> {
            switch (add.getType().getType()) {
                case "Permanent":
                    patientContact.setPermanentAddress(add);
                    break;
                case "Present":
                    patientContact.setPresentAddress(add);
                    break;
            }
        });

        ei.setContactInfo(patientContact);
        ei.setNextOfKin(nok);
        ei.setComplaints(repo.getComplaint(pid));
        ei.setLifestyle(repo.getLifestyle(pid));
        ei.setPersonalInfo(repo.getPersonalInfo(pid));

        return ei;
    }

    private static ContactInfo getNokContactInfo(int nokID) {
        ContactInfo nokContact = new ContactInfo();
        nokContact.setContacts(repo.getNextOfKinContact(nokID));
        nokContact.setPermanentAddress(repo.getNextOfKinAdd(nokID));
        return nokContact;
    }

    public static Patient getBasicInfo(int pid) {
        Patient patient = repo.getPatient(pid);
        NextOfKin nok = repo.getNextOfKin(pid);
        nok.setContactInformation(getNokContactInfo(nok.getId()));
        patient.setNextOfKin(nok);

        patient.setContact(repo.getPatientContact(pid).get(0));
        ComplaintsInfo complaint = repo.getComplaint(pid);
        if (complaint != null) {
            patient.setStmtOfComplaint(complaint.getStatementComplaint());
        }

        return patient;
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

    public static void updateBasicInfo(Patient p) {
        int pid = p.getId();
        repo.updatePatient(p, pid);
        repo.updateContact(p.getContact());

        NextOfKin nok = p.getNextOfKin();
        repo.updateNextOfKin(pid, nok);
        repo.updateAddress(nok.getContactInformation().getPermanentAddress());

        Contact contact = nok.getContactInformation().getContacts().get(0);
        repo.updateContact(contact);

        ComplaintsInfo ci = new ComplaintsInfo();
        ci.setStatementComplaint(p.getStmtOfComplaint());
        repo.updateComplaints(pid, ci);

    }

    public static void updateExtendedInfo(int pid, ExtendedPatientInformation ei) {
        repo.updateComplaints(pid, ei.getComplaints());
        ContactInfo pContactInfo = ei.getContactInfo();

        repo.updateAddress(pContactInfo.getPresentAddress());
        repo.updateAddress(pContactInfo.getPermanentAddress());

        pContactInfo.getContacts().forEach(c -> {
            repo.updateContact(c);
        });
    }

    public static List<ContactType> getContactTypes() {
        return repo.getContactTypes();
    }

    public static List<AddressType> getAddressTypes() {
        return repo.getAddressTypes();
    }

}
