/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Customer;
import com.foodieesoft.beans.Permissions;
import com.foodieesoft.beans.Product;
import com.foodieesoft.dao.CustomerDAO;
import com.foodieesoft.dao.PermissionsDAO;
import com.foodieesoft.dao.UserTypesDAO;
import com.foodieesoft.daoImpl.CustomerDAOImpl;
import com.foodieesoft.daoImpl.PermisionsDAOImpl;
import com.foodieesoft.daoImpl.UserTpesDAOImpl;
import com.foodieesoft.dialog.JDialogCustomer;
import com.foodieesoft.dialog.JDialogFoodCat;
import geeks.foodieesoft.util.CurrentDate;
import geeks.foodieesoft.util.InputValidation;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vksoni
 */
public class CustomerPage extends javax.swing.JFrame {

    /**
     * Creates new form UserType
     */
    CustomerDAO customerDAO;
    UserTypesDAO userTypesDAO;
    DefaultTableModel tableModelCustomer;
    public ArrayList<Customer> customers_list;
    Customer customer;
    TableRowSorter<DefaultTableModel> rowSorter = null;

    public int user_id = LoginPage.user_id;
    public int user_cat_id = LoginPage.user_cat_id;
    public String username;
    boolean goToSale = false, goToTableRes = false;

    public CustomerPage() {
        initComponents();

        customerDAO = new CustomerDAOImpl();
        userTypesDAO = new UserTpesDAOImpl();
        tableModelCustomer = (DefaultTableModel) this.jTableCustomer.getModel();
        showInTable("");
        this.jButtonRegisterForSale.setVisible(false);
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelCustomer);
        this.jTableCustomer.setRowSorter(rowSorter);

        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {

            this.jButtonSave.setEnabled(false);
            checkPermissions(user_cat_id);
        } else {
            this.jButtonSave.setEnabled(true);

        }
        this.jButtonback2D.setVisible(false);
    }

    public CustomerPage(String username) {
        super("Customers Management");

        initComponents();

        customerDAO = new CustomerDAOImpl();
        userTypesDAO = new UserTpesDAOImpl();
        tableModelCustomer = (DefaultTableModel) this.jTableCustomer.getModel();
        showInTable("");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });

        this.jButtonRegisterForSale.setVisible(false);
        this.jButtonRegisterForTable.setVisible(false);
        this.jButtonSave.setVisible(true);
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelCustomer);
        this.jTableCustomer.setRowSorter(rowSorter);
        this.jLabelProfileName.setText(username);
        System.out.println("dddd" + username);
        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {

            this.jButtonSave.setEnabled(false);
            checkPermissions(user_cat_id);
            this.jLabelProfileName.setText(username);
        } else {
            this.jButtonSave.setEnabled(true);

        }
        this.jButtonback2D.setVisible(false);
    }

    public CustomerPage(String contact, String uname) {
        super("Customers Management");

        initComponents();

        customerDAO = new CustomerDAOImpl();
        userTypesDAO = new UserTpesDAOImpl();
        tableModelCustomer = (DefaultTableModel) this.jTableCustomer.getModel();
        showInTable("");
        username = uname;
        this.jLabelProfileName.setText(username);

        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelCustomer);
        this.jTableCustomer.setRowSorter(rowSorter);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });

        JTableHeader header = this.jTableCustomer.getTableHeader();
        header.setBackground(new Color(0, 0, 51));
        header.setForeground(new Color(0, 204, 0));
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.jButtonback2D.setVisible(true);
        this.jButtonback.setVisible(false);
        goToSale = true;
        this.jLabelProfileName.setText(username);

        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {

            this.jButtonSave.setEnabled(false);
            checkPermissions(user_cat_id);
        } else {
            this.jButtonSave.setEnabled(true);
        }

    }

    CustomerPage(String contact, String uname, String tableReservation) {
        super("Customers Management");
        initComponents();
        customerDAO = new CustomerDAOImpl();
        userTypesDAO = new UserTpesDAOImpl();
        tableModelCustomer = (DefaultTableModel) this.jTableCustomer.getModel();
        showInTable("");
        this.jButtonRegisterForSale.setVisible(false);
        this.jButtonRegisterForTable.setVisible(true);
        this.jButtonSave.setVisible(false);
        username = uname;
        this.jLabelProfileName.setText(username);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });

        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelCustomer);
        this.jTableCustomer.setRowSorter(rowSorter);

        JTableHeader header = this.jTableCustomer.getTableHeader();
        header.setBackground(new Color(0, 0, 51));
        header.setForeground(new Color(0, 204, 0));
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.jButtonback2D.setVisible(true);
        this.jButtonback.setVisible(false);

        goToTableRes = true;

        if (!(userTypesDAO.getUserType(user_cat_id).equalsIgnoreCase("Admin"))) {

            this.jButtonSave.setEnabled(false);
            checkPermissions(user_cat_id);
        } else {
            this.jButtonSave.setEnabled(true);

        }

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
        jButtonSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();
        jButtonRegisterForSale = new javax.swing.JButton();
        jTextFieldCustomerSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonRegisterForTable = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonback2D = new javax.swing.JButton();
        jButtonback = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelProfileName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonCustomer = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        jTableCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Customer Name", "Contact #", "Address", "Created At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCustomer.setToolTipText("Products");
        jTableCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCustomer.setGridColor(new java.awt.Color(0, 0, 51));
        jTableCustomer.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableCustomer.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jTableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCustomer);
        if (jTableCustomer.getColumnModel().getColumnCount() > 0) {
            jTableCustomer.getColumnModel().getColumn(0).setMinWidth(100);
            jTableCustomer.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableCustomer.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableCustomer.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1220, 430));

        jButtonRegisterForSale.setBackground(new java.awt.Color(0, 19, 74));
        jButtonRegisterForSale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRegisterForSale.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegisterForSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus.png"))); // NOI18N
        jButtonRegisterForSale.setText("Add");
        jButtonRegisterForSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterForSaleActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegisterForSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        jTextFieldCustomerSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldCustomerSearch.setText("Enter text to search...");
        jTextFieldCustomerSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jTextFieldCustomerSearch.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldCustomerSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCustomerSearchMouseClicked(evt);
            }
        });
        jTextFieldCustomerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustomerSearchActionPerformed(evt);
            }
        });
        jTextFieldCustomerSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCustomerSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCustomerSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCustomerSearchKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldCustomerSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 290, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Search");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 60, -1));

        jButtonRegisterForTable.setBackground(new java.awt.Color(0, 19, 74));
        jButtonRegisterForTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRegisterForTable.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegisterForTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus.png"))); // NOI18N
        jButtonRegisterForTable.setText("Add");
        jButtonRegisterForTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterForTableActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegisterForTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 218, 40));

        jButton2.setBackground(new java.awt.Color(0, 19, 74));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/print_1.png"))); // NOI18N
        jButton2.setText("Print Records");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 256, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1240, 500));

        jButtonback2D.setBackground(new java.awt.Color(255, 255, 255));
        jButtonback2D.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonback2D.setForeground(new java.awt.Color(255, 255, 255));
        jButtonback2D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Antu_edit-undo.svg.png"))); // NOI18N
        jButtonback2D.setText("Back");
        jButtonback2D.setContentAreaFilled(false);
        jButtonback2D.setFocusPainted(false);
        jButtonback2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonback2DActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonback2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jButtonback.setBackground(new java.awt.Color(255, 255, 255));
        jButtonback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonback.setForeground(new java.awt.Color(255, 255, 255));
        jButtonback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Antu_edit-undo.svg.png"))); // NOI18N
        jButtonback.setText("Back");
        jButtonback.setContentAreaFilled(false);
        jButtonback.setFocusPainted(false);
        jButtonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbackActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, 90, -1));

        jLabelProfileName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelProfileName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProfileName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileName.setText("Username");
        getContentPane().add(jLabelProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 240, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 50, -1));

        jLabel10.setBackground(new java.awt.Color(0, 19, 74));
        jLabel10.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Customers Management");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1240, -1));

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
        getContentPane().add(jButtonCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 160, 140));

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1250, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        new JDialogCustomer(this, true, user_id, username, false, false).setVisible(true);
        showInTable("");

        {
    }//GEN-LAST:event_jButtonSaveActionPerformed
    }
    private void jTableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCustomerMouseClicked
        // TODO add your handling code here:

        int customer_id = Integer.parseInt("" + this.jTableCustomer.getValueAt(this.jTableCustomer.getSelectedRow(), 0));
        customer = customerDAO.getCustomerDetail(customer_id);
        new JDialogCustomer(this, true, user_id, customer).setVisible(true);
        showInTable("");


    }//GEN-LAST:event_jTableCustomerMouseClicked

    private void jButtonRegisterForSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterForSaleActionPerformed
        new JDialogCustomer(this, true, user_id, username, true, false).setVisible(true);
        showInTable("");

    }//GEN-LAST:event_jButtonRegisterForSaleActionPerformed

    private void jButtonback2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonback2DActionPerformed
        // TODO add your handling code here:
        new DeliveryInfoPage(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonback2DActionPerformed

    private void jButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbackActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonbackActionPerformed

    private void jTextFieldCustomerSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCustomerSearchMouseClicked
        if (this.jTextFieldCustomerSearch.getText().equalsIgnoreCase("Enter text to search...")) {
            this.jTextFieldCustomerSearch.setText("");
        }
    }//GEN-LAST:event_jTextFieldCustomerSearchMouseClicked

    private void jTextFieldCustomerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerSearchActionPerformed

    private void jTextFieldCustomerSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerSearchKeyPressed
        if (this.jTextFieldCustomerSearch.getText().equalsIgnoreCase("Enter text to search...")) {
            this.jTextFieldCustomerSearch.setText("");
        }

    }//GEN-LAST:event_jTextFieldCustomerSearchKeyPressed

    private void jTextFieldCustomerSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerSearchKeyReleased
        // TODO add your handling code here:
        String searchData = this.jTextFieldCustomerSearch.getText();
//        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));
        showInTable(searchData);
        if (this.jTableCustomer.getRowCount() == 0) {
            this.jButtonRegisterForSale.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldCustomerSearchKeyReleased

    private void jTextFieldCustomerSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerSearchKeyTyped

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        Window[] win = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButtonCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustomerMouseClicked
        // TODO add your handling code here:
        new CustomerPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCustomerMouseClicked

    private void jButtonCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCustomerActionPerformed

    private void jButtonRegisterForTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterForTableActionPerformed
        new JDialogCustomer(this, true, user_id, username, false, true).setVisible(true);
        showInTable("");    }//GEN-LAST:event_jButtonRegisterForTableActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("Foodiee Soft Customers");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            this.jTableCustomer.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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

                new CustomerPage().setVisible(true);
            }
        });
    }

    public void showInTable(String txt) {
        tableModelCustomer.setRowCount(0);

        customers_list = customerDAO.searchCustomers(txt);
        for (Customer customer : customers_list) {
            Vector V = new Vector();
            V.add(customer.getCustomer_id());
            V.add(customer.getCustomer_name());
            V.add(customer.getContact());
            V.add(customer.getAddress());
            V.add(customer.getCreated_date());
            tableModelCustomer.addRow(V);
        }
    }

    public void checkPermissions(int user_cat_id) {
        ArrayList<Permissions> permissions_name_list;
        PermissionsDAO permissionsDAO = new PermisionsDAOImpl();
        permissions_name_list = permissionsDAO.getUserPermissionName(user_cat_id);

        for (Permissions permissions : permissions_name_list) {
            if ((permissions.getPermission_name().equalsIgnoreCase("Add Customer"))) {
                this.jButtonSave.setEnabled(true);
            } else if ((permissions.getPermission_name().equalsIgnoreCase("Update Customer"))) {

            } else if ((permissions.getPermission_name().equalsIgnoreCase("Delete Customer"))) {

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCustomer;
    private javax.swing.JButton jButtonRegisterForSale;
    private javax.swing.JButton jButtonRegisterForTable;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonback;
    private javax.swing.JButton jButtonback2D;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelProfileName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCustomer;
    private javax.swing.JTextField jTextFieldCustomerSearch;
    // End of variables declaration//GEN-END:variables
}
