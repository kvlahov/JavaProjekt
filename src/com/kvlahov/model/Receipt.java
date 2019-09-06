/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.utils.Validatable;
import com.kvlahov.utils.Validations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author lordo
 */
public class Receipt implements Validatable{

    private int id;
    private String receiptNumber;
    private LocalDate date;
    private String comment;
    private int patientId;
    private int paymentMethodId;
    
    private List<ReceiptItem> items = new ArrayList<>();

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    
    @Override
    public boolean isValid() {
        List<Boolean> validations = Arrays.asList
        (
            Validations.notNullOrEmpty(receiptNumber),
            Validations.isPositive(patientId),
            Validations.isPositive(paymentMethodId)
        );
        
        return Validations.validate(validations);
    }

}
