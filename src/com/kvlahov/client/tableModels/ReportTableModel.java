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
public abstract class ReportTableModel<T> extends AbstractTableModel {

    List<T> newRecurringPatients;
    
     private String[] columnNames = {
        "Date",
        "Number of new patients",
        "Number of recurring patients"
    };

    public ReportTableModel(List<T> newRecurringPatients) {
        this.newRecurringPatients = newRecurringPatients;
    }

    protected void setColumnNames(String[] newColumnNames) {
        this.columnNames = newColumnNames;

        fireTableStructureChanged();
    }
    
    @Override
    public int getRowCount() {
        return newRecurringPatients.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T row = newRecurringPatients.get(rowIndex);
        return getValueAtColumn(row, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public abstract Object getValueAtColumn(T rowValue, int columnIndex);
    
}
