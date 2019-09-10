/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import com.kvlahov.model.Patient;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author lordo
 */
public class PatientTableModel extends GenericTableModel<Patient> {

    private String[] columnNames = {
        "Id",
        "First Name",
        "Last Name",
        "Sex",
        "Date of Birth"
    };

    public PatientTableModel(List<Patient> patients) {
        super(patients, 0);
        initTableModel();
    }

    @Override
    public Object cellValueForColumnIndex(Patient patient, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return patient.getId();
            case 1:
                return patient.getName();
            case 2:
                return patient.getSurname();
            case 3:
                return patient.getSex().toString();
            case 4:
                return patient.getFormatedDate(null);
            default:
                return null;
        }
    }

    private void initTableModel() {
        setColumnNames(columnNames);
        
        setRowModelPredicate((p) -> p.getId() == (int) super.getCellValue());
    }
}
