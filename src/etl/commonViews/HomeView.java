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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        modelBtn = new javax.swing.JButton();
        etlToolBtn = new javax.swing.JButton();
        dashboardBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emp-Sense Home (IT Industry)");
        setResizable(false);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(250, 40, 170, 100);

        modelBtn.setBackground(new java.awt.Color(0, 102, 204));
        modelBtn.setForeground(new java.awt.Color(0, 0, 204));
        modelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/model_icon.png"))); // NOI18N
        modelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelBtnActionPerformed(evt);
            }
        });
        jPanel2.add(modelBtn);
        modelBtn.setBounds(240, 160, 160, 160);

        etlToolBtn.setBackground(new java.awt.Color(0, 102, 204));
        etlToolBtn.setForeground(new java.awt.Color(0, 0, 204));
        etlToolBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/etl_icon.png"))); // NOI18N
        etlToolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etlToolBtnActionPerformed(evt);
            }
        });
        jPanel2.add(etlToolBtn);
        etlToolBtn.setBounds(80, 160, 150, 160);

        dashboardBtn.setBackground(new java.awt.Color(0, 102, 204));
        dashboardBtn.setForeground(new java.awt.Color(51, 204, 255));
        dashboardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/dashboard_icon.png"))); // NOI18N
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });
        jPanel2.add(dashboardBtn);
        dashboardBtn.setBounds(410, 160, 160, 160);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/bg_2.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 140, 510, 200);

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setOpaque(true);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 670, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton modelBtn;
    // End of variables declaration//GEN-END:variables
}
