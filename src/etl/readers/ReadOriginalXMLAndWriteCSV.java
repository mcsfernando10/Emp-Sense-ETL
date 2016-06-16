/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import com.opencsv.CSVWriter;
import etl.constants.StringConstants;
import etl.views.DataView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
public class ReadOriginalXMLAndWriteCSV implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JFrame extractView;
    //Private variables
    private Thread thread;
    private File xmlFile;
    private NodeList employeeNodesList;
    private String[] headings;
    private CSVWriter writer;
    
    public void createTableModel(){
        try{
            xmlFile = new File(selectedFilePath);
            
            //To write to file
            writer = new CSVWriter(new FileWriter(StringConstants.ORIGINAL_CSV_PATH));
            
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
                    headings = new String[count];

                    //index to insert heading into correct place
                    int index = 0;
                    for(int j = 0;j<childNodes.getLength();j++){
                        //to remove #text nodes
                        if(childNodes.item(j).getNodeType()== Node.ELEMENT_NODE){
                            headings[index++] = childNodes.item(j).getNodeName();
                        }                                    
                    }
                    writer.writeNext(headings);                  
                    break;
                }                
            }                       
        }
        catch(FileNotFoundException ex) {
            Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException | ParserConfigurationException ex) {
            Logger.getLogger(DataView.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    /*
    * @Method fillTable 
    * Fill Table with Reading line by line of the CSV File
    */   
    public void fillTable(){
        try {
            int size = employeeNodesList.getLength();
            //Set table rows
            String[] rowValues;
            for(int i = 0;i<size;i++){
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
                    //Error
                    writer.writeNext(rowValues);
                }
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadOriginalXMLAndWriteCSV.class.getName()).log(Level.SEVERE, null, ex);                        
        }
    }

    @Override
    public void run() {
        createTableModel();
        //tableView.setModel(model);  
        fillTable();
        extractView.dispose();
        new DataView(StringConstants.ORIGINAL_CSV_PATH).setVisible(true);
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
    
    public String[] getHeaders(){
        return headings;
    }
    
}
