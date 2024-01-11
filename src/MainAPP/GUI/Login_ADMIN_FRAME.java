/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainAPP.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Vincent
 */
public class Login_ADMIN_FRAME extends javax.swing.JFrame {

    /**
     * Creates new form Login_ADMIN_FRAME
     */
    public Login_ADMIN_FRAME() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_login_id = new javax.swing.JTextField();
        admin_login_password = new javax.swing.JPasswordField();
        home_button_login = new javax.swing.JButton();
        admin_login_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_login_id.setBackground(new java.awt.Color(0,0,0,0));
        admin_login_id.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        admin_login_id.setForeground(new java.awt.Color(255, 255, 255));
        admin_login_id.setText("ADMIN ID");
        admin_login_id.setBorder(null);
        admin_login_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admin_login_idFocusGained(evt);
            }
        });
        admin_login_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_login_idActionPerformed(evt);
            }
        });
        getContentPane().add(admin_login_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 200, 50));

        admin_login_password.setBackground(new java.awt.Color(0,0,0,0));
        admin_login_password.setForeground(new java.awt.Color(255, 255, 255));
        admin_login_password.setText("jPasswordField1");
        admin_login_password.setBorder(null);
        admin_login_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admin_login_passwordFocusGained(evt);
            }
        });
        getContentPane().add(admin_login_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 200, 40));

        home_button_login.setOpaque(false);
        home_button_login.setContentAreaFilled(false); //to make the content area transparent
        home_button_login.setBorderPainted(false); //to make the borders transparent
        home_button_login.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        home_button_login.setForeground(new java.awt.Color(51, 108, 251));
        home_button_login.setBorder(null);
        home_button_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_button_login.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        home_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_button_loginActionPerformed(evt);
            }
        });
        getContentPane().add(home_button_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 385, 220, 30));

        admin_login_btn.setOpaque(false);
        admin_login_btn.setContentAreaFilled(false); //to make the content area transparent
        admin_login_btn.setBorderPainted(false); //to make the borders transparent
        admin_login_btn.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        admin_login_btn.setForeground(new java.awt.Color(51, 108, 251));
        admin_login_btn.setBorder(null);
        admin_login_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_login_btn.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        admin_login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_login_btnActionPerformed(evt);
            }
        });
        getContentPane().add(admin_login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/LOGIN-PAGE-ADMIN.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField2.requestFocusInWindow();
        jTextField2.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jTextField2.setText("ADMIN ID");
        jTextField2.setBorder(null);
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 200, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_login_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_login_idActionPerformed
        admin_login_id.setFocusable(true);
    }//GEN-LAST:event_admin_login_idActionPerformed

    private void admin_login_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_login_idFocusGained
        admin_login_id.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_admin_login_idFocusGained

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jTextField2.requestFocusInWindow();
    }//GEN-LAST:event_formWindowActivated

    private void admin_login_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_login_passwordFocusGained
        admin_login_password.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_admin_login_passwordFocusGained

    private void home_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_button_loginActionPerformed
        Login_ADMIN_FRAME.this.setVisible(false);
        new Login_FRAME().setVisible(true);
    }//GEN-LAST:event_home_button_loginActionPerformed

    private void admin_login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_login_btnActionPerformed
    Connection con = null;
    try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); //Driver name
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/CLINIC_FinalProject", "clinicadmin", "clinicadmin");

        String id = admin_login_id.getText();
        String pwd = admin_login_password.getText();

        Statement stm = con.createStatement();

        // Check if the ID exists
        String checkIdSql = "select * from login_admin where admin_id ='" + id + "'";
        ResultSet idRs = stm.executeQuery(checkIdSql);

        if (idRs.next()) {
            // ID exists, now validate the password
            String validatePwdSql = "select * from login_admin where admin_id ='" + id + "' and admin_pwd='" + pwd + "'";
            ResultSet pwdRs = stm.executeQuery(validatePwdSql);

            if (pwdRs.next()) {
                // Password is valid
                dispose();

                Main_FRAME admin = new Main_FRAME();
                admin.show();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Password!", "", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Admin ID does not exist!", "", JOptionPane.WARNING_MESSAGE);
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }//GEN-LAST:event_admin_login_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Login_ADMIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_ADMIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_ADMIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_ADMIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_ADMIN_FRAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_login_btn;
    private javax.swing.JTextField admin_login_id;
    private javax.swing.JPasswordField admin_login_password;
    private javax.swing.JButton home_button_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
