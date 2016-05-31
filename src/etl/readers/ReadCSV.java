/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import etl.constants.NumberConstants;
import etl.models.CheckBoxHeader;
import etl.models.CheckBoxItemListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author suren
 */
public class ReadCSV implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JTable tableView;
    public static JProgressBar progressBar;
    public static JButton extractBtn;
    //Private variables
    private Thread thread;
    private List<String[]> tableEntries;
    private FileReader selectedFile;
    private DefaultTableModel model;
    private au.com.bytecode.opencsv.CSVReader reader;
    private String[] header;
    
    /*
    * @Method createTableModel 
    * Read the CSV File and Create Table Model
    * @Returns  Empty DefaultTableModel
    */            
    public DefaultTableModel createTableModel(){  
        try {
            //Create the file
            selectedFile = new FileReader(selectedFilePath);
            reader = new au.com.bytecode.opencsv.CSVReader(selectedFile);
            // if the first line is the header
            header = reader.readNext();           
            model = new DefaultTableModel(header,NumberConstants.ZERO);           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return model;
    }
    
    /*
    * @Method fillTable 
    * Fill Table with Reading line by line of the CSV File
    */   
    public void fillTable(){
        try {
            tableEntries = reader.readAll();
            int size = tableEntries.size();
            //Fill table entries and update progressbar
            for(int i = NumberConstants.ZERO; i < size; i++){
                model.addRow(tableEntries.get(i));
                int value = ((i+1)/size)*100;
                progressBar.setValue(value); 
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                selectedFile.close();                
                JOptionPane.showMessageDialog(null, "Data Loading Successful");
                progressBar.setVisible(false);
                extractBtn.setEnabled(true);
                addCheckBox();
            } catch (IOException ex) {
                Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

    @Override
    public void run(){        
        DefaultTableModel csvModel = createTableModel();
        
        tableView.setModel(csvModel);    
        fillTable();
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        extractBtn.setEnabled(false);
        if (thread == null)
        {
            thread = new Thread (this);
            thread.start ();
        }
    }
    
    public String[] getHeaders(){
        return header;
    }
    
    private void addCheckBox(){
        //To add checkbox in table columns
        for(int i = NumberConstants.ZERO;i<tableView.getColumnCount();i++){
            CheckBoxItemListener.table = tableView;
            TableColumn tc = tableView.getColumnModel().getColumn(i);
            tc.setCellEditor(tableView.getDefaultEditor(String.class));
            tc.setCellRenderer(tableView.getDefaultRenderer(String.class));
            tc.setHeaderRenderer(new CheckBoxHeader(
                    new CheckBoxItemListener(),tableView.getColumnName(i)));
        }
    }
    
}
