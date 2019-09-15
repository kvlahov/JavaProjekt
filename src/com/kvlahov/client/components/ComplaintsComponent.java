/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.model.patientInfo.ComplaintsInfo;

/**
 *
 * @author lordo
 */
public class ComplaintsComponent extends javax.swing.JPanel {

    private ComplaintsInfo complaints = new ComplaintsInfo();

    /**
     * Creates new form ComplaintsComponent
     */
    public ComplaintsComponent() {
        initComponents();
    }

    public ComplaintsInfo getComplaints() {
        bindUIToModel();
        return complaints;
    }

    public void setComplaints(ComplaintsInfo complaints) {
        this.complaints = complaints;
        updateComplaintsUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        cbDiabetic = new javax.swing.JCheckBox();
        cbHypertensive = new javax.swing.JCheckBox();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblBloodType3 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taBriefStatement = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTreatmentHistory = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taHospitalTreated = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        taCardiac = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        taRespitory = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        taDigestive = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        taOrthopedic = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        taMuscular = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        taAllergies = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        taReactionToDrugs = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        taNeurological = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        taMajorSurgeries = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel42.setText("Statement of Complaint");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel42, gridBagConstraints);

        jLabel43.setText("History of Previous Treatment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel43, gridBagConstraints);

        jLabel44.setText("Physician/Hospital Treated");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel44, gridBagConstraints);

        cbDiabetic.setText("Diabetic");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(cbDiabetic, gridBagConstraints);

        cbHypertensive.setText("Hypertensive");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(cbHypertensive, gridBagConstraints);

        jLabel50.setText(" Cardiac Condition");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel50, gridBagConstraints);

        jLabel51.setText("Respiratory Condition");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel51, gridBagConstraints);

        lblBloodType3.setText("Digestive Condition");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(lblBloodType3, gridBagConstraints);

        jLabel52.setText("Orthopedic Condition");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel52, gridBagConstraints);

        jLabel53.setText("Muscular Condition");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel53, gridBagConstraints);

        jLabel54.setText("Neurological Condition");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel54, gridBagConstraints);

        jLabel55.setText("Known Allergies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel55, gridBagConstraints);

        jLabel56.setText("Known Adverse Reaction to Specific Drugs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel56, gridBagConstraints);

        jLabel57.setText("Major Surgeries (History)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel57, gridBagConstraints);

        taBriefStatement.setColumns(20);
        taBriefStatement.setRows(5);
        jScrollPane1.setViewportView(taBriefStatement);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        taTreatmentHistory.setColumns(20);
        taTreatmentHistory.setRows(5);
        jScrollPane2.setViewportView(taTreatmentHistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        taHospitalTreated.setColumns(20);
        taHospitalTreated.setRows(5);
        jScrollPane3.setViewportView(taHospitalTreated);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane3, gridBagConstraints);

        taCardiac.setColumns(20);
        taCardiac.setRows(5);
        jScrollPane4.setViewportView(taCardiac);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane4, gridBagConstraints);

        taRespitory.setColumns(20);
        taRespitory.setRows(5);
        jScrollPane5.setViewportView(taRespitory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane5, gridBagConstraints);

        taDigestive.setColumns(20);
        taDigestive.setRows(5);
        jScrollPane6.setViewportView(taDigestive);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane6, gridBagConstraints);

        taOrthopedic.setColumns(20);
        taOrthopedic.setRows(5);
        jScrollPane7.setViewportView(taOrthopedic);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane7, gridBagConstraints);

        taMuscular.setColumns(20);
        taMuscular.setRows(5);
        jScrollPane8.setViewportView(taMuscular);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane8, gridBagConstraints);

        taAllergies.setColumns(20);
        taAllergies.setRows(5);
        jScrollPane9.setViewportView(taAllergies);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane9, gridBagConstraints);

        taReactionToDrugs.setColumns(20);
        taReactionToDrugs.setRows(5);
        jScrollPane10.setViewportView(taReactionToDrugs);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane10, gridBagConstraints);

        taNeurological.setColumns(20);
        taNeurological.setRows(5);
        jScrollPane11.setViewportView(taNeurological);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane11, gridBagConstraints);

        taMajorSurgeries.setColumns(20);
        taMajorSurgeries.setRows(5);
        jScrollPane12.setViewportView(taMajorSurgeries);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane12, gridBagConstraints);

        jScrollPane13.setViewportView(jPanel1);

        add(jScrollPane13, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbDiabetic;
    private javax.swing.JCheckBox cbHypertensive;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblBloodType3;
    private javax.swing.JTextArea taAllergies;
    private javax.swing.JTextArea taBriefStatement;
    private javax.swing.JTextArea taCardiac;
    private javax.swing.JTextArea taDigestive;
    private javax.swing.JTextArea taHospitalTreated;
    private javax.swing.JTextArea taMajorSurgeries;
    private javax.swing.JTextArea taMuscular;
    private javax.swing.JTextArea taNeurological;
    private javax.swing.JTextArea taOrthopedic;
    private javax.swing.JTextArea taReactionToDrugs;
    private javax.swing.JTextArea taRespitory;
    private javax.swing.JTextArea taTreatmentHistory;
    // End of variables declaration//GEN-END:variables

    private void bindUIToModel() {
        if (complaints == null) {
            return;
        }

        complaints.setCardiacCondition(taCardiac.getText().trim());
        complaints.setDigestiveCondition(taDigestive.getText().trim());
        complaints.setHospitalTreated(taHospitalTreated.getText().trim());
        complaints.setIsDiabetic(cbDiabetic.isSelected());
        complaints.setIsHypertensive(cbHypertensive.isSelected());
        complaints.setKnownAllergies(taAllergies.getText().trim());
        complaints.setMajorSurgeries(taMajorSurgeries.getText().trim());
        complaints.setMuscularCondition(taMuscular.getText().trim());
        complaints.setNeurologicalCondition(taNeurological.getText().trim());
        complaints.setOrthopedicCondition(taOrthopedic.getText().trim());
        complaints.setPreviousTreatments(taTreatmentHistory.getText().trim());
        complaints.setReactionDrugs(taReactionToDrugs.getText().trim());
        complaints.setRespiratoryCondition(taRespitory.getText().trim());
        complaints.setStatementComplaint(taBriefStatement.getText().trim());
    }

    private void updateComplaintsUI() {
        if (complaints == null) {
            return;
        }

        taAllergies.setText(complaints.getKnownAllergies());
        taBriefStatement.setText(complaints.getStatementComplaint());
        taCardiac.setText(complaints.getCardiacCondition());
        taDigestive.setText(complaints.getDigestiveCondition());
        taHospitalTreated.setText(complaints.getHospitalTreated());
        taMajorSurgeries.setText(complaints.getMajorSurgeries());
        taMuscular.setText(complaints.getMuscularCondition());
        taNeurological.setText(complaints.getNeurologicalCondition());
        taOrthopedic.setText(complaints.getOrthopedicCondition());
        taReactionToDrugs.setText(complaints.getReactionDrugs());
        taRespitory.setText(complaints.getRespiratoryCondition());
        taTreatmentHistory.setText(complaints.getPreviousTreatments());
        cbDiabetic.setSelected(complaints.getIsDiabetic());
        cbHypertensive.setSelected(complaints.getIsHypertensive());
    }
}
