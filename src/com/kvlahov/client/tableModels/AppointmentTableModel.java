/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import com.kvlahov.model.Appointment;
import java.util.List;

/**
 *
 * @author lordo
 */
public class AppointmentTableModel extends GenericTableModel<Appointment> {
    private String[] columnNames = {
        "Id",
        "Date",
        "Start Time",
        "End Time"
    };

    public AppointmentTableModel(List<Appointment> appointments) {
        super(appointments, 0);
        initTableModel();
    }

    @Override
    public Object cellValueForColumnIndex(Appointment appointment, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return appointment.getId();
            case 1:
                return appointment.getFormattedDate();
            case 2:
                return appointment.getStartTime().toLocalTime();
            case 3:
                return appointment.getEndTime().toLocalTime();
            default:
                return null;
        }
    }

    private void initTableModel() {
        setColumnNames(columnNames);
        
        setRowModelPredicate((a) -> a.getId() == (int) getCellValue());
    }
    
}
