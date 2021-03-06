/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.frames;

import com.foodieesoft.beans.Questions;
import com.sun.glass.events.KeyEvent;
import com.foodieesoft.beans.User;
import com.foodieesoft.beans.UserType;
import com.foodieesoft.dao.QuestionsDAO;
import com.foodieesoft.dao.UserDAO;
import com.foodieesoft.daoImpl.QuestionsDAOImpl;
import com.foodieesoft.daoImpl.UserDAOImpl;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vksoni
 */
public class ForgotPasswordPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public static int user_id;
    public static int user_cat_id;
    User user;

    DefaultComboBoxModel comboBoxModelQuestions;
    public ArrayList<Questions> questions_list;

    public ForgotPasswordPage() {
        initComponents();
    }

    public ForgotPasswordPage(String username) {
        super("Reset Account");
        initComponents();
        this.jTextFieldUsername.setText(username);
        this.jPasswordFieldNewPassword.setVisible(false);
        this.jButtonReset.setVisible(false);
        this.jSeparatorNewPassword.setVisible(false);
        this.jLabelNewPassword.setVisible(false);

        comboBoxModelQuestions = (DefaultComboBoxModel) this.jComboBoxQuestions.getModel();
        this.jComboBoxQuestions.setVisible(true);

        showInQuestionsComboBox();

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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jSeparatorUsername = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jTextFieldPhone = new javax.swing.JTextField();
        jSeparatorPhone = new javax.swing.JSeparator();
        jLabelPhone = new javax.swing.JLabel();
        jSeparatorName = new javax.swing.JSeparator();
        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jTextFieldAnswer = new javax.swing.JTextField();
        jSeparatorQuestion = new javax.swing.JSeparator();
        jLabelAnswer = new javax.swing.JLabel();
        jComboBoxQuestions = new javax.swing.JComboBox<>();
        jLabelQuestion = new javax.swing.JLabel();
        jSeparatorAnswer = new javax.swing.JSeparator();
        jSeparatorNewPassword = new javax.swing.JSeparator();
        jLabelNewPassword = new javax.swing.JLabel();
        jButtonVerification = new javax.swing.JButton();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();
        jLabelTitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUsernameMouseClicked(evt);
            }
        });
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 260, -1));
        jPanel1.add(jSeparatorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 260, -1));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 580, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/psdFoodieeSoft.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 170));

        jLabelUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelUsername.setText("USERNAME:");
        jPanel1.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jButtonReset.setBackground(new java.awt.Color(0, 19, 74));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/reset.png"))); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 190, 40));

        jTextFieldPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldPhone.setBorder(null);
        jTextFieldPhone.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldPhoneMouseClicked(evt);
            }
        });
        jTextFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneActionPerformed(evt);
            }
        });
        jTextFieldPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPhoneKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 260, -1));
        jPanel1.add(jSeparatorPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 260, -1));

        jLabelPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPhone.setText("PHONE #:");
        jPanel1.add(jLabelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));
        jPanel1.add(jSeparatorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 260, -1));

        jTextFieldName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldName.setBorder(null);
        jTextFieldName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNameMouseClicked(evt);
            }
        });
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });
        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 260, -1));

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelName.setText("NAME:");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jTextFieldAnswer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldAnswer.setBorder(null);
        jTextFieldAnswer.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldAnswerMouseClicked(evt);
            }
        });
        jTextFieldAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnswerActionPerformed(evt);
            }
        });
        jTextFieldAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAnswerKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 260, 20));
        jPanel1.add(jSeparatorQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 260, -1));

        jLabelAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAnswer.setText("ANSWER:");
        jPanel1.add(jLabelAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, 20));

        jComboBoxQuestions.setBackground(new java.awt.Color(0, 19, 74));
        jComboBoxQuestions.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxQuestions.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxQuestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQuestionsActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 260, -1));

        jLabelQuestion.setBackground(new java.awt.Color(0, 0, 51));
        jLabelQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelQuestion.setText("QUESTION:");
        jPanel1.add(jLabelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));
        jPanel1.add(jSeparatorAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 260, -1));
        jPanel1.add(jSeparatorNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 260, -1));

        jLabelNewPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNewPassword.setText("NEW PASSWORD");
        jPanel1.add(jLabelNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jButtonVerification.setBackground(new java.awt.Color(0, 19, 74));
        jButtonVerification.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonVerification.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/verify.png"))); // NOI18N
        jButtonVerification.setText("Verify");
        jButtonVerification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificationActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVerification, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 260, 40));

        jPasswordFieldNewPassword.setBorder(null);
        jPasswordFieldNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldNewPasswordMouseClicked(evt);
            }
        });
        jPasswordFieldNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldNewPasswordActionPerformed(evt);
            }
        });
        jPasswordFieldNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldNewPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordFieldNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 260, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 670, 270));

        jLabelTitle.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("RESET PASSWORD");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 630, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/bg.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 90));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("LOGIN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jTextFieldUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsernameMouseClicked
    }//GEN-LAST:event_jTextFieldUsernameMouseClicked

    private void jTextFieldPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPhoneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneMouseClicked

    private void jTextFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneActionPerformed

    private void jTextFieldPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhoneKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneKeyPressed

    private void jTextFieldNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameMouseClicked

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameKeyPressed

    private void jComboBoxQuestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQuestionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxQuestionsActionPerformed

    private void jTextFieldAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldAnswerMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldAnswerMouseClicked

    private void jTextFieldAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnswerActionPerformed

    private void jTextFieldAnswerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnswerKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldAnswerKeyPressed

    private void jButtonVerificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificationActionPerformed
        // TODO add your handling code here:\
        UserDAO userDAO = new UserDAOImpl();
        int question_id = questions_list.get(this.jComboBoxQuestions.getSelectedIndex()).getQuestion_id();
        String username = this.jTextFieldUsername.getText().toString().trim();
        String name = this.jTextFieldName.getText().toString().trim();
        String contact = this.jTextFieldPhone.getText().toString().trim();
        String answer = this.jTextFieldAnswer.getText().toString().trim();

        User user = new User();
        user.setQuestion_id(question_id);
        user.setUser_name(username);
        user.setName(name);
        user.setContact_num(contact);
        user.setAnswer(answer);
        user_id = userDAO.verifyUser(user);
        if (user_id > 0) {
            JOptionPane.showMessageDialog(this, "Verified! Now you can reset password");
            this.jPasswordFieldNewPassword.setVisible(true);
            this.jButtonReset.setVisible(true);
            this.jSeparatorNewPassword.setVisible(true);
            this.jLabelNewPassword.setVisible(true);
            this.jLabelTitle.setText(this.jTextFieldUsername.getText().toString().toUpperCase());
            this.jTextFieldUsername.setVisible(false);
            jComboBoxQuestions.setVisible(false);
            this.jLabelAnswer.setVisible(false);
            this.jLabelUsername.setVisible(false);
            this.jLabelName.setVisible(false);
            this.jLabelQuestion.setVisible(false);
            this.jLabelPhone.setVisible(false);

            this.jTextFieldName.setVisible(false);
            this.jTextFieldPhone.setVisible(false);
            this.jTextFieldAnswer.setVisible(false);
            this.jSeparatorAnswer.setVisible(false);
            this.jSeparatorName.setVisible(false);
            this.jSeparatorPhone.setVisible(false);
            this.jSeparatorUsername.setVisible(false);
            this.jSeparatorQuestion.setVisible(false);
            this.jButtonVerification.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(this, "Invalid user account details ");

        }
    }//GEN-LAST:event_jButtonVerificationActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        UserDAO userDAO = new UserDAOImpl();

        int i = userDAO.resetPassword(user_id, this.jPasswordFieldNewPassword.getText().toString().trim());
        JOptionPane.showMessageDialog(this, "Succesfully reset password ");
        new LoginPage().setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jPasswordFieldNewPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldNewPasswordMouseClicked
        if (this.jPasswordFieldNewPassword.getText().equalsIgnoreCase("Enter Password...")) {
            this.jPasswordFieldNewPassword.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldNewPasswordMouseClicked

    private void jPasswordFieldNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldNewPasswordActionPerformed

    private void jPasswordFieldNewPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldNewPasswordKeyPressed
        if (this.jPasswordFieldNewPassword.getText().equalsIgnoreCase("Enter Password...")) {
            this.jPasswordFieldNewPassword.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldNewPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPasswordPage().setVisible(true);
            }
        });
    }

    public void showInQuestionsComboBox() {
        QuestionsDAO questionsDAO = new QuestionsDAOImpl();
        questions_list = questionsDAO.getAllQuestions();
        for (Questions question : questions_list) {

            this.jComboBoxQuestions.addItem("" + question.getQuestions());

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
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonVerification;
    private javax.swing.JComboBox<String> jComboBoxQuestions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAnswer;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNewPassword;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    private javax.swing.JSeparator jSeparatorAnswer;
    private javax.swing.JSeparator jSeparatorName;
    private javax.swing.JSeparator jSeparatorNewPassword;
    private javax.swing.JSeparator jSeparatorPhone;
    private javax.swing.JSeparator jSeparatorQuestion;
    private javax.swing.JSeparator jSeparatorUsername;
    private javax.swing.JTextField jTextFieldAnswer;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
