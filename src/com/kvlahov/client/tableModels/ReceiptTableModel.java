/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import com.kvlahov.client.global.Constants;
import com.kvlahov.model.Appointment;
import com.kvlahov.model.Receipt;
import java.util.List;

/**
 *
 * @author lordo
 */
public class ReceiptTableModel extends GenericTableModel<Receipt> {
    private String[] columnNames = {
        "Id",
        "Receipt Number",
        "Date"
    };

    public ReceiptTableModel(List<Receipt> receipts) {
        super(receipts, 0);
        initTableModel();
    }

    @Override
    public Object cellValueForColumnIndex(Receipt receipt, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return receipt.getId();
            case 1:
                return receipt.getReceiptNumber();
            case 2:
                return receipt.getDate().format(Constants.DATE_FORMAT);
            default:
                return null;
        }
    }

    private void initTableModel() {
        setColumnNames(columnNames);
        
        setRowModelPredicate((a) -> a.getId() == (int) getCellValue());
    }
    
}
