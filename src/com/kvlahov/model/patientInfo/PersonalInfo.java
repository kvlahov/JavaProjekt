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
public class PersonalInfo {
   
    private String maritalStatus;
    private int noOFDependents;
    private float height;
    private float weight;
    private String bloodType;
    private String occupation;
    private String annualIncome;

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getNoOFDependents() {
        return noOFDependents;
    }

    public void setNoOFDependents(int noOFDependents) {
        this.noOFDependents = noOFDependents;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" + 
                "\nmaritalStatus=" + maritalStatus 
                + "\nnoOFDependents=" + noOFDependents + 
                "\nheight=" + height + 
                "\nweight=" + weight + 
                "\nbloodType=" + bloodType +
                "\noccupation=" + occupation +
                "\nannualIncome=" + annualIncome + '}';
    }
    
    
    
}
