/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.utils.Validatable;
import com.kvlahov.utils.Validations;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lordo
 */
public abstract class Person implements Validatable {
    private int id = -1;
    private String name;
    private String surname;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    
     public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "name = " + name + ", surname = " + surname + " ";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return this.id == other.id;
    }
    
    public boolean hasIdSet() {
        return id != -1;
    }
    
    @Override
    public boolean isValid() {
        List<Boolean> validations = Arrays.asList
        (
            Validations.notNullOrEmpty(this.name),
            Validations.notNullOrEmpty(this.surname)
                
        );
        return Validations.validate(validations);
    }

}
