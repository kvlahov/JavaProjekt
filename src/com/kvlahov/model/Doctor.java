/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.utils.Validatable;
import com.kvlahov.utils.Validations;

/**
 *
 * @author lordo
 */
public class Doctor extends Person implements Validatable{

    private int departmentID;

    public Doctor(int id, String name, String surname, int departmentID) {
        super(id, name, surname);
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname();
    }

    @Override
    public boolean isValid() {
        return true;
    }

}
