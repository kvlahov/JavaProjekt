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
public class ComplaintsInfo {
    private String statementComplaint;
    private String previousTreatments;
    private String hospitalTreated;
    
    private boolean isDiabetic;
    private boolean isHypertensive;
    
    private String cardiacCondition;
    private String respiratoryCondition;
    private String digestiveCondition;
    private String orthopedicCondition;
    private String muscularCondition;
    private String neurologicalCondition;
    
    private String knownAllergies;
    private String reactionDrugs;
    private String majorSurgeries;

    public String getStatementComplaint() {
        return statementComplaint;
    }

    public void setStatementComplaint(String statementComplaint) {
        this.statementComplaint = statementComplaint;
    }

    public String getPreviousTreatments() {
        return previousTreatments;
    }

    public void setPreviousTreatments(String previousTreatments) {
        this.previousTreatments = previousTreatments;
    }

    public String getHospitalTreated() {
        return hospitalTreated;
    }

    public void setHospitalTreated(String hospitalTreated) {
        this.hospitalTreated = hospitalTreated;
    }

    public boolean isIsDiabetic() {
        return isDiabetic;
    }

    public void setIsDiabetic(boolean isDiabetic) {
        this.isDiabetic = isDiabetic;
    }

    public boolean isIsHypertensive() {
        return isHypertensive;
    }

    public void setIsHypertensive(boolean isHypertensive) {
        this.isHypertensive = isHypertensive;
    }

    public String getCardiacCondition() {
        return cardiacCondition;
    }

    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    public String getRespiratoryCondition() {
        return respiratoryCondition;
    }

    public void setRespiratoryCondition(String respiratoryCondition) {
        this.respiratoryCondition = respiratoryCondition;
    }

    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    public String getMuscularCondition() {
        return muscularCondition;
    }

    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    public String getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    public String getReactionDrugs() {
        return reactionDrugs;
    }

    public void setReactionDrugs(String reactionDrugs) {
        this.reactionDrugs = reactionDrugs;
    }

    public String getMajorSurgeries() {
        return majorSurgeries;
    }

    public void setMajorSurgeries(String majorSurgeries) {
        this.majorSurgeries = majorSurgeries;
    }

    @Override
    public String toString() {
        return "ComplaintsInfo{" 
                + "\nstatementComplaint=" + statementComplaint +
                "\npreviousTreatments=" + previousTreatments + 
                "\nhospitalTreated=" + hospitalTreated + 
                "\nisDiabetic=" + isDiabetic + 
                "\nisHypertensive=" + isHypertensive +
                "\ncardiacCondition=" + cardiacCondition +
                "\nrespiratoryCondition=" + respiratoryCondition + 
                "\ndigestiveCondition=" + digestiveCondition +
                "\northopedicCondition=" + orthopedicCondition + 
                "\nmuscularCondition=" + muscularCondition + 
                "\nneurologicalCondition=" + neurologicalCondition +
                "\nknownAllergies=" + knownAllergies +
                "\nreactionDrugs=" + reactionDrugs + 
                "\nmajorSurgeries=" + majorSurgeries + '}';
    }
    
    

}
