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
        
        List<Float> accuracy = new ArrayList<Float>();
        accuracy = dbAccess.getAccuracy();
        System.out.println(accuracy);
        
        label_knn.setText(accuracy.get(0) * 100 + "%");
        label_rf.setText(accuracy.get(1) *100 + "%");
        label_svm.setText(accuracy.get(2) *100 + "%");
        
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
        label_svm = new javax.swing.JLabel();
        label_rf = new javax.swing.JLabel();
        label_knn = new javax.swing.JLabel();
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
        setPreferredSize(new java.awt.Dimension(466, 525));
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
        jLabel1.setBounds(10, 20, 430, 38);

        label_svm.setBackground(new java.awt.Color(51, 102, 255));
        label_svm.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_svm.setForeground(new java.awt.Color(255, 255, 255));
        label_svm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_svm.setOpaque(true);
        jPanel6.add(label_svm);
        label_svm.setBounds(300, 300, 130, 100);

        label_rf.setBackground(new java.awt.Color(51, 102, 255));
        label_rf.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_rf.setForeground(new java.awt.Color(255, 255, 255));
        label_rf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_rf.setOpaque(true);
        jPanel6.add(label_rf);
        label_rf.setBounds(300, 190, 130, 100);

        label_knn.setBackground(new java.awt.Color(51, 102, 255));
        label_knn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        label_knn.setForeground(new java.awt.Color(255, 255, 255));
        label_knn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_knn.setOpaque(true);
        jPanel6.add(label_knn);
        label_knn.setBounds(300, 70, 130, 110);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html>A non-parametric method used for <br> classification where the input consists of <br> the k closest training examples in the <br> feature space</html>");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(40, 110, 241, 60);

        knnRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(knnRadioBtn);
        knnRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        knnRadioBtn.setSelected(true);
        knnRadioBtn.setText("K Nearest Neighbours");
        jPanel6.add(knnRadioBtn);
        knnRadioBtn.setBounds(40, 80, 177, 25);

        jLabel9.setBackground(new java.awt.Color(51, 102, 255));
        jLabel9.setOpaque(true);
        jPanel6.add(jLabel9);
        jLabel9.setBounds(20, 70, 270, 110);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<html>Random Forests are an ensemble learning <br> method for classification that operate by <br> constructing a multitude of decision trees</html>\n");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(40, 230, 247, 49);

        randomForestRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(randomForestRadioBtn);
        randomForestRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        randomForestRadioBtn.setText("Random Forest");
        jPanel6.add(randomForestRadioBtn);
        randomForestRadioBtn.setBounds(40, 200, 131, 25);

        jLabel7.setBackground(new java.awt.Color(51, 102, 255));
        jLabel7.setOpaque(true);
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 190, 270, 100);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<html>A representation od the examples as <br> points in space, mapped so that the <br> examples of the seperate categories are <br> divided by a clear gap</html>\n");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(40, 340, 247, 56);

        svmRadioBtn.setBackground(new java.awt.Color(51, 102, 255));
        algorithm.add(svmRadioBtn);
        svmRadioBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        svmRadioBtn.setText("Support Vector Machine");
        jPanel6.add(svmRadioBtn);
        svmRadioBtn.setBounds(40, 310, 193, 25);

        jLabel8.setBackground(new java.awt.Color(51, 102, 255));
        jLabel8.setOpaque(true);
        jPanel6.add(jLabel8);
        jLabel8.setBounds(20, 300, 270, 100);

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
        submitBtn.setBounds(330, 420, 90, 40);

        jLabel6.setBackground(new java.awt.Color(51, 102, 255));
        jLabel6.setOpaque(true);
        jPanel6.add(jLabel6);
        jLabel6.setBounds(10, 410, 430, 60);

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setOpaque(true);
        jPanel6.add(jLabel2);
        jLabel2.setBounds(0, 0, 450, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String path = "D:/SLIIT/SoftwareIndustry";
        if(knnRadioBtn.isSelected()){
                Process p;
                try {
                    p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Prediction_KNN.py");
                    int i = p.waitFor();
                    System.out.println(i);
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
                    p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Prediction_RF.py");
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
                    p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "/Prediction_SVM.py");
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
    private javax.swing.JLabel label_rf;
    private javax.swing.JLabel label_svm;
    private javax.swing.JRadioButton randomForestRadioBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JRadioButton svmRadioBtn;
    // End of variables declaration//GEN-END:variables
}
