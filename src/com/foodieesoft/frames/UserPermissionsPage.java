/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Permissions;
import com.foodieesoft.beans.UserPermissions;
import com.foodieesoft.beans.UserType;
import com.foodieesoft.dao.PermissionsDAO;
import com.foodieesoft.dao.UserTypesDAO;
import com.foodieesoft.daoImpl.PermisionsDAOImpl;
import com.foodieesoft.daoImpl.UserTpesDAOImpl;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vksoni
 */
public class UserPermissionsPage extends javax.swing.JFrame {

    /**
     * Creates new form UserPermisssion
     */
    DefaultComboBoxModel comboBoxModelUserType;
    public ArrayList<UserType> user_types_list;
    public ArrayList<Permissions> unassign_permission_list;
    public ArrayList<Permissions> assign_permission_list;

    public int user_id = LoginPage.user_id;
    public int user_cat_id = LoginPage.user_cat_id;

    DefaultListModel permission_unassign_list_model;
    DefaultListModel permission_assign_list_model;

    public UserPermissionsPage() {
        initComponents();

        comboBoxModelUserType = (DefaultComboBoxModel) this.jComboBoxUserType.getModel();
        this.jComboBoxUserType.setVisible(true);
        permission_assign_list_model = new DefaultListModel();
        permission_unassign_list_model = new DefaultListModel();
        this.jListAssignedPermsission.setModel(permission_assign_list_model);
        this.jListUnAssignedPermisssion.setModel(permission_unassign_list_model);
        showInUserTypesComboBox();
        showInAssginPermissionList(user_types_list.get(this.jComboBoxUserType.getSelectedIndex() + 1).getUser_cat_id());
        showInUnassginPermissionList(user_types_list.get(this.jComboBoxUserType.getSelectedIndex() + 1).getUser_cat_id());
    }

    public UserPermissionsPage(String username) {
        super("User Privileges");
        initComponents();

        comboBoxModelUserType = (DefaultComboBoxModel) this.jComboBoxUserType.getModel();
        this.jComboBoxUserType.setVisible(true);
        permission_assign_list_model = new DefaultListModel();
        permission_unassign_list_model = new DefaultListModel();
        this.jListAssignedPermsission.setModel(permission_assign_list_model);
        this.jListUnAssignedPermisssion.setModel(permission_unassign_list_model);
        this.jLabelProfileName.setText(username);
        showInUserTypesComboBox();
        showInAssginPermissionList(user_types_list.get(1).getUser_cat_id());
        showInUnassginPermissionList(user_types_list.get(1).getUser_cat_id());
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                handleClosing();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxUserType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAssignedPermsission = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListUnAssignedPermisssion = new javax.swing.JList<>();
        jButtonUpdatePermissions = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUnassign = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelProfileName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonUserPrivla = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxUserType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxUserType.setForeground(new java.awt.Color(0, 19, 74));
        jComboBoxUserType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUserTypeItemStateChanged(evt);
            }
        });
        jComboBoxUserType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxUserTypeMouseClicked(evt);
            }
        });
        jComboBoxUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 270, -1));

        jLabel5.setBackground(new java.awt.Color(0, 19, 74));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Assigned Privileges");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 370, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 270, -1));

        jListAssignedPermsission.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jListAssignedPermsission.setForeground(new java.awt.Color(51, 153, 255));
        jScrollPane1.setViewportView(jListAssignedPermsission);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 370, 380));

        jListUnAssignedPermisssion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jListUnAssignedPermisssion.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(jListUnAssignedPermisssion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 340, 380));

        jButtonUpdatePermissions.setBackground(new java.awt.Color(0, 19, 74));
        jButtonUpdatePermissions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdatePermissions.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdatePermissions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/update.png"))); // NOI18N
        jButtonUpdatePermissions.setText("Update Permission");
        jButtonUpdatePermissions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePermissionsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdatePermissions, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 200, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("USER TYPE*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 19, 74));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Unassigned Privileges");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 340, 30));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus-icon-0.png"))); // NOI18N
        jButtonAdd.setBorder(null);
        jButtonAdd.setBorderPainted(false);
        jButtonAdd.setContentAreaFilled(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 60, 70));

        jButtonUnassign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Minus_icon.png"))); // NOI18N
        jButtonUnassign.setBorder(null);
        jButtonUnassign.setBorderPainted(false);
        jButtonUnassign.setContentAreaFilled(false);
        jButtonUnassign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnassignActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUnassign, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 60, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 980, 490));

        jLabel9.setBackground(new java.awt.Color(0, 19, 74));
        jLabel9.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User Privileges ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 980, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, -1));

        jLabelProfileName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelProfileName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProfileName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileName.setText("Username");
        getContentPane().add(jLabelProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Antu_edit-undo.svg.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/house-icon.png"))); // NOI18N
        jButton2.setText("Home");
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jButtonUserPrivla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/user pro.png"))); // NOI18N
        jButtonUserPrivla.setBorder(null);
        jButtonUserPrivla.setContentAreaFilled(false);
        jButtonUserPrivla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserPrivlaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUserPrivla, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 160, 140));

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUserTypeActionPerformed

    private void jButtonUpdatePermissionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePermissionsActionPerformed
        JOptionPane.showMessageDialog(this, "Updated Permissions Succesfully");


    }//GEN-LAST:event_jButtonUpdatePermissionsActionPerformed

    private void jComboBoxUserTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBoxUserTypeMouseClicked

    private void jComboBoxUserTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeItemStateChanged
        // TODO add your handling code here:
        int user_cat_id = user_types_list.get(this.jComboBoxUserType.getSelectedIndex() + 1).getUser_cat_id();
        System.out.println(user_cat_id);
        showInAssginPermissionList(user_cat_id);
        showInUnassginPermissionList(user_cat_id);


    }//GEN-LAST:event_jComboBoxUserTypeItemStateChanged

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (!(this.jListUnAssignedPermisssion.isSelectionEmpty())) {
            int permission_id = unassign_permission_list.get(this.jListUnAssignedPermisssion.getSelectedIndex()).getPermission_id();
            int user_cat_id = user_types_list.get(this.jComboBoxUserType.getSelectedIndex() + 1).getUser_cat_id();
            PermissionsDAO permissionsDAO = new PermisionsDAOImpl();
            permissionsDAO.savePermission(new UserPermissions(user_cat_id, permission_id));
            showInAssginPermissionList(user_cat_id);
            showInUnassginPermissionList(user_cat_id);
        } else {
            JOptionPane.showMessageDialog(this, "Please select permission from Unassigned Permssion List ");
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUnassignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnassignActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (!(this.jListAssignedPermsission.isSelectionEmpty())) {
            int permission_id = assign_permission_list.get(this.jListAssignedPermsission.getSelectedIndex()).getPermission_id();
            int user_cat_id = user_types_list.get(this.jComboBoxUserType.getSelectedIndex() + 1).getUser_cat_id();
            PermissionsDAO permissionsDAO = new PermisionsDAOImpl();
            permissionsDAO.deletePermission(new UserPermissions(user_cat_id, permission_id));
            showInAssginPermissionList(user_cat_id);
            showInUnassginPermissionList(user_cat_id);
        } else {
            JOptionPane.showMessageDialog(this, "Please select permission from Assigned Permssion List ");

        }

    }//GEN-LAST:event_jButtonUnassignActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
       
        
         Window[] win=java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        new UserManagement(user_id).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonUserPrivlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserPrivlaActionPerformed
    }//GEN-LAST:event_jButtonUserPrivlaActionPerformed

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
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPermissionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPermissionsPage().setVisible(true);
            }
        });
    }

    public void showInUserTypesComboBox() {
        UserTypesDAO userTypesDAO = new UserTpesDAOImpl();
        user_types_list = userTypesDAO.getAllUserTypes();
        for (UserType userType : user_types_list) {
            if (!(userType.getUser_type().equalsIgnoreCase("admin"))) {
                this.jComboBoxUserType.addItem("" + userType.getUser_type());
            }

        }
    }

    public void showInUnassginPermissionList(int user_cat_id) {
        PermissionsDAO permissionsDAO = new PermisionsDAOImpl();

        unassign_permission_list = permissionsDAO.getUnassignedPermissions(user_cat_id);
        this.permission_unassign_list_model.clear();
        for (Permissions permission : unassign_permission_list) {
            this.permission_unassign_list_model.addElement("" + permission.getPermission_name());
        }
    }

    public void showInAssginPermissionList(int user_cat_id) {
        PermissionsDAO permissionsDAO = new PermisionsDAOImpl();

        assign_permission_list = permissionsDAO.getAssignedPermissions(user_cat_id);
        this.permission_assign_list_model.clear();
        for (Permissions permission : assign_permission_list) {
            this.permission_assign_list_model.addElement("" + permission.getPermission_name());
        }
    }
private int showWarningMessage() {
        String[] buttonLabels = new String[] {"Yes", "No"};
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonUnassign;
    private javax.swing.JButton jButtonUpdatePermissions;
    private javax.swing.JButton jButtonUserPrivla;
    private javax.swing.JComboBox<String> jComboBoxUserType;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelProfileName;
    private javax.swing.JList<String> jListAssignedPermsission;
    private javax.swing.JList<String> jListUnAssignedPermisssion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
