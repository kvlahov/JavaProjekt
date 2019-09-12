/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov;

import com.kvlahov.client.Gui;
import com.kvlahov.client.RegularUI;
import com.kvlahov.client.Tets;
import com.kvlahov.client.components.NewPatientDialog;
import com.kvlahov.controller.PatientController;
import com.kvlahov.dal.repository.*;
import com.kvlahov.model.patientInfo.ExtendedPatientInformation;
import java.time.LocalDate;
import javax.swing.JFrame;


/**
 *
 * @author lordo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        // TODO code application logic here

//        //došao novi pacijent
//        bindFormToPatient(Patient p);
//        registerPatient(Patient p);
//        assignDoctor(Patient p);
//        
//        //postojeci pacijent
//        
//        getPatient(id);
//        setAppointment(patient);
//        Utilities.writeProperties();/
        IRepository repo = RepositoryFactory.getRepository();

//        LoginScreen.start();
//        DoctorUI.start();
        JFrame f = new RegularUI();
//        ((Gui) f).start();
        Tets.main(null);
        
        LocalDate date = LocalDate.now();
        
        LocalDate startOfMonth = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate endOfMonth = startOfMonth.plusDays(date.getMonth().length(date.isLeapYear()));
        
        System.out.println("AB+".substring(2));
        ////////////////////////////////
        //TESTING
    }

}
