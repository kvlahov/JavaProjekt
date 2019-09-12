/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.patientInfo.ContactInfo;
import com.kvlahov.model.patientInfo.ExtendedPatientInformation;
import com.kvlahov.model.patientInfo.NextOfKin;
import com.kvlahov.model.patientInfo.PersonalInfo;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.BorderFactory;

/**
 *
 * @author lordo
 */
public class ExtendedInfoComponent extends javax.swing.JPanel {

    private ExtendedPatientInformation extendedInfo = new ExtendedPatientInformation();
    private List<ContactType> contactTypes;
    private NextOfKin nextOfKin;

    private ActionListener btnSaveActionListener;
    private ActionListener btnCancelActionListener;

    public ExtendedInfoComponent() {

        initComponents();
        initForm();
    }

    public ExtendedPatientInformation getExtendedInfo() {
        bindUIToModel();
        return extendedInfo;
    }

    public void setExtendedInfo(ExtendedPatientInformation extendedInfo) {
        this.extendedInfo = extendedInfo;
        updateExtendedInfoUI();
    }

    public ActionListener getBtnSaveActionListener() {
        return btnSaveActionListener;
    }

    public void setBtnSaveActionListener(ActionListener btnSaveActionListener) {
        this.btnSaveActionListener = btnSaveActionListener;
    }

    public ActionListener getBtnCancelActionListener() {
        return btnCancelActionListener;
    }

    public void setBtnCancelActionListener(ActionListener btnCancelActionListener) {
        this.btnCancelActionListener = btnCancelActionListener;
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
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPane = new javax.swing.JPanel();
        patientContactPane = new javax.swing.JPanel();
        nokContactPane = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        mainPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        mainPane.setLayout(new java.awt.CardLayout());

        patientContactPane.setLayout(new java.awt.GridLayout(0, 1));
        mainPane.add(patientContactPane, "card2");

        nokContactPane.setLayout(new java.awt.GridLayout(0, 1));
        mainPane.add(nokContactPane, "card2");

        jScrollPane1.setViewportView(mainPane);

        add(jScrollPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        cardLayout.previous(mainPane);
        toggleControlButtons();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        cardLayout.next(mainPane);
        toggleControlButtons();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (btnSaveActionListener != null) {
            btnSaveActionListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (btnCancelActionListener != null) {
            btnCancelActionListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel nokContactPane;
    private javax.swing.JPanel patientContactPane;
    // End of variables declaration//GEN-END:variables
    private ComplaintsComponent complaintsComponent;
    private LifeStyleComponent lifestyleComponent;
    private PersonalInfoComponent personalInfoComponent;

    private AddressComponent permanentAddress;
    private AddressComponent presentAddress;
    private AddressComponent nokPermanentAddress;
    private ContactsComponent patientContacts;
    private ContactsComponent nokContacts;
    private CardLayout cardLayout;

    private void initForm() {
        contactTypes = Stream.of(ContactType.values())
                .collect(Collectors.toList());
        
        cardLayout = (CardLayout) mainPane.getLayout();
        initPatientContactPane();
        initNokContactPane();
        mainPane.add(new PersonalInfoComponent());
        mainPane.add(new LifeStyleComponent());
        mainPane.add(new ComplaintsComponent());

        setBtnsForFirstCard();

    }

    private void setBtnsForFirstCard() {
        btnPrevious.setVisible(false);
        btnNext.setVisible(true);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
    }

    private void setBtnsForLastCard() {
        btnPrevious.setVisible(true);
        btnNext.setVisible(false);
        btnSave.setVisible(true);
        btnCancel.setVisible(true);
    }

    private void setBtnsForMiddleCard() {
        btnPrevious.setVisible(true);
        btnNext.setVisible(true);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
    }

    private void initPatientContactPane() {
        permanentAddress = new AddressComponent(AddressType.PERMANENT);
        permanentAddress.setBorder(BorderFactory.createTitledBorder("Permanent Address"));
        patientContactPane.add(permanentAddress);

        presentAddress = new AddressComponent(AddressType.PRESENT);
        presentAddress.setBorder(BorderFactory.createTitledBorder("Present Address"));
        patientContactPane.add(presentAddress);

        patientContacts = new ContactsComponent(contactTypes);
        patientContacts.setBorder(BorderFactory.createTitledBorder("Contact"));
        patientContactPane.add(patientContacts);
    }

    private void bindUIToModel() {
        ContactInfo ci = new ContactInfo();
        ci.setPermanentAddress(permanentAddress.getAddress());
        ci.setPresentAddress(presentAddress.getAddress());
        ci.setContacts(patientContacts.getContacts());
        extendedInfo.setContactInfo(ci);

        ContactInfo nokCi = new ContactInfo();
        nokCi.setPermanentAddress(nokPermanentAddress.getAddress());
        nokCi.setContacts(nokContacts.getContacts());
        nextOfKin.setContactInformation(nokCi);
        extendedInfo.setNextOfKin(nextOfKin);

        extendedInfo.setComplaints(complaintsComponent.getComplaints());
        extendedInfo.setLifestyle(lifestyleComponent.getLifestyle());
        extendedInfo.setPersonalInfo(personalInfoComponent.getPersonalInfo());
    }

    private void updateExtendedInfoUI() {
        if (extendedInfo == null) {
            return;
        }

        permanentAddress.setAddress(extendedInfo.getContactInfo().getPermanentAddress());
        presentAddress.setAddress(extendedInfo.getContactInfo().getPresentAddress());
        nokPermanentAddress.setAddress(extendedInfo.getNextOfKin().getContactInformation().getPermanentAddress());

        patientContacts.setContacts(extendedInfo.getContactInfo().getContacts());
        nokContacts.setContacts(extendedInfo.getNextOfKin().getContactInformation().getContacts());

        complaintsComponent.setComplaints(extendedInfo.getComplaints());
        lifestyleComponent.setLifestyle(extendedInfo.getLifestyle());
        personalInfoComponent.setPersonalInfo(extendedInfo.getPersonalInfo());
    }

    private void initNokContactPane() {
        nokPermanentAddress = new AddressComponent(AddressType.PERMANENT);
        nokPermanentAddress.setBorder(BorderFactory.createTitledBorder("Permanent Address"));
        nokContactPane.add(nokPermanentAddress);

        nokContacts = new ContactsComponent(contactTypes);
        nokContacts.setBorder(BorderFactory.createTitledBorder("Contact"));
        nokContactPane.add(nokContacts);
    }

    private void toggleControlButtons() {
        Component c = getVisibleComponent();
        if (c == null) {
            return;
        }

        if (c == mainPane.getComponent(0)) {
            setBtnsForFirstCard();
        }
        else if(c == mainPane.getComponent(mainPane.getComponentCount() - 1)) {
            setBtnsForLastCard();
        }
        else {
            setBtnsForMiddleCard();
        }
    }

    private Component getVisibleComponent() {
        for (Component comp : mainPane.getComponents()) {
            if (comp.isVisible()) {
                return comp;
            }
        }
        return null;
    }

}
