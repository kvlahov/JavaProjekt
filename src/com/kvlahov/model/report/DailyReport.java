/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.report;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lordo
 */
public class DailyReport {
    private LocalDate date;
    private StatNewRecurringPatients newReccuringPatients;
    private List<StatPatientsTreated> patientsTreated;
    private List<StatServiceSummary> servicesSummary;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StatNewRecurringPatients getNewReccuringPatients() {
        return newReccuringPatients;
    }

    public void setNewReccuringPatients(StatNewRecurringPatients newReccuringPatients) {
        this.newReccuringPatients = newReccuringPatients;
    }

    public List<StatPatientsTreated> getPatientsTreated() {
        return patientsTreated;
    }

    public void setPatientsTreated(List<StatPatientsTreated> patientsTreated) {
        this.patientsTreated = patientsTreated;
    }

    public List<StatServiceSummary> getServicesSummary() {
        return servicesSummary;
    }

    public void setServicesSummary(List<StatServiceSummary> servicesSummary) {
        this.servicesSummary = servicesSummary;
    }
    
    
}
