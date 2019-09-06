/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.stream.Stream;

/**
 *
 * @author lordo
 */
public class Validations {
    public static boolean notNullOrEmpty(String s) {
        if(s == null) return false;
        return s.trim().isEmpty();
    }
    
    public static boolean dateBeforeOther(LocalDateTime start, LocalDateTime end) {
        return start.isBefore(end);
    }
    
    public static boolean isOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }
    
    public static boolean isAfterOrEqualNow(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        return date.isAfter(now) || date.isEqual(now);
    }
    
    public static boolean isPositive(Number num) {
        return num.doubleValue() > 0.0;
    }
    
    public static boolean validate(Collection<Boolean> validations ) {
        return validations.stream().allMatch(val -> val == true);
    }
}
