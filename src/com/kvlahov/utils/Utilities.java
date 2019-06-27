/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.utils;

import com.kvlahov.client.DoctorUI;
import com.kvlahov.client.RegularUI;
import com.kvlahov.model.enums.Sex;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.beans.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author lordo
 */
public class Utilities {

    public static void setDefaultsForJFrame() {
        UIManager.getLookAndFeelDefaults()
                .put("defaultFont", new Font("Segoe UI Light", Font.PLAIN, 14));

        UIManager.getDefaults().put("TextField.margin", new Insets(10, 10, 10, 10));
        UIManager.getDefaults().put("PasswordField.margin", new Insets(10, 10, 10, 10));
        UIManager.getDefaults().put("FormattedTextField.margin", new Insets(10, 10, 10, 10));
    }

    public static void writeProperties(String path) {
        //"C:\\Users\\programer10\\Downloads\\OMStudio-20190624T080759Z-001\\OMStudio\\src\\com\\kvlahov\\properties\\props.txt"
        try (OutputStream os = new FileOutputStream(path)) {
            Properties prop = new Properties();

            prop.setProperty("REGULAR", RegularUI.class.getName());
            prop.setProperty("DOCTOR", DoctorUI.class.getName());

            prop.store(os, "comments");

            System.out.println(prop);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void writeProperties(String path, Map<String, String> properties) {
        try (OutputStream os = new FileOutputStream(path)) {
            Properties prop = new Properties();

            prop.putAll(properties);

//            prop.setProperty("REGULAR", RegularUI.class.getName());
//            prop.setProperty("DOCTOR", DoctorUI.class.getName());
            prop.store(os, "comments");

            System.out.println(prop);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void initPropertyFilesForExtendedInfo() {

        Map<String, String> permaAddressMap = new HashMap<>();
        permaAddressMap.put("permanentAddArea", "area");
        permaAddressMap.put("permanentAddState", "state");
        permaAddressMap.put("permanentAddStreet", "street");
        permaAddressMap.put("permanentAddCity", "city");
        permaAddressMap.put("permanentAddZip", "zipCode");

        Map<String, String> presentAddressMap = new HashMap<>();
        presentAddressMap.put("presentAddArea", "area");
        presentAddressMap.put("presentAddState", "state");
        presentAddressMap.put("presentAddStreet", "street");
        presentAddressMap.put("presentAddCity", "city");
        presentAddressMap.put("presentAddZip", "zipCode");

        Map<String, String> complaintsMap = new HashMap<>();
        complaintsMap.put("cardiacCondition", "cardiacCondition");
        complaintsMap.put("digestiveCondition", "digestiveCondition");
        complaintsMap.put("hospitalTreated", "hospitalTreated");
        complaintsMap.put("isDiabetic", "isDiabetic");
        complaintsMap.put("isHypertensive", "isHypertensive");
        complaintsMap.put("knownAllergies", "knownAllergies");
        complaintsMap.put("surgeryHistory", "majorSurgeries");
        complaintsMap.put("muscularCondition", "muscularCondition");
        complaintsMap.put("neurologicalCondition", "neurologicalCondition");
        complaintsMap.put("orthopedicCondition", "orthopedicCondition");
        complaintsMap.put("treatmentHistory", "previousTreatments");
        complaintsMap.put("reactionToDrugs", "reactionDrugs");
        complaintsMap.put("respitoryCondition", "respiratoryCondition");
        complaintsMap.put("statementOfComplaint", "statementComplaint");

        Map<String, String> lifestyleMap = new HashMap<>();
        lifestyleMap.put("spinnerCigsPerDay", "averageCigarettesPerDay");
        lifestyleMap.put("spinnerAlcoholPerDay", "averageDrinksPerDay");
        lifestyleMap.put("spinCaffeinePerDay", "coffeineDrinkPerDay");
        lifestyleMap.put("consumesAlcohol", "consumesAlcohol");
        lifestyleMap.put("eatingHabits", "eatingHabits");
        lifestyleMap.put("isSmoker", "isSmoker");
        lifestyleMap.put("isVege", "isVegetarian");
        lifestyleMap.put("spinSoftPerDay", "softDrinkPerDay");
        lifestyleMap.put("stimulants", "usesStimulants");

        Map<String, String> personalInfoMap = new HashMap<>();
        personalInfoMap.put("grossIncome", "annualIncome");
        personalInfoMap.put("bloodType", "bloodType");
        personalInfoMap.put("height", "height");
        personalInfoMap.put("maritalStatus", "maritalStatus");
        personalInfoMap.put("noOfDependents", "noOFDependents");
        personalInfoMap.put("occupation", "occupation");
        personalInfoMap.put("weight", "weight");

        Map<String, String> nokAddressMap = new HashMap<>();
        nokAddressMap.put("nokAddArea", "area");
        nokAddressMap.put("nokAddCity", "city");
        nokAddressMap.put("nokAddState", "state");
        nokAddressMap.put("nokAddStreet", "street");
        nokAddressMap.put("nokAddZip", "zipCode");

        final String path = ".\\src\\com\\kvlahov\\properties\\";
        Utilities.writeProperties(path + "complaintsProps.txt", complaintsMap);
        Utilities.writeProperties(path + "lifestyleProps.txt", lifestyleMap);
        Utilities.writeProperties(path + "nokAddressProps.txt", nokAddressMap);
        Utilities.writeProperties(path + "permanentAddressProps.txt", permaAddressMap);
        Utilities.writeProperties(path + "personalInfoProps.txt", personalInfoMap);
        Utilities.writeProperties(path + "presentAddressProps.txt", presentAddressMap);
    }

    public static Properties readProperties(String path) {
        try (InputStream in = new FileInputStream(path)) {
            Properties prop = new Properties();

            prop.load(in);
            return prop;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * If {@code ofInstance} is null returns all elements flattened
     *
     * @param componentsArray
     * @param ofInstance
     * @return flattened List of Components
     */
    public static List<Component> getFlattenedListOfComponents(Component[] componentsArray, List<Class> ofInstance) {
        List<Component> resultList = new ArrayList<>();
        flattenComponents(componentsArray, resultList, ofInstance);
        return resultList;
    }

    private static void flattenComponents(Component[] components, List<Component> listToFill, List<Class> ofInstance) {
        for (Component component : components) {
            if (component instanceof Container) {
                flattenComponents(((Container) component).getComponents(), listToFill, ofInstance);
            }

            if (isInstanceOf(component, ofInstance)) {
                listToFill.add(component);
            }
        }
    }

    /**
     * If {@code classes} is null returns true
     *
     * @param target object to check
     * @param classes list of classes to compare object to
     * @return
     */
    public static boolean isInstanceOf(Object target, List<Class> classes) {
        if (classes == null) {
            return true;
        }
        return classes.stream().anyMatch((clazz) -> (clazz.isInstance(target)));
    }

    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void invokeGetters(Object target, Map<String, String> nameFieldMap, Map<String, String> values) {
        for (String name : nameFieldMap.keySet()) {
            try {
                String returnValue = target.getClass()
                        .getMethod("get" + StringUtils.capitalize(nameFieldMap.get(name)))
                        .invoke(target).toString();
                values.put(name, returnValue);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void invokeSetters(Object target, Map<String, String> nameFieldMap, Map<String, String> values) {
        for (String name : nameFieldMap.keySet()) {
            try {
                Statement stmt = new Statement(
                        target,
                        "set" + StringUtils.capitalize(nameFieldMap.get(name)),
                        new Object[]{tryCast(values.get(name))}
                );

                stmt.execute();
            } catch (Exception ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static <T> T tryCast(String value) {
        if (tryParseInt(value)) {
            return (T) Integer.valueOf(value);
        }
        if (tryParseLocalDate(value)) {
            return (T) LocalDate.parse(value);
        }
        if (tryParseFloat(value)) {
            return (T) Float.valueOf(value);
        }
        if (tryParseBoolean(value)) {
            return (T) Boolean.valueOf(value);
        }
        if (tryParseSex(value)) {
            return (T) Sex.valueOf(value.toUpperCase());
        }
//        if(tryParseDate(value)) {
//            toLocalDate(Date.pa)
//        }

        return (T) value;
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.valueOf(value);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private static boolean tryParseLocalDate(String value) {
        try {
            LocalDate.parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean tryParseFloat(String value) {
        try {
            Float.valueOf(value);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private static boolean tryParseBoolean(String value) {
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
    }

    private static boolean tryParseSex(String value) {
        try {
            Sex.valueOf(value.toUpperCase());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
