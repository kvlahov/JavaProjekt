/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client;

import com.kvlahov.client.components.AppointmentsPane;
import com.kvlahov.client.components.Calendar;
import com.kvlahov.client.components.TableComponent;
import com.kvlahov.client.components.ReceiptComponent;
import com.kvlahov.client.events.TableEvent;
import com.kvlahov.client.tableModels.AppointmentTableModel;
import com.kvlahov.client.tableModels.PatientTableModel;
import com.kvlahov.client.tableModels.ReceiptTableModel;
import com.kvlahov.controller.AppointmentsController;
import com.kvlahov.controller.DoctorController;
import com.kvlahov.controller.PatientController;
import com.kvlahov.controller.ReceiptController;
import com.kvlahov.model.Appointment;
import com.kvlahov.model.Doctor;
import com.kvlahov.model.Patient;
import com.kvlahov.model.PaymentMethod;
import com.kvlahov.model.Receipt;
import com.kvlahov.model.patientInfo.ContactInfo;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author lordo
 */
public class Tets extends javax.swing.JFrame {

    /**
     * Creates new form Tets
     */
    public Tets() {
        initComponents();
//        initCalendar();
//        registerEvents();
//        initAppointmentPane();
//        initReceiptPane();
//        initPatientListComponent();
//        initAppointmentListComponent();
        initReceiptListComponent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        setSize(new java.awt.Dimension(600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
//    private void initCalendar() {
//        List<Appointment> scheduledAppointments = AppointmentsController.getScheduledAppointments(4);
//        calendar1.setScheduledAppointments(scheduledAppointments);
//    }
//
//    private void registerEvents() {
//        calendar1.setFreeAppointmentsActionListener((calendarEvent) -> {
//            System.out.println(calendarEvent.getAppointment());
//        });
//
//        calendar1.setScheduledAppointmentsActionListener((calendarEvent) -> {
//            System.out.println(calendarEvent.getAppointment());
//
//        });
//    }
    private void initAppointmentPane() {
        Patient p = PatientController.getPatients().get(4);
        Doctor d = DoctorController.getDoctorForPatient(p.getId());
        List<Doctor> generalPhysicians = DoctorController.getGeneralPhysicians();
        Appointment appointment = AppointmentsController.getScheduledAppointments(4).get(0);

        AppointmentsPane appointmentsPane = new AppointmentsPane(p, d, appointment, generalPhysicians);
        appointmentsPane.setBtnAddAppointmentActionListener((e) -> {

        });

        Calendar calendar = new Calendar();
        calendar.setMinimumDate(LocalDate.now());

        appointmentsPane.setCurrentDoctorChangedListener((e) -> {
            Doctor targetDoctor = appointmentsPane.getCurrentDoctor();
            SwingUtilities.invokeLater(() -> {
                calendar.setScheduledAppointments(AppointmentsController.getScheduledAppointments(targetDoctor.getId()));
            });

        });

        calendar.setFreeAppointmentsActionListener((calendarEvent) -> {
            appointmentsPane.setAppointment(calendarEvent.getAppointment());
        });

        add(appointmentsPane, BorderLayout.NORTH);
        add(calendar, BorderLayout.CENTER);
    }

    private void initReceiptPane() {
        Appointment appointment = AppointmentsController.getScheduledAppointments(4).get(0);
        Receipt receipt = ReceiptController.generateReceipt(appointment);
        Patient patient = PatientController.getPatient(appointment.getPatientId());
        ContactInfo patientContactInfo = PatientController.getPatientContactInfo(appointment.getPatientId());
        List<PaymentMethod> allPaymentMethods = ReceiptController.getAllPaymentMethods();
        receipt.setPaymentMethod(allPaymentMethods.get(0));
        ReceiptComponent receiptComponent = new ReceiptComponent(receipt, patient, appointment.getDate(), patientContactInfo);
        receiptComponent.setEditMode(allPaymentMethods);
        add(receiptComponent, BorderLayout.CENTER);
    }

    private void initPatientListComponent() {
        List<Patient> patients = PatientController.getPatients();

        TableComponent<Patient> plc = new TableComponent<>(new PatientTableModel(patients));
        plc.getTableModel().setFilterPredicate((p) -> p.getName().toLowerCase().equals(plc.getSearchExpression().toLowerCase()));
        plc.setTableListener((TableEvent<Patient> e) -> {
            System.out.println(e.getModel().toString());
        });
        add(plc, BorderLayout.CENTER);
    }

    private void initAppointmentListComponent() {
        List<Appointment> appointments = AppointmentsController.getScheduledAppointments(4);

        TableComponent<Appointment> plc = new TableComponent<>(new AppointmentTableModel(appointments));
        plc.getTableModel().setFilterPredicate((p) -> p.getFormattedDate().equals(plc.getSearchExpression()));
        plc.setTableListener((TableEvent<Appointment> e) -> {
            System.out.println(e.getModel().toString());
        });
        add(plc, BorderLayout.CENTER);
    }

    private void initReceiptListComponent() {
        List<Receipt> receipts = ReceiptController.getReceiptsforPatient(2);

        TableComponent<Receipt> plc = new TableComponent<>(new ReceiptTableModel(receipts));
        plc.getTableModel().setFilterPredicate((p) -> p.getDate().equals(plc.getSearchExpression()));
        plc.setTableListener((TableEvent<Receipt> e) -> {
            System.out.println(e.getModel().toString());
        });
        add(plc, BorderLayout.CENTER);
    }
}
