/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.commonViews.HomeView;
import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.controllers.CustomConfirmDialog;
import etl.db.DBAccess;
import etl.dictionary.SynonymDictionary;
import etl.models.attribute;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author suren
 */
public class AttributeMapper_Predict extends javax.swing.JFrame {

    /**
     * Creates new form AttributeMapper
     */
    //All declared variables
    private final String filePath;
    private final String[] header;
    private List<attribute> attributes;
    private List<JComboBox> comboBoxes;
    public AttributeMapper_Predict(String selectedFilePath,  
            String[] headers) {
        initComponents();
        
        setWindowIcon();
                
        this.filePath = selectedFilePath;
        this.header = headers;                
        setAttributeMappers();   
    }
    
    /*
    * @Method setAttributeMappers 
    * Display Comboboxes in layout dynamically
    */
    private void setAttributeMappers(){
        attributes = new ArrayList<>();
        comboBoxes = new ArrayList<>();
        //mainPanel1.setLayout(null);
        
        int labelXpos = 25;
        int labelYpos = -30;
        int labelWidth = 120;
        int labelHeight = 30;
        
        int comboxBoxXpos = 140;
        int comboxBoxYpos = -30;
        int comboxBoxWidth = 200;
        int comboxBoxHeight = 30;
        
        int midGapX = 10;
        int midGapY = 12;       
        
        //mainPanel.setLayout(new GridLayout((StringConstants.ATTRIBUTES_PREDICT.length / 2)+1, 4));
        //mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        SynonymDictionary dictionary = new SynonymDictionary();
        for(int i=NumberConstants.ZERO;
                i<StringConstants.ATTRIBUTES_PREDICT.length;i++){
            //Create Attribute
            String attrName = StringConstants.ATTRIBUTES_PREDICT[i];
            attribute attribute = new attribute(attrName);
            attribute.setRules(StringConstants.RULES_LIST.get(attrName));
            attributes.add(attribute);
            
            JLabel attrLable = new JLabel(attrName);
            Font boldFont = new Font(attrLable.getFont().getName(),Font.BOLD,attrLable.getFont().getSize());
            
            attrLable.setFont(boldFont);
            attrLable.setForeground(Color.WHITE);
            JComboBox attrComBox = new JComboBox();
            //Left Side
            if(i%2 != 1){
                labelXpos = 25;
                comboxBoxXpos = 140;
                
                labelYpos = labelYpos + labelHeight + midGapY ;
                comboxBoxYpos = comboxBoxYpos + comboxBoxHeight + midGapY ;
            } else { //Right side
                labelXpos = comboxBoxXpos + comboxBoxWidth + midGapX;
                comboxBoxXpos = labelXpos + labelWidth + midGapX;    
            }
            mainPanelOut.add(attrLable);
            mainPanelOut.add(attrComBox);

            attrLable.setLocation(labelXpos, labelYpos);
            attrComBox.setLocation(comboxBoxXpos, comboxBoxYpos);

            attrLable.setSize(labelWidth, labelHeight);
            attrComBox.setSize(comboxBoxWidth, comboxBoxHeight);
            
            DefaultComboBoxModel<String> comboBoxModel 
                = new DefaultComboBoxModel<>(header);
            attrComBox.setModel(comboBoxModel);
            
            //Automate dropdown selection
            attrComBox.setSelectedIndex(dictionary.getIndex(attrName, header));
            comboBoxes.add(attrComBox);
        }
         
        /*DBAccess dbAccess = new DBAccess();
        List<String> features = new ArrayList<String>();
        features = dbAccess.getFeature("feature_importance_churn","Importance_Churn","DESC","Feature");
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel[] labels_feature=new JLabel[features.size()];
        for(int i = 0; i < features.size(); i++){
            labels_feature[i] = new JLabel(features.get(i), JLabel.LEFT);
            labels_feature[i].setForeground(Color.WHITE);
            labels_feature[i].setBorder(new EmptyBorder(4, 4, 4, 4));
            mainPanel.add(labels_feature[i]);
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

        jPanel1 = new javax.swing.JPanel();
        defineRulesBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainPanelOut = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpSense - Attribute Mapper (IT Industry)");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        defineRulesBtn.setBackground(new java.awt.Color(255, 255, 255));
        defineRulesBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        defineRulesBtn.setForeground(new java.awt.Color(0, 51, 255));
        defineRulesBtn.setText("Define Rules");
        defineRulesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defineRulesBtnActionPerformed(evt);
            }
        });
        jPanel1.add(defineRulesBtn);
        defineRulesBtn.setBounds(610, 450, 157, 30);

        jLabel10.setBackground(new java.awt.Color(51, 102, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 440, 760, 50);

        jLabel16.setBackground(new java.awt.Color(51, 102, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Map Attributes with Dataset");
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 20, 760, 50);

        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanelOut.setBackground(new java.awt.Color(0, 0, 102));
        mainPanelOut.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelOutLayout = new javax.swing.GroupLayout(mainPanelOut);
        mainPanelOut.setLayout(mainPanelOutLayout);
        mainPanelOutLayout.setHorizontalGroup(
            mainPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );
        mainPanelOutLayout.setVerticalGroup(
            mainPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(mainPanelOut);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 80, 760, 350);

        jLabel14.setBackground(new java.awt.Color(0, 0, 102));
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 800, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    * @Method defineRulesBtnActionPerformed
    * Get mapped attribtes and pass them to the DefineRules window
    * @param  Action Event
    */
    private void defineRulesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defineRulesBtnActionPerformed
        //set mapped attribute with defined attribute
        int noOfAttr = comboBoxes.size();
        for (int i = NumberConstants.ZERO;
            i < noOfAttr ; i++){
            attribute attribute = attributes.remove(i);
            attribute.setRules(StringConstants.RULES_LIST.get(attribute.getAttrName()));
            String mappedAttr = comboBoxes.get(i).getSelectedItem().toString();
            attribute.setMatchingField(mappedAttr);
            attributes.add(i,attribute);            
        }
        dispose();
        new DefineRules(attributes, filePath, NumberConstants.PREDICT_DATA).setVisible(true);
    }//GEN-LAST:event_defineRulesBtnActionPerformed

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
    private javax.swing.JButton defineRulesBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanelOut;
    // End of variables declaration//GEN-END:variables
}
