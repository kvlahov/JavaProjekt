/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client;

import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author lordo
 */
public abstract class AppDefaults {

    public static void setDefaults() {
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        if (defaults.get("Table.alternateRowColor") == null) {
            defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
        }
    }
}
