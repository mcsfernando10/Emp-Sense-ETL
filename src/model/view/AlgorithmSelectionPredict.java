/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import etl.commonViews.HomeView;
import etl.constants.StringConstants;
import etl.controllers.CustomConfirmDialog;
import etl.db.DBAccess;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import static model.view.AlgorithmSelectionTrain.round;

/**
 *
 * @author suren
 */
public class AlgorithmSelectionPredict extends javax.swing.JFrame {

    /**
     * Creates new form AlgorithmSelectionTrain
     */
    private DBAccess dbAccess;
    public AlgorithmSelectionPredict() {
        initComponents();
        setWindowIcon();        
        dbAccess = new DBAccess();
        
        List<Float> accuracy_churn = new ArrayList<Float>();
        accuracy_churn = dbAccess.getAccuracyForChurn();
        
        label_knn.setText(round(accuracy_churn.get(0) * 100,2) + "%");
        label_rf.setText(round(accuracy_churn.get(1) * 100,2) + "%");
        label_svm.setText(round(accuracy_churn.get(2) * 100,2) + "%");
        
        List<Float> accuracy_reason = new ArrayList<Float>();
        accuracy_reason = dbAccess.getAccuracyForReason();
        
        label_knn_reason.setText(round(accuracy_reason.get(0) * 100,2) + "%");
        label_rf_reason.setText(round(accuracy_reason.get(1) * 100,2) + "%");
        label_svm_reason.setText(round(accuracy_reason.get(2) * 100,2) + "%");
        
        BtnChurn.setText("<html><p>Churn<small style=\"font-size:6px\">&nbsp;&nbsp;▼</small></p></html>");
        BtnReason.setText("<html><p>Reason<small style=\"font-size:6px\">&nbsp;&nbsp;▲</small></p></html>");
        
        List<String> features = new ArrayList<String>();
        features = dbAccess.getFeature("feature_importance_churn","Importance_Churn","DESC","Feature");
        
        panel_feature.setLayout(new BoxLayout(panel_feature, BoxLayout.Y_AXIS));
        panel_feature.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel[] labels_feature=new JLabel[features.size()];
        for(int i = 0; i < features.size(); i++){
            labels_feature[i] = new JLabel(features.get(i), JLabel.LEFT);
            labels_feature[i].setForeground(Color.WHITE);
            labels_feature[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_feature.add(labels_feature[i]);
        }
        
        List<Float> importance_churn = new ArrayList<Float>();
        importance_churn = dbAccess.getImportance("feature_importance_churn","Importance_Churn","DESC","Importance_Churn");
        
        panel_importance_churn.setLayout(new BoxLayout(panel_importance_churn, BoxLayout.Y_AXIS));
        panel_importance_churn.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel[] labels_importance_churn=new JLabel[importance_churn.size()];
        for(int i = 0; i < importance_churn.size(); i++){
            labels_importance_churn[i] = new JLabel(importance_churn.get(i) + "%", JLabel.LEFT);
            labels_importance_churn[i].setForeground(Color.WHITE);
            labels_importance_churn[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_importance_churn.add(labels_importance_churn[i]);
        }
        
        List<Float> importance_reason = new ArrayList<Float>();
        importance_reason = dbAccess.getImportance("feature_importance_churn","Importance_Churn","DESC","Importance_Reason");
        
        panel_importance_reason.setLayout(new BoxLayout(panel_importance_reason, BoxLayout.Y_AXIS));
        panel_importance_reason.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel[] labels_importance_reason=new JLabel[importance_reason.size()];
        for(int i = 0; i < importance_reason.size(); i++){
            labels_importance_reason[i] = new JLabel(importance_reason.get(i) + "%", JLabel.LEFT);
            labels_importance_reason[i].setForeground(Color.WHITE);
            labels_importance_reason[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_importance_reason.add(labels_importance_reason[i]);
        }
        
        /*JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
        JLabel lab2 = new JLabel("User Name", JLabel.LEFT);
        
        panel_feature.add(lab1);
        panel_feature.add(lab2);*/
    }
    
    public static double round(double value, int places) {
            if (places < 0) throw new IllegalArgumentException();

            long factor = (long) Math.pow(10, places);
            value = value * factor;
            long tmp = Math.round(value);
            return (double) tmp / factor;
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algorithm = new javax.swing.ButtonGroup();
        Reason = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        knnRadio_Reason = new javax.swing.JRadioButton();
        knnRadioBtn = new javax.swing.JRadioButton();
        label_knn = new javax.swing.JLabel();
        rfRadio_Reason = new javax.swing.JRadioButton();
        randomForestRadioBtn = new javax.swing.JRadioButton();
        label_rf = new javax.swing.JLabel();
        svmRadioBtn = new javax.swing.JRadioButton();
        svmRadio_Reason = new javax.swing.JRadioButton();
        label_svm = new javax.swing.JLabel();
        label_knn_reason = new javax.swing.JLabel();
        label_rf_reason = new javax.swing.JLabel();
        label_svm_reason = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        submitBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panel_feature = new javax.swing.JPanel();
        panel_importance_churn = new javax.swing.JPanel();
        panel_importance_reason = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        BtnReason = new javax.swing.JButton();
        BtnChurn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select the Algorithm");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel6.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Algorithm Selection");
        jLabel1.setOpaque(true);
        jPanel6.add(jLabel1);
        jLabel1.setBounds(10, 30, 550, 38);

        jLabel11.setBackground(new java.awt.Color(0, 0, 102));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Churn");
        jLabel11.setOpaque(true);
        jPanel6.add(jLabel11);
        jLabel11.setBounds(300, 90, 130, 20);

        jLabel10.setBackground(new java.awt.Color(0, 0, 102));
        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reason");
        jLabel10.setOpaque(true);
        jPanel6.add(jLabel10);
        jLabel10.setBounds(430, 90, 130, 20);

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setOpaque(true);
        jPanel6.add(jLabel12);
        jLabel12.setBounds(430, 260, 2, 60);

        jLabel13.setBackground(new java.awt.Color(0, 0, 102));
        jLabel13.setOpaque(true);
        jPanel6.add(jLabel13);
        jLabel13.setBounds(430, 370, 2, 60);

        jLabel14.setBackground(new java.awt.Color(0, 0, 102));
        jLabel14.setOpaque(true);
        jPanel6.add(jLabel14);
        jLabel14.setBounds(430, 140, 2, 70);

        Reason.add(knnRadio_Reason);
        knnRadio_Reason.setSelected(true);
        knnRadio_Reason.setOpaque(false);
        jPanel6.add(knnRadio_Reason);
        knnRadio_Reason.setBounds(440, 120, 30, 21);

        knnRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(knnRadioBtn);
        knnRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        knnRadioBtn.setSelected(true);
        jPanel6.add(knnRadioBtn);
        knnRadioBtn.setBounds(300, 120, 21, 21);

        label_knn.setBackground(new java.awt.Color(51, 102, 255));
        label_knn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_knn.setForeground(new java.awt.Color(255, 255, 255));
        label_knn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_knn.setOpaque(true);
        jPanel6.add(label_knn);
        label_knn.setBounds(300, 120, 130, 109);

        Reason.add(rfRadio_Reason);
        rfRadio_Reason.setOpaque(false);
        jPanel6.add(rfRadio_Reason);
        rfRadio_Reason.setBounds(440, 240, 30, 21);

        randomForestRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(randomForestRadioBtn);
        randomForestRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel6.add(randomForestRadioBtn);
        randomForestRadioBtn.setBounds(300, 240, 21, 21);

        label_rf.setBackground(new java.awt.Color(51, 102, 255));
        label_rf.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_rf.setForeground(new java.awt.Color(255, 255, 255));
        label_rf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_rf.setOpaque(true);
        jPanel6.add(label_rf);
        label_rf.setBounds(300, 240, 130, 97);

        svmRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(svmRadioBtn);
        svmRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel6.add(svmRadioBtn);
        svmRadioBtn.setBounds(300, 350, 30, 21);

        Reason.add(svmRadio_Reason);
        svmRadio_Reason.setOpaque(false);
        jPanel6.add(svmRadio_Reason);
        svmRadio_Reason.setBounds(440, 350, 30, 21);

        label_svm.setBackground(new java.awt.Color(51, 102, 255));
        label_svm.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_svm.setForeground(new java.awt.Color(255, 255, 255));
        label_svm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_svm.setOpaque(true);
        jPanel6.add(label_svm);
        label_svm.setBounds(300, 350, 130, 101);

        label_knn_reason.setBackground(new java.awt.Color(51, 102, 255));
        label_knn_reason.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_knn_reason.setForeground(new java.awt.Color(255, 255, 255));
        label_knn_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_knn_reason.setOpaque(true);
        jPanel6.add(label_knn_reason);
        label_knn_reason.setBounds(430, 120, 130, 109);

        label_rf_reason.setBackground(new java.awt.Color(51, 102, 255));
        label_rf_reason.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_rf_reason.setForeground(new java.awt.Color(255, 255, 255));
        label_rf_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_rf_reason.setOpaque(true);
        jPanel6.add(label_rf_reason);
        label_rf_reason.setBounds(430, 240, 130, 97);

        label_svm_reason.setBackground(new java.awt.Color(51, 102, 255));
        label_svm_reason.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_svm_reason.setForeground(new java.awt.Color(255, 255, 255));
        label_svm_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_svm_reason.setOpaque(true);
        jPanel6.add(label_svm_reason);
        label_svm_reason.setBounds(430, 350, 130, 101);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html>A non-parametric method used for <br> classification where the input consists of <br> the k closest training examples in the <br> feature space</html>");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("K Nearest Neighbours");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(17, 17, 17))
        );

        jPanel6.add(jPanel2);
        jPanel2.setBounds(10, 120, 280, 112);

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<html>Random Forests are an ensemble learning <br> method for classification that operate by <br> constructing a multitude of decision trees</html>\n");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Random Forest");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel6.add(jPanel3);
        jPanel3.setBounds(10, 240, 280, 97);

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<html>A representation od the examples as <br> points in space, mapped so that the <br> examples of the seperate categories are <br> divided by a clear gap</html>\n");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Support Vector Machine");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel6.add(jPanel4);
        jPanel4.setBounds(10, 350, 280, 101);

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setLayout(null);

        submitBtn.setBackground(new java.awt.Color(255, 255, 255));
        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(0, 51, 255));
        submitBtn.setText("Predict");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel5.add(submitBtn);
        submitBtn.setBounds(460, 10, 81, 36);

        jPanel6.add(jPanel5);
        jPanel5.setBounds(10, 460, 550, 60);

        jScrollPane1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        panel_feature.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout panel_featureLayout = new javax.swing.GroupLayout(panel_feature);
        panel_feature.setLayout(panel_featureLayout);
        panel_featureLayout.setHorizontalGroup(
            panel_featureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        panel_featureLayout.setVerticalGroup(
            panel_featureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        panel_importance_churn.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout panel_importance_churnLayout = new javax.swing.GroupLayout(panel_importance_churn);
        panel_importance_churn.setLayout(panel_importance_churnLayout);
        panel_importance_churnLayout.setHorizontalGroup(
            panel_importance_churnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );
        panel_importance_churnLayout.setVerticalGroup(
            panel_importance_churnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_importance_reason.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout panel_importance_reasonLayout = new javax.swing.GroupLayout(panel_importance_reason);
        panel_importance_reason.setLayout(panel_importance_reasonLayout);
        panel_importance_reasonLayout.setHorizontalGroup(
            panel_importance_reasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );
        panel_importance_reasonLayout.setVerticalGroup(
            panel_importance_reasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_feature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_importance_churn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_importance_reason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_feature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_importance_churn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_importance_reason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(570, 80, 320, 440);

        jLabel9.setBackground(new java.awt.Color(0, 0, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Feature Importance");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(580, 30, 310, 20);

        BtnReason.setForeground(new java.awt.Color(255, 255, 255));
        BtnReason.setText("<html><p>Reason<small style=\\\"font-size:6px\\\">&nbsp;&nbsp;▲</small></p></html>");
        BtnReason.setBorder(null);
        BtnReason.setBorderPainted(false);
        BtnReason.setContentAreaFilled(false);
        BtnReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReasonActionPerformed(evt);
            }
        });
        jPanel6.add(BtnReason);
        BtnReason.setBounds(800, 60, 70, 20);

        BtnChurn.setForeground(new java.awt.Color(255, 255, 255));
        BtnChurn.setText("<html><p>Churn<small style=\\\"font-size:6px\\\">&nbsp;&nbsp;▼</small></p></html>");
        BtnChurn.setBorder(null);
        BtnChurn.setBorderPainted(false);
        BtnChurn.setContentAreaFilled(false);
        BtnChurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnChurnActionPerformed(evt);
            }
        });
        jPanel6.add(BtnChurn);
        BtnChurn.setBounds(720, 60, 60, 20);

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setOpaque(true);
        jPanel6.add(jLabel2);
        jLabel2.setBounds(0, 0, 920, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String path = etl.constants.StringConstants.PREDICTION_PATH;
        String path_reason = etl.constants.StringConstants.REASON_PATH;
        int algo_id_churn = 0;
        int algo_id_reason = 0;
        if(knnRadioBtn.isSelected()){
            algo_id_churn = 1;
        }
        else if(randomForestRadioBtn.isSelected()){
            algo_id_churn = 2;
        }
        else if(svmRadioBtn.isSelected()){
            algo_id_churn = 3;
        }
        if(knnRadio_Reason.isSelected()){
            algo_id_reason = 1;
        }
        else if(rfRadio_Reason.isSelected()){
            algo_id_reason = 2;
        }
        else if(svmRadio_Reason.isSelected()){
            algo_id_reason = 3;
        }
        Process p, p_reason;
        try {
            p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Prediction_bat.bat " + algo_id_churn);
            p.waitFor();
            p_reason = Runtime.getRuntime().exec("cmd /c start /wait " + path_reason + "/Prediction_bat.bat " + algo_id_reason);
            p_reason.waitFor();
            if(algo_id_churn == 2){
                Process p_importance;
                p_importance = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Feature_Importance.py");
                p_importance.waitFor();
            }
            dispose();
            new AlgorithmSelectionPredict().setVisible(true);
            //System.out.println(i);
            //JOptionPane.showMessageDialog(null, "Done!! database updated!!");
        } catch (IOException ex) {
            Logger.getLogger(AlgorithmSelectionPredict.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AlgorithmSelectionPredict.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    /*
    * @Method formWindowClosing 
    * Prevent closing system and display home page
    * @param  WindowEvent
    */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        /*if (JOptionPane.showConfirmDialog(this, 
            StringConstants.CLOSE_WINDOW_QUESTION, StringConstants.CLOSE_WINDOW, 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                dispose();
                new HomeView().setVisible(true);
        }*/
        CustomConfirmDialog dialog = new CustomConfirmDialog(this, new HomeView(), 
                StringConstants.CLOSE_WINDOW, StringConstants.CLOSE_WINDOW_QUESTION);
        // set the size of the window
        dialog.setSize(300, 150);
    }//GEN-LAST:event_formWindowClosing

    private void BtnChurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnChurnActionPerformed
        
        panel_feature.removeAll();
        panel_importance_churn.removeAll();
        panel_importance_reason.removeAll();
        
        BtnChurn.setText("<html><p>Churn<small style=\"font-size:6px\">&nbsp;&nbsp;▼</small></p></html>");
        BtnReason.setText("<html><p>Reason<small style=\"font-size:6px\">&nbsp;&nbsp;▲</small></p></html>");
        
        List<String> features = new ArrayList<String>();
        features = dbAccess.getFeature("feature_importance_churn","Importance_Churn","DESC","Feature");
        
        JLabel[] labels_feature=new JLabel[features.size()];
        for(int i = 0; i < features.size(); i++){
            labels_feature[i] = new JLabel(features.get(i), JLabel.LEFT);
            labels_feature[i].setForeground(Color.WHITE);
            labels_feature[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_feature.add(labels_feature[i]);
        }
        panel_feature.revalidate();
        panel_feature.repaint();
        
        List<Float> importance_churn = new ArrayList<Float>();
        importance_churn = dbAccess.getImportance("feature_importance_churn","Importance_Churn","DESC","Importance_Churn");
        
        JLabel[] labels_importance_churn=new JLabel[importance_churn.size()];
        for(int i = 0; i < importance_churn.size(); i++){
            labels_importance_churn[i] = new JLabel(importance_churn.get(i) + "%", JLabel.LEFT);
            labels_importance_churn[i].setForeground(Color.WHITE);
            labels_importance_churn[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_importance_churn.add(labels_importance_churn[i]);
        }
        panel_importance_churn.revalidate();
        panel_importance_churn.repaint();
        
        List<Float> importance_reason = new ArrayList<Float>();
        importance_reason = dbAccess.getImportance("feature_importance_churn","Importance_Churn","DESC","Importance_Reason");
        
        JLabel[] labels_importance_reason=new JLabel[importance_reason.size()];
        for(int i = 0; i < importance_reason.size(); i++){
            labels_importance_reason[i] = new JLabel(importance_reason.get(i) + "%", JLabel.LEFT);
            labels_importance_reason[i].setForeground(Color.WHITE);
            labels_importance_reason[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_importance_reason.add(labels_importance_reason[i]);
        }
        panel_importance_reason.revalidate();
        panel_importance_reason.repaint();
    }//GEN-LAST:event_BtnChurnActionPerformed

    private void BtnReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReasonActionPerformed
        panel_feature.removeAll();
        panel_importance_reason.removeAll();
        panel_importance_churn.removeAll();
        
        BtnChurn.setText("<html><p>Churn<small style=\"font-size:6px\">&nbsp;&nbsp;▲</small></p></html>");
        BtnReason.setText("<html><p>Reason<small style=\"font-size:6px\">&nbsp;&nbsp;▼</small></p></html>");
        
        List<String> features = new ArrayList<String>();
        features = dbAccess.getFeature("feature_importance_churn","Importance_Reason","DESC","Feature");
        
        JLabel[] labels_feature=new JLabel[features.size()];
        for(int i = 0; i < features.size(); i++){
            labels_feature[i] = new JLabel(features.get(i), JLabel.LEFT);
            labels_feature[i].setForeground(Color.WHITE);
            labels_feature[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_feature.add(labels_feature[i]);
        }
        panel_feature.revalidate();
        panel_feature.repaint();
        
        List<Float> importance_reason = new ArrayList<Float>();
        importance_reason = dbAccess.getImportance("feature_importance_churn","Importance_Reason","DESC","Importance_Reason");
        
        JLabel[] labels_importance_reason=new JLabel[importance_reason.size()];
        for(int i = 0; i < importance_reason.size(); i++){
            labels_importance_reason[i] = new JLabel(importance_reason.get(i) + "%", JLabel.LEFT);
            labels_importance_reason[i].setForeground(Color.WHITE);
            labels_importance_reason[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_importance_reason.add(labels_importance_reason[i]);
        }
        panel_importance_reason.revalidate();
        panel_importance_reason.repaint();
        
        List<Float> importance_churn = new ArrayList<Float>();
        importance_churn = dbAccess.getImportance("feature_importance_churn","Importance_Reason","DESC","Importance_Churn");
        
        JLabel[] labels_importance_churn=new JLabel[importance_churn.size()];
        for(int i = 0; i < importance_churn.size(); i++){
            labels_importance_churn[i] = new JLabel(importance_churn.get(i) + "%", JLabel.LEFT);
            labels_importance_churn[i].setForeground(Color.WHITE);
            labels_importance_churn[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            panel_importance_churn.add(labels_importance_churn[i]);
        }
        panel_importance_churn.revalidate();
        panel_importance_churn.repaint();
    }//GEN-LAST:event_BtnReasonActionPerformed

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
            java.util.logging.Logger.getLogger(AlgorithmSelectionPredict.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlgorithmSelectionPredict.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlgorithmSelectionPredict.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlgorithmSelectionPredict.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlgorithmSelectionPredict().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnChurn;
    private javax.swing.JButton BtnReason;
    private javax.swing.ButtonGroup Reason;
    private javax.swing.ButtonGroup algorithm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton knnRadioBtn;
    private javax.swing.JRadioButton knnRadio_Reason;
    private javax.swing.JLabel label_knn;
    private javax.swing.JLabel label_knn_reason;
    private javax.swing.JLabel label_rf;
    private javax.swing.JLabel label_rf_reason;
    private javax.swing.JLabel label_svm;
    private javax.swing.JLabel label_svm_reason;
    private javax.swing.JPanel panel_feature;
    private javax.swing.JPanel panel_importance_churn;
    private javax.swing.JPanel panel_importance_reason;
    private javax.swing.JRadioButton randomForestRadioBtn;
    private javax.swing.JRadioButton rfRadio_Reason;
    private javax.swing.JButton submitBtn;
    private javax.swing.JRadioButton svmRadioBtn;
    private javax.swing.JRadioButton svmRadio_Reason;
    // End of variables declaration//GEN-END:variables
}
