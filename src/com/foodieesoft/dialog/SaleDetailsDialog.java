/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dialog;

import com.foodieesoft.beans.OrderDetail;
import com.foodieesoft.dao.OrderDetailsDAO;
import com.foodieesoft.dao.ProductDAO;
import com.foodieesoft.daoImpl.OrderDetailsDAOImpl;
import com.foodieesoft.daoImpl.ProductDAOImpl;
import static com.foodieesoft.frames.OrderDetailPage.total_sale;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class SaleDetailsDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialogReport
     */
    DefaultTableModel tableModelOrderDetail;
    ArrayList<OrderDetail> order_detail_list;

    public SaleDetailsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tableModelOrderDetail = (DefaultTableModel) this.jTableOrderDetail.getModel();

    }

    public SaleDetailsDialog(java.awt.Frame parent, boolean modal,String billDate, int order_id,String customer_name) {
        super(parent, modal);
        initComponents();
        tableModelOrderDetail = (DefaultTableModel) this.jTableOrderDetail.getModel();
       OrderDetailsDAO orderDetailDAO=new OrderDetailsDAOImpl();
        this.jLabelCustomerName.setText("( "+customer_name+" )");
        this.jLabelBillNo.setText("" + order_id);
        this.jLabelDate.setText(billDate);
        this.jLabelTotalBill.setText("" + Double.parseDouble("" + orderDetailDAO.getAllOrderDetailById(order_id).get(0).getTotal_price()));

        showInOrderDetailTable(order_id);

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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrderDetail = new javax.swing.JTable();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabelBillNo = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(0, 19, 74));
        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 1, 54)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Order Details");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 19, 74), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableOrderDetail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableOrderDetail.setForeground(new java.awt.Color(0, 0, 51));
        jTableOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR #:", "Item Name", "Item QTY", "Individual Total "
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
        jTableOrderDetail.setToolTipText("Products");
        jTableOrderDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableOrderDetail.setGridColor(new java.awt.Color(0, 0, 51));
        jTableOrderDetail.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableOrderDetail.setSelectionForeground(new java.awt.Color(0, 240, 0));
        jTableOrderDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOrderDetail);
        if (jTableOrderDetail.getColumnModel().getColumnCount() > 0) {
            jTableOrderDetail.getColumnModel().getColumn(0).setMinWidth(60);
            jTableOrderDetail.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableOrderDetail.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableOrderDetail.getColumnModel().getColumn(1).setMinWidth(220);
            jTableOrderDetail.getColumnModel().getColumn(1).setPreferredWidth(220);
            jTableOrderDetail.getColumnModel().getColumn(1).setMaxWidth(220);
            jTableOrderDetail.getColumnModel().getColumn(2).setMinWidth(70);
            jTableOrderDetail.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableOrderDetail.getColumnModel().getColumn(2).setMaxWidth(70);
            jTableOrderDetail.getColumnModel().getColumn(3).setMinWidth(140);
            jTableOrderDetail.getColumnModel().getColumn(3).setPreferredWidth(140);
            jTableOrderDetail.getColumnModel().getColumn(3).setMaxWidth(140);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 310));

        jLabelTotalBill.setBackground(new java.awt.Color(0, 19, 74));
        jLabelTotalBill.setFont(new java.awt.Font("OCR A Std", 1, 24)); // NOI18N
        jLabelTotalBill.setForeground(new java.awt.Color(51, 255, 0));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalBill.setText("0.0");
        jLabelTotalBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabelTotalBill.setOpaque(true);
        jPanel1.add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 220, 40));

        jLabelBillNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBillNo.setText("Bill #:");
        jPanel1.add(jLabelBillNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 180, -1));

        jLabelDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDate.setText("Date:");
        jPanel1.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 190, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Total Bill:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Bill #:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Date:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 510, 420));

        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCustomerName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerName.setText("Customer Name");
        getContentPane().add(jLabelCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 340, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOrderDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableOrderDetailMouseClicked

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
            java.util.logging.Logger.getLogger(SaleDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaleDetailsDialog dialog = new SaleDetailsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void showInOrderDetailTable(int order_id) {
        tableModelOrderDetail.setRowCount(0);
        int counter = 1;
               OrderDetailsDAO orderDetailDAO=new OrderDetailsDAOImpl();
               ProductDAO  productD=new ProductDAOImpl();
        order_detail_list = orderDetailDAO.getAllOrderDetailById(order_id);
        for (OrderDetail order : order_detail_list) {
            Vector V = new Vector();
            V.add(counter++);
            V.add(productD.getProduct(order.getProduct_id()).getFood_name());
            V.add(order.getQantity());
            V.add(order.getTotal_price());

            tableModelOrderDetail.addRow(V);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBillNo;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrderDetail;
    // End of variables declaration//GEN-END:variables
}
