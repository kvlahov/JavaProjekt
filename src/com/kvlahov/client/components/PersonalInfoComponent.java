/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.model.patientInfo.PersonalInfo;

/**
 *
 * @author lordo
 */
public class PersonalInfoComponent extends javax.swing.JPanel {

    private PersonalInfo personalInfo = new PersonalInfo();

    /**
     * Creates new form PersonalInfoComponent
     */
    public PersonalInfoComponent() {
        initComponents();
    }

    public PersonalInfo getPersonalInfo() {
        bindUIToModel();
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
        updatePersonalInfoUI();
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

        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblBloodType = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfMaritalStatus = new javax.swing.JTextField();
        ddlBloodType = new javax.swing.JComboBox();
        ddlBloodRh = new javax.swing.JComboBox();
        tfOccupation = new javax.swing.JTextField();
        tfGrossIncome = new javax.swing.JTextField();
        spNoOFDependents = new javax.swing.JSpinner();
        spHeight = new javax.swing.JSpinner();
        spWeight = new javax.swing.JSpinner();

        setLayout(new java.awt.GridBagLayout());

        jLabel16.setText("Marital Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jLabel16, gridBagConstraints);

        jLabel17.setText("Number of Dependents");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jLabel17, gridBagConstraints);

        jLabel18.setText("Height (cm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jLabel18, gridBagConstraints);

        jLabel19.setText("Weight (kg)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jLabel19, gridBagConstraints);

        lblBloodType.setText("Blood Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(lblBloodType, gridBagConstraints);

        jLabel21.setText("Occupation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jLabel21, gridBagConstraints);

        jLabel22.setText("Gross Annual Income");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jLabel22, gridBagConstraints);

        tfMaritalStatus.setName("maritalStatus"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(tfMaritalStatus, gridBagConstraints);

        ddlBloodType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "A", "B", "AB" }));
        ddlBloodType.setName("bloodType"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 15;
        add(ddlBloodType, gridBagConstraints);

        ddlBloodRh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "+" }));
        ddlBloodRh.setName("bloodRh"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        add(ddlBloodRh, gridBagConstraints);

        tfOccupation.setName("occupation"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(tfOccupation, gridBagConstraints);

        tfGrossIncome.setName("grossIncome"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(tfGrossIncome, gridBagConstraints);

        spNoOFDependents.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(spNoOFDependents, gridBagConstraints);

        spHeight.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(spHeight, gridBagConstraints);

        spWeight.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(spWeight, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ddlBloodRh;
    private javax.swing.JComboBox ddlBloodType;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel lblBloodType;
    private javax.swing.JSpinner spHeight;
    private javax.swing.JSpinner spNoOFDependents;
    private javax.swing.JSpinner spWeight;
    private javax.swing.JTextField tfGrossIncome;
    private javax.swing.JTextField tfMaritalStatus;
    private javax.swing.JTextField tfOccupation;
    // End of variables declaration//GEN-END:variables

    private void updatePersonalInfoUI() {
        if(personalInfo == null) return;
        tfGrossIncome.setText(personalInfo.getAnnualIncome());
        
        String[] bloodType = splitBloodType(personalInfo.getBloodType());
        ddlBloodType.setSelectedItem(bloodType[0]);
        ddlBloodRh.setSelectedItem(bloodType[1]);
        
        spHeight.setValue(String.valueOf(personalInfo.getWeight()));
        spWeight.setValue(String.valueOf(personalInfo.getHeight()));
        spNoOFDependents.setValue(String.valueOf(personalInfo.getNoOFDependents()));
        tfOccupation.setText(personalInfo.getOccupation());
    }

    private void bindUIToModel() {
        personalInfo.setAnnualIncome(tfGrossIncome.getText().trim());
        personalInfo.setBloodType(ddlBloodType.getSelectedItem().toString() + ddlBloodRh.getSelectedItem().toString());
        personalInfo.setHeight((int)spHeight.getValue());
        personalInfo.setWeight((int) spWeight.getValue());
        personalInfo.setMaritalStatus(tfMaritalStatus.getText().trim());
        personalInfo.setNoOFDependents((int) spNoOFDependents.getValue());
        personalInfo.setOccupation(tfOccupation.getText().trim());
    }

    private String[] splitBloodType(String bloodType) {
        int lastChar = bloodType.length() - 1;
        String[] splittedType = new String[2];
        splittedType[0] = bloodType.substring(0, lastChar);
        splittedType[1] = bloodType.substring(lastChar);
        return splittedType;
    }
}