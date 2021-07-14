package Jframes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sina
 */
public class ResetPassword extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    //this variable is defined to display the username at the top of the home page
    public static String uN = "";

    public ResetPassword() {
        initComponents();
    }

    //-----------------------------------------------------------------------------------------------------------------------------    
    //method to prevent the user from entering incorrect values 
    public boolean validateReset() {
        //Variables of method : name for username, oldPwd for user oldpassword, newPwd for user newpassword
        String name = txt_username.getText();
        String oldPwd = txt_oldpassword.getText();
        String newPwd = txt_newpassword.getText();

        //make a variable for result
        boolean isExist = true;
        //if the username box was empty
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Pleas Entetr Username");
            isExist = false;
        }
        //if the oldpassword box was empty
        if (oldPwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Pleas Enter Password");
            isExist = false;
        }
        //if the newpassword box was empty
        if (newPwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Pleas Enter Password");
            isExist = false;
        }
        return isExist;
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    //method to username and oldpassword and newpassword verifier
    public void ResetPass() {
        //Variables of method : name for username, oldPwd for user oldpassword, newPwd for user newpassword
        String name = txt_username.getText();
        String oldPwd = txt_oldpassword.getText();
        String newPwd = txt_newpassword.getText();

        try {
            Connection con = databaseconnection.getConnection();
            //used query for name and password in user table
            //         String sql = "update users set password = '" + "newPwd" + "' where name = ?";
            String sql = " update users set password = ? where name=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPwd);
            ps.setString(2, name);

            //    ps.setString(2, oldPwd);
            //    ps.setString(2, oldPwd);
            //set "name of user" in uN
            //  uN = txt_username.getText();
            int ResultSet = ps.executeUpdate();

            //this means theere is this username and password in our databas            
            if (ResultSet > 0) {
                JOptionPane.showMessageDialog(this, "Reset Password Sucssecfuly, Now Login Your Account");
                Login L = new Login();
                L.show();
                this.hide();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Usename Or Password");
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    //-----------------------------------------------------------------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_oldpassword = new rojerusan.RSPasswordTextPlaceHolder();
        password_chekBox = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txt_newpassword = new rojerusan.RSPasswordTextPlaceHolder();
        password_chekBox1 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Welcome To This Library");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 350, 60));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("ORACLE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-3.png.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 760, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 40, 40));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reset your passwprd now");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Username");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 100, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("New Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 130, 30));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jLabel11.setText("Username");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 50, 50));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonCircle1.setText("Login");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 240, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Reset Password");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 240, 60));

        txt_username.setBackground(new java.awt.Color(102, 102, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 220, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reset Password Page");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 260, 40));

        txt_oldpassword.setBackground(new java.awt.Color(102, 102, 255));
        txt_oldpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_oldpassword.setForeground(new java.awt.Color(0, 0, 0));
        txt_oldpassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txt_oldpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 230, 30));

        password_chekBox.setBackground(new java.awt.Color(102, 102, 255));
        password_chekBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_chekBoxActionPerformed(evt);
            }
        });
        jPanel2.add(password_chekBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Old Password");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 130, 30));

        txt_newpassword.setBackground(new java.awt.Color(102, 102, 255));
        txt_newpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_newpassword.setForeground(new java.awt.Color(0, 0, 0));
        txt_newpassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txt_newpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 230, 30));

        password_chekBox1.setBackground(new java.awt.Color(102, 102, 255));
        password_chekBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_chekBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(password_chekBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jLabel13.setText("Username");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 400, 600));

        setSize(new java.awt.Dimension(1199, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost

    }//GEN-LAST:event_txt_usernameFocusLost

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        Login L = new Login();
        L.show();
        this.hide();

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void password_chekBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_chekBoxActionPerformed
        //to set visibility of password in password box
        if (password_chekBox.isSelected()) {
            txt_oldpassword.setEchoChar('\0');
        } else {
            txt_oldpassword.setEchoChar('*');
        }

    }//GEN-LAST:event_password_chekBoxActionPerformed

    private void password_chekBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_chekBox1ActionPerformed
        //to set visibility of password in password box
        if (password_chekBox.isSelected()) {
            txt_newpassword.setEchoChar('\0');
        } else {
            txt_newpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_password_chekBox1ActionPerformed

    //-----------------------------------------------------------------------------------------------------------------------------

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed

        if (validateReset()) {
            ResetPass();
            Login L = new Login();
            L.show();
            this.hide();
        } else {
        }

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

//-----------------------------------------------------------------------------------------------------------------------------
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
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ResetPassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox password_chekBox;
    private javax.swing.JCheckBox password_chekBox1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSPasswordTextPlaceHolder txt_newpassword;
    private rojerusan.RSPasswordTextPlaceHolder txt_oldpassword;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
