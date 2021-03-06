/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.FoodCategory;
import com.foodieesoft.beans.Permissions;
import com.foodieesoft.beans.UserType;

import com.foodieesoft.dao.FoodCategoryDAO;
import com.foodieesoft.dao.PermissionsDAO;
import com.foodieesoft.dao.UserTypesDAO;
import com.foodieesoft.daoImpl.FoodCategoryDAOImpl;
import com.foodieesoft.daoImpl.PermisionsDAOImpl;
import com.foodieesoft.daoImpl.UserTpesDAOImpl;
import com.foodieesoft.dialog.JDialogEmployee;
import com.foodieesoft.dialog.JDialogFoodCat;
import geeks.foodieesoft.util.CurrentDate;
import geeks.foodieesoft.util.InputValidation;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Vksoni
 */
public class FoodCategoryPage extends javax.swing.JFrame {

    /**
     * Creates new form UserType
     */
    DefaultTableModel tableModelUserType;
    ArrayList<FoodCategory> food_category_list;
    public int user_id = LoginPage.user_id;
    public int user_cat_id = LoginPage.user_cat_id;

    public FoodCategoryPage() {
        initComponents();
        tableModelUserType = (DefaultTableModel) this.jTableFoodCategory.getModel();
        showInTable();
        UserTypesDAO userTypesDAO = new UserTpesDAOImpl();

        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {

            this.jButtonSave.setEnabled(false);
            checkPermissions(user_cat_id);
        } else {
            this.jButtonSave.setEnabled(true);

        }

    }

    public FoodCategoryPage(String username) {
        super("Food Category");
        initComponents();

        tableModelUserType = (DefaultTableModel) this.jTableFoodCategory.getModel();
        showInTable();
        UserTypesDAO userTypesDAO = new UserTpesDAOImpl();

        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {

            this.jButtonSave.setEnabled(false);
            checkPermissions(user_cat_id);
        } else {
            this.jButtonSave.setEnabled(true);

        }
        this.jLabelProfileName.setText(username);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFoodCategory = new javax.swing.JTable();
        jButtonSave = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelProfileName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonProductCat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableFoodCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableFoodCategory.setForeground(new java.awt.Color(0, 0, 51));
        jTableFoodCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Category", "Created At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFoodCategory.setGridColor(new java.awt.Color(0, 0, 51));
        jTableFoodCategory.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableFoodCategory.setSelectionForeground(new java.awt.Color(0, 240, 0));
        jTableFoodCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFoodCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFoodCategory);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 930, 330));

        jButtonSave.setBackground(new java.awt.Color(0, 19, 74));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus.png"))); // NOI18N
        jButtonSave.setText("Add");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 40));

        jButton3.setBackground(new java.awt.Color(0, 19, 74));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/print_1.png"))); // NOI18N
        jButton3.setText("Print Records");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 950, 400));

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

        jLabel10.setBackground(new java.awt.Color(0, 19, 74));
        jLabel10.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Food Categories");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 950, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        jLabelProfileName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelProfileName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProfileName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileName.setText("Username");
        getContentPane().add(jLabelProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        jButtonProductCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/img_263507.png"))); // NOI18N
        jButtonProductCat.setBorder(null);
        jButtonProductCat.setContentAreaFilled(false);
        jButtonProductCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductCatActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProductCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 160, 140));

        jLabel6.setBackground(new java.awt.Color(0, 0, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        new JDialogFoodCat(this, true, user_id).setVisible(true);
        showInTable();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTableFoodCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFoodCategoryMouseClicked
        // TO

        FoodCategory foodCategory = new FoodCategory();
        foodCategory = food_category_list.get(this.jTableFoodCategory.getSelectedRow());
        new JDialogFoodCat(this, true, user_id, foodCategory).setVisible(true);
        showInTable();
    }//GEN-LAST:event_jTableFoodCategoryMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        new InventoryManagement(user_id).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        Window[] win = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }

        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButtonProductCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductCatActionPerformed
    }//GEN-LAST:event_jButtonProductCatActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("Foodiee Soft Food Category");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            this.jTableFoodCategory.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(FoodCategoryPage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FoodCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodCategoryPage().setVisible(true);
            }
        });
    }

    public void showInTable() {
        tableModelUserType.setRowCount(0);
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();

        food_category_list = foodCategoryDAO.getAllFoodTypes();
        for (FoodCategory foodCategory : food_category_list) {
            Vector V = new Vector();
            V.add(foodCategory.getFood_type());
            V.add(foodCategory.getCreated_date());
            tableModelUserType.addRow(V);

        }
    }

    public void checkPermissions(int user_cat_id) {
        ArrayList<Permissions> permissions_name_list;
        PermissionsDAO permissionsDAO = new PermisionsDAOImpl();

        permissions_name_list = permissionsDAO.getUserPermissionName(user_cat_id);

        for (Permissions permissions : permissions_name_list) {
            if ((permissions.getPermission_name().equalsIgnoreCase("Add Product Categories"))) {
                this.jButtonSave.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("Update Product Categories"))) {

            } else if ((permissions.getPermission_name().equalsIgnoreCase("Delete Product Categories"))) {

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonProductCat;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelProfileName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFoodCategory;
    // End of variables declaration//GEN-END:variables
}
