/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model;

import com.kvlahov.model.enums.Department;

/**
 *
 * @author lordo
 */
public class Doctor extends Person{
    private int departmentID;

    public Doctor(int id, String name, String surname, int departmentID) {
        super(id, name, surname);
        this.departmentID = departmentID;
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    @Override
    public String toString() {
        return  "Doctor{" + super.toString() + "department = " + departmentID + '}';
    }

}
