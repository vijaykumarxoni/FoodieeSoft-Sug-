/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Permissions;

import com.foodieesoft.dao.PermissionsDAO;
import com.foodieesoft.dao.UserDAO;
import com.foodieesoft.dao.UserTypesDAO;
import com.foodieesoft.daoImpl.PermisionsDAOImpl;
import com.foodieesoft.daoImpl.UserDAOImpl;
import com.foodieesoft.daoImpl.UserTpesDAOImpl;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vksoni
 */
public class UserManagement extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public static int user_id;
    public static int user_cat_id = LoginPage.user_cat_id;

    public UserManagement(int user_id) {
        super("User Management");
        initComponents();
        UserDAO userDAO = new UserDAOImpl();

        this.jLabelUsename.setText(userDAO.retriveUsername(user_id));
        this.user_id = user_id;

        UserTypesDAO userTypesDAO = new UserTpesDAOImpl();
        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {
            this.jButtonUserAccounts.setEnabled(false);
            this.jButtonUserPrivla.setEnabled(false);
            this.jButtonQuestions.setEnabled(false);
            this.jButtonuserTypes.setEnabled(false);

        } else {

            this.jButtonUserAccounts.setEnabled(true);
            this.jButtonUserPrivla.setEnabled(true);
            this.jButtonQuestions.setEnabled(true);
            this.jButtonuserTypes.setEnabled(true);

        }
        checkPermissions(user_cat_id);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                handleClosing();
            }
        });
    }

    public UserManagement() {
        initComponents();
//        checkPermissions(user_cat_id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsename = new javax.swing.JLabel();
        jPanelHomePage = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonUserAccounts = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonuserTypes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonQuestions = new javax.swing.JButton();
        jButtonUserPrivla = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonUser1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(0, 19, 74));
        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("USER MANAGEMENT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        jLabelUsename.setBackground(new java.awt.Color(0, 0, 51));
        jLabelUsename.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsename.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsename.setText("Username");
        getContentPane().add(jLabelUsename, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 170, -1));

        jPanelHomePage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelHomePage.setMinimumSize(new java.awt.Dimension(750, 450));
        jPanelHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 19, 74), 2, true));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonUserAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/acount.png"))); // NOI18N
        jButtonUserAccounts.setBorder(null);
        jButtonUserAccounts.setContentAreaFilled(false);
        jButtonUserAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserAccountsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUserAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 140));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 19, 74));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("User Accounts");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jButtonuserTypes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Multiple-login.png"))); // NOI18N
        jButtonuserTypes.setBorder(null);
        jButtonuserTypes.setContentAreaFilled(false);
        jButtonuserTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonuserTypesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonuserTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 160, 140));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 19, 74));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("User Types");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        jButtonQuestions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Artboard_15-512.png"))); // NOI18N
        jButtonQuestions.setBorder(null);
        jButtonQuestions.setContentAreaFilled(false);
        jButtonQuestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuestionsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 160, 140));

        jButtonUserPrivla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/user pro.png"))); // NOI18N
        jButtonUserPrivla.setBorder(null);
        jButtonUserPrivla.setContentAreaFilled(false);
        jButtonUserPrivla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserPrivlaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUserPrivla, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 160, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 19, 74));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("User Privileges ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 19, 74));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Security Questions");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        jPanelHomePage.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 280));

        getContentPane().add(jPanelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 920, 320));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel2.setText("LOGOUT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Antu_edit-undo.svg.png"))); // NOI18N
        jButton1.setText("BACK");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jButtonUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/users.png"))); // NOI18N
        jButtonUser.setBorder(null);
        jButtonUser.setContentAreaFilled(false);
        jButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 160, 140));

        jButtonUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/users.png"))); // NOI18N
        jButtonUser1.setBorder(null);
        jButtonUser1.setContentAreaFilled(false);
        jButtonUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 140));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 180));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUserPrivlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserPrivlaActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();

        new UserPermissionsPage(userDAO.retriveUsername(user_id)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonUserPrivlaActionPerformed

    private void jButtonQuestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionsActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();

        new QuestionsPage(userDAO.retriveUsername(user_id)).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonQuestionsActionPerformed

    private void jButtonuserTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonuserTypesActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();

        new UserTypePage(userDAO.retriveUsername(user_id)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonuserTypesActionPerformed

    private void jButtonUserAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserAccountsActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();

        new UserPage(userDAO.retriveUsername(user_id)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonUserAccountsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Window[] win = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }

        this.dispose();
        new LoginPage().setVisible(true);

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new UserManagement(user_id).setVisible(true);
    }//GEN-LAST:event_jButtonUserActionPerformed

    private void jButtonUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUser1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagement().setVisible(true);
            }
        });
    }

    public void checkPermissions(int user_cat_id) {
        ArrayList<Permissions> permissions_name_list;

        PermissionsDAO permissionsDAO = new PermisionsDAOImpl();
        permissions_name_list = permissionsDAO.getUserPermissionName(user_cat_id);

        for (Permissions permissions : permissions_name_list) {
            if ((permissions.getPermission_name().equalsIgnoreCase("View Security Question"))) {
                this.jButtonQuestions.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View User Privileges"))) {
                this.jButtonUserPrivla.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View User Type"))) {
                this.jButtonuserTypes.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View User Accounts"))) {
                this.jButtonUserAccounts.setEnabled(true);
            }
        }

    }

    private int showWarningMessage() {
        String[] buttonLabels = new String[]{"Yes", "No"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;

        return JOptionPane.showOptionDialog(this,
                "Are you sure you wanna close it!",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);
    }

    private void handleClosing() {
        {
            int answer = showWarningMessage();

            switch (answer) {
                case JOptionPane.YES_OPTION:
                    dispose();
                    break;

                case JOptionPane.NO_OPTION:
                    break;

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonQuestions;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JButton jButtonUser1;
    private javax.swing.JButton jButtonUserAccounts;
    private javax.swing.JButton jButtonUserPrivla;
    private javax.swing.JButton jButtonuserTypes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelUsename;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHomePage;
    // End of variables declaration//GEN-END:variables
}