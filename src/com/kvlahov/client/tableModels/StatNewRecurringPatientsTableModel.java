/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import com.kvlahov.model.report.StatNewRecurringPatients;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lordo
 */
public class StatNewRecurringPatientsTableModel extends ReportTableModel<StatNewRecurringPatients>{
     private String[] columnNames = {
        "Date",
        "Number of new patients",
        "Number of recurring patients"
    };

    public StatNewRecurringPatientsTableModel(List<StatNewRecurringPatients> newRecurringPatients) {
        super(newRecurringPatients);
        setColumnNames(columnNames);
    }

    @Override
    public Object getValueAtColumn(StatNewRecurringPatients row, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return row.getDate();
            case 1:
                return row.getNoNewPatients();
            case 2:
                return row.getNoRecurringPatients();
            default:
                return null;
        }
    }
}
