/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov;

import com.kvlahov.client.AppDefaults;
import com.kvlahov.client.LoginScreen;


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
        main.start();

        

    }

}
