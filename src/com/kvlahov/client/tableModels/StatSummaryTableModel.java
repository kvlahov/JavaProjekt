/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import com.kvlahov.model.report.StatServiceSummary;
import java.util.List;

/**
 *
 * @author lordo
 */
public class StatSummaryTableModel extends ReportTableModel<StatServiceSummary> {

    private String[] columnNames = {
        "Patient",
        "Service",
        "Price",
        "Type Of Service",
        "Quantity",
        "Description"
    };

    public StatSummaryTableModel(List<StatServiceSummary> newRecurringPatients) {
        super(newRecurringPatients);
        setColumnNames(columnNames);
    }

    @Override
    public Object getValueAtColumn(StatServiceSummary rowValue, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowValue.getPatient().toString();
            case 1:
                return rowValue.getService();
            case 2:
                return rowValue.getPrice();
            case 3:
                return rowValue.getTypeOfService();
            case 4:
                return rowValue.getQuantity();
            case 5:
                return rowValue.getDescription();
            default:
                return null;
        }
    }
}