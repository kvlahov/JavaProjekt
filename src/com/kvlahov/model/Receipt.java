/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.utils.Validatable;
import com.kvlahov.utils.ValidationResult;
import com.kvlahov.utils.Validations;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lordo
 */
public class Receipt implements Validatable {

    private int id;
    private String receiptNumber;
    private LocalDate date;
    private String comment;
    private int patientId;
    private int paymentMethodId;

    private PaymentMethod paymentMethod;
    private double total;

    private List<ReceiptItem> items = new ArrayList<>();
    private String validationErrors = "";

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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void calculateTotal() {
        this.total
                = items.stream()
                        .mapToDouble(item -> item.getTotalPrice())
                        .sum();

    }

    public void generateReceiptNumber() {
        this.receiptNumber = date.format(DateTimeFormatter.ISO_DATE)
                .concat("-" + patientId + "-")
                .concat(String.valueOf(hashCode()));
    }

    public String getValidationErrors() {
        return validationErrors;
    }

    @Override
    public boolean isValid() {
        List<ValidationResult> validations = Arrays.asList(
                Validations.notNullOrEmpty(receiptNumber, "Receipt number"),
                Validations.isPositive(patientId, "PatientId"),
                Validations.isPositive(paymentMethod.getId(), "PaymentMethodID")
        );
        ValidationResult validationResult = Validations.validate(validations);
        validationErrors = validationResult.getErrors();
        return validationResult.isValid();
    }

}
