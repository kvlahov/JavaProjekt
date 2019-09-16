/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov;

import com.kvlahov.client.AppDefaults;
import com.kvlahov.client.DoctorUI;
import com.kvlahov.client.Gui;
import com.kvlahov.client.LoginScreen;
import com.kvlahov.client.RegularUI;
import com.kvlahov.client.Tets;
import com.kvlahov.dal.repository.*;
import com.kvlahov.model.Patient;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.patientInfo.ComplaintsInfo;
import com.kvlahov.model.patientInfo.Contact;
import com.kvlahov.model.patientInfo.ContactInfo;
import com.kvlahov.model.patientInfo.NextOfKin;
import java.util.Arrays;
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
        AppDefaults.setDefaults();
        
//        LoginScreen main = new LoginScreen();
//        main.start();
//        DoctorUI docUi = new DoctorUI();
//        docUi.start();
        JFrame f = new RegularUI();
        ((Gui) f).start();
        
//        IRepository repo = RepositoryFactory.getRepository();
//        
//        Patient patient = repo.getPatient(1);
////        
////        NextOfKin nok = new NextOfKin("Prvi nok", "Prezime", "Mater");
////        
////        ContactInfo ci = new ContactInfo();        
////        ContactType ct = new ContactType(3, "Mobile");
////        
////        ci.setContacts(Arrays.asList(new Contact(ct, "987654321")));
////        nok.setContactInformation(ci);
////        
////        int nokID = repo.insertNextOfKin(patient.getId(), nok);
////        repo.insertNextOfKinContact(nokID, ci.getContacts().get(0));
//        
//        ComplaintsInfo complaints = new ComplaintsInfo();
//        complaints.setStatementComplaint("Basic statement of complaint");
//        repo.insertComplaint(patient.getId(), complaints);
//        repo.insertPatientContact(patient.getId(), new Contact(ct, "0912058091"));
//        Tets.main(null);
        

    }

}
