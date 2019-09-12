/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.report;

import com.kvlahov.client.global.Constants;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lordo
 */
public class GeneralReport {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<StatNewRecurringPatients> newReccuringPatients;
    private List<StatPatientsTreated> patientsTreated;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<StatNewRecurringPatients> getNewReccuringPatients() {
        return newReccuringPatients;
    }

    public void setNewReccuringPatients(List<StatNewRecurringPatients> newReccuringPatients) {
        this.newReccuringPatients = newReccuringPatients;
    }

    public List<StatPatientsTreated> getPatientsTreated() {
        return patientsTreated;
    }

    public void setPatientsTreated(List<StatPatientsTreated> patientsTreated) {
        this.patientsTreated = patientsTreated;
    }
    
    public String getFormatedDate() {
        return startDate.format(Constants.DATE_FORMAT) + " - " + endDate.format(Constants.DATE_FORMAT);
    }
    
    
}
