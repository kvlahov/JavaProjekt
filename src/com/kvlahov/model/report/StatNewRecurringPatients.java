/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.report;

import java.time.LocalDate;

/**
 *
 * @author lordo
 */
public class StatNewRecurringPatients {
    private LocalDate date;
    private int noNewPatients;
    private int noRecurringPatients;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNoNewPatients() {
        return noNewPatients;
    }

    public void setNoNewPatients(int noNewPatients) {
        this.noNewPatients = noNewPatients;
    }

    public int getNoRecurringPatients() {
        return noRecurringPatients;
    }

    public void setNoRecurringPatients(int noRecurringPatients) {
        this.noRecurringPatients = noRecurringPatients;
    }  
    
}
