/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client;

import com.kvlahov.controller.UserController;
import com.kvlahov.dal.repository.IRepository;
import com.kvlahov.dal.repository.RepositoryFactory;
import com.kvlahov.model.User;
import com.kvlahov.model.enums.UserRole;
import com.kvlahov.utils.Utilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author lordo
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
        initContent();
        initViewsMap();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OMStudio");
        setBackground(new java.awt.Color(17, 72, 112));
        setForeground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.BorderLayout());

        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.setMinimumSize(new java.awt.Dimension(300, 420));
        mainPanel.setPreferredSize(new java.awt.Dimension(300, 420));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        mainPanel.add(jPanel1);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new Color(0,0,0,0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setBackground(new Color(0,0,0,0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        jButton1.setBackground(new Color(0,0,0,0));
        jButton1.setText("   ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_START);

        jButton2.setBackground(new Color(0,0,0,0));
        jButton2.setText("  ");
        getContentPane().add(jButton2, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void start() {
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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Utilities.setDefaultsForJFrame();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
    private JTextField tfUsername;
    private JTextField tfPassword;
    JLabel errorMsg;

    private void initContent() {
        Container contentPane = getContentPane();
        /*
         whiteish: EEEBE8 - text on blueish/bg
         orangeish: DF985B - accent
         bluegrayish: 8C97BB 
         purpleish: 795CC1 - whatever
         blueish: 276DA2 - sidemenu
        
         */
        Color bgColor = getColorFromHex("276DA2");
        contentPane.setBackground(bgColor);

        mainPanel.setBackground(bgColor);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        Font textFont = new Font("Segoe UI Light", Font.PLAIN, 16);
        Font titleFont = new Font("Segoe UI Light", Font.BOLD, 40);
        Font subtitleFont = new Font("Segoe UI Black", Font.BOLD, 12);

        Color textColor = getColorFromHex("EEEBE8");

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 35, 0);
        c.gridwidth = 2;

        final String title = "OMStudio";

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(titleFont);

        mainPanel.add(lblTitle, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.LINE_END;

        JLabel lblUser = new JLabel("Username");
        lblUser.setForeground(textColor);

        mainPanel.add(lblUser, c);

        c.gridx = 0;
        c.gridy = 2;

        JLabel lblPass = new JLabel("Password");
        lblPass.setForeground(textColor);

        mainPanel.add(lblPass, c);

        c.gridx = 1;
        c.gridy = 1;
//        c.gridwidth = 3;
        c.ipadx = 20;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 15, 0, 0);
        c.anchor = GridBagConstraints.PAGE_START;

        tfUsername = new JTextField();
        tfUsername.setMinimumSize(new Dimension(250, 30));
        mainPanel.add(tfUsername, c);

        c.gridx = 1;
        c.gridy = 2;

        tfPassword = new JPasswordField();
        mainPanel.add(tfPassword, c);

        Color accentColor = getColorFromHex("DF985B");

        tfUsername.addFocusListener(new FocusAdapter() {
               @Override
               public void focusGained(FocusEvent e) {
                   tfUsername.selectAll();
            }
        });
        
        tfPassword.addFocusListener(new FocusAdapter() {
               @Override
               public void focusGained(FocusEvent e) {
                   tfPassword.selectAll();
            }
        });
        
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 0, -10, 0);

        errorMsg = new JLabel("Incorrect username or password");
        hideErrorMsg();

        mainPanel.add(errorMsg, c);

        c.gridx = 0;
        c.gridy++;
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 3;
        c.ipadx = 10;
        c.ipady = 10;
        c.insets = new Insets(20, 0, 0, 0);

        JButton btnLogin = new JButton("Login");
        getRootPane().setDefaultButton(btnLogin);

        btnLogin.setBackground(accentColor);
        

        btnLogin.addActionListener(e -> {
            btnLoginActionPerformed(e);
        });

        getRootPane().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();
                }
            }
        });

        mainPanel.add(btnLogin, c);

        for (Component component : mainPanel.getComponents()) {
            component.setFont(textFont);
        }

        lblTitle.setFont(titleFont);
        errorMsg.setFont(subtitleFont);

    }

    private static Color getColorFromHex(String hex) {
        Color color;
        try {
            color = new Color(Integer.parseInt(hex, 16));
        } catch (Exception e) {
            color = new Color(0, 0, 0);
        }
        return color;
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        showErrorMsg();
    }

    private void showErrorMsg() {
        String username = tfUsername.getText().trim();
        String pass = tfPassword.getText().trim();

        if (!username.isEmpty() && !pass.isEmpty()) {
            User user = new User(username, pass);
            boolean isValid = UserController.isUserValid(user);
            if (isValid) {
                UserController.setUserRole(user);
                getViewForUser(user);
                dispose();
            }
        }
        errorMsg.setForeground(getColorFromHex("d3b69e"));
    }

    private void hideErrorMsg() {
        errorMsg.setForeground(new Color(0, 0, 0, 0));
    }
    
    Map<UserRole, Class> viewsMap = new HashMap<>();

    private void getViewForUser(User user) {
        UserRole role = user.getRole();
//        JFrame view;
        
        Class clazz = viewsMap.get(role);
        
        try {
            Object o = clazz.newInstance();
            ((Gui)o).start();
            
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//    if (role == UserRole.REGULAR) {
////            view = new RegularUI();
//            RegularUI.start();
//        } else if (role == UserRole.DOCTOR) {
////            view = new DoctorUI();
//            DoctorUI.main(null);
//        } else {
////            view = new SomethingWrongUI();
//            SomethingWrongUI.main(null);
//        }
////        view.setVisible(true);
    }

    private void initViewsMap() {
//        viewsMap.put(UserRole.REGULAR, RegularUI.class);
//        viewsMap.put(UserRole.DOCTOR, DoctorUI.class);
        String path  = ".\\src\\com\\kvlahov\\properties\\props.txt";
        
        Properties prop = Utilities.readProperties(path);
        for (Object key : prop.keySet()) {
            String keyString = key.toString();
            try {
                viewsMap.put(UserRole.valueOf(keyString), Class.forName(prop.getProperty(keyString)));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (UserRole userRole : viewsMap.keySet()) {
            System.out.println(userRole);
            System.out.println(viewsMap.get(userRole));
        }
    }
}
