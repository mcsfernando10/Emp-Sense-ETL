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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author suren
 */
public class AlgorithmSelectionTrain extends javax.swing.JFrame {

    /**
     * Creates new form AlgorithmSelectionTrain
     */
    private DBAccess dbAccess;
    public AlgorithmSelectionTrain() {
        initComponents();
        setWindowIcon();        
        dbAccess = new DBAccess();
        
        List<Float> accuracy_churn = new ArrayList<Float>();
        accuracy_churn = dbAccess.getAccuracyForChurn();
        
        label_knn.setText(accuracy_churn.get(0) * 100 + "%");
        label_rf.setText(accuracy_churn.get(1) *100 + "%");
        label_svm.setText(accuracy_churn.get(2) *100 + "%");
        
        List<Float> accuracy_reason = new ArrayList<Float>();
        accuracy_reason = dbAccess.getAccuracyForReason();
        
        label_knn_reason.setText(accuracy_reason.get(0) * 100 + "%");
        label_rf_reason.setText(accuracy_reason.get(1) *100 + "%");
        label_svm_reason.setText(accuracy_reason.get(2) *100 + "%");
        
        /*FileReader selectedFile = null;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        try {
            initComponents();
            setWindowIcon();
            selectedFile = new FileReader("src/etl/outputs/accuracy.csv");
            CSVReader reader = new CSVReader(selectedFile);
            // if the first line is the header
            label_knn.setText(df.format(Float.parseFloat(reader.readNext()[1])*100) + "%");
            label_rf.setText(df.format(Float.parseFloat(reader.readNext()[1])*100) + "%");
            label_svm.setText("53%");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                selectedFile.close();
            } catch (IOException ex) {
                Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
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
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        label_svm = new javax.swing.JLabel();
        label_svm_reason = new javax.swing.JLabel();
        label_rf = new javax.swing.JLabel();
        label_rf_reason = new javax.swing.JLabel();
        label_knn = new javax.swing.JLabel();
        label_knn_reason = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        knnRadioBtn = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        randomForestRadioBtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        svmRadioBtn = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select the Algorithm");
        setPreferredSize(new java.awt.Dimension(585, 550));
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
        jLabel1.setBounds(10, 20, 560, 38);

        jLabel10.setBackground(new java.awt.Color(51, 102, 255));
        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reason");
        jLabel10.setOpaque(true);
        jPanel6.add(jLabel10);
        jLabel10.setBounds(430, 70, 130, 20);

        jLabel11.setBackground(new java.awt.Color(51, 102, 255));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Churn");
        jLabel11.setOpaque(true);
        jPanel6.add(jLabel11);
        jLabel11.setBounds(300, 70, 130, 20);

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setOpaque(true);
        jPanel6.add(jLabel12);
        jLabel12.setBounds(432, 120, 2, 70);

        jLabel13.setBackground(new java.awt.Color(0, 0, 102));
        jLabel13.setOpaque(true);
        jPanel6.add(jLabel13);
        jLabel13.setBounds(430, 350, 2, 60);

        jLabel14.setBackground(new java.awt.Color(0, 0, 102));
        jLabel14.setOpaque(true);
        jPanel6.add(jLabel14);
        jLabel14.setBounds(430, 240, 2, 60);

        label_svm.setBackground(new java.awt.Color(51, 102, 255));
        label_svm.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_svm.setForeground(new java.awt.Color(255, 255, 255));
        label_svm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_svm.setOpaque(true);
        jPanel6.add(label_svm);
        label_svm.setBounds(300, 330, 130, 100);

        label_svm_reason.setBackground(new java.awt.Color(51, 102, 255));
        label_svm_reason.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_svm_reason.setForeground(new java.awt.Color(255, 255, 255));
        label_svm_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_svm_reason.setOpaque(true);
        jPanel6.add(label_svm_reason);
        label_svm_reason.setBounds(430, 330, 130, 100);

        label_rf.setBackground(new java.awt.Color(51, 102, 255));
        label_rf.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_rf.setForeground(new java.awt.Color(255, 255, 255));
        label_rf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_rf.setOpaque(true);
        jPanel6.add(label_rf);
        label_rf.setBounds(300, 220, 130, 100);

        label_rf_reason.setBackground(new java.awt.Color(51, 102, 255));
        label_rf_reason.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_rf_reason.setForeground(new java.awt.Color(255, 255, 255));
        label_rf_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_rf_reason.setOpaque(true);
        jPanel6.add(label_rf_reason);
        label_rf_reason.setBounds(430, 220, 130, 100);

        label_knn.setBackground(new java.awt.Color(51, 102, 255));
        label_knn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_knn.setForeground(new java.awt.Color(255, 255, 255));
        label_knn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_knn.setOpaque(true);
        jPanel6.add(label_knn);
        label_knn.setBounds(300, 100, 130, 110);

        label_knn_reason.setBackground(new java.awt.Color(51, 102, 255));
        label_knn_reason.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_knn_reason.setForeground(new java.awt.Color(255, 255, 255));
        label_knn_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_knn_reason.setOpaque(true);
        jPanel6.add(label_knn_reason);
        label_knn_reason.setBounds(430, 100, 130, 110);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html>A non-parametric method used for <br> classification where the input consists of <br> the k closest training examples in the <br> feature space</html>");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(40, 140, 241, 60);

        knnRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(knnRadioBtn);
        knnRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        knnRadioBtn.setSelected(true);
        knnRadioBtn.setText("K Nearest Neighbours");
        jPanel6.add(knnRadioBtn);
        knnRadioBtn.setBounds(40, 110, 177, 25);

        jLabel9.setBackground(new java.awt.Color(51, 102, 255));
        jLabel9.setOpaque(true);
        jPanel6.add(jLabel9);
        jLabel9.setBounds(20, 100, 270, 110);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<html>Random Forests are an ensemble learning <br> method for classification that operate by <br> constructing a multitude of decision trees</html>\n");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(40, 260, 247, 49);

        randomForestRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(randomForestRadioBtn);
        randomForestRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        randomForestRadioBtn.setText("Random Forest");
        jPanel6.add(randomForestRadioBtn);
        randomForestRadioBtn.setBounds(40, 230, 131, 25);

        jLabel7.setBackground(new java.awt.Color(51, 102, 255));
        jLabel7.setOpaque(true);
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 220, 270, 100);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<html>A representation od the examples as <br> points in space, mapped so that the <br> examples of the seperate categories are <br> divided by a clear gap</html>\n");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(40, 370, 247, 56);

        svmRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(svmRadioBtn);
        svmRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        svmRadioBtn.setText("Support Vector Machine");
        jPanel6.add(svmRadioBtn);
        svmRadioBtn.setBounds(40, 340, 193, 25);

        jLabel8.setBackground(new java.awt.Color(51, 102, 255));
        jLabel8.setOpaque(true);
        jPanel6.add(jLabel8);
        jLabel8.setBounds(20, 330, 270, 100);

        submitBtn.setBackground(new java.awt.Color(255, 255, 255));
        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(0, 51, 255));
        submitBtn.setText("Train");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel6.add(submitBtn);
        submitBtn.setBounds(460, 450, 90, 40);

        jLabel6.setBackground(new java.awt.Color(51, 102, 255));
        jLabel6.setOpaque(true);
        jPanel6.add(jLabel6);
        jLabel6.setBounds(10, 440, 560, 60);

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setOpaque(true);
        jPanel6.add(jLabel2);
        jLabel2.setBounds(0, 0, 590, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String path = "D:/SLIIT/SoftwareIndustry";
        String path_reason = "D:/SLIIT/ITIndustry/Reason";
            
        if(knnRadioBtn.isSelected()){
            Process p, p_reason;
            try {
                p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Train_KNN_bat.bat");
                p.waitFor();
                p_reason = Runtime.getRuntime().exec("cmd /c start /wait " + path_reason + "/Train_KNN_bat.bat");
                p_reason.waitFor();
                //System.out.println(i);
                //JOptionPane.showMessageDialog(null, "Done!! database updated!!");
            } catch (IOException ex) {
                Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        if(randomForestRadioBtn.isSelected()){
            Process p;
                try {
                    p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Prediction_RF.bat");
                    int i = p.waitFor();
                    System.out.println(i);
                    //JOptionPane.showMessageDialog(null, "Done!! database updated!!");
                } catch (IOException ex) {
                    Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if(svmRadioBtn.isSelected()){
            Process p;
                try {
                    p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Prediction_SVM.bat");
                    int i = p.waitFor();
                    System.out.println(i);
                    //JOptionPane.showMessageDialog(null, "Done!! database updated!!");
                } catch (IOException ex) {
                    Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            java.util.logging.Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlgorithmSelectionTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlgorithmSelectionTrain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton knnRadioBtn;
    private javax.swing.JLabel label_knn;
    private javax.swing.JLabel label_knn_reason;
    private javax.swing.JLabel label_rf;
    private javax.swing.JLabel label_rf_reason;
    private javax.swing.JLabel label_svm;
    private javax.swing.JLabel label_svm_reason;
    private javax.swing.JRadioButton randomForestRadioBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JRadioButton svmRadioBtn;
    // End of variables declaration//GEN-END:variables
}
