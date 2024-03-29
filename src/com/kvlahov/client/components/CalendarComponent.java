/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.client.events.CalendarEvent;
import com.kvlahov.client.events.CalendarListener;
import com.kvlahov.model.Appointment;
import com.kvlahov.utils.Utilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 *
 * @author lordo
 */
public class CalendarComponent extends javax.swing.JPanel {

    private List<Appointment> scheduledAppointments;
    private LocalDate startOfWeek;
    private LocalTime dayStartTime = LocalTime.of(8, 0);
    private LocalTime dayEndTime = LocalTime.of(16, 0);
    private LocalDate minimumDate = LocalDate.MIN;

    private final int gridStartX = 1;
    private final int gridStartY = 1;

    private Map<Integer, LocalDate> weekdays = new HashMap<>();
    private Map<Integer, LocalTime> timeOfDay = new HashMap<>();

    private static final Color COLOR_TODAY = Color.yellow;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM");
    private static final DateTimeFormatter HOUR_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    private CalendarListener freeAppointmentsActionListener;
    private CalendarListener scheduledAppointmentsActionListener;

    public CalendarListener getFreeAppointmentsActionListener() {
        return freeAppointmentsActionListener;
    }

    public void setFreeAppointmentsActionListener(CalendarListener freeAppointmentsActionListener) {
        this.freeAppointmentsActionListener = freeAppointmentsActionListener;
    }

    public CalendarListener getScheduledAppointmentsActionListener() {
        return scheduledAppointmentsActionListener;
    }

    public void setScheduledAppointmentsActionListener(CalendarListener scheduledAppointmentsActionListener) {
        this.scheduledAppointmentsActionListener = scheduledAppointmentsActionListener;
    }

    public LocalTime getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(LocalTime dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public LocalTime getDayEndTime() {
        return dayEndTime;
    }

    public void setDayEndTime(LocalTime dayEndTime) {
        this.dayEndTime = dayEndTime;
    }

    public List<Appointment> getScheduledAppointments() {
        return scheduledAppointments;
    }

    public void setScheduledAppointments(List<Appointment> scheduledAppointments) {
        this.scheduledAppointments = scheduledAppointments;
        updateAppointments();
    }

    public LocalDate getStartOfWeek() {
        return startOfWeek;
    }

    public void setStartOfWeek(LocalDate startOfWeek) {
        this.startOfWeek = startOfWeek;
    }

    public LocalDate getMinimumDate() {
        return minimumDate;
    }

    public void setMinimumDate(LocalDate minimumDate) {
        this.minimumDate = minimumDate;
    }

    /**
     * Creates new form Calendar
     */
    public CalendarComponent() {
        initComponents();
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);
        initData();
        updateWeekLabel();
        setGridBag();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        dateRange = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnToday = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Week:");
        jPanel1.add(jLabel1);

        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);

        dateRange.setText("date");
        dateRange.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateRangePropertyChange(evt);
            }
        });
        jPanel1.add(dateRange);

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext);

        btnToday.setText("Today");
        btnToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodayActionPerformed(evt);
            }
        });
        jPanel1.add(btnToday);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        startOfWeek = startOfWeek.minusDays(7);
        updateWeekLabel();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        startOfWeek = startOfWeek.plusDays(7);
        updateWeekLabel();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        startOfWeek = Utilities.getStartOfWeek(LocalDate.now());
        updateWeekLabel();

    }//GEN-LAST:event_btnTodayActionPerformed

    private void dateRangePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateRangePropertyChange
        if(startOfWeek.isEqual(Utilities.getStartOfWeek(minimumDate))) {
            btnBack.setEnabled(false);
        }
        else {
            btnBack.setEnabled(true);
        }
        updateData();
        updateGridBag();
    }//GEN-LAST:event_dateRangePropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnToday;
    private javax.swing.JLabel dateRange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    private void setGridBag() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();

        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        for (Map.Entry<Integer, LocalDate> entry : weekdays.entrySet()) {
            gridBagConstraints.gridx = entry.getKey();
            String dayOFWeek = entry.getValue().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            String date = entry.getValue().format(DATE_FORMAT);

            JLabel lblDayOfWeek = new JLabel(dayOFWeek + " " + date);
            lblDayOfWeek.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(lblDayOfWeek, gridBagConstraints);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;

        for (Map.Entry<Integer, LocalTime> entry : timeOfDay.entrySet()) {
            gridBagConstraints.gridy = entry.getKey();

            JLabel label = new JLabel(entry.getValue().format(HOUR_FORMAT));
            label.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
            mainPanel.add(label, gridBagConstraints);
        }
        gridBagConstraints.gridy++;
        mainPanel.add(new JLabel(dayEndTime.toString()), gridBagConstraints);

        updateAppointments();

    }

    private void updateGridBag() {
        int gridx, gridy = 0;
        for (Map.Entry<Integer, LocalDate> entry : weekdays.entrySet()) {
            gridx = entry.getKey();
            String dayOfWeek = entry.getValue().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            String date = entry.getValue().format(DATE_FORMAT);

            Component c = getComponentAtGridBagConstraint(gridx, gridy);
            if (c instanceof JLabel) {
                JLabel lblDay = (JLabel) c;
                if (entry.getValue().isEqual(LocalDate.now())) {
                    lblDay.setOpaque(true);
                    lblDay.setBackground(COLOR_TODAY);
                } else {
                    lblDay.setOpaque(false);
                }

                lblDay.setText(dayOfWeek + " " + date);
            }
        }

        updateAppointments();

    }

    private Component getComponentAtGridBagConstraint(int x, int y) {
        GridBagLayout layout = (GridBagLayout) mainPanel.getLayout();
        for (Component c : mainPanel.getComponents()) {
            GridBagConstraints gbc = layout.getConstraints(c);
            if (gbc.gridx == x && gbc.gridy == y) {
                return c;
            }
        }
        return null;
    }

    private void initData() {
        startOfWeek = Utilities.getStartOfWeek(LocalDate.now());

        for (int i = gridStartX, addDays = 0; i < gridStartX + 7; i++, addDays++) {
            weekdays.put(i, startOfWeek.plusDays(addDays));
        }

        {
            int i = gridStartY;
            for (LocalTime currentTime = dayStartTime; currentTime.isBefore(dayEndTime); currentTime = currentTime.plusMinutes(30)) {
                timeOfDay.put(i++, currentTime);
            }
        }

        scheduledAppointments = new ArrayList<>();

    }

    private void updateWeekLabel() {
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        dateRange.setText(startOfWeek.format(DATE_FORMAT) + " - " + endOfWeek.format(DATE_FORMAT));
    }

    private void updateData() {
        for (int i = gridStartX, addDays = 0; i < gridStartX + 7; i++, addDays++) {
            weekdays.put(i, startOfWeek.plusDays(addDays));
        }
    }

    private void updateAppointments() {
        Stream.of(mainPanel.getComponents())
                .filter(c -> c instanceof JButton)
                .forEach(c -> mainPanel.remove(c));

        List<Appointment> appointmentsForWeek = scheduledAppointments
                .stream()
                .filter(app -> Utilities.isInTargetWeek(startOfWeek, app.getStartTime().toLocalDate()))
                .collect(Collectors.toList());

        GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.ipadx = 150;
        gbc.ipady = 150;
        gbc.weightx = 1.0;

        weekdays.entrySet().stream().forEach((dateEntry) -> {
            timeOfDay.entrySet().stream().forEach((timeEntry) -> {
                JButton btnAppointment = getAppointmentButton(dateEntry, timeEntry, appointmentsForWeek);

                gbc.gridx = dateEntry.getKey();
                gbc.gridy = timeEntry.getKey();

                mainPanel.add(btnAppointment, gbc);
            });
        });
    }

    private JButton getAppointmentButton(Map.Entry<Integer, LocalDate> dateEntry, Map.Entry<Integer, LocalTime> timeEntry, List<Appointment> appointmentsForWeek) {
        JButton btnAppointment = new JButton();
        btnAppointment.setHorizontalAlignment(SwingConstants.LEFT);
        btnAppointment.setVerticalAlignment(SwingConstants.TOP);
        
        LocalDateTime datetime = LocalDateTime.of(dateEntry.getValue(), timeEntry.getValue().truncatedTo(ChronoUnit.MINUTES));
        Optional<Appointment> optionalAppointment = appointmentsForWeek
                .stream()
                .filter(app -> app.getStartTime().truncatedTo(ChronoUnit.MINUTES).equals(datetime))
                .findFirst();
        
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            styleAppointmentButton(appointment, btnAppointment);
            
            btnAppointment.addActionListener((e) -> {
                scheduledAppointmentActionPerformed(e, appointment);
            });
            
        } else {
            
            btnAppointment.addActionListener((e) -> {
                freeAppointmentActionPerformed(e, datetime);
            });
            
        }
        if (dateEntry.getValue().isEqual(LocalDate.now())) {
            btnAppointment.setBorder(new MatteBorder(1, 1, 1, 1, COLOR_TODAY));
        }
        return btnAppointment;
    }
    
    private void freeAppointmentActionPerformed(ActionEvent e, LocalDateTime datetime) {
        if (freeAppointmentsActionListener == null) {
            return;
        }

        Appointment blankAppointment = new Appointment();
        blankAppointment.setStartTime(datetime);
        blankAppointment.setEndTime(datetime.plusMinutes(30));
        CalendarEvent ce = new CalendarEvent(e.getSource(), blankAppointment);

        freeAppointmentsActionListener.calendarEventOccured(ce);
    }

    private void scheduledAppointmentActionPerformed(ActionEvent e, Appointment appointment) {
        if (scheduledAppointmentsActionListener == null) {
            return;
        }
        scheduledAppointmentsActionListener.calendarEventOccured(new CalendarEvent(e.getSource(), appointment));
    }

    private void styleAppointmentButton(Appointment appointment, JButton btnAppointment) {
        btnAppointment.setBackground(Color.red);

        StringBuilder sb = new StringBuilder();
        LocalTime startTime = appointment.getStartTime().toLocalTime();
        sb.append("<html>");
        sb.append("<b>");
        sb.append(startTime.format(HOUR_FORMAT)).append(" - ").append(startTime.plusMinutes(30).format(HOUR_FORMAT));
        sb.append("</b>");
        sb.append("<br>");
        sb.append("Patient").append(appointment.getPatientId());
        sb.append("</html>");
        btnAppointment.setText(sb.toString());
    }
}
