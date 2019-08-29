/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.utils.Validations;
import java.time.LocalDateTime;

/**
 *
 * @author lordo
 */
public class Appointment {

    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int patientId;
    private int doctorId;
    private String anamnesis;
    private String diagnosis;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isValid() {
        if (!Validations.dateBeforeOther(startTime, endTime)) return false;
        if (!Validations.isAfterToday(startTime)) return false;
        
        return true;
    }
}
