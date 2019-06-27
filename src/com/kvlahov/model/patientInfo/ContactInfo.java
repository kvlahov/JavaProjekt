/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.patientInfo;

import com.kvlahov.model.enums.PhoneNumberType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lordo
 */
public class ContactInfo {
    private Address presentAddress;
    private Address permanentAddress;
    private String email;
    private HashMap<PhoneNumberType, Set<String>> phoneNumbers = initPhoneNumbers();

    private HashMap<PhoneNumberType, Set<String>> initPhoneNumbers() {
        HashMap<PhoneNumberType, Set<String>> phoneNumbers = new HashMap<>();
        
        phoneNumbers.put(PhoneNumberType.WORK, new LinkedHashSet<>());
        phoneNumbers.put(PhoneNumberType.HOME, new LinkedHashSet<>());
        phoneNumbers.put(PhoneNumberType.MOBILE, new LinkedHashSet<>());
        phoneNumbers.put(PhoneNumberType.PAGER, new LinkedHashSet<>());
        phoneNumbers.put(PhoneNumberType.FAX, new LinkedHashSet<>());
        
        return phoneNumbers;
    }

    public Address getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(Address presentAddress) {
        this.presentAddress = presentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<PhoneNumberType, Set<String>> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(PhoneNumberType type, String number) {
        this.phoneNumbers.get(type).add(number);
    }  
    
    public void setPhoneNumber(PhoneNumberType type, Set<String> number) {
        this.phoneNumbers.put(type, number);
    }  

    public static class Address {
        private String street;
        private String area;
        private String city;
        private String state;
        private String zipCode;
        

        public Address() {
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        @Override
        public String toString() {
            return "Address{" + "\nstreet=" + street + "\narea=" + area + "\ncity=" + city + "\nstate=" + state + "\nzipCode=" + zipCode + '}';
        }
        
        
    }

    @Override
    public String toString() {
        return "ContactInfo{" + 
                "\npresentAddress\n\t" + presentAddress + 
                "\npermanentAddress\n\t" + permanentAddress + 
                "\nemail=" + email + "\nphoneNumbers=\n\t" + phoneNumbers;
    }
    
    
}
