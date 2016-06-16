/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.views.DataView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFrame;

/**
 *
 * @author suren
 */
public class ReadOriginalCSVandWrite implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JFrame extractView;
    //Private variables
    private Thread thread;
    private List<String[]> tableEntries;
    private FileReader selectedFile;
    private FileWriter csvOutputFile;
    private CSVReader reader;
    private CSVWriter writer;
    
    /*
    * @Method createTableModel 
    * Read the CSV File and Create Table Model
    * @Returns  Empty DefaultTableModel
    */            
    public void createReadAndWriteCSV(){  
        try {
            //Create the file
            selectedFile = new FileReader(selectedFilePath);
            reader = new CSVReader(selectedFile);            
            //To write to file
            csvOutputFile = new FileWriter(StringConstants.ORIGINAL_CSV_PATH);
            writer = new CSVWriter(csvOutputFile);       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /*
    * @Method fillTable 
    * Fill Table with Reading line by line of the CSV File
    */   
    public void writeDataToCSV(){
        try {
            tableEntries = reader.readAll();
            reader.close();
            selectedFile.close();
            int size = tableEntries.size(); 
            //FileWriter writer = new FileWriter(StringConstants.ORIGINAL_CSV_PATH);
            
            //Fill table entries and update progressbar
            for(int i = NumberConstants.ZERO; i < size; i++){
                String[] arr = tableEntries.get(i);
                //writer.write(Arrays.asList(arr).stream().collect(Collectors.joining(",")));
                //writer.write("\n"); // newline
                System.out.println();
            }
            writer.writeAll(tableEntries);            
            writer.close();
            csvOutputFile.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void run(){        
        createReadAndWriteCSV();
        writeDataToCSV();
        extractView.dispose();
        new DataView(StringConstants.ORIGINAL_CSV_PATH).setVisible(true);
        //tableView.setModel(csvModel);    
        //fillTable();
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        if (thread == null)
        {
            thread = new Thread (this);
            thread.start();
        }
    }
}
