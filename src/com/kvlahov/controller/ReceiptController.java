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
import com.kvlahov.model.ReceiptItem;
import com.kvlahov.model.ServiceAppointment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lordo
 */
public class ReceiptController {

    private static final IRepository repo = RepositoryFactory.getRepository();

    public static Receipt generateReceipt(Appointment appointment) {
        Receipt receipt = new Receipt();
        receipt.setDate(LocalDate.now());
        
        List<ServiceAppointment> services = repo.getServicesForAppointment(appointment.getId());
        receipt.setItems(receiptItemsFromServices(services));
        
        receipt.setPatientId(appointment.getPatientId());
        
        return receipt;
    }

    public static void insertReceipt(Receipt receipt) throws InvalidModelException {
        if (!receipt.isValid()) {
            throw new InvalidModelException("Receipt model is invalid");
        }

        repo.insertReceipt(receipt);
    }

    public static Receipt getReceipt(int id) {
        return repo.getReceipt(id);
    }

    public static List<Receipt> getReceiptsforPatient(int pid) {
        return repo.getReceiptsforPatient(pid);
    }

    public static void updateReceipt(Receipt receipt) throws InvalidModelException {
        if (!receipt.isValid()) {
            throw new InvalidModelException("Receipt model is invalid");
        }

        repo.updateReceipt(receipt);
    }
    
    public static void deleteReceipt(int receiptId) {
        repo.deleteReceipt(receiptId);
    }

    private static List<ReceiptItem> receiptItemsFromServices(List<ServiceAppointment> services) {
        List<ReceiptItem> receiptItems = new ArrayList<>();
        for (ServiceAppointment service : services) {
            ReceiptItem item = new ReceiptItem();
            item.setServiceId(service.getServiceId());
            item.setPricePerItem(repo.getService(service.getServiceId()).getPrice());
            item.setQuantity(service.getQuantity());
            
            receiptItems.add(item);
        }
        
        return receiptItems;
    }

}
