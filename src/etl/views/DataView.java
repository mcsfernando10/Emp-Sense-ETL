/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.views;

import etl.models.CheckBoxHeader;
import etl.models.MyItemListener;
import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author suren
 */
public class DataView extends javax.swing.JFrame {

    /**
     * Creates new form DataView
     */
    private String filePath;
    private String fileType;
    public DataView(String selectedFilePath, String selectedFileType) {
        initComponents();
        this.filePath = selectedFilePath;   
        this.fileType = selectedFileType;
        
        try {
            //Create the file 
            FileReader selectedFile = new FileReader(filePath);
            if(fileType.equals("csv")) {
                CSVReader reader = new CSVReader(selectedFile);
                //List<String[]> myEntries = reader.readAll();
                //String[][] rowData = myEntries.toArray(new String[0][]);
                // if the first line is the header 
                String[] header = reader.readNext();
                //JTable table = new JTable(rowData,header);
                //this.add(table);
                List<String[]> myEntries = reader.readAll();
                
                DefaultTableModel model = new DefaultTableModel(header,0);
                
                for(int i=0;i<myEntries.size();i++){
                    model.addRow(myEntries.get(i));
                }
                dataTableView.setModel(model);                
                
                //To add checkbox in table columns
                for(int i=0;i<header.length;i++){
                    MyItemListener.table = dataTableView;
                    TableColumn tc = dataTableView.getColumnModel().getColumn(i);
                    tc.setCellEditor(dataTableView.getDefaultEditor(String.class));
                    tc.setCellRenderer(dataTableView.getDefaultRenderer(String.class));
                    tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener(),header[i]));
                }              
                
            }
            else if(fileType.equals("xml")){
                try{
                    File fXmlFile = new File(filePath);
                    DocumentBuilderFactory dbFactory = 
                            DocumentBuilderFactory.newInstance();
                    dbFactory.setIgnoringElementContentWhitespace(true);
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(fXmlFile);


                    doc.getDocumentElement().normalize();

                    //Get root node
                    Node rootNode = doc.getFirstChild();
                    //Get employee data nodes
                    NodeList employeeNodesList = rootNode.getChildNodes(); 
                    DefaultTableModel model = null;
                    for(int i = 0;i<employeeNodesList.getLength();i++){
                        if(employeeNodesList.item(i).
                                getNodeType() == Node.ELEMENT_NODE){
                            Node employeeNode = employeeNodesList.item(i);
                    
                            NodeList childNodes = employeeNode.getChildNodes();
                            int count = 0;
                            //for loop for count valid nodes(not containing spaces)
                            for(int j = 0;j<childNodes.getLength();j++){
                                //to remove #text nodes
                                if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE)
                                    count++;
                            }
                            //Create string array
                            String[] headings = new String[count];

                            //index to insert heading into correct place
                            int index = 0;
                            for(int j = 0;j<childNodes.getLength();j++){
                                //to remove #text nodes
                                if(childNodes.item(j).getNodeType()== Node.ELEMENT_NODE){
                                    headings[index++] = childNodes.item(j).getNodeName();
                                }                                    
                            }
                            model = new DefaultTableModel(headings,0); 
                            break;
                        }                        
                    }
                    
                    //Set table rows
                    String[] rowValues = null;
                    for(int i = 0;i<employeeNodesList.getLength();i++){
                        if(employeeNodesList.item(i).
                                getNodeType() == Node.ELEMENT_NODE){
                            Node employeeNode = employeeNodesList.item(i);
                    
                            NodeList childNodes = employeeNode.getChildNodes();
                            int count = 0;
                            //for loop for count valid nodes(not containing spaces)
                            for(int j = 0;j<childNodes.getLength();j++){
                                //to remove #text nodes
                                if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE)
                                    count++;
                            }
                            //Create string array for store row values
                            rowValues = new String[count];

                            //index to insert heading into correct place
                            int index = 0;
                            for(int j = 0;j<childNodes.getLength();j++){
                                //to remove #text nodes
                                if(childNodes.item(j).getNodeType()== Node.ELEMENT_NODE){
                                    rowValues[index++] = childNodes.item(j).getTextContent();
                                }                                    
                            }
                            model.addRow(rowValues);
                        }                        
                    }                   
                    dataTableView.setModel(model);
                    
                    //Define headings as String array
                    /*Node employeeNode = employeeNodesList.item(0);
                    
                    NodeList childNodes = employeeNode.getChildNodes();
                    String[] headings = new String[childNodes.getLength()];
                    
                                           
                    for(int i = 0;i<childNodes.getLength();i++){
                        headings[i] = childNodes.item(i).getNodeName().toString();
                        //System.out.println(childNodes.item(i).getNodeName().toString());
                    }
                    
                    DefaultTableModel model = new DefaultTableModel(headings,0);
                
                    
                    dataTableView.setModel(model);  */

                    /*NodeList nList = doc.getElementsByTagName("staff");

                    System.out.println("----------------------------");
                    for (int temp = 0; temp < nList.getLength(); temp++) {

                        Node nNode = nList.item(temp);
                        NodeList childNodes = nNode.getChildNodes();
                        
                        String[] headings = new String[childNodes.getLength()];
                        
                        for(int i = 0;i<childNodes.getLength();i++){
                            headings[i] = childNodes.item(i).getNodeName().toString();
                        }

                        System.out.println("\nCurrent Element :" + nNode.getNodeName());

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element eElement = (Element) nNode;

                                System.out.println("Staff id : " + eElement.getAttribute("id"));
                                System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                                System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                                System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                                System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                        }
                    }*/
                }
                catch(FileNotFoundException ex) {
                    Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
            else {

            }
        }
        catch(FileNotFoundException ex) {
                    Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTableView = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data View");

        jButton1.setText("Extract");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(dataTableView);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new AttributeMapper(filePath,fileType).setVisible(true);        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTableView;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
