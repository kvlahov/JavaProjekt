/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.patientInfo;

import com.kvlahov.model.enums.AddressType;
import com.kvlahov.model.enums.ContactType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author lordo
 */
public class ContactInfo {
    private Address presentAddress;
    private Address permanentAddress;
    private String email;
    private HashMap<ContactType, Set<String>> contacts = initPhoneNumbers();

    private HashMap<ContactType, Set<String>> initPhoneNumbers() {
        HashMap<ContactType, Set<String>> initContacts = new HashMap<>();
        
        initContacts.put(ContactType.WORK, new LinkedHashSet<>());
        initContacts.put(ContactType.HOME, new LinkedHashSet<>());
        initContacts.put(ContactType.MOBILE, new LinkedHashSet<>());
        initContacts.put(ContactType.PAGER, new LinkedHashSet<>());
        initContacts.put(ContactType.FAX, new LinkedHashSet<>());
        initContacts.put(ContactType.EMAIL, new LinkedHashSet<>());
        
        return initContacts;
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

    public HashMap<ContactType, Set<String>> getContacts() {
        return contacts;
    }
    
    public String getFirstContactForType(ContactType type) {

        return contacts.keySet().stream()
                .filter(k -> k == type)
                .flatMap(k -> contacts.get(k).stream())
                .findFirst()
                .orElse("");
                
    }

    public void addPhoneNumber(ContactType type, String number) {
        this.contacts.get(type).add(number);
    }  
    
    public void setPhoneNumber(ContactType type, Set<String> number) {
        this.contacts.put(type, number);
    }  

    public static class Address {
        private String street;
        private String area;
        private String city;
        private String state;
        private String zipCode;
        private AddressType type;  
        

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

        public AddressType getType() {
            return type;
        }

        public void setType(AddressType type) {
            this.type = type;
        }
        
        

        @Override
        public String toString() {
            return street + ", " + zipCode + " " + city + ", " + state;
        }
        
        
    }

    @Override
    public String toString() {
        return "ContactInfo{" + 
                "\npresentAddress\n\t" + presentAddress + 
                "\npermanentAddress\n\t" + permanentAddress + 
                "\nemail=" + email;
    }
    
    
}
