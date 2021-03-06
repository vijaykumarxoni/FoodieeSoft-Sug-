/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dialog;

import com.foodieesoft.beans.FoodCategory;
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
import com.foodieesoft.daoImpl.FoodCategoryDAOImpl;

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
import geeks.foodieesoft.util.InputValidation;

/**
 *
 * @author Vksoni
 */
public class JDialogFoodCat extends javax.swing.JDialog {
    /**
     * Creates new form NewJDialogReport
     */
     private int userId;
     private FoodCategory foodCategory;

    public JDialogFoodCat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
 public JDialogFoodCat(java.awt.Frame parent, boolean modal,int userId) {
        super(parent, modal);
        this.userId=userId;
        initComponents();
        
        this.jButtonUpdate.setVisible(false);
        this.jButtonDelete.setVisible(false);
    }

  public JDialogFoodCat(java.awt.Frame parent, boolean modal,int userId,FoodCategory foodCategory) {
        super(parent, modal);
        this.userId=userId;
        this.foodCategory=foodCategory;
        initComponents();
        
        this.jTextFieldFoodName.setText(foodCategory.getFood_type());
        this.jButtonSave.setVisible(false);
        this.jLabeltitle.setText(foodCategory.getFood_type());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabeltitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldFoodName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabeltitle.setBackground(new java.awt.Color(0, 19, 74));
        jLabeltitle.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        jLabeltitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltitle.setText("Add Food Category");
        getContentPane().add(jLabeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 90));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 90));

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
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 150, 40));

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
        jPanel1.add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 150, 40));

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
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 150, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 320, -1));

        jTextFieldFoodName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldFoodName.setText("Enter Food Name");
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
        jPanel1.add(jTextFieldFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 320, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Food Name*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 510, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();

        if (!(this.jTextFieldFoodName.getText().equals("Enter Food Name") || this.jTextFieldFoodName.getText().equals(""))) {
            if (!InputValidation.validateName(this.jTextFieldFoodName.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Invalid Food name Format!");

            } else {
                int status = foodCategoryDAO.saveFoodCategory(new FoodCategory(userId, CurrentDate.getCurrentDate(), this.jTextFieldFoodName.getText()));
                this.jTextFieldFoodName.setText("Enter Food Name");
                if (status != 0) {
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Successfully added");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill required field");
            this.jTextFieldFoodName.setText("Enter Food Name");

        }    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
  
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","Save Update",JOptionPane.YES_NO_OPTION);

if(dialogButton == JOptionPane.YES_OPTION) {

        int food_cat_id = foodCategory.getFood_cat_id();
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();

        if (!InputValidation.validateName(this.jTextFieldFoodName.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Invalid Food name Format!");

        } else {
            int i = foodCategoryDAO.modifyFoodCategory(new FoodCategory(food_cat_id, 0, 0, userId, "", CurrentDate.getCurrentDate(),
                    this.jTextFieldFoodName.getText()));

            if (i != 0) {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Updated Sucessfully");
                this.jTextFieldFoodName.setText("Enter Food Name");
           

            }
        }
        }else {}

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","Save Update",JOptionPane.YES_NO_OPTION);

if(dialogButton == JOptionPane.YES_OPTION) {
               int food_cat_id = foodCategory.getFood_cat_id();
        FoodCategoryDAO foodCategoryDAO = new FoodCategoryDAOImpl();
        int i = foodCategoryDAO.removeFoodCategory(new FoodCategory(food_cat_id, 0, 0, 0, "", "", ""));

        if (i != 0) {
            this.dispose();
        }
            JOptionPane.showMessageDialog(this, "Deleted Sucessfully");
         

        }else {}

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldFoodNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFoodNameMouseClicked
        if (this.jTextFieldFoodName.getText().equalsIgnoreCase("Enter Food Name")) {
            this.jTextFieldFoodName.setText("");
        }
    }//GEN-LAST:event_jTextFieldFoodNameMouseClicked

    private void jTextFieldFoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFoodNameActionPerformed

    private void jTextFieldFoodNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFoodNameKeyPressed
        // TODO add your handling code here:
        if (this.jTextFieldFoodName.getText().equalsIgnoreCase("Enter Food Name")) {
            this.jTextFieldFoodName.setText("");
        }
    }//GEN-LAST:event_jTextFieldFoodNameKeyPressed

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
            java.util.logging.Logger.getLogger(JDialogFoodCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogFoodCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogFoodCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogFoodCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogFoodCat dialog = new JDialogFoodCat(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldFoodName;
    // End of variables declaration//GEN-END:variables
}
