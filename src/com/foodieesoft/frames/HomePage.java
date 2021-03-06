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
import java.awt.Toolkit;
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
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public static int user_id;
    public static int user_cat_id;

    public HomePage(int user_id, int user_cat_id) {
        initComponents();
        
       
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        int xsize=(int)toolkit.getScreenSize().getWidth();
        int ysize=(int)toolkit.getScreenSize().getHeight();
        this.pack();
//        this.setSize(xsize,ysize);
        
        System.out.println("x"+xsize+" y:"+ysize);
        
        this.jPanelMenu.setSize((int)(xsize*0.9409663), (int)(ysize*0.683125));
        this.jPanelBase.setSize((int)(xsize*0.9482869692), (int)(ysize*0.7091666666));

        
//        this.jPanelMenu.setSize((int)(20), (int)(40));
//        this.jPanelBase.setSize((int)(20), (int)(40)); 
        
        UserDAO userDAO = new UserDAOImpl();
        this.jLabelUsename.setText(userDAO.retriveUsername(user_id));
        this.user_id = user_id;
        UserTypesDAO userTypesDAO = new UserTpesDAOImpl();
        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {
            this.jButtonUser.setEnabled(false);
            this.jButtonCustomer.setEnabled(false);
            this.jButtonSaleHistory.setEnabled(false);
            this.jButtonInventroyManagement.setEnabled(false);
            this.jButtonOrder.setEnabled(false);
            this.jButtonReportsManagement.setEnabled(false);
        } else {

            this.jButtonUser.setEnabled(true);
            this.jButtonCustomer.setEnabled(true);
            this.jButtonSaleHistory.setEnabled(true);
            this.jButtonInventroyManagement.setEnabled(true);
            this.jButtonOrder.setEnabled(true);
            this.jButtonReportsManagement.setEnabled(true);
        }
        checkPermissions(user_cat_id);
        
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
        

//
//        if (!(dbManager.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {
//            this.jButtonPermissions.setVisible(false);
//        }
    }

    public HomePage() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsename = new javax.swing.JLabel();
        jPanelBase = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonOrder = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonInventroyManagement = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonCustomer = new javax.swing.JButton();
        jButtonSaleHistory = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButtonUser = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButtonReportsManagement = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(0, 19, 74));
        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DASHBOARD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/psdFoodieeSoft.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 180));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, -1, -1));

        jLabelUsename.setBackground(new java.awt.Color(0, 0, 51));
        jLabelUsename.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsename.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsename.setText("Username");
        getContentPane().add(jLabelUsename, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 210, -1));

        jPanelBase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelBase.setMinimumSize(new java.awt.Dimension(750, 450));
        jPanelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 19, 74), 2, true));
        jPanelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/employee.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 150, 130));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 19, 74));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Employee Management");
        jPanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, -1, -1));

        jButtonOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/cart.png"))); // NOI18N
        jButtonOrder.setBorder(null);
        jButtonOrder.setContentAreaFilled(false);
        jButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 190, 140));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 19, 74));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sale Dashboard");
        jPanelMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jButtonInventroyManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/purchase-guy.png"))); // NOI18N
        jButtonInventroyManagement.setBorder(null);
        jButtonInventroyManagement.setContentAreaFilled(false);
        jButtonInventroyManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventroyManagementActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonInventroyManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, 140));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 19, 74));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inventory Management");
        jPanelMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jButtonCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/customer.png"))); // NOI18N
        jButtonCustomer.setBorder(null);
        jButtonCustomer.setContentAreaFilled(false);
        jButtonCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustomerMouseClicked(evt);
            }
        });
        jButtonCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustomerActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 160, 140));

        jButtonSaleHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/analytics-04.png"))); // NOI18N
        jButtonSaleHistory.setBorder(null);
        jButtonSaleHistory.setContentAreaFilled(false);
        jButtonSaleHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaleHistoryActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonSaleHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 160, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 19, 74));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sales History");
        jPanelMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, -1, -1));

        jButtonUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/users.png"))); // NOI18N
        jButtonUser.setBorder(null);
        jButtonUser.setContentAreaFilled(false);
        jButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 160, 140));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 19, 74));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("User Management");
        jPanelMenu.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jButtonReportsManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/client_report_dock_icon_by_ornorm-d5e0d34.png"))); // NOI18N
        jButtonReportsManagement.setBorder(null);
        jButtonReportsManagement.setContentAreaFilled(false);
        jButtonReportsManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportsManagementActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonReportsManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 160, 140));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 19, 74));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Reports Management");
        jPanelMenu.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 19, 74));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Order Management");
        jPanelMenu.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, -1, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/order-mgmt (1).png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setContentAreaFilled(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 150, 140));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 19, 74));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Customer Management");
        jPanelMenu.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 19, 74));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Exit");
        jPanelMenu.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 360, -1, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/reserve-tbl-icon.png"))); // NOI18N
        jButton12.setBorder(null);
        jButton12.setContentAreaFilled(false);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 150, 140));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/exit.png"))); // NOI18N
        jButton13.setBorder(null);
        jButton13.setContentAreaFilled(false);
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 220, 150, 140));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 19, 74));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Table Reservation System");
        jPanelMenu.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 180, -1, -1));

        jPanelBase.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1340, 470));

        getContentPane().add(jPanelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1360, 490));

        jLabelLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabelLogout.setText("LOGOUT");
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1170, 180));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        // TODO add your handling code here:
        Window[] win = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }

        this.dispose();
        new LoginPage().setVisible(true);

    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        new TablesRerservationPage().setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        UserDAO userDAO = new UserDAOImpl();
        new OrderManagement(userDAO.retriveUsername(user_id)).setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButtonReportsManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportsManagementActionPerformed
        // TODO add your handling code here:
        new ReportManagements(user_id).setVisible(true);
    }//GEN-LAST:event_jButtonReportsManagementActionPerformed

    private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserActionPerformed
        // TODO add your handling code here:
        new UserManagement(user_id).setVisible(true);
    }//GEN-LAST:event_jButtonUserActionPerformed

    private void jButtonSaleHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaleHistoryActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();
        new OrderDetailPage(userDAO.retriveUsername(user_id)).setVisible(true);
    }//GEN-LAST:event_jButtonSaleHistoryActionPerformed

    private void jButtonCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustomerActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();

        new CustomerPage(userDAO.retriveUsername(user_id)).setVisible(true);
    }//GEN-LAST:event_jButtonCustomerActionPerformed

    private void jButtonCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustomerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCustomerMouseClicked

    private void jButtonInventroyManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventroyManagementActionPerformed
        // TODO add your handling code here:
        new InventoryManagement(user_id).setVisible(true);
    }//GEN-LAST:event_jButtonInventroyManagementActionPerformed

    private void jButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();
        new SalePage(userDAO.retriveUsername(user_id)).setVisible(true);
    }//GEN-LAST:event_jButtonOrderActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();
        new EmployeePage(userDAO.retriveUsername(user_id)).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

                        handleClosing();

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    public void checkPermissions(int user_cat_id) {
        ArrayList<Permissions> permissions_name_list;
        PermissionsDAO permissionsDAO = new PermisionsDAOImpl();

        permissions_name_list = permissionsDAO.getUserPermissionName(user_cat_id);

        for (Permissions permissions : permissions_name_list) {
            if ((permissions.getPermission_name().equalsIgnoreCase("View Reports Management"))) {
                this.jButtonReportsManagement.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View Sale History"))) {
                this.jButtonSaleHistory.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View User Management"))) {
                this.jButtonUser.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View Inventory Management"))) {
                this.jButtonInventroyManagement.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View Sale Dashboard"))) {
                this.jButtonOrder.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("View Customer Management"))) {
                this.jButtonCustomer.setEnabled(true);
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
                    System.exit(0);
                    break;

                case JOptionPane.NO_OPTION:
                    break;

            }
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCustomer;
    private javax.swing.JButton jButtonInventroyManagement;
    private javax.swing.JButton jButtonOrder;
    private javax.swing.JButton jButtonReportsManagement;
    private javax.swing.JButton jButtonSaleHistory;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelUsename;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables
}
