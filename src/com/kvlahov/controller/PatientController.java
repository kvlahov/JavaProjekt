/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.controller;

import com.kvlahov.model.Patient;
import com.kvlahov.dal.repository.*;
import com.kvlahov.model.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lordo
 */
public class PatientController {
    private static IRepository repo = RepositoryFactory.getRepository();

    public static int insertBasicInformation(Patient p) {
        return repo.insertPatient(p);
    }

    public static void updatePatient(Patient p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Map<String, Set<String>> getContactNumbersForPatient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setAppointment(Patient p) {
//        int calendar = CalendarController.getCalendarFor(p);
    }
}
