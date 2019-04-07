/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dialog;

import com.foodieesoft.beans.FoodCategory;
import com.foodieesoft.beans.Product;
import com.foodieesoft.dao.QuestionsDAO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.foodieesoft.beans.Questions;
import com.foodieesoft.dao.FoodCategoryDAO;
import com.foodieesoft.dao.ProductDAO;
import com.foodieesoft.daoImpl.FoodCategoryDAOImpl;
import com.foodieesoft.daoImpl.ProductDAOImpl;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import com.foodieesoft.daoImpl.QuestionsDAOImpl;
import com.foodieesoft.daoImpl.UserTpesDAOImpl;
import geeks.foodieesoft.util.CurrentDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vksoni
 */
public class JDialogProduct extends javax.swing.JDialog {
    /**
     * Creates new form NewJDialogReport
     */
     private int userId;
     private Product product;
      DefaultComboBoxModel comboBoxModelCategory;
    public ArrayList<Product> products_list;
    ArrayList<FoodCategory> category_list;
    FoodCategoryDAO foodCategoryDAO;
   

    public JDialogProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
 public JDialogProduct(java.awt.Frame parent, boolean modal,int userId) {
        super(parent, modal);
        this.userId=userId;
        initComponents();
        
        this.jButtonUpdate.setVisible(false);
        this.jButtonDelete.setVisible(false);
        
        
             comboBoxModelCategory = (DefaultComboBoxModel) this.jComboBoxCategories.getModel();
        this.jComboBoxCategories.setVisible(true);
         foodCategoryDAO = new FoodCategoryDAOImpl();
        category_list = foodCategoryDAO.getAllFoodTypes();
        showInComboBox();
   
    }

  public JDialogProduct(java.awt.Frame parent, boolean modal,int userId,Product product) {
        super(parent, modal);
        this.userId=userId;
        this.product=product;
        initComponents();
            this.jButtonSave.setVisible(false);
        
             comboBoxModelCategory = (DefaultComboBoxModel) this.jComboBoxCategories.getModel();
        this.jComboBoxCategories.setVisible(true);
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();
        category_list = foodCategoryDAO.getAllFoodTypes();
        showInComboBox();
     this.jTextFieldFoodName.setText(product.getFood_name());
        this.jTextFieldPrice.setText("" + product.getPrice());
        this.jLabelTitle.setText(this.product.getFood_name().trim());
        this.jSpinnerQuantity.setValue(Integer.parseInt("" + product.getQuantity()));
        foodCategoryDAO = new FoodCategoryDAOImpl();
        this.jComboBoxCategories.setSelectedItem(foodCategoryDAO.getFoodType(product.getFood_cat_id()));        
        
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
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSpinnerQuantity = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldFoodName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxCategories = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 19, 74), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSave.setBackground(new java.awt.Color(0, 19, 74));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/save.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 150, 40));

        jButtonUpdate.setBackground(new java.awt.Color(0, 19, 74));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/update.png"))); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 150, 40));

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
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 150, 40));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 500, -1));

        jSpinnerQuantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
        jPanel1.add(jSpinnerQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 370, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 51));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("QUNATITY");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 330, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 500, -1));

        jTextFieldPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldPrice.setText("Enter Price...");
        jTextFieldPrice.setBorder(null);
        jTextFieldPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldPriceMouseClicked(evt);
            }
        });
        jTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPriceActionPerformed(evt);
            }
        });
        jTextFieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPriceKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 500, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("PRICE*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 300, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 500, -1));

        jTextFieldFoodName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldFoodName.setText("Enter Food Name...");
        jTextFieldFoodName.setBorder(null);
        jTextFieldFoodName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldFoodName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldFoodNameMouseClicked(evt);
            }
        });
        jTextFieldFoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFoodNameActionPerformed(evt);
            }
        });
        jTextFieldFoodName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFoodNameKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 500, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("FOOD NAME*");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 350, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 500, -1));

        jComboBoxCategories.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxCategories.setForeground(new java.awt.Color(0, 91, 74));
        jComboBoxCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriesActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCategories, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 500, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("CATEGORY*");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 530, 350));

        jLabelTitle.setBackground(new java.awt.Color(0, 19, 74));
        jLabelTitle.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Add Product");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 90));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed

        ProductDAO productDAO = new ProductDAOImpl();

        if (!((this.jTextFieldFoodName.getText().equals("Enter Food Name...") || this.jTextFieldPrice.getText().equals("Enter Price...") || this.jSpinnerQuantity.getValue().equals(0)
                || this.jTextFieldFoodName.getText().equals("") || this.jTextFieldPrice.getText().equals("")))) {

            int food_cat_id = category_list.get(this.jComboBoxCategories.getSelectedIndex()).getFood_cat_id();
            int price = Integer.parseInt(this.jTextFieldPrice.getText());
            int quantity = Integer.parseInt("" + this.jSpinnerQuantity.getValue());
            int status = productDAO.saveProducts(new Product(0, food_cat_id, 1, price,
                    quantity, userId, 0, CurrentDate.getCurrentDate(), "", this.jTextFieldFoodName.getText()));

            if (status != 0) {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Successfully added");
                this.jTextFieldFoodName.setText("Enter Food Name...");
                this.jTextFieldPrice.setText("Enter Price...");
                this.jSpinnerQuantity.setValue(0);
                this.jComboBoxCategories.setSelectedIndex(0);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill required field");

        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
  
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","Save Update",JOptionPane.YES_NO_OPTION);

if(dialogButton == JOptionPane.YES_OPTION) {
        
     int product_id = product.getProduct_id();
        int food_cat_id = category_list.get(this.jComboBoxCategories.getSelectedIndex()).getFood_cat_id();
        ProductDAO productDAO = new ProductDAOImpl();

        int price = Integer.parseInt("" + this.jTextFieldPrice.getText());
        int quantity = Integer.parseInt("" + jSpinnerQuantity.getValue());

        int i = productDAO.modifyProducts(new Product(product_id, food_cat_id, 0, price, quantity, 0, userId, "", CurrentDate.getCurrentDate(),
                this.jTextFieldFoodName.getText()));

        if (i != 0) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "Updated Sucessfully");
        }
    
        }else {}

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","Save Update",JOptionPane.YES_NO_OPTION);

if(dialogButton == JOptionPane.YES_OPTION) {
         int product_id = product.getProduct_id();
        ProductDAO productDAO = new ProductDAOImpl();
        int i = productDAO.removeProducts(new Product(product_id, 0, 0, 0, 0, 0, 0, "", "", ""));

        if (i != 0) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "Deleted Sucessfully");
         

        }else {}
}
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPriceMouseClicked
        // TODO add your handling code here:
        if (this.jTextFieldPrice.getText().equalsIgnoreCase("Enter Price...")) {
            this.jTextFieldPrice.setText("");
        }
    }//GEN-LAST:event_jTextFieldPriceMouseClicked

    private void jTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPriceActionPerformed

    private void jTextFieldPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPriceKeyPressed

        if (this.jTextFieldPrice.getText().equalsIgnoreCase("Enter Price...")) {
            this.jTextFieldPrice.setText("");
        }
    }//GEN-LAST:event_jTextFieldPriceKeyPressed

    private void jTextFieldFoodNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFoodNameMouseClicked
        // TODO add your handling code here:
        if (this.jTextFieldFoodName.getText().equalsIgnoreCase("Enter Food Name...")) {
            this.jTextFieldFoodName.setText("");
        }
    }//GEN-LAST:event_jTextFieldFoodNameMouseClicked

    private void jTextFieldFoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFoodNameActionPerformed

    private void jTextFieldFoodNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFoodNameKeyPressed
        if (this.jTextFieldFoodName.getText().equalsIgnoreCase("Enter Food Name...")) {
            this.jTextFieldFoodName.setText("");
        }
    }//GEN-LAST:event_jTextFieldFoodNameKeyPressed

    private void jComboBoxCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriesActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogProduct dialog = new JDialogProduct(new javax.swing.JFrame(), true);
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
    public void genReport(String from ,String to) {

        new Thread(new Runnable() {

            int i = 1;

            @Override
            public void run() {
                while (true) {
                    i += 10;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                }
            }
        }).start();

        IReportEngine engine = null;
        EngineConfig config = null;
        Map parameters = new HashMap();
        parameters.put("from", "" + from);
        parameters.put("to", to);
        String reportTitle = "custom report of "+to+" to "+from;
        String path = "Reports\\CustomReports/" + reportTitle + ".pdf";
        File f = new File(path);
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
            String rpath = "reprotFiles/custom_report.rptdesign";

            design = engine.openReportDesign(rpath);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
//           task.setParameterValue("custo_id", ""+6);
//            task.validateParameters();
//            // int order=DbManager.getMaxOrder();
            HTMLRenderOption options = new HTMLRenderOption();
            options.setOutputFileName(path);
            options.setOutputFormat("pdf");

            task.setRenderOption(options);

            task.setParameterValues(parameters);

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
            System.out.println("report generated");
            System.out.println(ex.getMessage());
        } finally {
            Platform.shutdown();
            JOptionPane.showMessageDialog(rootPane, "report scucessfully generated");

            try {

                if ((new File("Reports\\CustomReports/" + reportTitle + ".pdf")).exists()) {

                    Process p = Runtime
                            .getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler Reports\\CustomReports/" + reportTitle + ".pdf");
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
     public void showInComboBox() {
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();

        category_list = foodCategoryDAO.getAllFoodTypes();
        for (FoodCategory foodCategory : category_list) {

            this.jComboBoxCategories.addItem("" + foodCategory.getFood_type());

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxCategories;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinnerQuantity;
    private javax.swing.JTextField jTextFieldFoodName;
    private javax.swing.JTextField jTextFieldPrice;
    // End of variables declaration//GEN-END:variables
}