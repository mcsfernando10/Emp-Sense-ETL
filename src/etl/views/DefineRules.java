/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import com.google.gson.Gson;
import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.controllers.CreateCleansedCSV;
import etl.controllers.CreatingDBDialog;
import etl.models.attribute;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author suren
 */
public class DefineRules extends javax.swing.JFrame {

    /**
     * Creates new form DefineRules
     */
    //All declared variables
    private final List<attribute> attributes;
    private DefaultListModel model;
    private String filePath;
    private String fileType;
    public DefineRules(
            List<attribute> passedAttributes, 
            String selFilePath,
            String selFileType
    ) {
        initComponents();
        
        setWindowIcon();
                
        this.attributes = passedAttributes;
        this.filePath = selFilePath;
        this.fileType = selFileType;
        //attributes = new ArrayList<>();
        
        //Generate attribute Selection List
        model = new DefaultListModel();
        for (attribute curAttr : attributes) {
            model.addElement(curAttr.getAttrName());
        }
        attributeList.setModel(model);
        
        /*
        ListModel<String> listModel = attributeList.getModel();
        for (int i = NumberConstants.ZERO; i < listModel.getSize(); i++) {
            attributes.add((new attribute(listModel.getElementAt(i))));
        }      */
        attributeList.setSelectedIndex(0);
        String selectedAttr = attributeList.getSelectedValue();
        selectedFieldTxt.setText(selectedAttr); 
        
        List<String> definedRules = getAttributeFromName(selectedAttr).getDefinedRulesList();
        DefaultComboBoxModel<String> definedRulesModel
                = new DefaultComboBoxModel<>(definedRules.toArray(new String[0]));
        rulesComBox.setModel(definedRulesModel);
    }

    private attribute getAttributeFromName(String attrName){
        for(int i=NumberConstants.ZERO;i<attributes.size();i++){
            attribute curAttr = attributes.get(i);
            if(curAttr.getAttrName().equals(attrName)){
                return curAttr;
            }
        }
        return null;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attributeList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        selectedFieldTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rulesComBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        rulesList = new javax.swing.JList<>();
        addRuleBtn = new javax.swing.JButton();
        removeRulesBtn = new javax.swing.JButton();
        createDataBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpSense - Add Rules for Attributes  (IT Industry)");
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Add Rules for Attributes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Select Attribute");

        attributeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attributeListMouseClicked(evt);
            }
        });
        attributeList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                attributeListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(attributeList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Selected Field");

        selectedFieldTxt.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Rules");

        rulesComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Rule", "Remove Null Value Rows", "Clean Number values with Average" }));

        rulesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rulesListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rulesList);

        addRuleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/add.png"))); // NOI18N
        addRuleBtn.setToolTipText("Add Rules ");
        addRuleBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addRuleBtn.setBorderPainted(false);
        addRuleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRuleBtnActionPerformed(evt);
            }
        });

        removeRulesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etl/images/remove.png"))); // NOI18N
        removeRulesBtn.setToolTipText("Remove Rules");
        removeRulesBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        removeRulesBtn.setBorderPainted(false);
        removeRulesBtn.setEnabled(false);
        removeRulesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRulesBtnActionPerformed(evt);
            }
        });

        createDataBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        createDataBtn.setText("Create Data Store");
        createDataBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createDataBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectedFieldTxt)
                                    .addComponent(rulesComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addRuleBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRulesBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createDataBtn)
                                .addGap(70, 70, 70)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(selectedFieldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rulesComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addRuleBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeRulesBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createDataBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    * @Method attributeListMouseClicked
    * Get Selected attribte from the list and populate it's defined rules 
    * Enable or disable the remove button according to the rules
    * @param  MouseEvent
    */
    private void attributeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attributeListMouseClicked
        populateRulesList();
        enableOrDisableRemoveBtn();
    }//GEN-LAST:event_attributeListMouseClicked
    
    /*
    * @Method addRuleBtnActionPerformed
    * Add the selected rule to attributes list
    * @param  ActionEvent
    */
    private void addRuleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRuleBtnActionPerformed
        //Check user selected a rule
        if(rulesComBox.getSelectedIndex() != NumberConstants.ZERO){
            //initialize the model
            model = new DefaultListModel();
            //get selected Attribute
            String selectedAttrName = attributeList.getSelectedValue();        
            attribute selectedAttr = getAttribute(selectedAttrName);
            /*get selected rule from the dropdown and check if it is already 
            exists in the rules list of selected Attribute*/
            String selectedRule = (String) rulesComBox.getSelectedItem(); 
            if(!selectedAttr.setRule(selectedRule)){
                JOptionPane.showMessageDialog(null, 
                        StringConstants.RULE_ERROR);
            }
            //Get rules and populate JList model
            List<String> rulesOfSelAttr = selectedAttr.getRules();
            for (String rule : rulesOfSelAttr) {
                model.addElement(rule);
            } 
            rulesList.setModel(model);
            //If model has rules then select first index
            if(rulesOfSelAttr.size() > NumberConstants.ZERO)
                rulesList.setSelectedIndex(NumberConstants.ZERO);
        } else {
            JOptionPane.showMessageDialog(null, 
                        StringConstants.INVALID_RULE);
        }        
        enableOrDisableRemoveBtn();        
    }//GEN-LAST:event_addRuleBtnActionPerformed

    /*
    * @Method attributeListKeyReleased
    * Detect up or down arrow keys and populate Rules
    * @param  KeyEvent
    */
    private void attributeListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_attributeListKeyReleased
        //Detect up or down arrow keys and populate Rules
        int keyCode = evt.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_UP:
                populateRulesList();
                break;
            case KeyEvent.VK_DOWN:
                populateRulesList();                
                break;            
        }
    }//GEN-LAST:event_attributeListKeyReleased

    /*
    * @Method rulesListMouseClicked
    * Enable or disable accroding to the rules list
    * @param  MouseEvent
    */
    private void rulesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesListMouseClicked
        enableOrDisableRemoveBtn();
    }//GEN-LAST:event_rulesListMouseClicked

    
    /*
    * @Method removeRulesBtnActionPerformed
    * Remove selected rule from selected attribute
    * @param  ActionEvent
    */
    private void removeRulesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRulesBtnActionPerformed
        //Check user comfirms remove
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, 
                StringConstants.REMOVE_RULE,
                StringConstants.WARNING,dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            //Get the attribute
            String selectedAttribute = attributeList.getSelectedValue();
            attribute selectedAttr = getAttribute(selectedAttribute);
            //Select the rule
            String selectedRule = rulesList.getSelectedValue();
            selectedAttr.removeRule(selectedRule);
            System.out.println(selectedRule);
            
            populateRulesList();
        }
        enableOrDisableRemoveBtn(); 
    }//GEN-LAST:event_removeRulesBtnActionPerformed

    private void createDataBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createDataBtnMouseClicked
        //Show popup window
        CreatingDBDialog dialog = new CreatingDBDialog(this, 
                "Creating Database....", "Please Wait.....");
        dialog.setSize(300, 200);         
        CreateCleansedCSV.filePath = filePath;
        CreateCleansedCSV.fileType = fileType;
        CreateCleansedCSV.dbDialog = dialog;
        
        //Create rules json file
        createJSONFile();
        CreateCleansedCSV cleanCSV = new CreateCleansedCSV();
        cleanCSV.start();        
    }//GEN-LAST:event_createDataBtnMouseClicked

    /*
    * @Method populateRulesList
    * Display rules accroding to the selected attribute
    */
    private void populateRulesList(){
        String selectedAttribute = attributeList.getSelectedValue();
        //Set text
        selectedFieldTxt.setText(selectedAttribute);
        //initialize the model
        model = new DefaultListModel();
        //get selected Attribute       
        attribute selectedAttr = getAttribute(selectedAttribute);
        //Get rules and populate JList model
        List<String> rulesOfSelAttr = selectedAttr.getRules();
        for (String rule : rulesOfSelAttr) {
            model.addElement(rule);
        } 
        rulesList.setModel(model);
        //If model has rules then select first index
        if(rulesOfSelAttr.size() > NumberConstants.ZERO)
            rulesList.setSelectedIndex(NumberConstants.ZERO);
        
        List<String> definedRules = getAttributeFromName(selectedAttribute).getDefinedRulesList();
        DefaultComboBoxModel<String> definedRulesModel
                = new DefaultComboBoxModel<>(definedRules.toArray(new String[0]));
        rulesComBox.setModel(definedRulesModel);
    }
    
    /*
    * @Method getAttribute
    * Get attribute from given name
    * @param  String
    * @returns Attribute
    */
    private attribute getAttribute(String attributeName){
        int i = NumberConstants.ZERO;
        attribute selectedAttr = new attribute();
        for (attribute attr : attributes) {
            if(attr.getAttrName().equals(attributeName)){
                selectedAttr =  attributes.get(i);
            }  
            i++;
        }
        return selectedAttr;
    }
    
    /*
    * @Method enableOrDisableRemoveBtn
    * enable or disable remove button according to the rules list
    */
    private void enableOrDisableRemoveBtn(){
        if(rulesList.getModel().getSize()>NumberConstants.ZERO)
            removeRulesBtn.setEnabled(true);
        else 
            removeRulesBtn.setEnabled(false);
    }   
    
    /*
    * @Method createJSONFile
    * Create JSON file to be read in python
    */
    private void createJSONFile(){
        Gson gsonForAttr = new Gson();
        //Create JSON array for attributes
        JSONArray attrs = new JSONArray();        
        JSONParser parser = new JSONParser();        
        try {
            for(attribute attr : attributes){                
                String jsonStringForAttr = gsonForAttr.toJson(attr);
                Object attrObj = parser.parse(jsonStringForAttr);
                JSONObject attrJSONObj = (JSONObject)attrObj;
                attrs.add(attrJSONObj);
            }
            
            JSONObject mainJSONObj = new JSONObject();
            mainJSONObj.put("attibutes", attrs);
            mainJSONObj.put("filePath", filePath);
            FileWriter file;
            try {
                file = new FileWriter("src/etl/outputs/attributes.json");
                file.write(mainJSONObj.toJSONString());
                file.flush();
                file.close();
                System.out.println(mainJSONObj.toJSONString());
            } catch (IOException ex) {
                System.out.println("Error in reading or writing in file");
            }
        } catch (ParseException ex) {
            System.out.println("Parsing Error");
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
            java.util.logging.Logger.getLogger(DefineRules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefineRules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefineRules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefineRules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefineRules(new ArrayList<attribute>(),"/home/suren/Desktop/data.csv","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRuleBtn;
    private javax.swing.JList<String> attributeList;
    private javax.swing.JButton createDataBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeRulesBtn;
    private javax.swing.JComboBox<String> rulesComBox;
    private javax.swing.JList<String> rulesList;
    private javax.swing.JTextField selectedFieldTxt;
    // End of variables declaration//GEN-END:variables
}
