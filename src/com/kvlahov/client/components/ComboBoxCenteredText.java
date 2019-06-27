/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author lordo
 */
public class ComboBoxCenteredText extends JComboBox<Object>{

    public ComboBoxCenteredText(ComboBoxModel<Object> aModel) {
        super(aModel);
    }

    public ComboBoxCenteredText(Object[] items) {
        super(items);
    }

    public ComboBoxCenteredText(Vector<Object> items) {
        super(items);
    }

    public ComboBoxCenteredText() {
        ((JLabel)this.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }
    
}
