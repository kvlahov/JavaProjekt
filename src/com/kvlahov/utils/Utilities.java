/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.utils;

import com.kvlahov.client.DoctorUI;
import com.kvlahov.client.RegularUI;
import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.enums.AddressTypeEnum;
import com.kvlahov.model.enums.ContactType;
import com.kvlahov.model.enums.ContactTypeEnum;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
                .put("defaultFont", new Font("Segoe UI Light", Font.PLAIN, 18));

        UIManager.getDefaults().put("TextField.margin", new Insets(10, 10, 10, 10));
        UIManager.getDefaults().put("TextArea.margin", new Insets(10, 10, 10, 10));
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

    public static Date toDate(LocalDateTime localDate) {
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static boolean isInTargetWeek(LocalDate startOfWeek, LocalDate date) {
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        
        return (date.isAfter(startOfWeek) || date.isEqual(startOfWeek))
                && 
                (date.isBefore(endOfWeek) || date.isEqual(endOfWeek));
        
    }
    
    public static boolean isInCurrentWeek(LocalDate date) {
        LocalDate startOfWeek = getStartOfWeek(LocalDate.now());
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        
        return (date.isAfter(startOfWeek) || date.isEqual(startOfWeek))
                && 
                (date.isBefore(endOfWeek) || date.isEqual(endOfWeek));
    }
    
    public static LocalDate getStartOfWeek(LocalDate date) {
        int daysToSubtract = date.getDayOfWeek().getValue() - 1;
        return date.minusDays(daysToSubtract);
    }
    
    public static LocalDate calendarToLocalDate(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toLocalDate();
    }

    public static LocalDate getEndOfMonth(LocalDate date) {
        
        return getStartOfMonth(date).plusDays(date.getMonth().length(date.isLeapYear()) - 1);
    }
    
    public static LocalDate getStartOfMonth(LocalDate date) {
        
        return LocalDate.of(date.getYear(), date.getMonth(), 1);
    }
    
    public static AddressType getAddressType(AddressTypeEnum addressType, List<AddressType> addressTypes) {
        return addressTypes.stream()
                .filter(t -> t.getType().toUpperCase().equals(addressType.name()))
                .findFirst()
                .get();
    }
    
    public static ContactType getContactType(ContactTypeEnum contactType, List<ContactType> contactTypes) {
        return contactTypes.stream()
                .filter(t -> t.getType().toUpperCase().equals(contactType.name()))
                .findFirst()
                .get();
    }
    
    
}
