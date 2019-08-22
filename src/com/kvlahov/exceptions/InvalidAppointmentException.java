/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.exceptions;

/**
 *
 * @author programer10
 */
public class InvalidAppointmentException extends Exception {

    public InvalidAppointmentException() {
    }

    public InvalidAppointmentException(String message) {
        super(message);
    }
}
