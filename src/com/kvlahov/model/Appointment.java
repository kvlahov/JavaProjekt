/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.utils.Validatable;
import com.kvlahov.utils.Validations;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lordo
 */
public class Appointment implements Validatable {

    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int patientId;
    private int doctorId;
    private String anamnesis;
    private String diagnosis;

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

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

    public String getFormattedDate() {
        return startTime.format(dateFormat);
    }
    
    public String getFormattedDuration() {
        return startTime.format(timeFormat) + " - " + endTime.format(timeFormat);
    }
    
    public LocalDate getDate() {
        return startTime.toLocalDate();
    }

    @Override
    public boolean isValid() {
        List<Boolean> validations = Arrays.asList(
                Validations.dateBeforeOther(startTime, endTime)
//                Validations.isAfterOrEqualNow(startTime)
        );

        return Validations.validate(validations);
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", patientId=" + patientId + ", doctorId=" + doctorId + '}';
    }

}
