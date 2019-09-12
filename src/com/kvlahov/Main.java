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
        
        LoginScreen main = new LoginScreen();
//        main.start();
        DoctorUI docUi = new DoctorUI();
        docUi.start();
        JFrame f = new RegularUI();
//        ((Gui) f).start();
        

    }

}
