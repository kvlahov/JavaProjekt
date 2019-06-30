/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov;

import com.kvlahov.client.DoctorUI;
import com.kvlahov.client.Gui;
import com.kvlahov.client.LoginScreen;
import com.kvlahov.client.RegularUI;
import com.kvlahov.controller.PatientController;
import com.kvlahov.dal.repository.*;
import com.kvlahov.model.Patient;
import com.kvlahov.model.Person;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.Sex;
import com.kvlahov.model.enums.UserRole;
import com.kvlahov.model.patientInfo.LifestyleInfo;
import com.kvlahov.model.patientInfo.PersonalInfo;
import com.kvlahov.utils.Utilities;
import com.sun.xml.internal.ws.util.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import org.jcp.xml.dsig.internal.dom.Utils;

/**
 *
 * @author lordo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
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
        ((Gui) f).start();

        ////////////////////////////////
        //TESTING
        Map<String, String> map = new HashMap<>();
        Map<String, String> values = new HashMap<>();

        values.put("patientName", "Kreso");
        values.put("patientSurname", "Vlahov");
        values.put("patientId", "100");
        values.put("patientSex", "female");

        map.put("patientName", "name");
        map.put("patientSurname", "surname");
        map.put("patientId", "id");
        map.put("patientSex", "sex");
        
        String s = "Pero";
        String[] split = s.split(" ");
        System.out.println(split.length);
        
        repo.insertPatientContact(1, 6, "testmail@mail.com");
        
//        mapa.forEach((k,v) -> System.out.println(k + " " + v));
        
    }

}
