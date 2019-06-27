/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client;

import com.kvlahov.client.components.NewPatientDialog;
import com.kvlahov.utils.Utilities;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;

import javax.swing.UIManager;

/**
 *
 * @author lordo
 */
public class RegularUI extends javax.swing.JFrame implements Gui{

    /**
     * Creates new form RegularUI
     */
    public RegularUI() {
        initComponents();
        initContent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miHide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel9.setText("Home");
        jPanel4.add(jLabel9);

        getContentPane().add(jPanel4, "card3");

        jMenuBar.setBackground(new java.awt.Color(51, 204, 255));
        jMenuBar.setForeground(new java.awt.Color(51, 204, 255));
        jMenuBar.setMaximumSize(new java.awt.Dimension(94, 32769));
        jMenuBar.setPreferredSize(new java.awt.Dimension(94, 44));

        jMenu1.setBackground(new java.awt.Color(204, 255, 0));
        jMenu1.setText("Patient");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miNew.setText("New");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        jMenu1.add(miNew);

        miHide.setText("Hide");
        miHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHideActionPerformed(evt);
            }
        });
        jMenu1.add(miHide);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewActionPerformed
        // TODO add your handling code here:      
        NewPatientDialog dialog = new NewPatientDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_miNewActionPerformed

    private void miHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHideActionPerformed
        // TODO add your handling code here:
//        mainCardLayout.first(getContentPane());
    }//GEN-LAST:event_miHideActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
     @Override
    public void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegularUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Utilities.setDefaultsForJFrame();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegularUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JMenuItem miHide;
    private javax.swing.JMenuItem miNew;
    // End of variables declaration//GEN-END:variables
    private CardLayout mainCardLayout;
    
    private void initContent() {
        mainCardLayout = (CardLayout) getContentPane().getLayout();
        JMenu menuLogOut = new JMenu("Log Out");
        jMenuBar.add(Box.createHorizontalGlue());
        jMenuBar.add(menuLogOut);

        menuLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogOutMouseClicked(evt);
            }

        });
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        //for CardLayout.show
//        mainCardLayout.addLayoutComponent(newPatientPanel, "newPatientPanel");
        
    }

    private void menuLogOutMouseClicked(MouseEvent evt) {
        this.dispose();
        LoginScreen.start();
    }

 
}
