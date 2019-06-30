
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.model.enums.Sex;
import com.kvlahov.model.Person;
import com.kvlahov.model.patientInfo.ExtendedPatientInformation;
import com.kvlahov.model.patientInfo.NextOfKin;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author lordo
 */
public class Patient extends Person {

    private NextOfKin nextOfKin;
    private String stmtOfComplaint;
    private String contact;
    private Sex sex;
    private LocalDate dateOfBirth;

    public Patient(String name, String surname, Sex sex, LocalDate dateOfBirth) {
        super(name, surname);
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Patient(int id, String name, String surname, Sex sex, LocalDate dateOfBirth) {
        super(id, name, surname);
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public NextOfKin getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKin nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStmtOfComplaint() {
        return stmtOfComplaint;
    }

    public void setStmtOfComplaint(String stmtOfComplaint) {
        this.stmtOfComplaint = stmtOfComplaint;
    }

    @Override
    public String toString() {
        return "Patient{" + "sex=" + sex + ", dateOfBirth=" + dateOfBirth + '}';
    }

    public String getFormatedDate(String pattern) {
        if (pattern == null) {
            return getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return getDateOfBirth().format(DateTimeFormatter.ofPattern(pattern));
    }

    
  }
