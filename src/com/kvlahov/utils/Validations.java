/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author lordo
 */
public class Validations {
    public static ValidationResult notNullOrEmpty(String s, String propertyName) {
        final String errorMsg = " must not be null or empty";
        boolean result;
        if(s == null) {
            result = false;
        } else {
            result = !s.trim().isEmpty();
        }
        return new ValidationResult(result, propertyName + errorMsg);
        
    }
    
    public static boolean dateBeforeOther(LocalDateTime start, LocalDateTime end) {
        return start.isBefore(end);
    }
    
    public static boolean isOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }
    
    public static ValidationResult isAfterOrEqualNow(LocalDateTime date, String propertyName) {
        final String errorMsg = " must not be in the past";
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        return new ValidationResult((date.isAfter(now) || date.isEqual(now)), propertyName + errorMsg);
    }
    
    public static ValidationResult isPositive(Number num, String propertyName) {
        final String errorMsg = " must be positive";
        return new ValidationResult(num.doubleValue() > 0.0, propertyName + errorMsg);
    }
    
    public static ValidationResult validate(Collection<ValidationResult> validations ) {
         boolean result = validations.stream().allMatch(val -> val.isValid() == true);
         String errors = validations.stream()
                 .filter(v -> v.isValid() == false)
                 .map(v -> v.getErrors())
                 .collect(Collectors.joining("\n"));
         
         return new ValidationResult(result, errors);
    }
}
