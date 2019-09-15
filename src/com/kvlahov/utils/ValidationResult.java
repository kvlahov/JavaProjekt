/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.utils;

/**
 *
 * @author Travelino
 */
public class ValidationResult {

    private boolean isValid;
    private String errors;

    public ValidationResult(boolean isValid, String errors) {
        this.isValid = isValid;
        this.errors = errors;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getErrors() {
        if(!isValid) {
            return errors;
        }
        return "";
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        errors = errors.concat("\n" + error);
    }

    public void clearErrors() {
        errors = "";
    }

}
