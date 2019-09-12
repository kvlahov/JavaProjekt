/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.report;

import com.kvlahov.model.Doctor;

/**
 *
 * @author lordo
 */
public class StatPatientsTreated {
    private Doctor doctor;
    private double noPatientsTreated;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getNoPatientsTreated() {
        return noPatientsTreated;
    }

    public void setNoPatientsTreated(double noPatientsTreated) {
        this.noPatientsTreated = noPatientsTreated;
    }
    
}
