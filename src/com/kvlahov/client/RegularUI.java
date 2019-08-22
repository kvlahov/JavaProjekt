/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client;

import com.kvlahov.client.components.NewPatientDialog;
import com.kvlahov.controller.PatientController;
import com.kvlahov.model.Patient;
import com.kvlahov.model.enums.Sex;
import com.kvlahov.model.patientInfo.ExtendedPatientInformation;
import com.kvlahov.utils.Utilities;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.jdesktop.swingx.decorator.PatternPredicate;
import org.jdesktop.swingx.decorator.ShadingColorHighlighter;

/**
 *
 * @author lordo
 */
public class RegularUI extends javax.swing.JFrame implements Gui, Observer {

    /**
     * Creates new form RegularUI
     */
    public RegularUI() {
        initComponents();
        initContent();
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PatientsTable = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        btnView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatients = new org.jdesktop.swingx.JXTable();
        patientViewPane = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        personalInfo = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        basicInfoPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        patientBasicInfo = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel11 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel13 = new javax.swing.JLabel();
        nokBasicInfo = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel15 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel17 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel19 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel21 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        medicalInfo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        currentDoctor = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        appointments = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        nextAppointment = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        finances = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 32767));
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miShowPatients = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel9.setText("Home");
        jPanel4.add(jLabel9);

        getContentPane().add(jPanel4, "card3");

        jScrollPane3.setMaximumSize(new java.awt.Dimension(800, 32767));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(800, 23));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(800, 464));

        PatientsTable.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        tfSearch.setMaximumSize(new java.awt.Dimension(20000, 2147483647));
        tfSearch.setMinimumSize(new java.awt.Dimension(20000, 40));
        tfSearch.setPreferredSize(new java.awt.Dimension(350, 55));
        jPanel1.add(tfSearch);

        btnSearch.setText("Search");
        btnSearch.setMaximumSize(new java.awt.Dimension(105, 43));
        btnSearch.setPreferredSize(new java.awt.Dimension(105, 43));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch);

        btnClear.setText("Clear");
        btnClear.setMaximumSize(new java.awt.Dimension(85, 43));
        btnClear.setPreferredSize(new java.awt.Dimension(65, 43));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        jPanel1.add(filler2);

        btnView.setText("View");
        btnView.setMaximumSize(new java.awt.Dimension(85, 43));
        btnView.setPreferredSize(new java.awt.Dimension(65, 43));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView);

        PatientsTable.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null, null},
                {"3", null, null, null, null},
                {"4", null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Surname", "Date Of Birth", "Sex"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPatients);

        PatientsTable.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane3.setViewportView(PatientsTable);

        getContentPane().add(jScrollPane3, "patientTable");

        patientViewPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 10));
        patientViewPane.setLayout(new javax.swing.BoxLayout(patientViewPane, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        personalInfo.setLayout(new javax.swing.BoxLayout(personalInfo, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        basicInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic info"));
        basicInfoPanel.setLayout(new javax.swing.BoxLayout(basicInfoPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel10.setPreferredSize(new java.awt.Dimension(220, 215));
        jPanel10.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        patientBasicInfo.setMaximumSize(new java.awt.Dimension(250, 100));
        patientBasicInfo.setPreferredSize(new java.awt.Dimension(250, 100));
        patientBasicInfo.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jPanel7.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("First Name");
        jPanel7.add(jLabel1);
        jPanel7.add(filler7);

        jLabel2.setText("jLabel2");
        jPanel7.add(jLabel2);

        patientBasicInfo.add(jPanel7);

        jPanel11.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Last Name");
        jPanel11.add(jLabel3);
        jPanel11.add(filler8);

        jLabel4.setText("jLabel2");
        jPanel11.add(jLabel4);

        patientBasicInfo.add(jPanel11);

        jPanel12.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Sex");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel12.add(jLabel5);
        jPanel12.add(filler1);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("jLabel2");
        jPanel12.add(jLabel6);

        patientBasicInfo.add(jPanel12);

        jPanel13.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Date of Birth");
        jPanel13.add(jLabel7);
        jPanel13.add(filler9);

        jLabel8.setText("jLabel2");
        jPanel13.add(jLabel8);

        patientBasicInfo.add(jPanel13);

        jPanel14.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Statement of Complaint");
        jPanel14.add(jLabel10);
        jPanel14.add(filler10);

        jLabel11.setText("jLabel2");
        jPanel14.add(jLabel11);

        patientBasicInfo.add(jPanel14);

        jPanel15.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Contact");
        jPanel15.add(jLabel12);
        jPanel15.add(filler11);

        jLabel13.setText("jLabel2");
        jPanel15.add(jLabel13);

        patientBasicInfo.add(jPanel15);

        jPanel10.add(patientBasicInfo);

        nokBasicInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Next Of Kin"));
        nokBasicInfo.setMaximumSize(new java.awt.Dimension(300, 100));
        nokBasicInfo.setPreferredSize(new java.awt.Dimension(180, 100));
        nokBasicInfo.setLayout(new java.awt.GridLayout(0, 1));

        jPanel17.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("First Name");
        jPanel17.add(jLabel14);
        jPanel17.add(filler12);

        jLabel15.setText("jLabel2");
        jPanel17.add(jLabel15);

        nokBasicInfo.add(jPanel17);

        jPanel18.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.LINE_AXIS));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Last Name");
        jPanel18.add(jLabel16);
        jPanel18.add(filler13);

        jLabel17.setText("jLabel2");
        jPanel18.add(jLabel17);

        nokBasicInfo.add(jPanel18);

        jPanel19.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.LINE_AXIS));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Contact");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel19.add(jLabel18);
        jPanel19.add(filler3);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("jLabel2");
        jPanel19.add(jLabel19);

        nokBasicInfo.add(jPanel19);

        jPanel20.setMaximumSize(new java.awt.Dimension(150, 20));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.LINE_AXIS));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Relatinship to Patient");
        jPanel20.add(jLabel20);
        jPanel20.add(filler14);

        jLabel21.setText("jLabel2");
        jPanel20.add(jLabel21);

        nokBasicInfo.add(jPanel20);

        jPanel10.add(nokBasicInfo);

        jPanel23.setMaximumSize(new java.awt.Dimension(32767, 100));

        jButton4.setText("Edit Basic Information");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton4);

        jPanel10.add(jPanel23);

        basicInfoPanel.add(jPanel10);

        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 100));

        jLabel22.setText("Extended information added:");
        jPanel6.add(jLabel22);

        jLabel23.setText("jLabel23");
        jPanel6.add(jLabel23);

        jPanel22.add(jPanel6);

        jButton1.setText("Add");
        jPanel21.add(jButton1);

        jButton2.setText("Edit Extended Information");
        jPanel21.add(jButton2);

        jPanel22.add(jPanel21);

        basicInfoPanel.add(jPanel22);

        jPanel5.add(basicInfoPanel);

        personalInfo.add(jPanel5);

        jTabbedPane1.addTab("Personal Info", personalInfo);

        medicalInfo.setLayout(new javax.swing.BoxLayout(medicalInfo, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel8.setMaximumSize(new java.awt.Dimension(300, 500));

        jLabel24.setText("Current physician");
        jPanel8.add(jLabel24);

        currentDoctor.setText("jLabel25");
        jPanel8.add(currentDoctor);

        jButton3.setText("Change");
        jPanel8.add(jButton3);

        jPanel2.add(jPanel8);

        medicalInfo.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        appointments.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointments"));
        appointments.setLayout(new javax.swing.BoxLayout(appointments, javax.swing.BoxLayout.Y_AXIS));

        jPanel16.setMaximumSize(new java.awt.Dimension(32767, 200));

        jLabel26.setText("Next Appointment");
        jPanel16.add(jLabel26);

        nextAppointment.setText("jLabel27");
        jPanel16.add(nextAppointment);

        appointments.add(jPanel16);

        jButton5.setText("Set appointment");
        jPanel24.add(jButton5);

        appointments.add(jPanel24);

        jPanel3.add(appointments);
        jPanel3.add(jPanel9);

        medicalInfo.add(jPanel3);

        jTabbedPane1.addTab("Medical Info", medicalInfo);

        finances.setLayout(new javax.swing.BoxLayout(finances, javax.swing.BoxLayout.Y_AXIS));

        jPanel25.setMaximumSize(new java.awt.Dimension(32767, 150));

        jLabel25.setText("Generate receipt");
        jPanel25.add(jLabel25);

        jButton6.setText("Generate");
        jPanel25.add(jButton6);

        finances.add(jPanel25);

        jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.Y_AXIS));

        jPanel27.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        jPanel27.setMaximumSize(new java.awt.Dimension(32832, 100));
        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.LINE_AXIS));

        jPanel28.setMaximumSize(new java.awt.Dimension(500, 70));
        jPanel28.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel28.setLayout(new java.awt.GridLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel28.add(jTextField1);

        jPanel27.add(jPanel28);

        jButton7.setText("Search");
        jButton7.setMaximumSize(new java.awt.Dimension(80, 70));
        jButton7.setPreferredSize(new java.awt.Dimension(65, 80));
        jPanel27.add(jButton7);

        jPanel26.add(jPanel27);

        jPanel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        jPanel29.setMaximumSize(new java.awt.Dimension(32832, 100));
        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.LINE_AXIS));

        jLabel27.setText("Show last n receipts");
        jPanel29.add(jLabel27);
        jPanel29.add(filler4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setMaximumSize(new java.awt.Dimension(100, 32767));
        jPanel29.add(jComboBox1);

        jPanel26.add(jPanel29);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel26.add(jScrollPane1);

        finances.add(jPanel26);

        jTabbedPane1.addTab("Finances", finances);

        patientViewPane.add(jTabbedPane1);

        getContentPane().add(patientViewPane, "viewPatient");

        jMenuBar.setBackground(new java.awt.Color(51, 204, 255));
        jMenuBar.setForeground(new java.awt.Color(51, 204, 255));
        jMenuBar.setMaximumSize(new java.awt.Dimension(94, 32769));
        jMenuBar.setPreferredSize(new java.awt.Dimension(94, 44));

        jMenu1.setBackground(new java.awt.Color(204, 255, 0));
        jMenu1.setText("Patient");

        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miNew.setText("New");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        jMenu1.add(miNew);

        miShowPatients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        miShowPatients.setText("Show All Patients");
        miShowPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miShowPatientsActionPerformed(evt);
            }
        });
        jMenu1.add(miShowPatients);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewActionPerformed
        // TODO add your handling code here:      
        NewPatientDialog dialog = new NewPatientDialog(this, true, null, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_miNewActionPerformed

    private void miShowPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miShowPatientsActionPerformed
        ((PatientTableModel) tblPatients.getModel()).updateModel();
//        ((PatientTableModel) tblPatients.getModel()).fireTableDataChanged();
//        tblPatients.revalidate();
        tblPatients.repaint();
        mainCardLayout.show(getContentPane(), "patientTable");
    }//GEN-LAST:event_miShowPatientsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        ((PatientTableModel) tblPatients.getModel()).filterPatientsByName(tfSearch.getText().trim());
        tblPatients.repaint();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        tfSearch.setText("");
        btnSearchActionPerformed(evt);

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        viewSelectedPatient(tblPatients);
    }//GEN-LAST:event_btnViewActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    @Override
    public void start() {
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
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Utilities.setDefaultsForJFrame();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegularUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PatientsTable;
    private javax.swing.JPanel appointments;
    private javax.swing.JPanel basicInfoPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel currentDoctor;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel finances;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel medicalInfo;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JMenuItem miShowPatients;
    private javax.swing.JLabel nextAppointment;
    private javax.swing.JPanel nokBasicInfo;
    private javax.swing.JPanel patientBasicInfo;
    private javax.swing.JPanel patientViewPane;
    private javax.swing.JPanel personalInfo;
    private org.jdesktop.swingx.JXTable tblPatients;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
    private CardLayout mainCardLayout;
    private Patient selectedPatientModel;

    private void initContent() {
        mainCardLayout = (CardLayout) getContentPane().getLayout();
        JMenu menuLogOut = new JMenu("Log Out");
        jMenuBar.add(Box.createHorizontalGlue());
        jMenuBar.add(menuLogOut);

        menuLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogOutMouseClicked(evt);
            }

        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        PatientController.addObserver(this);
    }

    private void menuLogOutMouseClicked(MouseEvent evt) {
        this.dispose();
        LoginScreen.start();
    }

    private void initTable() {
        tblPatients.setModel(new PatientTableModel());

        tblPatients.setRowHeight(100);
        tblPatients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    viewSelectedPatient(target);

                }
            }
        });

        tblPatients.removeColumn(tblPatients.getColumn(4));
        tblPatients.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW,
                null, Color.RED));

        tblPatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Highlighter simpleStriping = HighlighterFactory.createSimpleStriping();
        tblPatients.addHighlighter(simpleStriping);

    }

    @Override
    public void update(Observable o, Object arg) {
        ((PatientTableModel) tblPatients.getModel()).updateModel();
        tblPatients.repaint();
    }

    private void showViewPatient(Patient p) {
        JOptionPane.showMessageDialog(null, "Patient: " + p.getId() + " " + p.getName());
//        NewPatientDialog dialog = new NewPatientDialog(this, true, p);
//        dialog.setVisible(true);
//        setLabelsForPatient(p);
        selectedPatientModel = p;
        mainCardLayout.show(getContentPane(), "viewPatient");
    }

    private Patient getPatientForRow(JTable target, int selectedRow) {
        return ((PatientTableModel) target.getModel()).getPatientForRow(selectedRow);
    }

    private void viewSelectedPatient(JTable target) {
        int selected = target.getSelectedRow();
        if (selected != -1) {
            int index = target.convertRowIndexToModel(selected);
            Patient p = getPatientForRow(target, index);
            showViewPatient(p);
        } else {
            JOptionPane.showMessageDialog(null, "No patient selected", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

//    private void setLabelsForPatient(Patient p) {
//        lblName.setText(p.getName());
//        lblSurname.setText(p.getSurname());
//        lblSex.setText(p.getSex().toString());
//        lblDateOfBirth.setText(p.getFormatedDate("dd/MM/yyyy"));
//        lblContact.setText("");
//        lblComplaint.setText("");
//        
//        patientViewPane.repaint();
//        
//    }

    private static class PatientTableModel extends AbstractTableModel {

        //https://tips4java.wordpress.com/2008/11/21/row-table-model/
//        List<Patient> patients = PatientController.getPatients();
        List<Patient> patients = PatientController.getPatients();
        List<Patient> filteredPatients = patients;

        private String[] columnNames = {
            "First Name",
            "Last Name",
            "Sex",
            "Date of birth",
            "Id"
        };

        @Override
        public int getRowCount() {
            return filteredPatients.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Patient p = filteredPatients.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return p.getName();
                case 1:
                    return p.getSurname();
                case 2:
                    return p.getSex().toString();
                case 3:
                    return p.getFormatedDate("dd-MM-yyyy");
                case 4:
                    return p.getId();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        public Patient getPatientForRow(int row) {
            int id = (int) getValueAt(row, 4);
            return patients.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(new Patient(-1, null, null, Sex.MALE, LocalDate.MIN));
        }

        public void updateModel() {
            this.patients = PatientController.getPatients();
            filteredPatients = patients;
            fireTableDataChanged();
        }

        public void filterPatientsByName(String filter) {
            String[] compositeFilter = filter.split(" ");
            if (compositeFilter.length > 1) {
                filteredPatients = patients.stream()
                        .filter(p
                                -> p.getName().toLowerCase().startsWith(compositeFilter[0].toLowerCase()))
                        .filter(p -> p.getSurname().toLowerCase().startsWith(compositeFilter[1].toLowerCase()))
                        .collect(Collectors.toList());
            } else {
                filteredPatients = patients.stream()
                        .filter(p -> p.getName().toLowerCase().startsWith(filter.toLowerCase()))
                        .collect(Collectors.toList());

            }
            fireTableDataChanged();

        }

    }

}
