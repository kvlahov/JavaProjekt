/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;


import com.kvlahov.model.Appointment;
import com.kvlahov.model.Service;
import com.kvlahov.model.ServiceAppointment;
import com.kvlahov.model.TypeOfService;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author lordo
 */
public class EditAppointmentComponent extends javax.swing.JPanel {

    private List<ServiceAppointment> servicesForAppointment = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private List<TypeOfService> typesOfService = new ArrayList<>();
    private Appointment appointment;
    private String patientName = "";

    private ActionListener btnSaveActionListener;
    private ActionListener btnCancelActionListener;

    public EditAppointmentComponent(List<TypeOfService> typesOfService, Appointment appointment, List<Service> services) {
        this.typesOfService = typesOfService;
        this.appointment = appointment;
        this.services = services;

        initComponents();
        initUI();
    }

    public void setBtnSaveActionListener(ActionListener btnSaveActionListener) {
        this.btnSaveActionListener = btnSaveActionListener;
    }

    public void setBtnCancelActionListener(ActionListener btnCancelActionListener) {
        this.btnCancelActionListener = btnCancelActionListener;
    }

    public List<ServiceAppointment> getServicesForAppointment() {
        return servicesForAppointment;
    }

    public void setServicesForAppointment(List<ServiceAppointment> servicesForAppointment) {
        this.servicesForAppointment = servicesForAppointment;
        updateServicesForAppointment();
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAppointmentDuration = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAnamnesis = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDiagnosis = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        addServicePane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ddlTypeOfService = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        ddlServices = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        spQuantity = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        servicesPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        btnMedicalInfo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Appointment"));
        setLayout(new java.awt.BorderLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        mainPanel.add(jLabel2, gridBagConstraints);

        lblDate.setText("N/A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        mainPanel.add(lblDate, gridBagConstraints);

        jLabel3.setText("Time:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 5);
        mainPanel.add(jLabel3, gridBagConstraints);

        lblAppointmentDuration.setText("N/A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 10);
        mainPanel.add(lblAppointmentDuration, gridBagConstraints);

        jLabel4.setText("Anamnesis");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel4, gridBagConstraints);

        tbAnamnesis.setColumns(40);
        tbAnamnesis.setRows(10);
        jScrollPane2.setViewportView(tbAnamnesis);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        mainPanel.add(jScrollPane2, gridBagConstraints);

        jLabel5.setText("Diagnosis");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPanel.add(jLabel5, gridBagConstraints);

        tbDiagnosis.setColumns(40);
        tbDiagnosis.setRows(10);
        jScrollPane3.setViewportView(tbDiagnosis);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(jScrollPane3, gridBagConstraints);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        mainPanel.add(btnAdd, gridBagConstraints);

        jLabel8.setText("Type of Service:");
        addServicePane.add(jLabel8);

        ddlTypeOfService.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ddlTypeOfService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlTypeOfServiceActionPerformed(evt);
            }
        });
        addServicePane.add(ddlTypeOfService);

        jLabel6.setText("Service:");
        addServicePane.add(jLabel6);

        ddlServices.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addServicePane.add(ddlServices);

        jLabel7.setText("Quantity:");
        addServicePane.add(jLabel7);

        spQuantity.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        addServicePane.add(spQuantity);

        jLabel9.setText("Description");
        addServicePane.add(jLabel9);

        tfDescription.setColumns(20);
        addServicePane.add(tfDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 0.1;
        mainPanel.add(addServicePane, gridBagConstraints);

        servicesPanel.setLayout(new javax.swing.BoxLayout(servicesPanel, javax.swing.BoxLayout.Y_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(servicesPanel, gridBagConstraints);

        jScrollPane1.setViewportView(mainPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Patient:");
        jPanel1.add(jLabel1);

        lblPatientName.setText("N/A");
        jPanel1.add(lblPatientName);

        btnMedicalInfo.setText("Medical Information");
        jPanel1.add(btnMedicalInfo);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ServiceAppointment newServiceAppointment = new ServiceAppointment();
        newServiceAppointment.setAppointmentId(appointment.getId());
        newServiceAppointment.setQuantity((Integer) spQuantity.getValue());
        newServiceAppointment.setDescription(tfDescription.getText().trim());
        newServiceAppointment.setService((Service) ddlServices.getSelectedItem());
        
        Optional<ServiceAppointment> optionalSA = Stream.of(servicesPanel.getComponents())
                .filter(c -> c instanceof ServiceAppointmentComponent)
                .map(c -> ((ServiceAppointmentComponent) c).getServiceForAppointment())
                .filter(s -> s.getService().equals(newServiceAppointment.getService()))
                .findFirst();
        if(optionalSA.isPresent()) {
            optionalSA.get().setQuantity(newServiceAppointment.getQuantity());
        }
        else {
            addServiceComponent(newServiceAppointment, filterServicesByType());
        }
        
        updateServicesForAppointment();

    }//GEN-LAST:event_btnAddActionPerformed

    private void ddlTypeOfServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlTypeOfServiceActionPerformed
        ddlServices.setModel(new DefaultComboBoxModel(filterServicesByType().toArray()));
    }//GEN-LAST:event_ddlTypeOfServiceActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        servicesForAppointment = Stream.of(servicesPanel.getComponents())
                .filter(c -> c instanceof ServiceAppointmentComponent)
                .map(c -> ((ServiceAppointmentComponent) c).getServiceForAppointment())
                .collect(Collectors.toList());

        appointment.setAnamnesis(tbAnamnesis.getText().trim());
        appointment.setDiagnosis(tbDiagnosis.getText().trim());

        btnSaveActionListener.actionPerformed(evt);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        btnCancelActionListener.actionPerformed(evt);

    }//GEN-LAST:event_btnCancelActionPerformed

    private List<Service> filterServicesByType() {
        TypeOfService typeOfService = ((TypeOfService) ddlTypeOfService.getSelectedItem());
        List<Service> filteredServices = services.stream().filter(s -> s.getTypeOfServiceId() == typeOfService.getId()).collect(Collectors.toList());
        return filteredServices;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addServicePane;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnMedicalInfo;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox ddlServices;
    private javax.swing.JComboBox ddlTypeOfService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAppointmentDuration;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel servicesPanel;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTextArea tbAnamnesis;
    private javax.swing.JTextArea tbDiagnosis;
    private javax.swing.JTextField tfDescription;
    // End of variables declaration//GEN-END:variables

    private void initUI() {
        ddlServices.setModel(new DefaultComboBoxModel(services.toArray()));
        ddlTypeOfService.setModel(new DefaultComboBoxModel(typesOfService.toArray()));
        ddlTypeOfService.setSelectedIndex(0);
        lblPatientName.setText(patientName);

        if (appointment != null) {
            lblDate.setText(appointment.getFormattedDate());
            lblAppointmentDuration.setText(appointment.getFormattedDuration());
            tbAnamnesis.setText(appointment.getAnamnesis());
            tbDiagnosis.setText(appointment.getDiagnosis());
        }

        updateServicesForAppointment();
    }

    private void updateServicesForAppointment() {
        servicesPanel.removeAll();
        servicesForAppointment.stream()
                .forEach(sa -> addServiceComponent(sa, filterServicesByType(sa.getService().getTypeOfServiceId())));
        for (Component component : servicesPanel.getComponents()) {
            System.out.println(component);
        }
    }

    private void addServiceComponent(ServiceAppointment sa, List<Service> services) {
        ServiceAppointmentComponent serviceComponent = new ServiceAppointmentComponent(sa, services);
        serviceComponent.addBtnRemoveActionListener((ActionEvent e) -> {
            servicesPanel.remove(serviceComponent);
            this.revalidate();
            this.repaint();
        });
//        serviceComponent.setPreferredSize(addServicePane.getSize());
        servicesPanel.add(serviceComponent);
    }

    private List<Service> filterServicesByType(int typeOfServiceId) {
        List<Service> filteredServices = services.stream().filter(s -> s.getTypeOfServiceId() == typeOfServiceId).collect(Collectors.toList());
        return filteredServices;
    }

}