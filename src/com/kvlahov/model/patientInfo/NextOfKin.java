/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.patientInfo;

import com.kvlahov.model.Person;
import java.util.List;

/**
 *
 * @author lordo
 */
public class NextOfKin extends Person {

    private String relationshipToPatient;
    private ContactInfo contactInformation;

    public ContactInfo getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInfo contactInformation) {
        this.contactInformation = contactInformation;
    }

    public NextOfKin(String name, String surname, String relationshipToPatient) {
        super(name, surname);
        this.relationshipToPatient = relationshipToPatient;
    }

    public String getRelationshipToPatient() {
        return relationshipToPatient;
    }

    public void setRelationshipToPatient(String relationshipToPatient) {
        this.relationshipToPatient = relationshipToPatient;
    }

    public Contact getContactForBasicInformation() {
        if (contactInformation != null) {
            List<Contact> contacts = contactInformation.getContacts();
            if (contacts != null) {
                return contacts.stream()
                        .filter(c -> c.getType().getType().equalsIgnoreCase("Mobile"))
                        .findFirst()
                        .get();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "NextOfKin{" + "\nrelationshipToPatient=" + relationshipToPatient + "\ncontactInformation\n\t" + contactInformation + '}';
    }

}
