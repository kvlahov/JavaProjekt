/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.exceptions.InvalidModelException;
import com.kvlahov.model.Appointment;
import com.kvlahov.model.Receipt;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lordo
 */
public class ReceiptController {

    private static final IRepository repo = RepositoryFactory.getRepository();

    public static Receipt generateReceipt(int appointmentId) {
        Receipt receipt = new Receipt();
        receipt.setDate(LocalDate.now());
        receipt.setItems(null);
    }

    public static void insertReceipt(Receipt receipt) throws InvalidModelException {
        if (!receipt.isValid()) {
            throw new InvalidModelException("Receipt model is invalid");
        }

        repo.insertReceipt(receipt);
    }

    public static Receipt getReceipt(int id) {
        repo.getReceipt(id);
    }

    public static List<Receipt> getReceiptsforPatient(int pid) {
        repo.getReceiptsforPatient(pid);
    }

    public static void updateReceipt(Receipt receipt) throws InvalidModelException {
        if (!receipt.isValid()) {
            throw new InvalidModelException("Receipt model is invalid");
        }

        repo.updateReceipt(receipt);
    }

}
