/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Customer;
import com.foodieesoft.beans.Discount;
import com.foodieesoft.beans.Order;
import com.foodieesoft.beans.Product;
import com.foodieesoft.beans.OrderDetail;
import com.foodieesoft.dao.CustomerDAO;
import com.foodieesoft.dao.FoodCategoryDAO;
import com.foodieesoft.dao.OrderDAO;
import com.foodieesoft.dao.OrderDetailsDAO;
import com.foodieesoft.dao.ProductDAO;
import com.foodieesoft.dao.UserDAO;
import com.foodieesoft.daoImpl.CustomerDAOImpl;
import com.foodieesoft.daoImpl.FoodCategoryDAOImpl;
import com.foodieesoft.daoImpl.OrderDAOImpl;
import com.foodieesoft.daoImpl.OrderDetailsDAOImpl;
import com.foodieesoft.daoImpl.ProductDAOImpl;
import com.foodieesoft.daoImpl.UserDAOImpl;
import com.foodieesoft.dialog.reciptDialog;
import geeks.foodieesoft.util.CurrentDate;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

/**
 *
 * @author Vksoni
 */
public class SalePage extends javax.swing.JFrame {

    /**
     * Creates new form UserType
     */
    DefaultTableModel tableModelProduct;
    DefaultTableModel tableModelProductBills;
    ArrayList<Product> product_list;
    ArrayList<Discount> discount_types_list;
    ArrayList<OrderDetail> order_detail_list;
    TableRowSorter<DefaultTableModel> rowSorter = null;
    DefaultComboBoxModel comboBoxModelDiscountType;
    public int user_id = LoginPage.user_id;
    public int user_cat_id = LoginPage.user_cat_id;
    public int total_calcu_bill = 0;
    public int grand_total = 0;
    Customer customer;
    public static int custo_id;
    Random randomNumGenerator;
    public static String uname;
    public static String order_status = "dispatched";

    public SalePage() {
        initComponents();
        tableModelProduct = (DefaultTableModel) this.jTableProduct.getModel();
        tableModelProductBills = (DefaultTableModel) this.jTableProductBills.getModel();
        comboBoxModelDiscountType = (DefaultComboBoxModel) this.jComboBoxDiscountType.getModel();
        this.jComboBoxDiscountType.setVisible(true);
        OrderDAO orderDAO = new OrderDAOImpl();
        discount_types_list = orderDAO.getDiscountTypes();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelProduct);
        this.jTableProduct.setRowSorter(rowSorter);
        this.jSpinnerQuantity.setValue(1);
        order_detail_list = new ArrayList<OrderDetail>();
        // disable before select delivery or walkin
        this.jButtonAdd.setEnabled(false);
        this.jTableProduct.setEnabled(false);
        this.jTableProductBills.setEnabled(false);
        this.jTextFieldSerachProducts.setEnabled(false);
        this.jSpinnerQuantity.setEnabled(false);
        this.jComboBoxDiscountType.setEnabled(false);
        this.jTextFieldDiscount.setEnabled(false);
        this.jButtonGenerateBill.setEnabled(false);
        showInProductTable("");
        showInDiscountComboBox();
        randomNumGenerator = new Random();

        custo_id = 1;

    }

    public SalePage(String username) {
        super("Sale Dashboard");
        initComponents();

//              
////        
        tableModelProduct = (DefaultTableModel) this.jTableProduct.getModel();
        tableModelProductBills = (DefaultTableModel) this.jTableProductBills.getModel();
        comboBoxModelDiscountType = (DefaultComboBoxModel) this.jComboBoxDiscountType.getModel();
        this.jComboBoxDiscountType.setVisible(true);
//  
        OrderDAO orderDAO = new OrderDAOImpl();
        discount_types_list = orderDAO.getDiscountTypes();

        discount_types_list = orderDAO.getDiscountTypes();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelProduct);
        this.jTableProduct.setRowSorter(rowSorter);
        uname = username;
        this.jSpinnerQuantity.setValue(1);

        this.jLabelProfileName.setText(username);
        order_detail_list = new ArrayList<OrderDetail>();
        // disable before select delivery or walkin
        this.jButtonAdd.setEnabled(false);
        this.jTableProduct.setEnabled(false);
        this.jTableProductBills.setEnabled(false);
        this.jTextFieldSerachProducts.setEnabled(false);
        this.jSpinnerQuantity.setEnabled(false);
        this.jComboBoxDiscountType.setEnabled(false);
        this.jTextFieldDiscount.setEnabled(false);
        this.jButtonGenerateBill.setEnabled(false);
        showInProductTable("");
        showInDiscountComboBox();
        randomNumGenerator = new Random();

        custo_id = 1;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                handleClosing();
            }
        });

    }

    public SalePage(int customer_id) {
        super("Sale Dashboard");
        initComponents();

        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        customer = customerDAO.getCustomerDetail(customer_id);
        tableModelProduct = (DefaultTableModel) this.jTableProduct.getModel();
        tableModelProductBills = (DefaultTableModel) this.jTableProductBills.getModel();
        comboBoxModelDiscountType = (DefaultComboBoxModel) this.jComboBoxDiscountType.getModel();
        this.jComboBoxDiscountType.setVisible(true);
        discount_types_list = orderDAO.getDiscountTypes();
        this.jSpinnerQuantity.setValue(1);

        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelProduct);
        this.jTableProduct.setRowSorter(rowSorter);

        this.jTextFieldCustomerName.setText(customer.getCustomer_name());
        this.jLabelContact.setText(customer.getContact());
        this.jLabelAddress.setText(customer.getAddress());
        order_detail_list = new ArrayList<OrderDetail>();

        showInProductTable("");
        this.jButtonAdd.setEnabled(true);
        custo_id = customer_id;
        showInDiscountComboBox();
        randomNumGenerator = new Random();

        // disable before select delivery or walkin
        this.jButtonAdd.setEnabled(true);
        this.jTableProduct.setEnabled(true);
        this.jTableProductBills.setEnabled(true);
        this.jTextFieldSerachProducts.setEnabled(true);
        this.jSpinnerQuantity.setEnabled(true);
        this.jComboBoxDiscountType.setEnabled(true);
        this.jTextFieldDiscount.setEnabled(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                handleClosing();
            }
        });

    }

    public SalePage(int customer_id, String username) {
        initComponents();

        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        customer = customerDAO.getCustomerDetail(customer_id);
        tableModelProduct = (DefaultTableModel) this.jTableProduct.getModel();
        tableModelProductBills = (DefaultTableModel) this.jTableProductBills.getModel();
        comboBoxModelDiscountType = (DefaultComboBoxModel) this.jComboBoxDiscountType.getModel();
        this.jComboBoxDiscountType.setVisible(true);
        discount_types_list = orderDAO.getDiscountTypes();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelProduct);
        this.jTableProduct.setRowSorter(rowSorter);
        this.jSpinnerQuantity.setValue(1);
        this.jTextFieldCustomerName.setText("");
        this.jTextFieldCustomerName.setText(customer.getCustomer_name());

        this.jLabelContact.setText(customer.getContact());
        this.jLabelAddress.setText(customer.getAddress());
        order_detail_list = new ArrayList<OrderDetail>();
        this.jLabelProfileName.setText(username);
        showInProductTable("");
        this.jButtonAdd.setEnabled(true);
        custo_id = customer_id;
        showInDiscountComboBox();
        randomNumGenerator = new Random();

        // disable before select delivery or walkin
        this.jButtonAdd.setEnabled(true);
        this.jTableProduct.setEnabled(true);
        this.jTableProductBills.setEnabled(true);
        this.jTextFieldSerachProducts.setEnabled(true);
        this.jSpinnerQuantity.setEnabled(true);
        this.jComboBoxDiscountType.setEnabled(true);
        this.jTextFieldDiscount.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabelUsename = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabelContact = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabelAddress = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jTextFieldDiscount = new javax.swing.JTextField();
        jSpinnerQuantity = new javax.swing.JSpinner();
        jLabelShowlBill = new javax.swing.JLabel();
        jComboBoxDiscountType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldSerachProducts = new javax.swing.JTextField();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jRadioButtonDelivery = new javax.swing.JRadioButton();
        jRadioButtonWalkin = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProductBills = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jButtonGenerateBill = new javax.swing.JButton();
        jButtonSave1 = new javax.swing.JButton();
        jCheckBoxPending = new javax.swing.JCheckBox();
        jCheckBoxDispatched = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jButtonTableReservation = new javax.swing.JButton();
        jTextFieldCustomerName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelProfileName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonOrder = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel2.setText("LOGOUT");

        jLabelUsename.setBackground(new java.awt.Color(0, 0, 51));
        jLabelUsename.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsename.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsename.setText("Username");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("CUSTOMER");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTableProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableProduct.setForeground(new java.awt.Color(0, 0, 51));
        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Id", "Food Name", "Price ", "QTY", "Food Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTableProduct.setGridColor(new java.awt.Color(0, 0, 51));
        jTableProduct.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableProduct.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduct);
        if (jTableProduct.getColumnModel().getColumnCount() > 0) {
            jTableProduct.getColumnModel().getColumn(0).setMinWidth(50);
            jTableProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableProduct.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableProduct.getColumnModel().getColumn(1).setMinWidth(200);
            jTableProduct.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableProduct.getColumnModel().getColumn(1).setMaxWidth(200);
            jTableProduct.getColumnModel().getColumn(2).setMinWidth(80);
            jTableProduct.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableProduct.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableProduct.getColumnModel().getColumn(3).setMinWidth(50);
            jTableProduct.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableProduct.getColumnModel().getColumn(3).setMaxWidth(50);
            jTableProduct.getColumnModel().getColumn(4).setMinWidth(110);
            jTableProduct.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTableProduct.getColumnModel().getColumn(4).setMaxWidth(110);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 490, 370));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("NAME:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 310, -1));

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 220, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("CONTACT#:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 100, 30));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 370, 10));

        jLabelContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 260, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("ADDRESS:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 90, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 430, -1));

        jLabelAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 340, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setText("Search:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 460, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 230, -1));

        jTextFieldDiscount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDiscount.setText("0");
        jTextFieldDiscount.setBorder(null);
        jTextFieldDiscount.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldDiscountMouseClicked(evt);
            }
        });
        jTextFieldDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiscountActionPerformed(evt);
            }
        });
        jTextFieldDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDiscountKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 180, 20));

        jSpinnerQuantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(jSpinnerQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 130, -1));

        jLabelShowlBill.setBackground(new java.awt.Color(0, 19, 74));
        jLabelShowlBill.setFont(new java.awt.Font("OCR A Std", 1, 24)); // NOI18N
        jLabelShowlBill.setForeground(new java.awt.Color(102, 255, 0));
        jLabelShowlBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelShowlBill.setText("0");
        jLabelShowlBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 19, 74), 1, true));
        jLabelShowlBill.setOpaque(true);
        jPanel1.add(jLabelShowlBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 230, 50));

        jComboBoxDiscountType.setBackground(new java.awt.Color(0, 0, 51));
        jComboBoxDiscountType.setForeground(new java.awt.Color(0, 204, 0));
        jComboBoxDiscountType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDiscountTypeItemStateChanged(evt);
            }
        });
        jComboBoxDiscountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiscountTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxDiscountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 180, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Status");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 180, -1));

        jTextFieldSerachProducts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldSerachProducts.setText("search products ....");
        jTextFieldSerachProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jTextFieldSerachProducts.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldSerachProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSerachProductsMouseClicked(evt);
            }
        });
        jTextFieldSerachProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerachProductsActionPerformed(evt);
            }
        });
        jTextFieldSerachProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSerachProductsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSerachProductsKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldSerachProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 400, 20));

        jLabelTotalBill.setBackground(new java.awt.Color(0, 19, 74));
        jLabelTotalBill.setFont(new java.awt.Font("OCR A Std", 1, 24)); // NOI18N
        jLabelTotalBill.setForeground(new java.awt.Color(102, 255, 0));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalBill.setText("0");
        jLabelTotalBill.setOpaque(true);
        jPanel1.add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 230, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setText("Amount");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 70, -1));

        jRadioButtonDelivery.setBackground(new java.awt.Color(0, 19, 74));
        buttonGroup1.add(jRadioButtonDelivery);
        jRadioButtonDelivery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonDelivery.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonDelivery.setText("DELIVERY");
        jRadioButtonDelivery.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonDeliveryItemStateChanged(evt);
            }
        });
        jRadioButtonDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonDeliveryMouseClicked(evt);
            }
        });
        jRadioButtonDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeliveryActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 130, -1));

        jRadioButtonWalkin.setBackground(new java.awt.Color(0, 19, 74));
        buttonGroup1.add(jRadioButtonWalkin);
        jRadioButtonWalkin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonWalkin.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonWalkin.setText("WALKING");
        jRadioButtonWalkin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonWalkinItemStateChanged(evt);
            }
        });
        jRadioButtonWalkin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonWalkinMouseClicked(evt);
            }
        });
        jRadioButtonWalkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWalkinActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonWalkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 140, -1));

        jTableProductBills.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableProductBills.setForeground(new java.awt.Color(0, 0, 51));
        jTableProductBills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Price ", "QTY", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductBills.setGridColor(new java.awt.Color(0, 0, 51));
        jTableProductBills.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableProductBills.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jTableProductBills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductBillsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableProductBills);
        if (jTableProductBills.getColumnModel().getColumnCount() > 0) {
            jTableProductBills.getColumnModel().getColumn(0).setMinWidth(200);
            jTableProductBills.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTableProductBills.getColumnModel().getColumn(0).setMaxWidth(200);
            jTableProductBills.getColumnModel().getColumn(1).setMinWidth(70);
            jTableProductBills.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTableProductBills.getColumnModel().getColumn(1).setMaxWidth(70);
            jTableProductBills.getColumnModel().getColumn(2).setMinWidth(50);
            jTableProductBills.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableProductBills.getColumnModel().getColumn(2).setMaxWidth(50);
            jTableProductBills.getColumnModel().getColumn(3).setMinWidth(100);
            jTableProductBills.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableProductBills.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 420, 370));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 51));
        jLabel17.setText("DISCOUNT ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 100, 20));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus-icon-0.png"))); // NOI18N
        jButtonAdd.setBorder(null);
        jButtonAdd.setBorderPainted(false);
        jButtonAdd.setContentAreaFilled(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 60, 70));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setText("QUANTITY");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 90, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -40, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 51));
        jLabel18.setText("DISCOUNT TYPE");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 140, 20));

        jButtonGenerateBill.setBackground(new java.awt.Color(0, 19, 74));
        jButtonGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGenerateBill.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGenerateBill.setText("Generate Bill");
        jButtonGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateBillActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 330, 40));

        jButtonSave1.setBackground(new java.awt.Color(0, 19, 74));
        jButtonSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSave1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave1.setText("Order Management");
        jButtonSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 200, 40));

        jCheckBoxPending.setBackground(new java.awt.Color(0, 19, 74));
        buttonGroup3.add(jCheckBoxPending);
        jCheckBoxPending.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxPending.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxPending.setText("Pending");
        jPanel1.add(jCheckBoxPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 100, -1));

        jCheckBoxDispatched.setBackground(new java.awt.Color(0, 19, 74));
        buttonGroup3.add(jCheckBoxDispatched);
        jCheckBoxDispatched.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDispatched.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxDispatched.setSelected(true);
        jCheckBoxDispatched.setText("Dispatched");
        jPanel1.add(jCheckBoxDispatched, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 51));
        jLabel12.setText("Total Bill");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, -1));

        jButtonTableReservation.setBackground(new java.awt.Color(0, 19, 74));
        jButtonTableReservation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonTableReservation.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTableReservation.setText("Reserve Table");
        jButtonTableReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTableReservationActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTableReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 200, 40));

        jTextFieldCustomerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldCustomerName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jTextFieldCustomerName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldCustomerName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCustomerNameMouseClicked(evt);
            }
        });
        jTextFieldCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustomerNameActionPerformed(evt);
            }
        });
        jTextFieldCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCustomerNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCustomerNameKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 250, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1290, 550));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel7.setBackground(new java.awt.Color(0, 19, 74));
        jLabel7.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sale Dashboard");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 90, -1, -1));

        jLabelProfileName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelProfileName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProfileName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileName.setText("Username");
        getContentPane().add(jLabelProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, -1, -1));

        jButtonOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/cart.png"))); // NOI18N
        jButtonOrder.setBorder(null);
        jButtonOrder.setContentAreaFilled(false);
        jButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 190, 140));

        jLabel6.setBackground(new java.awt.Color(0, 0, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        this.jButtonGenerateBill.setEnabled(true);

        if (this.jTableProduct.getSelectedRow() != -1 && Integer.parseInt("" + this.jSpinnerQuantity.getValue()) > 0) {
            int old_quantitiy = Integer.parseInt("" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 3));
            int selling_quantity = Integer.parseInt(this.jSpinnerQuantity.getValue() + "");
            int new_quantity = old_quantitiy - selling_quantity;
            String product_name = "" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 1);
            ProductDAO productDAO = new ProductDAOImpl();
            if (old_quantitiy > 0 && selling_quantity <= old_quantitiy) {
                int product_id = Integer.parseInt("" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 0));
                int price = Integer.parseInt("" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 2));
                int i = productDAO.mofidyProductsQuantity(new Product(product_id, 0, 0, 0, new_quantity, 0, 0, "", "", ""));
                double total_price = price * selling_quantity;
                total_calcu_bill += total_price;
                this.jLabelTotalBill.setText("" + total_calcu_bill);
                this.jLabelShowlBill.setText("" + total_calcu_bill);

                Object row[] = {product_name, price, selling_quantity, total_price};

                showInBillTable(row);
                showInProductTable("");
                try {
                    order_detail_list.add(new OrderDetail(0, 0, product_id, selling_quantity, 1, user_id, "", 0, total_price, ""));
                } catch (Exception e) {
                }
                this.jSpinnerQuantity.setValue(1);

            } else {
                JOptionPane.showMessageDialog(this, "Can't sell " + selling_quantity + " " + product_name + " because  avalible quantity is " + old_quantitiy);

            }

        } else if (this.jTableProduct.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select the product");
        } else if (Integer.parseInt("" + this.jSpinnerQuantity.getValue()) == 0) {
            JOptionPane.showMessageDialog(this, "Quantity can't be zero ");
        } else if (Integer.parseInt("" + this.jSpinnerQuantity.getValue()) <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity can't be negative");
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTableProductBillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductBillsMouseClicked
        // TODO add your handling code here:

        JPanel panel = new JPanel();
        panel.add(new JLabel("Quantity"));

        JTextField textField = new JTextField(10);
        panel.add(textField);
        JButton btnUpdate = new JButton("Update");
        panel.add(btnUpdate);

        int result = JOptionPane.showOptionDialog(null, panel, "Update quantity",
                0, 0,
                null, null, null);

    }//GEN-LAST:event_jTableProductBillsMouseClicked

    private void jRadioButtonWalkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWalkinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonWalkinActionPerformed

    private void jRadioButtonWalkinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonWalkinMouseClicked
        // TODO add your handling code here:
        if (this.jRadioButtonWalkin.isSelected()) {
            this.jButtonAdd.setEnabled(true);
            this.jTableProduct.setEnabled(true);
            this.jTableProductBills.setEnabled(true);
            this.jTextFieldSerachProducts.setEnabled(true);
            this.jSpinnerQuantity.setEnabled(true);
            this.jComboBoxDiscountType.setEnabled(true);
            this.jTextFieldDiscount.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonWalkinMouseClicked

    private void jRadioButtonWalkinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonWalkinItemStateChanged
        // TODO add your handling code here:
        this.jButtonGenerateBill.setEnabled(false);

        if (this.jRadioButtonWalkin.isSelected()) {
            this.jTextFieldCustomerName.setText("Mr Walking");

            this.jLabelAddress.setText("NA");
            this.jLabelAddress.setText("NA");
            custo_id = 1;

        }
    }//GEN-LAST:event_jRadioButtonWalkinItemStateChanged

    private void jRadioButtonDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDeliveryActionPerformed

    private void jRadioButtonDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonDeliveryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDeliveryMouseClicked

    private void jRadioButtonDeliveryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonDeliveryItemStateChanged
        // TODO add your handling code here:
        if (this.jRadioButtonDelivery.isSelected()) {
            new DeliveryInfoPage(uname).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jRadioButtonDeliveryItemStateChanged

    private void jTextFieldSerachProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsKeyReleased
        // TODO add your handling code here:

        String searchData = this.jTextFieldSerachProducts.getText();
        showInProductTable(searchData);
    }//GEN-LAST:event_jTextFieldSerachProductsKeyReleased

    private void jTextFieldSerachProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsKeyPressed
        if (this.jTextFieldSerachProducts.getText().equalsIgnoreCase("search products ....")) {
            this.jTextFieldSerachProducts.setText("");
        }
    }//GEN-LAST:event_jTextFieldSerachProductsKeyPressed

    private void jTextFieldSerachProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSerachProductsActionPerformed

    private void jTextFieldSerachProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsMouseClicked
        if (this.jTextFieldSerachProducts.getText().equalsIgnoreCase("search products ....")) {
            this.jTextFieldSerachProducts.setText("");
        }
    }//GEN-LAST:event_jTextFieldSerachProductsMouseClicked

    private void jComboBoxDiscountTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiscountTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDiscountTypeActionPerformed

    private void jComboBoxDiscountTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDiscountTypeItemStateChanged
        // TODO add your handling code here:
        int discount_id = discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_id();
        try {
            int discount = 0;
            if (!(this.jTextFieldDiscount.getText().equalsIgnoreCase("Enter Discount.."))) {
                discount = Integer.parseInt(this.jTextFieldDiscount.getText());
            }
            if (containsLetter(this.jTextFieldDiscount.getText())) {
                if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Amount")) {
                    grand_total = total_calcu_bill - discount;
                    this.jLabelTotalBill.setText("" + grand_total);
                } else if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Percentage")) {
                    int percent_money = (discount * total_calcu_bill) / 100;
                    grand_total = total_calcu_bill - percent_money;
                    this.jLabelTotalBill.setText("" + grand_total);

                }

            } else {

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBoxDiscountTypeItemStateChanged

    private void jTextFieldDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscountKeyReleased
        try {
            int discount = 0;
            if (!(this.jTextFieldDiscount.getText().equalsIgnoreCase("Enter Discount.."))) {
                discount = Integer.parseInt(this.jTextFieldDiscount.getText());
            }
            if (containsLetter(this.jTextFieldDiscount.getText())) {
                if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Amount")) {
                    grand_total = total_calcu_bill - discount;
                    this.jLabelTotalBill.setText("" + grand_total);

                } else if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Percentage")) {
                    int percent_money = (discount * total_calcu_bill) / 100;
                    grand_total = total_calcu_bill - percent_money;
                    this.jLabelTotalBill.setText(" " + grand_total);

                }

            } else {
                JOptionPane.showMessageDialog(this, "Discount should in number");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Discount should in number");
        }
    }//GEN-LAST:event_jTextFieldDiscountKeyReleased

    private void jTextFieldDiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscountKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldDiscountKeyPressed

    private void jTextFieldDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiscountActionPerformed

    private void jTextFieldDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldDiscountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiscountMouseClicked

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
        //        this.jButtonUpdate.setVisible(true);
        //        this.jButtonDelete.setVisible(true);
        //        this.jButtonSave.setVisible(false);
        //
        //        this.jTextFieldQuestion.setText(questions_list.get(this.jTableQuestions.getSelectedRow()).getQuestions());
    }//GEN-LAST:event_jTableProductMouseClicked

    private void jButtonGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateBillActionPerformed
        // TODO add your handling code here:

        int discount_id = discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_id();
        int billNum = randomNumGenerator.nextInt(10000);
        int total_qty = 0;
        int items = 0;

        if (this.jCheckBoxDispatched.isSelected()) {
            order_status = "Dispatched";
        } else {
            order_status = "Pending";
        }

        if (this.jRadioButtonWalkin.isSelected()) {
            custo_id = 1;
        }
        try {
            int discount = 0;
            if (!(this.jTextFieldDiscount.getText().equalsIgnoreCase("Enter Discount.."))) {
                discount = Integer.parseInt(this.jTextFieldDiscount.getText());
            }
            if (containsLetter(this.jTextFieldDiscount.getText())) {
                if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Amount")) {
                    grand_total = total_calcu_bill - discount;
                    this.jLabelTotalBill.setText("" + grand_total);
                    OrderDAO orderDAO = new OrderDAOImpl();

                    orderDAO.saveOrder(new Order(0, custo_id, billNum, 1, user_id, CurrentDate.getCurrentDate(), 0, "", discount_id, discount, grand_total, order_status, this.jTextFieldCustomerName.getText().toString()));
                    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();

                    for (OrderDetail detail : order_detail_list) {
                        items++;
                        total_qty += detail.getQantity();
                        orderDetailsDAO.saveOrderDetail(new OrderDetail(0, orderDAO.getLastOrderId(), detail.getProduct_id(), detail.getQantity(), 1, user_id, CurrentDate.getCurrentDate(), 0, detail.getTotal_price(), "", custo_id));
                    }
                    CustomerDAO customerDAO = new CustomerDAOImpl();
                    new reciptDialog(this, true, items, total_qty, order_detail_list, user_id, this.jTextFieldCustomerName.getText().toString(), billNum, discount_id, discount, grand_total).setVisible(true);

                    JOptionPane.showMessageDialog(this, "Your total bill is " + grand_total);
                    new SalePage().setVisible(true);
                    this.dispose();

//                    genReport(dbManager.getCustomerDetail(custo_id).getCustomer_name());
                } else if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Percentage")) {
                    int percent_money = (discount * total_calcu_bill) / 100;
                    grand_total = total_calcu_bill - percent_money;
                    this.jLabelTotalBill.setText("" + grand_total);
                    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
                    OrderDAO orderDAO = new OrderDAOImpl();

                    orderDAO.saveOrder(new Order(0, custo_id, billNum, 1, user_id, CurrentDate.getCurrentDate(), 0, "", discount_id, discount, grand_total, order_status, this.jTextFieldCustomerName.getText().toString()));
                    for (OrderDetail detail : order_detail_list) {
                        items++;

                        total_qty += detail.getQantity();
                        orderDetailsDAO.saveOrderDetail(new OrderDetail(0, orderDAO.getLastOrderId(), detail.getProduct_id(), detail.getQantity(), 1, user_id, CurrentDate.getCurrentDate(), 0, detail.getTotal_price(), "", custo_id));
                    }
                    CustomerDAO customerDAO = new CustomerDAOImpl();
                    new reciptDialog(this, true, items, total_qty, order_detail_list, user_id, this.jTextFieldCustomerName.getText().toString(), billNum, discount_id, discount, grand_total).setVisible(true);

                    JOptionPane.showMessageDialog(this, "Your total bill is  " + grand_total);

                    new SalePage().setVisible(true);
                    this.dispose();

//                    genReport(dbManager.getCustomerDetail(custo_id).getCustomer_name());
                }

            } else {
                JOptionPane.showMessageDialog(this, "Discount should in number");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Discount should in number");
        }

    }//GEN-LAST:event_jButtonGenerateBillActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        Window[] win = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }

        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderActionPerformed
    }//GEN-LAST:event_jButtonOrderActionPerformed

    private void jButtonSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave1ActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();
        new OrderManagement(userDAO.retriveUsername(user_id), "Sale Page").setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonSave1ActionPerformed

    private void jButtonTableReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTableReservationActionPerformed

        new TablesRerservationPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonTableReservationActionPerformed

    private void jTextFieldCustomerNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCustomerNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerNameMouseClicked

    private void jTextFieldCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerNameActionPerformed

    private void jTextFieldCustomerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerNameKeyPressed

    private void jTextFieldCustomerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerNameKeyReleased

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
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SalePage().setVisible(true);
            }
        });
    }

    public void showInProductTable(String txt) {
        tableModelProduct.setRowCount(0);
        ProductDAO productDAO = new ProductDAOImpl();
        product_list = productDAO.getAllProducts(txt);
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();
        for (Product product : product_list) {
            Vector V = new Vector();
            V.add(product.getProduct_id());
            V.add(product.getFood_name());
            V.add(product.getPrice());
            V.add(product.getQuantity());
            V.add(foodCategoryDAO.getFoodType(product.getFood_cat_id()));
            V.add(product.getFood_cat_id());
            tableModelProduct.addRow(V);
        }
    }

    public void showInBillTable(Object row[]) {
        tableModelProductBills.addRow(row);

    }

    public void showInDiscountComboBox() {
        for (Discount discount : discount_types_list) {

            this.jComboBoxDiscountType.addItem("" + discount.getDiscount_type());

        }
    }

    public final boolean containsLetter(String s) {
        boolean containsLetter = true;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    containsLetter = false;
                    break;
                }
            }
        }

        return containsLetter;
    }

    public void genReport(String name) {

        new Thread(new Runnable() {

            int i = 1;

            @Override
            public void run() {
                while (true) {
                    i += 10;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();

        IReportEngine engine = null;
        EngineConfig config = null;
        String report_name = "Recipt of " + name;

        File f = new File("Recipts/" + report_name + ".pdf");
        if (f.exists()) {
            f.delete();
        }
        try {

            config = new EngineConfig();
            //config.setLogConfig("c:/temp/test", Level.FINEST);
            Platform.startup(config);
            IReportEngineFactory factory = (IReportEngineFactory) Platform
                    .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);

            IReportRunnable design = null;
            //Open the report design
            String rpath = "reprotFiles/recipt.rptdesign";

            design = engine.openReportDesign(rpath);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
//           task.setParameterValue("custo_id", ""+6);
//            task.validateParameters();
//            // int order=DbManager.getMaxOrder();
            HTMLRenderOption options = new HTMLRenderOption();
            options.setOutputFileName("Recipts/" + report_name + ".pdf");
            options.setOutputFormat("pdf");

            //options.setHtmlRtLFlag(false);
            //options.setEmbeddable(false);
            //options.setImageDirectory("C:\\test\\images");
            //PDFRenderOption options = new PDFRenderOption();
            //options.setOutputFileName("c:/temp/test.pdf");
            //options.setOutputFormat("pdf");
            task.setRenderOption(options);
            task.run();
            task.close();
            engine.destroy();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Platform.shutdown();
            System.out.println("reportGenerated");
            JOptionPane.showMessageDialog(rootPane, "report scucessfully generated");

            try {

                if ((new File("Recipts\\" + report_name + ".pdf")).exists()) {

                    Process p = Runtime
                            .getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler Recipts\\" + report_name + ".pdf");
                    p.waitFor();

                } else {

                    System.out.println("File is not exists");

                }

                System.out.println("Done");

            } catch (Exception ex) {
                ex.printStackTrace();
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonGenerateBill;
    private javax.swing.JButton jButtonOrder;
    private javax.swing.JButton jButtonSave1;
    private javax.swing.JButton jButtonTableReservation;
    private javax.swing.JCheckBox jCheckBoxDispatched;
    private javax.swing.JCheckBox jCheckBoxPending;
    private javax.swing.JComboBox<String> jComboBoxDiscountType;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelContact;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelProfileName;
    private javax.swing.JLabel jLabelShowlBill;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JLabel jLabelUsename;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonDelivery;
    private javax.swing.JRadioButton jRadioButtonWalkin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinnerQuantity;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableProductBills;
    private javax.swing.JTextField jTextFieldCustomerName;
    private javax.swing.JTextField jTextFieldDiscount;
    private javax.swing.JTextField jTextFieldSerachProducts;
    // End of variables declaration//GEN-END:variables
}
