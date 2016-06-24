/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.commonViews;

import etl.constants.StringConstants;
import etl.views.Extract;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.view.ModelMethodSelection;

/**
 *
 * @author Chinthaka Suren
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     */
    public HomeView() {
        initComponents();
        setWindowIcon(); 
    }

    /*
    * @Method setWindowIcon 
    * Set Window Icon
    */
    private void setWindowIcon(){
        //Set ImageIcon of window
        ImageIcon img = new ImageIcon(StringConstants.ICON_FILE_PATH);
        setIconImage(img.getImage());
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
        jLabel1 = new javax.swing.JLabel();
        etlToolBtn = new javax.swing.JButton();
        modelBtn = new javax.swing.JButton();
        dashboardBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emp-Sense Home (IT Industry)");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/emp-senseLogo.png"))); // NOI18N
        jLabel1.setText("Predict Your Employees' Churn");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        etlToolBtn.setText("ETL Tool");
        etlToolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etlToolBtnActionPerformed(evt);
            }
        });

        modelBtn.setText("Predict Employee Churn");
        modelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelBtnActionPerformed(evt);
            }
        });

        dashboardBtn.setText("View Employee Churn");
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(etlToolBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(modelBtn)
                .addGap(51, 51, 51)
                .addComponent(dashboardBtn)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etlToolBtn)
                    .addComponent(modelBtn)
                    .addComponent(dashboardBtn))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
    * @Method etlToolBtnActionPerformed 
    * Display ETL Tool
    * @param  ActionEvent
    */
    private void etlToolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etlToolBtnActionPerformed
        dispose();
        new Extract().setVisible(true);
    }//GEN-LAST:event_etlToolBtnActionPerformed

    /*
    * @Method modelBtnActionPerformed 
    * Display Model Train window
    * @param  ActionEvent
    */
    private void modelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelBtnActionPerformed
        dispose();
        new ModelMethodSelection().setVisible(true);
    }//GEN-LAST:event_modelBtnActionPerformed

    /*
    * @Method dashboardBtnActionPerformed 
    * Display Dashboard in web browser
    * @param  ActionEvent
    */
    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        try {
            openWebpage(new URI(StringConstants.DASHBOARD_URL));
        } catch (URISyntaxException ex) {
            Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dashboardBtnActionPerformed

    /*
    * @Method openWebpage 
    * Open URL in web browser
    * @param  URI
    */
    public void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, StringConstants.DASHBOARD_NOT_AVAIL,
                    StringConstants.DASHBOARD_ERROR, JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JButton etlToolBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modelBtn;
    // End of variables declaration//GEN-END:variables
}
