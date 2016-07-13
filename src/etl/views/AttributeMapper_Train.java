/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.commonViews.HomeView;
import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.dictionary.SynonymDictionary;
import etl.models.attribute;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author suren
 */
public class AttributeMapper_Train extends javax.swing.JFrame {

    /**
     * Creates new form AttributeMapper
     */
    //All declared variables
    private final String filePath;
    private final String[] header;
    private List<attribute> attributes;
    public AttributeMapper_Train(String selectedFilePath,  
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
        DefaultComboBoxModel<String> modelDepartment 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelWorkFrom 
                = new DefaultComboBoxModel<>(header);
        DefaultComboBoxModel<String> modelWorkTo 
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
        DefaultComboBoxModel<String> modelReasonToLeave 
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
        departmentComBox.setModel(modelDepartment);
        workFromComBox.setModel(modelWorkFrom);
        workToComBox.setModel(modelWorkTo);
        departmentComBox.setModel(modelDepartment);
        tenureComBox.setModel(modelTenure);
        salaryComBox.setModel(modelSalary);
        noOfLeavesComBox.setModel(modelNoOfLeaves);
        distanceComBox.setModel(modelDistance);
        noOfDepComBox.setModel(modelNoOfDep);
        reasonToLeaveComBox.setModel(modelReasonToLeave);
        churnComBox.setModel(modelChurn);
        
        SynonymDictionary dictionary = new SynonymDictionary();
        
        //Automate dropdown selection
        employeeIDComBox.setSelectedIndex(dictionary.getIndex(StringConstants.EMPLOYEE_ID, header));
        employeeNameComBox.setSelectedIndex(dictionary.getIndex(StringConstants.EMPLOYEE_NAME, header));
        ageComBox.setSelectedIndex(dictionary.getIndex(StringConstants.AGE, header));
        genderComBox.setSelectedIndex(dictionary.getIndex(StringConstants.GENDER, header));
        maritalStatComBox.setSelectedIndex(dictionary.getIndex(StringConstants.MARITAL_STAT, header));
        havingDegreeComBox.setSelectedIndex(dictionary.getIndex(StringConstants.HAVING_DEGREE, header));
        jobRoleComBox.setSelectedIndex(dictionary.getIndex(StringConstants.JOB_ROLE, header));
        departmentComBox.setSelectedIndex(dictionary.getIndex(StringConstants.DEPARTMENT, header));
        workFromComBox.setSelectedIndex(dictionary.getIndex(StringConstants.WORK_FROM, header));
        workToComBox.setSelectedIndex(dictionary.getIndex(StringConstants.WORK_TO, header));
        tenureComBox.setSelectedIndex(dictionary.getIndex(StringConstants.TENURE, header));
        salaryComBox.setSelectedIndex(dictionary.getIndex(StringConstants.SALARY, header));
        noOfLeavesComBox.setSelectedIndex(dictionary.getIndex(StringConstants.NO_OF_LEAVES, header));
        distanceComBox.setSelectedIndex(dictionary.getIndex(StringConstants.DISTANCE, header));
        noOfDepComBox.setSelectedIndex(dictionary.getIndex(StringConstants.NO_OF_DEPENDENTS, header));
        reasonToLeaveComBox.setSelectedIndex(dictionary.getIndex(StringConstants.REASON_TO_LEAVE, header));
        churnComBox.setSelectedIndex(dictionary.getIndex(StringConstants.CHURN, header));
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
        jLabel17 = new javax.swing.JLabel();
        workFromComBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        departmentComBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        reasonToLeaveComBox = new javax.swing.JComboBox<>();
        workToComBox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpSense - Attribute Mapper (IT Industry)");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Gender");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(380, 150, 43, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Marital Status");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 190, 87, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Salary");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(380, 310, 37, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Job Role");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 230, 53, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("No of Leaves");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 350, 78, 15);

        genderComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(genderComBox);
        genderComBox.setBounds(500, 140, 220, 30);

        maritalStatComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(maritalStatComBox);
        maritalStatComBox.setBounds(140, 180, 220, 30);

        jobRoleComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jobRoleComBox);
        jobRoleComBox.setBounds(140, 220, 220, 30);

        salaryComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(salaryComBox);
        salaryComBox.setBounds(500, 300, 220, 30);

        noOfLeavesComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(noOfLeavesComBox);
        noOfLeavesComBox.setBounds(140, 340, 220, 30);

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
        defineRulesBtn.setBounds(550, 490, 157, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Distance");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(380, 350, 52, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("NoofDependents");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 390, 120, 15);

        distanceComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(distanceComBox);
        distanceComBox.setBounds(500, 340, 220, 30);

        noOfDepComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(noOfDepComBox);
        noOfDepComBox.setBounds(140, 380, 220, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Employee ID");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 110, 76, 15);

        employeeIDComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(employeeIDComBox);
        employeeIDComBox.setBounds(140, 100, 220, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Employee Name");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(380, 110, 95, 15);

        employeeNameComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(employeeNameComBox);
        employeeNameComBox.setBounds(500, 100, 220, 30);

        jLabel10.setBackground(new java.awt.Color(51, 102, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 480, 710, 50);

        ageComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(ageComBox);
        ageComBox.setBounds(140, 140, 220, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Age");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 150, 36, 15);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Having Degree");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(380, 190, 89, 15);

        havingDegreeComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(havingDegreeComBox);
        havingDegreeComBox.setBounds(500, 180, 220, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Tenure");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(30, 310, 42, 15);

        tenureComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(tenureComBox);
        tenureComBox.setBounds(140, 300, 220, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Churn");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 430, 37, 15);

        churnComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(churnComBox);
        churnComBox.setBounds(140, 420, 220, 30);

        jLabel17.setBackground(new java.awt.Color(51, 102, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Map Attributes with Dataset");
        jLabel17.setOpaque(true);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(14, 20, 720, 50);

        workFromComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(workFromComBox);
        workFromComBox.setBounds(140, 260, 220, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Work From");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(30, 270, 70, 15);

        departmentComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(departmentComBox);
        departmentComBox.setBounds(500, 220, 220, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Department");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(380, 230, 100, 15);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("WorkTo");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(380, 270, 60, 15);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Reason to Leave");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(380, 390, 120, 15);

        reasonToLeaveComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(reasonToLeaveComBox);
        reasonToLeaveComBox.setBounds(500, 380, 220, 30);

        workToComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(workToComBox);
        workToComBox.setBounds(500, 260, 220, 30);

        jLabel16.setBackground(new java.awt.Color(51, 102, 255));
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 80, 710, 390);

        jLabel15.setBackground(new java.awt.Color(0, 0, 102));
        jLabel15.setOpaque(true);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(0, 0, 750, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            departmentComBox.getSelectedItem().toString(),
            workFromComBox.getSelectedItem().toString(),
            workToComBox.getSelectedItem().toString(),
            tenureComBox.getSelectedItem().toString(),
            salaryComBox.getSelectedItem().toString(),
            noOfLeavesComBox.getSelectedItem().toString(),
            distanceComBox.getSelectedItem().toString(),
            noOfDepComBox.getSelectedItem().toString(),
            reasonToLeaveComBox.getSelectedItem().toString(),
            churnComBox.getSelectedItem().toString()
        };
        for (int i = NumberConstants.ZERO; 
                i < StringConstants.ATTRIBUTES_TRAIN.length ; i++){
            String attr = StringConstants.ATTRIBUTES_TRAIN[i];
            attribute attribute = new attribute(attr);
            attribute.setRules(StringConstants.RULES_LIST.get(attr));
            attribute.setMatchingField(mappedAttributes[i]);
            attributes.add(attribute);
        }                
        dispose();
        new DefineRules(attributes, filePath, NumberConstants.TRAIN_DATA).setVisible(true);
    }//GEN-LAST:event_defineRulesBtnActionPerformed

    /*
    * @Method formWindowClosing 
    * Prevent closing system and display home page
    * @param  WindowEvent
    */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        if (JOptionPane.showConfirmDialog(this, 
            StringConstants.CLOSE_WINDOW_QUESTION, StringConstants.CLOSE_WINDOW, 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                dispose();
                new HomeView().setVisible(true);
        } 
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ageComBox;
    private javax.swing.JComboBox<String> churnComBox;
    private javax.swing.JButton defineRulesBtn;
    private javax.swing.JComboBox<String> departmentComBox;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jobRoleComBox;
    private javax.swing.JComboBox<String> maritalStatComBox;
    private javax.swing.JComboBox<String> noOfDepComBox;
    private javax.swing.JComboBox<String> noOfLeavesComBox;
    private javax.swing.JComboBox<String> reasonToLeaveComBox;
    private javax.swing.JComboBox<String> salaryComBox;
    private javax.swing.JComboBox<String> tenureComBox;
    private javax.swing.JComboBox<String> workFromComBox;
    private javax.swing.JComboBox<String> workToComBox;
    // End of variables declaration//GEN-END:variables
}
