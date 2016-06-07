/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.db.DBAccess;
import etl.db.DBConnect;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author suren
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private DBAccess dbAccess;
    public Login() {
        initComponents();
        setWindowIcon();        
        dbAccess = new DBAccess();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();

        jLabel3.setText("Username");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emp-Sense - Login");
        setResizable(false);

        jLabel1.setText("Username");

        usernameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameTxtKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/emp-senseLogo.png"))); // NOI18N
        jLabel2.setText("Emp-Sense Login");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setText("Password");

        passwordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTxtKeyReleased(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameTxt)
                        .addComponent(passwordTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(176, 176, 176))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBtn)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
    * @Method setWindowIcon 
    * Set Window Icon
    */
    private void setWindowIcon(){
        //Set ImageIcon of window
        ImageIcon img = new ImageIcon(StringConstants.ICON_FILE_PATH);
        setIconImage(img.getImage());
    }
    
    /*
    * @Method loginBtnActionPerformed 
    * Execute if user clicks on Login Button
    * Validate the empty fields
    * Check whether the username and the password(encrypted) exists
    * If user exists display Extract View with closing the current window
    * @param  Action Event
    */
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        LoginButtonAction();
    }//GEN-LAST:event_loginBtnActionPerformed

    /*
    * @Method usernameTxtKeyReleased 
    * Enable Enter Key login
    * @param  KeyEvent
    */
    private void usernameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTxtKeyReleased
        //Detect Enter Key pressed
        int keyCode = evt.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_ENTER:
                LoginButtonAction();
                break;           
        }
    }//GEN-LAST:event_usernameTxtKeyReleased

    /*
    * @Method passwordTxtKeyReleased 
    * Enable Enter Key login
    * @param  KeyEvent
    */
    private void passwordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtKeyReleased
        //Detect Enter Key pressed
        int keyCode = evt.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_ENTER:
                LoginButtonAction();
                break;           
        }
    }//GEN-LAST:event_passwordTxtKeyReleased

    /*
    * @Method LoginButtonAction 
    * Check username and password matched and load next page
    */
    private void LoginButtonAction(){
        if(usernameTxt.getText().length() == NumberConstants.ZERO)  
            // Checking for empty field
            JOptionPane.showMessageDialog(null, 
                    StringConstants.EMPTY_FIELD);
        else if(passwordTxt.getPassword().length == NumberConstants.ZERO)  
            // Checking for empty field
            JOptionPane.showMessageDialog(null, 
                    StringConstants.EMPTY_FIELD);
        else{
            // Collecting the input
            String user = usernameTxt.getText();   
            char[] pass = passwordTxt.getPassword();
            // converting from array to string
            String pwd = String.copyValueOf(pass);  
            String encryptedPassword = StringConstants.EMPTY_STRING;
            try{
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance(StringConstants.MD5_ENCRYPTION);
                //Add password bytes to digest
                md.update(pwd.getBytes());
                //Get the hash's bytes
                byte[] bytes = md.digest();
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for(int i = NumberConstants.ZERO; i< bytes.length ;i++)
                {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 
                            NumberConstants.SIXTEEN).substring(1));
                }
                //Get complete hashed password in hex format to string variable
                encryptedPassword = sb.toString();                
            }
            catch(NoSuchAlgorithmException e){
                System.out.println(StringConstants.NO_ENCRYPTION_ALGO);
            }
            
            if(dbAccess.isLoginValid(user,encryptedPassword)){
                dispose();
                new Extract().setVisible(true);
            }               
            else{
                JOptionPane.showMessageDialog(null, 
                        StringConstants.INCORRECT_CREDENTIALS);
            }               
        }
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
