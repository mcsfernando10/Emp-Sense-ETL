/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import etl.constants.NumberConstants;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class ReadXML implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JTable tableView;
    public static JProgressBar progressBar;
    public static JButton extractBtn;
    //Private variables
    private Thread thread;
    private File xmlFile;
    private DefaultTableModel model;
    private NodeList employeeNodesList;
    
    public DefaultTableModel createTableModel(){
        try {
            xmlFile = new File(selectedFilePath);
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            dbFactory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);            
            
            doc.getDocumentElement().normalize();
            
            //Get root node
            Node rootNode = doc.getFirstChild();
            //Get employee data nodes
            employeeNodesList = rootNode.getChildNodes();
            
            for(int i = NumberConstants.ZERO;i<employeeNodesList.getLength();i++){
                if(employeeNodesList.item(i).
                        getNodeType() == Node.ELEMENT_NODE){
                    Node employeeNode = employeeNodesList.item(i);
                    
                    NodeList childNodes = employeeNode.getChildNodes();
                    int count = NumberConstants.ZERO;
                    //for loop for count valid nodes(not containing spaces)
                    for(int j = NumberConstants.ZERO;j<childNodes.getLength();j++){
                        //to remove #text nodes
                        if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE)
                            count++;
                    }
                    //Create string array
                    String[] headings = new String[count];
                    
                    //index to insert heading into correct place
                    int index = NumberConstants.ZERO;
                    for(int j = NumberConstants.ZERO;j<childNodes.getLength();j++){
                        //to remove #text nodes
                        if(childNodes.item(j).getNodeType()== Node.ELEMENT_NODE){
                            headings[index++] = childNodes.item(j).getNodeName();
                        }
                    }
                    model = new DefaultTableModel(headings,NumberConstants.ZERO);
                    return model;
                }
            }     
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(ReadXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    /*
    * @Method fillTable 
    * Fill Table with Reading line by line of the CSV File
    */   
    public void fillTable(){
        //Set table rows
        String[] rowValues;
        int size = employeeNodesList.getLength();
        for(int i = NumberConstants.ZERO;i < size;i++){
            if(employeeNodesList.item(i).
                    getNodeType() == Node.ELEMENT_NODE){
                Node employeeNode = employeeNodesList.item(i);

                NodeList childNodes = employeeNode.getChildNodes();                                    
                int count = NumberConstants.ZERO;
                //for loop for count valid nodes(not containing spaces)
                for(int j = NumberConstants.ZERO;j < childNodes.getLength();j++){
                    //to remove #text nodes
                    if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE)
                        count++;
                }
                //Create string array for store row values
                rowValues = new String[count];

                //index to insert heading into correct place
                int index = NumberConstants.ZERO;
                for(int j = NumberConstants.ZERO;j<childNodes.getLength();j++){
                    //to remove #text nodes
                    if(childNodes.item(j).getNodeType()== Node.ELEMENT_NODE){
                        rowValues[index++] = childNodes.item(j).getTextContent();
                    }
                }
                model.addRow(rowValues);
                
                int value = ((i+1)/size)*100;
                progressBar.setValue(value);
                progressBar.setString(value + "%");
            }
        }               
        JOptionPane.showMessageDialog(null, "Data Loading Successful");
        progressBar.setVisible(false);
    }

    @Override
    public void run() {
        extractBtn.setEnabled(false);
        DefaultTableModel xmlModel = createTableModel();
        tableView.setModel(xmlModel);    
        fillTable();
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        if (thread == null)
        {
           thread = new Thread (this);
           thread.start ();
        }
    }
    
}
