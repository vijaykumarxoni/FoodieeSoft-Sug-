/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Customer;
import com.foodieesoft.beans.Employee;
import com.foodieesoft.beans.Permissions;
import com.foodieesoft.beans.Questions;
import com.foodieesoft.beans.TableReservation;
import com.foodieesoft.beans.User;
import com.foodieesoft.beans.UserType;
import com.foodieesoft.dao.CustomerDAO;
import com.foodieesoft.dao.ReserveTableDAO;
import com.foodieesoft.dao.UserDAO;
import com.foodieesoft.daoImpl.CustomerDAOImpl;
import com.foodieesoft.daoImpl.ReserveTableDAOImpl;
import com.foodieesoft.daoImpl.UserDAOImpl;
import static com.foodieesoft.frames.HomePage.user_id;
import geeks.foodieesoft.util.CurrentDate;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vksoni
 */
public class TablesRerservationPage extends javax.swing.JFrame {

    /**
     * Creates new form UserType
     */
    DefaultTableModel tableModelTableReservation;
    public ArrayList<TableReservation> reserved_tables_list;
    public int user_id = LoginPage.user_id;
    public int user_cat_id = LoginPage.user_cat_id;
    TableRowSorter<DefaultTableModel> rowSorter = null;
    private static int custo_id;
    DefaultComboBoxModel comboBoxModelPartyType;
    DefaultComboBoxModel comboBoxModelTimeFormat;

    TablesRerservationPage tableReservation;

    public TablesRerservationPage() {
        super("Table Reservation");
        initComponents();
        tableModelTableReservation = (DefaultTableModel) this.jTableTableReserve.getModel();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelTableReservation);
        this.jTableTableReserve.setRowSorter(rowSorter);

        showInTable();
        showInPartyTypeComboBox();
        showInTimeFormatComboxBox();
                
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                handleClosing();
            }
        });

    }

    public TablesRerservationPage(String username) {
        super("Table Reservation");
        initComponents();
        tableModelTableReservation = (DefaultTableModel) this.jTableTableReserve.getModel();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelTableReservation);
        this.jTableTableReserve.setRowSorter(rowSorter);
        this.jLabel17.setVisible(false);
        this.jLabel12.setVisible(false);

        this.jLabelProfileName.setText(username);

        comboBoxModelPartyType = (DefaultComboBoxModel) this.jComboBoxPartyType.getModel();
        this.jComboBoxPartyType.setVisible(true);

        comboBoxModelTimeFormat = (DefaultComboBoxModel) this.jComboBoxTimeFormat.getModel();
        this.jComboBoxTimeFormat.setVisible(true);

        showInTable();
        showInPartyTypeComboBox();
        showInTimeFormatComboxBox();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                handleClosing();
            }
        });

    }

    public TablesRerservationPage(String username, int customer_id) {
        super("Table Reservation");
        initComponents();
        tableModelTableReservation = (DefaultTableModel) this.jTableTableReserve.getModel();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelTableReservation);
        this.jTableTableReserve.setRowSorter(rowSorter);
        custo_id = customer_id;
        System.out.println(custo_id);
        CustomerDAO customerDAO = new CustomerDAOImpl();
        Customer customer = customerDAO.getCustomerDetail(custo_id);
        this.jLabelCustomerName.setText(customer.getCustomer_name());
        this.jLabelCustomerContact.setText(customer.getContact());
        this.jLabel17.setVisible(true);
        this.jLabel12.setVisible(true);
        this.jLabelProfileName.setText(username);
        comboBoxModelPartyType = (DefaultComboBoxModel) this.jComboBoxPartyType.getModel();
        this.jComboBoxPartyType.setVisible(true);
        comboBoxModelTimeFormat = (DefaultComboBoxModel) this.jComboBoxTimeFormat.getModel();
        this.jComboBoxTimeFormat.setVisible(true);

        showInTable();
        showInPartyTypeComboBox();
        showInTimeFormatComboxBox();
        
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
        jButtonSave = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jDateChooseDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCustomerSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTableReserve = new javax.swing.JTable();
        jSeparator9 = new javax.swing.JSeparator();
        jSpinnerPartySize = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jButtonSave1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabelCustomerContact = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxPartyType = new javax.swing.JComboBox<>();
        jSpinFieldMin = new com.toedter.components.JSpinField();
        jSpinFieldHours = new com.toedter.components.JSpinField();
        jComboBoxTimeFormat = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelProfileName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButtonUserAccounts = new javax.swing.JButton();
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
        jButtonSave.setText("Select Customer");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 30));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 260, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText(":");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 302, 10, 20));

        jDateChooseDate.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Customer Name:");
        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

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
        jPanel1.add(jTextFieldCustomerSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 400, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Search");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 60, -1));

        jTableTableReserve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableTableReserve.setForeground(new java.awt.Color(0, 0, 51));
        jTableTableReserve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reserver Table Id", "Date ", "Check In Time", "Customer Name ", "Contact #", "Party Type", "Party Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        jTableTableReserve.setToolTipText("Products");
        jTableTableReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTableReserve.setGridColor(new java.awt.Color(0, 0, 51));
        jTableTableReserve.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableTableReserve.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jTableTableReserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTableReserveMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTableReserve);
        if (jTableTableReserve.getColumnModel().getColumnCount() > 0) {
            jTableTableReserve.getColumnModel().getColumn(0).setMinWidth(100);
            jTableTableReserve.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableTableReserve.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableTableReserve.getColumnModel().getColumn(1).setMinWidth(120);
            jTableTableReserve.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableTableReserve.getColumnModel().getColumn(1).setMaxWidth(120);
            jTableTableReserve.getColumnModel().getColumn(2).setMinWidth(100);
            jTableTableReserve.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableTableReserve.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableTableReserve.getColumnModel().getColumn(6).setMinWidth(80);
            jTableTableReserve.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTableTableReserve.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 1010, 390));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 260, -1));

        jSpinnerPartySize.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSpinnerPartySize.setValue(2
        );
        jPanel1.add(jSpinnerPartySize, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 260, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Party Size*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 260, -1));

        jButtonSave1.setBackground(new java.awt.Color(0, 19, 74));
        jButtonSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSave1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/save.png"))); // NOI18N
        jButtonSave1.setText("Reserve Table");
        jButtonSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 260, 40));

        jLabel17.setBackground(new java.awt.Color(0, 0, 51));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Contact#:");
        jLabel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, -1));

        jLabelCustomerName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabelCustomerContact.setBackground(new java.awt.Color(0, 0, 51));
        jLabelCustomerContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelCustomerContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel19.setBackground(new java.awt.Color(0, 0, 51));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("DATE*");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 260, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Checkin Time");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jComboBoxPartyType.setBackground(new java.awt.Color(0, 19, 74));
        jComboBoxPartyType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxPartyType.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxPartyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPartyTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxPartyType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 260, -1));

        jSpinFieldMin.setMaximum(59);
        jSpinFieldMin.setMinimum(0);
        jPanel1.add(jSpinFieldMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 60, -1));

        jSpinFieldHours.setMaximum(12);
        jSpinFieldHours.setMinimum(1);
        jPanel1.add(jSpinFieldHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 60, -1));

        jComboBoxTimeFormat.setBackground(new java.awt.Color(0, 19, 74));
        jComboBoxTimeFormat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxTimeFormat.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxTimeFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTimeFormatActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxTimeFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 120, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Party Type*");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jButtonDelete.setBackground(new java.awt.Color(0, 19, 74));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/delete.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 260, 40));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 250, 40));

        jRadioButton1.setBackground(new java.awt.Color(0, 19, 74));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Today's  Reservations");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1320, 520));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/pro.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

        jLabelProfileName.setBackground(new java.awt.Color(0, 0, 51));
        jLabelProfileName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProfileName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileName.setText("Username");
        getContentPane().add(jLabelProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/logoutmini.png"))); // NOI18N
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 100, -1, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jLabel14.setBackground(new java.awt.Color(0, 19, 74));
        jLabel14.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Table Reservation");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        jButtonUserAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/reserve-tbl-icon_1.png"))); // NOI18N
        jButtonUserAccounts.setBorder(null);
        jButtonUserAccounts.setContentAreaFilled(false);
        jButtonUserAccounts.setFocusPainted(false);
        jButtonUserAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserAccountsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUserAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 140));

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        UserDAO userDAO = new UserDAOImpl();
        new DeliveryInfoPage(userDAO.retriveUsername(user_id), "Customer Details").setVisible(true);
        this.dispose();

        {
    }//GEN-LAST:event_jButtonSaveActionPerformed
    }
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
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));

    }//GEN-LAST:event_jTextFieldCustomerSearchKeyReleased

    private void jTextFieldCustomerSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerSearchKeyTyped

    private void jButtonUserAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserAccountsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUserAccountsActionPerformed

    private void jButtonSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave1ActionPerformed
        String check_in_time = "", hours, min = "00";
        try {
            SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
            String reservationdate = formats.format(this.jDateChooseDate.getDate());
            String party_type = "" + this.jComboBoxPartyType.getSelectedItem();

            hours = "" + jSpinFieldHours.getValue();
            min = "" + jSpinFieldMin.getValue();
            String format = "" + jComboBoxTimeFormat.getSelectedItem();

            if (Integer.parseInt(hours) >= 1 && Integer.parseInt(hours) < 10) {
                hours = "0" + hours;
            }
            if (Integer.parseInt(min) >= 0 && Integer.parseInt(min) < 10) {
                min = "0" + min;
            }

            check_in_time = "" + hours + ":" + min + " " + format;

            int party_size = (int) this.jSpinnerPartySize.getValue();
            System.out.println("Custo id" + custo_id);
            ReserveTableDAO reserveTableDAO = new ReserveTableDAOImpl();
            int status = reserveTableDAO.reserveTable(new TableReservation(1, custo_id, party_type, reservationdate, check_in_time, party_size));

            if (status != 0) {
                JOptionPane.showMessageDialog(this, "Successfully Table Reserved");
                showInTable();
                new TablesRerservationPage().setVisible(true);
                this.dispose();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please fill required fields");
            System.out.println(e.getMessage());

        }


    }//GEN-LAST:event_jButtonSave1ActionPerformed

    private void jComboBoxPartyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPartyTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPartyTypeActionPerformed

    private void jComboBoxTimeFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTimeFormatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTimeFormatActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed

        int reserved_table_id = Integer.parseInt("" + this.jTableTableReserve.getValueAt(this.jTableTableReserve.getSelectedRow(), 0));
        ReserveTableDAO reserveTableDAO = new ReserveTableDAOImpl();

        int i = reserveTableDAO.removeReservedTable(new TableReservation(reserved_table_id, 0, "", "", "", 0));

        if (i != 0) {
            JOptionPane.showMessageDialog(this, "Deleted Sucessfully");
            showInTable();
            this.dispose();
            new TablesRerservationPage().setVisible(true);
            this.dispose();

        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableTableReserveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTableReserveMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTableTableReserveMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("Foodiee Soft Reserved Tables");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            this.jTableTableReserve.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(TablesRerservationPage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        // TODO add your handling code here:

        if (this.jRadioButton1.isSelected()) {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + CurrentDate.getCurrentDate()));
            System.out.println(CurrentDate.getCurrentDate());
        } else {

            String searchData = this.jTextFieldCustomerSearch.getText();
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));

        }
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TablesRerservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablesRerservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablesRerservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablesRerservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new TablesRerservationPage().setVisible(true);
            }
        });
    }

    public void showInPartyTypeComboBox() {
//        for (String type : party_type) {
//             System.out.println(type);
        this.jComboBoxPartyType.addItem("Family Lunch");
        this.jComboBoxPartyType.addItem("Family Dinner");
        this.jComboBoxPartyType.addItem("Office Lunch");
        this.jComboBoxPartyType.addItem("Office Dinner");
        this.jComboBoxPartyType.addItem("Office Party");
        this.jComboBoxPartyType.addItem("Birthday party");
        this.jComboBoxPartyType.addItem("Marriage Party");
        this.jComboBoxPartyType.addItem("Other");

//        }
    }

    public void showInTimeFormatComboxBox() {
//        for (String type : party_type) {
//             System.out.println(type);
        this.jComboBoxTimeFormat.addItem("AM");
        this.jComboBoxTimeFormat.addItem("PM");

//        }
    }

    public void showInTable() {
        tableModelTableReservation.setRowCount(0);
        ReserveTableDAO reserveTableDAO = new ReserveTableDAOImpl();

        reserved_tables_list = reserveTableDAO.getAllReservedTables();
        for (TableReservation tableReservation : reserved_tables_list) {
            Vector V = new Vector();
            CustomerDAO customerDAO = new CustomerDAOImpl();
            Customer customer = customerDAO.getCustomerDetail(tableReservation.getCustomer_id());
//           
            V.add(tableReservation.getTable_reserv_id());
            V.add(tableReservation.getReservationDate());
            V.add(tableReservation.getCheck_in_time());
            V.add(customer.getCustomer_name());
            V.add(customer.getContact());
            V.add(tableReservation.getParty_type());
            V.add(tableReservation.getParty_size());

            tableModelTableReservation.addRow(V);
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

//    public void checkPermissions(int user_cat_id) {
//        ArrayList<Permissions> permissions_name_list;
//        permissions_name_list = dbManager.getUserPermissionName(user_cat_id);
//
//        for (Permissions permissions : permissions_name_list) {
//            if ((permissions.getPermission_name().equalsIgnoreCase("Add Employee"))) {
//                this.jButtonSave.setEnabled(true);
//            } else if ((permissions.getPermission_name().equalsIgnoreCase("Update Add Employee"))) {
//                this.jButtonUpdate.setEnabled(true);
//
//            } else if ((permissions.getPermission_name().equalsIgnoreCase("Delete Add Employee"))) {
//                this.jButtonDelete.setEnabled(true);
//
//            }
//
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSave1;
    private javax.swing.JButton jButtonUserAccounts;
    private javax.swing.JComboBox<String> jComboBoxPartyType;
    private javax.swing.JComboBox<String> jComboBoxTimeFormat;
    private com.toedter.calendar.JDateChooser jDateChooseDate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCustomerContact;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelProfileName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private com.toedter.components.JSpinField jSpinFieldHours;
    private com.toedter.components.JSpinField jSpinFieldMin;
    private javax.swing.JSpinner jSpinnerPartySize;
    private javax.swing.JTable jTableTableReserve;
    private javax.swing.JTextField jTextFieldCustomerSearch;
    // End of variables declaration//GEN-END:variables
}
