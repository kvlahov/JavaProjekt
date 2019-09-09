/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.events;

import com.kvlahov.model.Appointment;
import java.util.EventObject;

/**
 *
 * @author lordo
 */
public class CalendarEvent extends EventObject {

    private Appointment appointment;

    public CalendarEvent(Object source) {
        super(source);
    }

    public CalendarEvent(Object source, Appointment appointment) {
        super(source);
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    

}
