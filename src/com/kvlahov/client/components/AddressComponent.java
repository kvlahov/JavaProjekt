/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.patientInfo.ContactInfo;

/**
 *
 * @author lordo
 */
public class AddressComponent extends javax.swing.JPanel {

    private ContactInfo.Address address = new ContactInfo.Address();
    private AddressType addressType;

    /**
     * Creates new form AddressComponent
     */
    public AddressComponent(AddressType addressType) {
        this.addressType = addressType;
        initComponents();
    }

    public AddressComponent() {
        initComponents();
    }

    public ContactInfo.Address getAddress() {
        address.setArea(tfArea.getText().trim());
        address.setCity(tfCity.getText().trim());
        address.setState(tfState.getText().trim());
        address.setStreet(tfStreet.getText().trim());
        address.setZipCode(tfZipCode.getText().trim());
        address.setType(addressType);

        return address;
    }

    public void setAddress(ContactInfo.Address address) {
        this.address = address;
        updateForm();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfStreet = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tfArea = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        tfState = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        tfZipCode = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(2147483647, 500));
        setPreferredSize(new java.awt.Dimension(214, 400));
        setVerifyInputWhenFocusTarget(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel11.setText("Street");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 10);
        jPanel1.add(jLabel11, gridBagConstraints);

        tfStreet.setColumns(20);
        tfStreet.setName("permanentAddStreet"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel1.add(tfStreet, gridBagConstraints);

        jLabel28.setText("Area");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 10);
        jPanel1.add(jLabel28, gridBagConstraints);

        tfArea.setColumns(20);
        tfArea.setName("permanentAddArea"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel1.add(tfArea, gridBagConstraints);

        jLabel29.setText("City");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 10);
        jPanel1.add(jLabel29, gridBagConstraints);

        tfCity.setColumns(20);
        tfCity.setName("permanentAddCity"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel1.add(tfCity, gridBagConstraints);

        jLabel30.setText("State");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 10);
        jPanel1.add(jLabel30, gridBagConstraints);

        tfState.setColumns(20);
        tfState.setName("permanentAddState"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel1.add(tfState, gridBagConstraints);

        jLabel31.setText("Zip code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 10);
        jPanel1.add(jLabel31, gridBagConstraints);

        tfZipCode.setColumns(20);
        tfZipCode.setName("permanentAddZip"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel1.add(tfZipCode, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfArea;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfState;
    private javax.swing.JTextField tfStreet;
    private javax.swing.JTextField tfZipCode;
    // End of variables declaration//GEN-END:variables

    private void updateForm() {
        if (address != null) {
            tfArea.setText(address.getArea());
            tfCity.setText(address.getCity());
            tfState.setText(address.getState());
            tfStreet.setText(address.getStreet());
            tfZipCode.setText(address.getZipCode());
        }
    }
}
