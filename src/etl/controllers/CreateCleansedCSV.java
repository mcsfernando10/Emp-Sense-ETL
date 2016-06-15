/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.controllers;

import etl.constants.NumberConstants;
import etl.db.DBAccess;
import etl.readers.ReadCSV;
import etl.views.DefineRules;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suren
 */
public class CreateCleansedCSV implements Runnable{

    public static String filePath;
    public static String fileType;
    public static CreatingDBDialog dbDialog;
    //Private variables
    private Thread thread;
    
    @Override
    public void run() {
        executePythonFile();
        insertData();
        //Set Label text with finish messages
        dbDialog.setButtonVisible();
        dbDialog.setLabelText();
    }
    
    /*
    * @Method executePythonFile
    * Execute Python file
    */
    public void executePythonFile(){  
        try {
            /*Process p = Runtime.getRuntime().
                    exec("python src/etl/pythonCodes/cleanData.py " + filePath);*/
            
            Process p = Runtime.getRuntime().
                    exec("python src/etl/pythonCodes/cleanData.py");
            
            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
            
 
            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
 
            String s = null;
            
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
             
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(DefineRules.class.getName()).log(Level.SEVERE, null, ex);
        }               
    }
    
    /*
    * @Method insertData
    * Insert cleansed data into database
    */
    private void insertData(){
        //To insert original values
        ReadCSV.selectedFilePath = "src/etl/outputs/cleansed.csv";
        ReadCSV csvReaderForInsert = new ReadCSV();
        List<String[]> csvData = csvReaderForInsert.readCSVFile();
        
        //To insert raw values
        ReadCSV.selectedFilePath = "src/etl/outputs/rawData.csv";
        csvReaderForInsert = new ReadCSV();
        List<String[]> csvRawData = csvReaderForInsert.readCSVFile();
        int size = csvData.size();
        DBAccess dbAccess = new DBAccess();
        for(int i = NumberConstants.ONE;i<size;i++){
            String[] data = csvData.get(i);
            dbAccess.insertData("employeesIT",csvData.get(i));
            dbAccess.insertRawData("employeesIT_raw",csvRawData.get(i));
            dbDialog.setInsertProgress(size, i);
        }
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        if (thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }
    }
    
}