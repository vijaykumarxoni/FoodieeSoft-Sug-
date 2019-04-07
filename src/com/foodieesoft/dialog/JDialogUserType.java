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
import com.foodieesoft.dao.UserTypesDAO;
import com.foodieesoft.daoImpl.FoodCategoryDAOImpl;
import com.foodieesoft.beans.UserType;

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
public class JDialogUserType extends javax.swing.JDialog {
    /**
     * Creates new form NewJDialogReport
     */
     private int userId;
     private UserType userType;

    public JDialogUserType(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
 public JDialogUserType(java.awt.Frame parent, boolean modal,int userId) {
        super(parent, modal);
        this.userId=userId;
        initComponents();
        
        this.jButtonUpdate.setVisible(false);
        this.jButtonDelete.setVisible(false);
    }

  public JDialogUserType(java.awt.Frame parent, boolean modal,int userId,UserType userType) {
        super(parent, modal);
        this.userId=userId;
        this.userType=userType;
        initComponents();
        
        this.jTextFieldUserType.setText(this.userType.getUser_type());
        this.jButtonSave.setVisible(false);
        this.jLabeltitle.setText(userType.getUser_type());
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
        jTextFieldUserType = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabeltitle.setBackground(new java.awt.Color(0, 19, 74));
        jLabeltitle.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        jLabeltitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltitle.setText("Add User Type");
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
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 320, -1));

        jTextFieldUserType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldUserType.setText("Enter UserType");
        jTextFieldUserType.setBorder(null);
        jTextFieldUserType.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldUserType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUserTypeMouseClicked(evt);
            }
        });
        jTextFieldUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserTypeActionPerformed(evt);
            }
        });
        jTextFieldUserType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUserTypeKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 320, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("UserType*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 510, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
                if (!(this.jTextFieldUserType.getText().equals("Enter UserType") || this.jTextFieldUserType.getText().equals(""))) {

            if (!InputValidation.validateName(this.jTextFieldUserType.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Invalid User type Format!");

            } else {
                UserTypesDAO userTypesDAO = new UserTpesDAOImpl();

                int status = userTypesDAO.saveUserType(new com.foodieesoft.beans.UserType(userId, CurrentDate.getCurrentDate(), this.jTextFieldUserType.getText()));
                this.jTextFieldUserType.setText("Enter UserType");
                if (status != 0) {
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Successfully added");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill required field");
            this.jTextFieldUserType.setText("Enter UserType");

        }

        
        {
        }    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
  
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","Save Update",JOptionPane.YES_NO_OPTION);

if(dialogButton == JOptionPane.YES_OPTION) {
if (!(this.jTextFieldUserType.getText().equals("Enter UserType") || this.jTextFieldUserType.getText().equals(""))) {

            int user_cat_id = userType.getUser_cat_id();

            if (!InputValidation.validateName(this.jTextFieldUserType.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Invalid User type Format!");

            } else {
                UserTypesDAO userTypesDAO = new UserTpesDAOImpl();

                int i = userTypesDAO.modifyUserType(new UserType(user_cat_id, 0, 0, userId, "", CurrentDate.getCurrentDate(),
                        this.jTextFieldUserType.getText()));

                if (i != 0) {
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Updated Sucessfully");

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill required field");
            this.jTextFieldUserType.setText("Enter UserType");

        }
        }else {}

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","Save Update",JOptionPane.YES_NO_OPTION);

if(dialogButton == JOptionPane.YES_OPTION) {
                 int user_cat_id = userType.getUser_cat_id();
        UserTypesDAO userTypesDAO = new UserTpesDAOImpl();

        int i = userTypesDAO.removeUserType(new UserType(user_cat_id, 0, 0, 0, "", "", ""));

        if (i != 0) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "Deleted Sucessfully");

}

        }else {}

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldUserTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUserTypeMouseClicked
        if (this.jTextFieldUserType.getText().equalsIgnoreCase("Enter UserType")) {
            this.jTextFieldUserType.setText("");
        }
    }//GEN-LAST:event_jTextFieldUserTypeMouseClicked

    private void jTextFieldUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserTypeActionPerformed

    private void jTextFieldUserTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUserTypeKeyPressed
        // TODO add your handling code here:
        if (this.jTextFieldUserType.getText().equalsIgnoreCase("Enter UserType")) {
            this.jTextFieldUserType.setText("");
        }
    }//GEN-LAST:event_jTextFieldUserTypeKeyPressed

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
            java.util.logging.Logger.getLogger(JDialogUserType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogUserType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogUserType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogUserType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogUserType dialog = new JDialogUserType(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldUserType;
    // End of variables declaration//GEN-END:variables
}
