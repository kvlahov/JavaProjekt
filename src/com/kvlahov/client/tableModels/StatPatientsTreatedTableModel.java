/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import com.kvlahov.model.Appointment;
import com.kvlahov.model.report.StatPatientsTreated;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lordo
 */
public class StatPatientsTreatedTableModel extends ReportTableModel<StatPatientsTreated> {

    private String[] columnNames = {
        "Id",
        "Doctor",
        "Number of Patients Treated"
    };

    public StatPatientsTreatedTableModel(List<StatPatientsTreated> patientsTreated) {
        super(patientsTreated);
        setColumnNames(columnNames);
    }

    @Override
    public Object getValueAtColumn(StatPatientsTreated rowValue, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return rowValue.getDoctor().getId();
            case 1:
                return rowValue.getDoctor().toString();
            case 2:
                return rowValue.getNoPatientsTreated();
            default:
                return null;
        }
    }

    

}
