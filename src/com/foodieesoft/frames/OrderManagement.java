/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Order;
import com.foodieesoft.beans.OrderDetail;
import com.foodieesoft.dao.CustomerDAO;
import com.foodieesoft.dao.OrderDAO;
import com.foodieesoft.dao.UserDAO;
import com.foodieesoft.daoImpl.CustomerDAOImpl;
import com.foodieesoft.daoImpl.OrderDAOImpl;
import com.foodieesoft.daoImpl.UserDAOImpl;
import static com.foodieesoft.frames.HomePage.user_id;
import geeks.foodieesoft.util.CurrentDate;
import java.awt.Window;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vksoni
 */
public class OrderManagement extends javax.swing.JFrame {

    DefaultTableModel tableModelOrder;
    DefaultTableModel tableModelOrderDetail;
    TableRowSorter<DefaultTableModel> rowSorter = null;
    public static double total_sale;
    String comingFromPage = "";

    ArrayList<Order> order_list;
    ArrayList<Order> order_list_between_dates;

    ArrayList<OrderDetail> order_detail_list;

    public static int user_id = LoginPage.user_id;
    public static int user_cat_id = LoginPage.user_cat_id;

    public OrderManagement() {
        initComponents();
        tableModelOrder = (DefaultTableModel) this.jTableOrder.getModel();

        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelOrder);
        this.jTableOrder.setRowSorter(rowSorter);

        showInTable();
        this.jLabelTotalSale.setText("" + total_sale);

    }

    public OrderManagement(String username) {
        super("Order Management");
        initComponents();
        tableModelOrder = (DefaultTableModel) this.jTableOrder.getModel();

        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelOrder);
        this.jTableOrder.setRowSorter(rowSorter);
        this.jLabelProfileName.setText(username);
        showInTable();
        this.jLabelTotalSale.setText("" + total_sale);
        this.jLabelOrderNum.setVisible(false);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
    }

    public OrderManagement(String username, String comingFrom) {
        super("Order Management");
        initComponents();
        tableModelOrder = (DefaultTableModel) this.jTableOrder.getModel();
        comingFromPage = comingFrom;
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelOrder);
        this.jTableOrder.setRowSorter(rowSorter);
        this.jLabelProfileName.setText(username);
        showInTable();
        this.jLabelTotalSale.setText("" + total_sale);
        this.jLabelOrderNum.setVisible(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jLabelTotalSale = new javax.swing.JLabel();
        jTextFieldSerachProducts = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCheckBoxAllOrders = new javax.swing.JCheckBox();
        jCheckBoxDispatched = new javax.swing.JCheckBox();
        jCheckBoxWalkin = new javax.swing.JCheckBox();
        jCheckBoxPending = new javax.swing.JCheckBox();
        jCheckBoxDelivey = new javax.swing.JCheckBox();
        jButtonDelOrder = new javax.swing.JButton();
        jButtonUpdateorderStatus = new javax.swing.JButton();
        jCheckBoxupdatedis = new javax.swing.JCheckBox();
        jCheckBoxupdatepending = new javax.swing.JCheckBox();
        jLabelOrderNum = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButtonNewOrder = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelProfileName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableOrder.setForeground(new java.awt.Color(0, 0, 51));
        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill Number", "Purchase Date", "Order ", "Order Status", "Customer name", "Discount", "Total Bill (Rs)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrder.setToolTipText("Products");
        jTableOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableOrder.setGridColor(new java.awt.Color(0, 0, 51));
        jTableOrder.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableOrder.setSelectionForeground(new java.awt.Color(0, 240, 0));
        jTableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableOrder);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 970, 380));

        jLabelTotalSale.setBackground(new java.awt.Color(0, 19, 74));
        jLabelTotalSale.setFont(new java.awt.Font("OCR A Std", 1, 24)); // NOI18N
        jLabelTotalSale.setForeground(new java.awt.Color(102, 255, 0));
        jLabelTotalSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalSale.setText("0");
        jLabelTotalSale.setOpaque(true);
        jPanel1.add(jLabelTotalSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 230, 40));

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
        jPanel1.add(jTextFieldSerachProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 270, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("SEARCH");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setText("Update Order Status");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setText("Total Sale:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 100, -1));

        jCheckBoxAllOrders.setBackground(new java.awt.Color(0, 0, 51));
        buttonGroup1.add(jCheckBoxAllOrders);
        jCheckBoxAllOrders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxAllOrders.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxAllOrders.setText("Today's All Orders");
        jCheckBoxAllOrders.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBoxAllOrders.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxAllOrdersItemStateChanged(evt);
            }
        });
        jCheckBoxAllOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAllOrdersActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxAllOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 200, 30));

        jCheckBoxDispatched.setBackground(new java.awt.Color(0, 0, 51));
        buttonGroup1.add(jCheckBoxDispatched);
        jCheckBoxDispatched.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDispatched.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxDispatched.setText("Dispatched  Orders");
        jCheckBoxDispatched.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBoxDispatched.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxDispatchedItemStateChanged(evt);
            }
        });
        jPanel1.add(jCheckBoxDispatched, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 200, 30));

        jCheckBoxWalkin.setBackground(new java.awt.Color(0, 0, 51));
        buttonGroup1.add(jCheckBoxWalkin);
        jCheckBoxWalkin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxWalkin.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxWalkin.setText("Walkin  Orders");
        jCheckBoxWalkin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBoxWalkin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxWalkinItemStateChanged(evt);
            }
        });
        jPanel1.add(jCheckBoxWalkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 200, 30));

        jCheckBoxPending.setBackground(new java.awt.Color(0, 0, 51));
        buttonGroup1.add(jCheckBoxPending);
        jCheckBoxPending.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxPending.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxPending.setText("Pending  Orders");
        jCheckBoxPending.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBoxPending.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxPendingItemStateChanged(evt);
            }
        });
        jCheckBoxPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPendingActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 200, 30));

        jCheckBoxDelivey.setBackground(new java.awt.Color(0, 0, 51));
        buttonGroup1.add(jCheckBoxDelivey);
        jCheckBoxDelivey.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDelivey.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxDelivey.setText("Delivery Orders");
        jCheckBoxDelivey.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBoxDelivey.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxDeliveyItemStateChanged(evt);
            }
        });
        jCheckBoxDelivey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDeliveyActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxDelivey, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 30));

        jButtonDelOrder.setBackground(new java.awt.Color(0, 19, 74));
        jButtonDelOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDelOrder.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelOrder.setText("Delete order");
        jButtonDelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelOrderActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 210, 30));

        jButtonUpdateorderStatus.setBackground(new java.awt.Color(0, 19, 74));
        jButtonUpdateorderStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdateorderStatus.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdateorderStatus.setText("Update Order status");
        jButtonUpdateorderStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateorderStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdateorderStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, 30));

        jCheckBoxupdatedis.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBoxupdatedis);
        jCheckBoxupdatedis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxupdatedis.setText("Dispatched");
        jPanel1.add(jCheckBoxupdatedis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

        jCheckBoxupdatepending.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBoxupdatepending);
        jCheckBoxupdatepending.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxupdatepending.setText("Pending");
        jCheckBoxupdatepending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxupdatependingActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxupdatepending, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 80, -1));

        jLabelOrderNum.setBackground(new java.awt.Color(0, 0, 51));
        jLabelOrderNum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOrderNum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOrderNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOrderNum.setText("Bill #:");
        jLabelOrderNum.setOpaque(true);
        jPanel1.add(jLabelOrderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 51));
        jLabel18.setText("Filters");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 250, 40));

        jButtonNewOrder.setBackground(new java.awt.Color(0, 19, 74));
        jButtonNewOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonNewOrder.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNewOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus.png"))); // NOI18N
        jButtonNewOrder.setText("Place new Order");
        jButtonNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewOrderActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNewOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1220, 500));

        jLabel10.setBackground(new java.awt.Color(0, 19, 74));
        jLabel10.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Order Details");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 1220, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 90, -1, -1));

        jLabelProfileName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelProfileName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProfileName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileName.setText("Username");
        getContentPane().add(jLabelProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, -1, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 120, 40));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/house-icon.png"))); // NOI18N
        jButton5.setText("Home");
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderMouseClicked
        // TODO add your handling code here:

        int order_id = (int) this.jTableOrder.getValueAt(this.jTableOrder.getSelectedRow(), 0);
//        new SaleDetailsDialog(this, true ,""+this.jTableOrder.getValueAt(this.jTableOrder.getSelectedRow(), 1), order_id,""+this.jTableOrder.getValueAt(this.jTableOrder.getSelectedRow(), 2)).setVisible(true);
//
        OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.getorderById(order_id);
        this.jLabelOrderNum.setVisible(true);

        this.jLabelOrderNum.setText("Bill #:" + order_id);
        String order_status = (String) this.jTableOrder.getValueAt(this.jTableOrder.getSelectedRow(), 3);
        if (order_status.equalsIgnoreCase("Dispatched")) {
            this.jCheckBoxupdatedis.setSelected(true);
        } else {
            this.jCheckBoxupdatepending.setSelected(true);

        }

    }//GEN-LAST:event_jTableOrderMouseClicked

    private void jTextFieldSerachProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsMouseClicked
        if (this.jTextFieldSerachProducts.getText().equalsIgnoreCase("search products ....")) {
            this.jTextFieldSerachProducts.setText("");
        }
    }//GEN-LAST:event_jTextFieldSerachProductsMouseClicked

    private void jTextFieldSerachProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSerachProductsActionPerformed

    private void jTextFieldSerachProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsKeyPressed
        if (this.jTextFieldSerachProducts.getText().equalsIgnoreCase("search products ....")) {
            this.jTextFieldSerachProducts.setText("");
        }
    }//GEN-LAST:event_jTextFieldSerachProductsKeyPressed

    private void jTextFieldSerachProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsKeyReleased
        // TODO add your handling code here:

        String searchData = this.jTextFieldSerachProducts.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));
    }//GEN-LAST:event_jTextFieldSerachProductsKeyReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        Window[] win = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (comingFromPage.equals("Sale Page")) {
            UserDAO userDAO = new UserDAOImpl();
            new SalePage(userDAO.retriveUsername(user_id)).setVisible(true);

        } else {
            new HomePage(user_id, user_cat_id).setVisible(true);

        }
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBoxAllOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAllOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAllOrdersActionPerformed

    private void jCheckBoxPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxPendingActionPerformed

    private void jCheckBoxDeliveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDeliveyActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBoxDeliveyActionPerformed

    private void jCheckBoxWalkinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxWalkinItemStateChanged

        if (this.jCheckBoxWalkin.isSelected()) {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Walkin"));
            System.out.println(CurrentDate.getCurrentDate());
        } else {

            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + ""));

        }
    }//GEN-LAST:event_jCheckBoxWalkinItemStateChanged

    private void jCheckBoxDeliveyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxDeliveyItemStateChanged
        // TODO add your handling code here:

        if (this.jCheckBoxDelivey.isSelected()) {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Delivery"));
            System.out.println(CurrentDate.getCurrentDate());
        } else {

            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + ""));

        }


    }//GEN-LAST:event_jCheckBoxDeliveyItemStateChanged

    private void jCheckBoxPendingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxPendingItemStateChanged
        if (this.jCheckBoxPending.isSelected()) {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Pending"));
            System.out.println(CurrentDate.getCurrentDate());
        } else {

            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + ""));

        }    }//GEN-LAST:event_jCheckBoxPendingItemStateChanged

    private void jCheckBoxDispatchedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxDispatchedItemStateChanged
        // TODO add your handling code here:
        if (this.jCheckBoxDispatched.isSelected()) {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Dispatched"));
            System.out.println(CurrentDate.getCurrentDate());
        } else {

            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + ""));

        }
    }//GEN-LAST:event_jCheckBoxDispatchedItemStateChanged

    private void jCheckBoxAllOrdersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxAllOrdersItemStateChanged

        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + CurrentDate.getCurrentDate()));

    }//GEN-LAST:event_jCheckBoxAllOrdersItemStateChanged

    private void jButtonDelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelOrderActionPerformed

        try {
            int order_id = (int) this.jTableOrder.getValueAt(this.jTableOrder.getSelectedRow(), 0);
            OrderDAO orderDAO = new OrderDAOImpl();

            orderDAO.removeOrder(order_id);

            JOptionPane.showMessageDialog(null, "Sucessfully deleted", "Delete Order details.", JOptionPane.INFORMATION_MESSAGE);

            showInTable();
            this.jLabelOrderNum.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select the row", "FoodieeSoft", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jButtonDelOrderActionPerformed

    private void jButtonUpdateorderStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateorderStatusActionPerformed
        // TODO add your handling code here:
        String order_stat = "";
        if (this.jCheckBoxupdatedis.isSelected()) {
            order_stat = "Dispatched";
        } else {
            order_stat = "Pending";
        }
        try {
            int order_id = (int) this.jTableOrder.getValueAt(this.jTableOrder.getSelectedRow(), 0);
            OrderDAO orderDAO = new OrderDAOImpl();

            orderDAO.modifyOrderStatus(new Order(order_id, 0, 0, 0, 0, "", 0, "", 0, 0, 0, order_stat));
            JOptionPane.showMessageDialog(null, "Sucessfully Updated", "Order Infomation", JOptionPane.INFORMATION_MESSAGE);
            this.jLabelOrderNum.setVisible(false);

            showInTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Select the Order row ", "FoodieeSoft", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButtonUpdateorderStatusActionPerformed

    private void jCheckBoxupdatependingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxupdatependingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxupdatependingActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("Foodiee Soft Order Management");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            this.jTableOrder.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewOrderActionPerformed
        UserDAO userDAO = new UserDAOImpl();
        new SalePage(userDAO.retriveUsername(user_id)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonNewOrderActionPerformed

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
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderManagement().setVisible(true);
            }
        });
    }

    public void showInTable() {
        tableModelOrder.setRowCount(0);
        OrderDAO orderDAO = new OrderDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();

        order_list = orderDAO.getAllOrder();
        try {
            for (Order order : order_list) {
                Vector V = new Vector();
                V.add(order.getOrder_id());
                V.add(order.getCreated_date());
                if (order.getCustomer_id() == 1) {
                    V.add("Walk in order");

                } else {
                    V.add("Delivery order");

                }
                V.add(order.getOrder_status());
                V.add(customerDAO.getCustomerDetail(order.getCustomer_id()).getCustomer_name());
                V.add(orderDAO.getDiscountTypeById(order.getDiscount_id()).getDiscount_type() + ": " + order.getDiscount());
                V.add(order.getTotal_bill());
                total_sale += Double.parseDouble("" + order.getTotal_bill());
                tableModelOrder.addRow(V);
            }
        } catch (Exception e) {
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonDelOrder;
    private javax.swing.JButton jButtonNewOrder;
    private javax.swing.JButton jButtonUpdateorderStatus;
    private javax.swing.JCheckBox jCheckBoxAllOrders;
    private javax.swing.JCheckBox jCheckBoxDelivey;
    private javax.swing.JCheckBox jCheckBoxDispatched;
    private javax.swing.JCheckBox jCheckBoxPending;
    private javax.swing.JCheckBox jCheckBoxWalkin;
    private javax.swing.JCheckBox jCheckBoxupdatedis;
    private javax.swing.JCheckBox jCheckBoxupdatepending;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelOrderNum;
    private javax.swing.JLabel jLabelProfileName;
    private javax.swing.JLabel jLabelTotalSale;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTextField jTextFieldSerachProducts;
    // End of variables declaration//GEN-END:variables
}