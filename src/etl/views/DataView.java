/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.commonViews.HomeView;
import etl.constants.StringConstants;
import etl.controllers.CreateSelectDBTableDialog;
import etl.controllers.CustomConfirmDialog;
import etl.readers.ReadCSV;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author suren
 */
public class DataView extends javax.swing.JFrame {

    /**
     * Creates new form DataView
     */
    //All declared variables
    private final String filePath;
    
    //Readers
    private final ReadCSV csvReader;
    
    private String[] headers;
    public DataView(String selectedFilePath) {
        initComponents();
        
        setWindowIcon();
                
        this.filePath = selectedFilePath;
        csvReader = new ReadCSV();
        ReadCSV.selectedFilePath = filePath;
        ReadCSV.tableView = dataTableView;
        ReadCSV.jLableProgress = progressLable;
        ReadCSV.extractBtn = mapAttrBtn;
        csvReader.start();                
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
        mapAttrBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTableView = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        progressLable = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpSense - Data View (IT Industry)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setLayout(null);

        mapAttrBtn.setBackground(new java.awt.Color(255, 255, 255));
        mapAttrBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mapAttrBtn.setForeground(new java.awt.Color(0, 51, 255));
        mapAttrBtn.setText("Map Attributes");
        mapAttrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapAttrBtnActionPerformed(evt);
            }
        });
        jPanel2.add(mapAttrBtn);
        mapAttrBtn.setBounds(840, 570, 150, 30);

        jLabel3.setBackground(new java.awt.Color(51, 102, 255));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 560, 980, 50);

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setDoubleBuffered(true);

        dataTableView.setAutoCreateRowSorter(true);
        dataTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataTableView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dataTableView.setDragEnabled(true);
        dataTableView.setEnabled(false);
        dataTableView.setName(""); // NOI18N
        dataTableView.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(dataTableView);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 960, 450);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("View of Selected Data");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 20, 197, 40);

        progressLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        progressLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/progress.gif"))); // NOI18N
        progressLable.setText("Loading Table......");
        progressLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(progressLable);
        progressLable.setBounds(300, 20, 280, 40);

        jLabel5.setBackground(new java.awt.Color(51, 102, 255));
        jLabel5.setOpaque(true);
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 80, 980, 470);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/bg_2.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(280, 20, 700, 40);

        jLabel6.setBackground(new java.awt.Color(51, 102, 255));
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 10, 980, 60);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 980, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    * Get selected attribtes and send them to next window : AttributeMapper
    * @param  ActionEvent
    */
    private void mapAttrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapAttrBtnActionPerformed
        //To get headers string array to bind in jcombobox
        headers = csvReader.getCheckBoxes();
        
        //Select DB Table - Predict or Train Database
        CreateSelectDBTableDialog selectDBTable = new CreateSelectDBTableDialog(this,headers);
        selectDBTable.setSize(300, 150); 
    }//GEN-LAST:event_mapAttrBtnActionPerformed

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
        } */
        CustomConfirmDialog dialog = new CustomConfirmDialog(this, new HomeView(), 
                StringConstants.CLOSE_WINDOW, StringConstants.CLOSE_WINDOW_QUESTION);
        // set the size of the window
        dialog.setSize(300, 150);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTableView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mapAttrBtn;
    private javax.swing.JLabel progressLable;
    // End of variables declaration//GEN-END:variables
}
