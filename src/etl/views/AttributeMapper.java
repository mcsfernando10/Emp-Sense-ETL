/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.models.attribute;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author suren
 */
public class AttributeMapper extends javax.swing.JFrame {

    /**
     * Creates new form AttributeMapper
     */
    //All declared variables
    private final String filePath;
    private final String[] header;
    private List<attribute> attributes;
    public AttributeMapper(String selectedFilePath,  
            String[] headers) {
        initComponents();
        
        setWindowIcon();
                
        this.filePath = selectedFilePath;
        this.header = headers;                
        setComboboxModels();   
    }
    
    /*
    * @Method setComboboxModels 
    * Set Combobox for attribtes to map them
    */
    private void setComboboxModels(){
        DefaultComboBoxModel<String> modelEmployeeID 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelEmployeeName 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelAge 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelGender 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelMaritalStatus 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelHavingDegree 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelJobRole 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelTenure 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelSalary 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelNoOfLeaves 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelDistance 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelNoOfDep 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelChurn 
                = new DefaultComboBoxModel<>(header);
        
        employeeIDComBox.setModel(modelEmployeeID);
        employeeNameComBox.setModel(modelEmployeeName);
        ageComBox.setModel(modelAge);
        genderComBox.setModel(modelGender);
        maritalStatComBox.setModel(modelMaritalStatus);
        havingDegreeComBox.setModel(modelHavingDegree);
        jobRoleComBox.setModel(modelJobRole);
        tenureComBox.setModel(modelTenure);
        salaryComBox.setModel(modelSalary);
        noOfLeavesComBox.setModel(modelNoOfLeaves);
        distanceComBox.setModel(modelDistance);
        noOfDepComBox.setModel(modelNoOfDep);
        churnComBox.setModel(modelChurn);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        attributeListPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        genderComBox = new javax.swing.JComboBox<>();
        maritalStatComBox = new javax.swing.JComboBox<>();
        jobRoleComBox = new javax.swing.JComboBox<>();
        salaryComBox = new javax.swing.JComboBox<>();
        noOfLeavesComBox = new javax.swing.JComboBox<>();
        defineRulesBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        distanceComBox = new javax.swing.JComboBox<>();
        noOfDepComBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        employeeIDComBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        employeeNameComBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ageComBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        havingDegreeComBox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        tenureComBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        churnComBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpSense - Attribute Mapper (IT Industry)");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Gender");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Marital Status");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Salary");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Job Role");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("No of Leaves");

        genderComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maritalStatComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jobRoleComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        salaryComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        noOfLeavesComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        defineRulesBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        defineRulesBtn.setText("Define Rules");
        defineRulesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defineRulesBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Distance");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("No of Dependents");

        distanceComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        noOfDepComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Employee ID");

        employeeIDComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setText("Employee Name");

        employeeNameComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("Map Attributes with Dataset");

        ageComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setText("Age");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel12.setText("Having Degree");

        havingDegreeComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel13.setText("Tenure");

        tenureComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel14.setText("Churn");

        churnComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout attributeListPanelLayout = new javax.swing.GroupLayout(attributeListPanel);
        attributeListPanel.setLayout(attributeListPanelLayout);
        attributeListPanelLayout.setHorizontalGroup(
            attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attributeListPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(attributeListPanelLayout.createSequentialGroup()
                        .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(churnComBox, 0, 220, Short.MAX_VALUE)
                                .addComponent(maritalStatComBox, 0, 220, Short.MAX_VALUE)
                                .addComponent(distanceComBox, 0, 220, Short.MAX_VALUE)
                                .addComponent(ageComBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 220, Short.MAX_VALUE)
                                .addComponent(jobRoleComBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 220, Short.MAX_VALUE)
                                .addComponent(salaryComBox, 0, 220, Short.MAX_VALUE))
                            .addComponent(employeeIDComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attributeListPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tenureComBox, 0, 220, Short.MAX_VALUE)
                                    .addComponent(havingDegreeComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genderComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(employeeNameComBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(noOfDepComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(noOfLeavesComBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attributeListPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(defineRulesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)))))
                .addContainerGap())
        );
        attributeListPanelLayout.setVerticalGroup(
            attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attributeListPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(employeeIDComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(employeeNameComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ageComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(genderComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maritalStatComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(havingDegreeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jobRoleComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenureComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(salaryComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(noOfLeavesComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(distanceComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noOfDepComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(attributeListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(churnComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defineRulesBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(attributeListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(attributeListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        //Add attributes - *To add new attribute
        attributes = new ArrayList<>();
        String[] mappedAttributes = new String[]{
            employeeIDComBox.getSelectedItem().toString(), 
            employeeNameComBox.getSelectedItem().toString(),
            ageComBox.getSelectedItem().toString(),
            genderComBox.getSelectedItem().toString(),
            maritalStatComBox.getSelectedItem().toString(),
            havingDegreeComBox.getSelectedItem().toString(),            
            jobRoleComBox.getSelectedItem().toString(),
            tenureComBox.getSelectedItem().toString(),
            salaryComBox.getSelectedItem().toString(),
            noOfLeavesComBox.getSelectedItem().toString(),
            distanceComBox.getSelectedItem().toString(),
            noOfDepComBox.getSelectedItem().toString(),
            churnComBox.getSelectedItem().toString()
        };
        for (int i = NumberConstants.ZERO; 
                i < StringConstants.ATTRIBUTES.length ; i++){
            String attr = StringConstants.ATTRIBUTES[i];
            attribute attribute = new attribute(attr);
            attribute.setRules(StringConstants.RULES_LIST.get(attr));
            attribute.setMatchingField(mappedAttributes[i]);
            attributes.add(attribute);
        }        
        
        dispose();
        new DefineRules(attributes, filePath).setVisible(true);
    }//GEN-LAST:event_defineRulesBtnActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ageComBox;
    private javax.swing.JPanel attributeListPanel;
    private javax.swing.JComboBox<String> churnComBox;
    private javax.swing.JButton defineRulesBtn;
    private javax.swing.JComboBox<String> distanceComBox;
    private javax.swing.JComboBox<String> employeeIDComBox;
    private javax.swing.JComboBox<String> employeeNameComBox;
    private javax.swing.JComboBox<String> genderComBox;
    private javax.swing.JComboBox<String> havingDegreeComBox;
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
    private javax.swing.JComboBox<String> jobRoleComBox;
    private javax.swing.JComboBox<String> maritalStatComBox;
    private javax.swing.JComboBox<String> noOfDepComBox;
    private javax.swing.JComboBox<String> noOfLeavesComBox;
    private javax.swing.JComboBox<String> salaryComBox;
    private javax.swing.JComboBox<String> tenureComBox;
    // End of variables declaration//GEN-END:variables
}
