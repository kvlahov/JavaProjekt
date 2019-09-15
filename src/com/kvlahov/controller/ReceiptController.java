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
import com.kvlahov.model.PaymentMethod;
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
        receipt.calculateTotal();
        
        receipt.setPatientId(appointment.getPatientId());
        receipt.generateReceiptNumber();
        
        return receipt;
    }

    public static void insertReceipt(Receipt receipt) throws InvalidModelException {
        if (!receipt.isValid()) {
            throw new InvalidModelException(receipt.getValidationErrors());
        }

        int receiptId = repo.insertReceipt(receipt);
        receipt.getItems().forEach(i -> i.setReceiptId(receiptId));
        receipt.getItems().forEach(i -> repo.insertReceiptItem(i));
    }

    public static Receipt getReceipt(int id) {
        Receipt receipt = repo.getReceipt(id);
        receipt.setItems(getReceiptItems(id));
        receipt.calculateTotal();
        
        return receipt;
    }

    public static List<Receipt> getReceiptsforPatient(int pid) {
        List<Receipt> receiptsForPatient = repo.getReceiptsForPatient(pid);
        receiptsForPatient.forEach(r -> r.calculateTotal());
        return receiptsForPatient;
    }

    public static void updateReceipt(Receipt receipt) throws InvalidModelException {
        if (!receipt.isValid()) {
            throw new InvalidModelException(receipt.getValidationErrors());
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
            item.setServiceId(service.getService().getId());
            item.setPricePerItem(service.getService().getPrice());
            item.setQuantity(service.getQuantity());
            item.setService(service.getService());
            item.setReceiptId(0);
            
            item.calculateTotalPrice();
            
            receiptItems.add(item);
        }
        
        return receiptItems;
    }
    
    public static List<PaymentMethod> getAllPaymentMethods() {
        return repo.getAllPaymentMethods();
    }
    
    private static List<ReceiptItem> getReceiptItems(int receiptId) {
        List<ReceiptItem> receiptItems = repo.getReceiptItems(receiptId);
        receiptItems.forEach(ri -> ri.setService(repo.getService(ri.getServiceId())));
        return receiptItems;
    }

}
