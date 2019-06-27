/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.patientInfo;

/**
 *
 * @author lordo
 */
public class ExtendedPatientInformation {
    private ContactInfo contactInfo;
    private NextOfKin nextOfKin;
    private PersonalInfo personalInfo;
    private LifestyleInfo lifestyle;
    private ComplaintsInfo complaints;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public NextOfKin getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKin nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public LifestyleInfo getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(LifestyleInfo lifestyle) {
        this.lifestyle = lifestyle;
    }

    public ComplaintsInfo getComplaints() {
        return complaints;
    }

    public void setComplaints(ComplaintsInfo complaints) {
        this.complaints = complaints;
    }

    @Override
    public String toString() {
        return "ExtendedPatientInformation{" + 
                "\ncontactInfo\n\t" + contactInfo + 
                "\nnextOfKin\n\t" + nextOfKin + 
                "\npersonalInfo\n\t" + personalInfo + 
                "\nlifestyle\n\t" + lifestyle + 
                "\ncomplaints\n\t" + complaints + '}';
    }
    
    
    
}
