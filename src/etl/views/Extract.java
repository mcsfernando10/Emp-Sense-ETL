/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.constants.StringConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author suren
 */
public class Extract extends javax.swing.JFrame {

    //All declared variables
    private String selectedIndustry;
    private String selectedFileType;
    private String selectedFilePath;
    private JFileChooser sourceFileChooser;
    
    /**
     * Creates new form Extract
     */
    public Extract() {
        initComponents();
        
        selectedIndustry = StringConstants.IT;
        selectedFileType = StringConstants.CSV_EXTENSION;
        selectedFilePath = StringConstants.EMPTY_STRING;
        sourceFileChooser = new JFileChooser();
        
        //Set the selected industry
        //itRadioBtn.setSelected(true);
        
        setWindowIcon(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        industry = new javax.swing.ButtonGroup();
        fileType = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        extractBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        browseBtn = new javax.swing.JButton();
        filePathTxt = new javax.swing.JTextField();
        fileTypeComBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpSense - Extract Data (IT Industry)");
        setBackground(new java.awt.Color(254, 254, 254));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Select the file type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Source File");

        extractBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        extractBtn.setText("Extract");
        extractBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        browseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        filePathTxt.setEditable(false);

        fileTypeComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSV", "XML", "Excel", "JSON", "SQL" }));
        fileTypeComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileTypeComBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Extract Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileTypeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filePathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(extractBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelBtn)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fileTypeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(filePathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extractBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(20, Short.MAX_VALUE))
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
    * @Method extractBtnActionPerformed 
    * Execute if user clicks on Extract Button
    * Check whether user selected a source file or not
    * Check whether user enter a table name if use default name option unchecked
    * If validation completed:Close the current window and open Data View window
    * @param  Action Event
    */
    private void extractBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractBtnActionPerformed
        if(selectedFilePath.equals(StringConstants.EMPTY_STRING)){
            JOptionPane.showMessageDialog(null, StringConstants.PLEASE_SELECT_FILE);
        } 
        /*else if(!defaultNameCKBox.isSelected() && 
                newTableNameTxt.getText().equals(StringConstants.EMPTY_STRING)) {
            JOptionPane.showMessageDialog(null, 
                    StringConstants.PLEASE_ENTER_TABLENAME);
        }*/
        else{
            dispose();
            new DataView(selectedFilePath, selectedFileType).setVisible(true);
        }        
    }//GEN-LAST:event_extractBtnActionPerformed

    /*
    * @Method browseBtnActionPerformed 
    * Execute if user clicks on Browser Button
    * Set the selected file type and open JFileChooser
    * @param  Action Event
    */
    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        //set the file types
        FileNameExtensionFilter fileFilter = new 
                    FileNameExtensionFilter(selectedFileType, selectedFileType);
        sourceFileChooser.setFileFilter(fileFilter);        
        int result = sourceFileChooser.showOpenDialog(this);
        //Detect user click on Open or Cancel Button of JFilePicker
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFilePath = sourceFileChooser.getSelectedFile().getAbsolutePath();
            filePathTxt.setText(selectedFilePath);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
        }
    }//GEN-LAST:event_browseBtnActionPerformed

    /*
    * @Method cancelBtnActionPerformed 
    * Execute if user clicks on Cancel Button
    * Close the current window
    * @param  Action Event
    */
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        dispose();              
    }//GEN-LAST:event_cancelBtnActionPerformed

    /*
    * @Method fileTypeComBoxActionPerformed 
    * Execute if user clicks on Combobox
    * Set the selected file type accordingly and reset the selected file if any
    * @param  Action Event
    */
    private void fileTypeComBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileTypeComBoxActionPerformed
        JComboBox comboBox = (JComboBox) evt.getSource();

        Object selected = comboBox.getSelectedItem();
        switch (selected.toString()){
            case StringConstants.CSV_CAPITAL:
                //Set the selected file type
                resetSelectedSourceFile(StringConstants.CSV_EXTENSION);           
                break;
            case StringConstants.XML_CAPITAL:
                //Set the selected file type
                resetSelectedSourceFile(StringConstants.XML_EXTENSION);               
                break;
            case StringConstants.EXCEL_NORMAL:
                //Set the selected file type
                resetSelectedSourceFile(StringConstants.EXCEL_EXTENSION);
                break;    
            case StringConstants.JSON_CAPITAL:
                //Set the selected file type
                resetSelectedSourceFile(StringConstants.JSON_EXTENSION);
                break;     
            case StringConstants.SQL_CAPITAL:
                //Set the selected file type
                resetSelectedSourceFile(StringConstants.SQL_EXTENSION);             
                break;   
        }
    }//GEN-LAST:event_fileTypeComBoxActionPerformed

    /*
    * @Method resetSelectedSourceFile 
    * Reset the selected file if any asking user confirmation
    * @param  String fileType
    */
    private void resetSelectedSourceFile(String fileType){
        //Check whether the file is selected 
        if(!selectedFilePath.equals(StringConstants.EMPTY_STRING)){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, 
                    StringConstants.REMOVE_FILE,
                    StringConstants.WARNING,dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                //Set the file type
                selectedFileType = fileType;
                //Reset the selected file variable
                selectedFilePath = StringConstants.EMPTY_STRING;
                //Reset the file path visible text box
                filePathTxt.setText(selectedFilePath);
                //Reset the jfilechooser's selected file
                sourceFileChooser = new JFileChooser();
            } 
            else {
                //Reset the dropdown to select the previously selected file type
                switch (selectedFileType){
                    case StringConstants.CSV_EXTENSION:
                        //Set the selected file type
                        fileTypeComBox.setSelectedItem(StringConstants.CSV_CAPITAL);          
                        break;
                    case StringConstants.XML_EXTENSION:
                        //Set the selected file type
                        fileTypeComBox.setSelectedItem(StringConstants.XML_CAPITAL);              
                        break;
                    case StringConstants.EXCEL_EXTENSION:
                        //Set the selected file type
                        fileTypeComBox.setSelectedItem(StringConstants.EXCEL_NORMAL);
                        break;    
                    case StringConstants.JSON_EXTENSION:
                        //Set the selected file type
                        fileTypeComBox.setSelectedItem(StringConstants.JSON_CAPITAL);
                        break;     
                    case StringConstants.SQL_EXTENSION:
                        //Set the selected file type
                        fileTypeComBox.setSelectedItem(StringConstants.SQL_CAPITAL);            
                        break;   
                }
            }
        }
        else {
            //set the file type
            selectedFileType = fileType;
        }
    }
    
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
                new Extract().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton extractBtn;
    private javax.swing.JTextField filePathTxt;
    private javax.swing.ButtonGroup fileType;
    private javax.swing.JComboBox<String> fileTypeComBox;
    private javax.swing.ButtonGroup industry;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
